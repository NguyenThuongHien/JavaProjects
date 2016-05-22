package com.company;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;

import net.semanticmetadata.lire.DocumentBuilder;
import net.semanticmetadata.lire.imageanalysis.AutoColorCorrelogram;
import net.semanticmetadata.lire.imageanalysis.CEDD;
import net.semanticmetadata.lire.imageanalysis.ColorLayout;
import net.semanticmetadata.lire.imageanalysis.EdgeHistogram;
import net.semanticmetadata.lire.imageanalysis.FCTH;
import net.semanticmetadata.lire.imageanalysis.Gabor;
import net.semanticmetadata.lire.imageanalysis.JpegCoefficientHistogram;
import net.semanticmetadata.lire.imageanalysis.LireFeature;
import net.semanticmetadata.lire.imageanalysis.LocalBinaryPatterns;
import net.semanticmetadata.lire.imageanalysis.LuminanceLayout;
import net.semanticmetadata.lire.imageanalysis.OpponentHistogram;
import net.semanticmetadata.lire.imageanalysis.PHOG;
import net.semanticmetadata.lire.imageanalysis.ScalableColor;
import net.semanticmetadata.lire.imageanalysis.SimpleColorHistogram;
import net.semanticmetadata.lire.imageanalysis.Tamura;
import net.semanticmetadata.lire.imageanalysis.joint.JointHistogram;
import net.semanticmetadata.lire.impl.GenericDocumentBuilder;
import net.semanticmetadata.lire.utils.FileUtils;
import net.semanticmetadata.lire.utils.LuceneUtils;

import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;

public class SingleIndex {

	public static void main(String[] args) throws IOException {
		String imagePath = Constant.imagePath;
		String indexPath = Constant.indexPath;

		long start = System.currentTimeMillis();

		ArrayList<String> images = FileUtils.getAllImages(new File(imagePath),
				true);

		// DocumentBuilder builder = Constant.builder;

		DocumentBuilder builder = new GenericDocumentBuilder(Tamura.class);

		IndexWriterConfig conf = new IndexWriterConfig(
				LuceneUtils.LUCENE_VERSION, new WhitespaceAnalyzer(
						LuceneUtils.LUCENE_VERSION));

		IndexWriter iw = new IndexWriter(FSDirectory.open(new File(indexPath)),
				conf);

		File f = new File("Tamurahh.txt");
		f.createNewFile();

		FileOutputStream propFile = null;
		MultiOutputStream multi = null;

		propFile = new FileOutputStream(f, true); // ��׷�ӵķ�ʽ

		multi = new MultiOutputStream(new PrintStream(propFile), System.out);
		System.setOut(new PrintStream(multi));

		for (Iterator<String> it = images.iterator(); it.hasNext();) {
			String imageFilePath = it.next();

			String imageSub = imageFilePath.substring(0, imageFilePath
					.lastIndexOf("\\"));
			imageSub = imageSub.replaceAll("\\\\", "/");
			// System.out.print(imageFilePath);
			try {
				BufferedImage img = ImageIO.read(new FileInputStream(
						imageFilePath));
				Document document = builder.createDocument(img, imageFilePath);

				LireFeature lireFeature = null;
				lireFeature = Tamura.class.newInstance();
				lireFeature.extract(img);

				Field[] result = builder.createDescriptorFields(img);
				// result[0] = new StoredField("featureColorLayo ut", new
				// BytesRef(lireFeature.getByteArrayRepresentation()));
				byte[] bytes = lireFeature.getByteArrayRepresentation();

				ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
				int data = bais.read();

				int i = 0;
				while (data != -1) {
					// System.out.print(data+" ");
					data = bais.read();
					i++;
				}

				// System.out.println();
				// System.out.print();
				bais.close();
				ByteArrayInputStream bais1 = new ByteArrayInputStream(bytes);
				int data1 = bais1.read();
				int j = 0;
				while (data1 != -1) {
					System.out.print(data1 + " ");
					data1 = bais1.read();
					j++;
				}

				if (imageSub
						.equals("E:/WorkspacesMyEclipse 8.5/SkinRetrieval0.3/pics/BCC")) {
					imageSub = "1";
				} else if (imageSub
						.equals("E:/WorkspacesMyEclipse 8.5/SkinRetrieval0.3/pics/MM")) {
					imageSub = "2";
				} else if (imageSub
						.equals("E:/WorkspacesMyEclipse 8.5/SkinRetrieval0.3/pics/Nevi")) {
					imageSub = "3";
				} else {
					imageSub = "4";
				}

				System.out.print(imageSub);
				System.out.println();
				iw.addDocument(document);
				// System.out.println(document);
			} catch (Exception e) {
				System.out.println("Error reading image or indexing it.");
				e.printStackTrace();
			}
		}

		multi.close();
		propFile.close();

		iw.close();
		System.out.println("Finished indexing.");
		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000 + "s");

	}

}
