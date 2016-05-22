package com.company;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.logging.Logger;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.util.BytesRef;

import net.semanticmetadata.lire.AbstractDocumentBuilder;
import net.semanticmetadata.lire.DocumentBuilder;
import net.semanticmetadata.lire.imageanalysis.AutoColorCorrelogram;
import net.semanticmetadata.lire.imageanalysis.BinaryPatternsPyramid;
import net.semanticmetadata.lire.imageanalysis.CEDD;
import net.semanticmetadata.lire.imageanalysis.ColorLayout;
import net.semanticmetadata.lire.imageanalysis.EdgeHistogram;
import net.semanticmetadata.lire.imageanalysis.FCTH;
import net.semanticmetadata.lire.imageanalysis.Gabor;
import net.semanticmetadata.lire.imageanalysis.JCD;
import net.semanticmetadata.lire.imageanalysis.JpegCoefficientHistogram;
import net.semanticmetadata.lire.imageanalysis.LireFeature;
import net.semanticmetadata.lire.imageanalysis.LocalBinaryPatterns;
import net.semanticmetadata.lire.imageanalysis.LuminanceLayout;
import net.semanticmetadata.lire.imageanalysis.OpponentHistogram;
import net.semanticmetadata.lire.imageanalysis.PHOG;
import net.semanticmetadata.lire.imageanalysis.RotationInvariantLocalBinaryPatterns;
import net.semanticmetadata.lire.imageanalysis.ScalableColor;
import net.semanticmetadata.lire.imageanalysis.SimpleColorHistogram;
import net.semanticmetadata.lire.imageanalysis.Tamura;
import net.semanticmetadata.lire.imageanalysis.joint.JointHistogram;
import net.semanticmetadata.lire.impl.GenericDocumentBuilder;
import net.semanticmetadata.lire.impl.GenericDocumentBuilder.Mode;
import net.semanticmetadata.lire.indexing.hashing.BitSampling;
import net.semanticmetadata.lire.indexing.hashing.LocalitySensitiveHashing;
import net.semanticmetadata.lire.utils.ImageUtils;
import net.semanticmetadata.lire.utils.SerializationUtils;

public class Generic extends AbstractDocumentBuilder {

	enum HashingMode {
		BitSampling, LSH
	}

	private boolean hashingEnabled = false;
	private Logger logger = Logger.getLogger(getClass().getName());
	public static final int MAX_IMAGE_DIMENSION = 1024;
	Class<? extends LireFeature> descriptorClass;
	String fieldName;
	final static Mode DEFAULT_MODE = Mode.Fast;
	Mode currentMode = DEFAULT_MODE;
	// private LireFeature lireFeature;
	protected HashingMode hashingMode = HashingMode.BitSampling;

	public static HashMap<Class, String> fieldForClass = new HashMap<Class, String>();
	public static HashMap<String, Class> classForField = new HashMap<String, Class>();

	public static final String HASH_FIELD_SUFFIX = "_hash";

	static {
		// Let's try to read the hash functions right here and we don't have to
		// care about it right now.
		try {
			BitSampling.readHashFunctions();
			// LocalitySensitiveHashing.readHashFunctions();
		} catch (Exception e) {
			System.err
					.println("Could not read hashes from file when first creating a GenericDocumentBuilder instance.");
			e.printStackTrace();
		}

		// Setting up the class 2 field relation:
		fieldForClass.put(AutoColorCorrelogram.class,
				FIELD_NAME_AUTOCOLORCORRELOGRAM);
		fieldForClass.put(BinaryPatternsPyramid.class,
				FIELD_NAME_BINARY_PATTERNS_PYRAMID);
		fieldForClass.put(CEDD.class, FIELD_NAME_CEDD);
		fieldForClass
				.put(SimpleColorHistogram.class, FIELD_NAME_COLORHISTOGRAM);
		fieldForClass.put(ColorLayout.class, FIELD_NAME_COLORLAYOUT);
		fieldForClass.put(EdgeHistogram.class, FIELD_NAME_EDGEHISTOGRAM);
		fieldForClass.put(FCTH.class, FIELD_NAME_FCTH);
		fieldForClass.put(Gabor.class, FIELD_NAME_GABOR);
		fieldForClass.put(JCD.class, FIELD_NAME_JCD);
		fieldForClass.put(JointHistogram.class, FIELD_NAME_JOINT_HISTOGRAM);
		fieldForClass
				.put(JpegCoefficientHistogram.class, FIELD_NAME_JPEGCOEFFS);
		fieldForClass.put(LocalBinaryPatterns.class,
				FIELD_NAME_LOCAL_BINARY_PATTERNS);
		fieldForClass.put(LuminanceLayout.class, FIELD_NAME_LUMINANCE_LAYOUT);
		fieldForClass.put(OpponentHistogram.class,
				FIELD_NAME_OPPONENT_HISTOGRAM);
		fieldForClass.put(PHOG.class, FIELD_NAME_PHOG);
		fieldForClass.put(RotationInvariantLocalBinaryPatterns.class,
				FIELD_NAME_ROTATION_INVARIANT_LOCAL_BINARY_PATTERNS);
		fieldForClass.put(ScalableColor.class, FIELD_NAME_SCALABLECOLOR);
		fieldForClass.put(Tamura.class, FIELD_NAME_TAMURA);

		// Setting up the field 2 class relation:
		classForField.put(FIELD_NAME_AUTOCOLORCORRELOGRAM,
				AutoColorCorrelogram.class);
		classForField.put(FIELD_NAME_BINARY_PATTERNS_PYRAMID,
				BinaryPatternsPyramid.class);
		classForField.put(FIELD_NAME_CEDD, CEDD.class);
		classForField
				.put(FIELD_NAME_COLORHISTOGRAM, SimpleColorHistogram.class);
		classForField.put(FIELD_NAME_COLORLAYOUT, ColorLayout.class);
		classForField.put(FIELD_NAME_EDGEHISTOGRAM, EdgeHistogram.class);
		classForField.put(FIELD_NAME_FCTH, FCTH.class);
		classForField.put(FIELD_NAME_GABOR, Gabor.class);
		classForField.put(FIELD_NAME_JCD, JCD.class);
		classForField.put(FIELD_NAME_JOINT_HISTOGRAM, JointHistogram.class);
		classForField
				.put(FIELD_NAME_JPEGCOEFFS, JpegCoefficientHistogram.class);
		classForField.put(FIELD_NAME_LOCAL_BINARY_PATTERNS,
				LocalBinaryPatterns.class);
		classForField.put(FIELD_NAME_LUMINANCE_LAYOUT, LuminanceLayout.class);
		classForField.put(FIELD_NAME_OPPONENT_HISTOGRAM,
				OpponentHistogram.class);
		classForField.put(FIELD_NAME_PHOG, PHOG.class);
		classForField.put(FIELD_NAME_ROTATION_INVARIANT_LOCAL_BINARY_PATTERNS,
				RotationInvariantLocalBinaryPatterns.class);
		classForField.put(FIELD_NAME_SCALABLECOLOR, ScalableColor.class);
		classForField.put(FIELD_NAME_TAMURA, Tamura.class);
	}

	// Decide between byte array version (fast) or string version (slow)
	public enum Mode {
		Fast, Slow
	}

	public Generic(Class<? extends LireFeature> descriptorClass) {
		this.descriptorClass = descriptorClass;
		this.fieldName = fieldForClass.get(descriptorClass);
		if (fieldName == null) {
			try {
				fieldName = descriptorClass.newInstance().getFieldName();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Field[] createDescriptorFields(BufferedImage image) {
		Field[] result;
		if (hashingEnabled)
			result = new Field[2];
		else
			result = new Field[1];
		String featureString = "";
		assert (image != null);
		BufferedImage bimg = image;
		// Scaling image is especially with the correlogram features very
		// important!
		// All images are scaled to guarantee a certain upper limit for
		// indexing.
		if (Math.max(image.getHeight(), image.getWidth()) > MAX_IMAGE_DIMENSION) {
			bimg = ImageUtils.scaleImage(image, MAX_IMAGE_DIMENSION);
		}
		Document doc = null;
		try {
			logger.finer("Starting extraction from image ["
					+ descriptorClass.getName() + "].");
			LireFeature lireFeature = null;

			lireFeature = descriptorClass.newInstance();

			lireFeature.extract(bimg);
			System.out.println("--------------------------------");
			System.out.println(lireFeature.getByteArrayRepresentation());
			System.out.println("--------------------------------");
			// featureString = vd.getStringRepresentation();
			logger.fine("Extraction finished [" + descriptorClass.getName()
					+ "].");

			// TODO: Stored field is compressed and upon search decompression
			// takes a lot of time (> 50% with a small index with 50k images).
			// Find something else ...
			result[0] = new StoredField(fieldName, new BytesRef(lireFeature
					.getByteArrayRepresentation()));

			// if BitSampling is an issue we add a field with the given
			// hashFunctionsFileName and the suffix "hash":
			if (hashingEnabled) {
				// TODO: check eventually if there is a more compressed string
				// version of the integers. i.e. the hex string
				if (lireFeature.getDoubleHistogram().length <= 3100) {
					int[] hashes;
					if (hashingMode == HashingMode.BitSampling) {
						hashes = BitSampling.generateHashes(lireFeature
								.getDoubleHistogram());
					} else {
						hashes = LocalitySensitiveHashing
								.generateHashes(lireFeature
										.getDoubleHistogram());
					}
					result[1] = new TextField(fieldName + HASH_FIELD_SUFFIX,
							SerializationUtils.arrayToString(hashes),
							Field.Store.YES);
				} else
					System.err
							.println("Could not create hashes, feature vector too long: "
									+ lireFeature.getDoubleHistogram().length
									+ " ("
									+ lireFeature.getClass().getName()
									+ ")");
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Creates a fully fledged Document to be added to a Lucene index.
	 * 
	 * @param image
	 *            the image to index. Cannot be NULL.
	 * @param identifier
	 *            an id for the image, for instance the filename or an URL. Can
	 *            be NULL.
	 * @return
	 */
	public Document createDocument(BufferedImage image, String identifier) {
		assert (image != null);

		// sangupta: create a new document else code below
		// will throw a NPE
		Document doc = new Document();

		if (identifier != null) {
			doc.add(new StringField(DocumentBuilder.FIELD_NAME_IDENTIFIER,
					identifier, Field.Store.YES));
		}

		Field[] fields = createDescriptorFields(image);
		for (int i = 0; i < fields.length; i++) {
			doc.add(fields[i]);
		}

		return doc;
	}

}
