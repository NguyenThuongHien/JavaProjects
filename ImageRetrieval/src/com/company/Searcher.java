package com.company;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import net.semanticmetadata.lire.DocumentBuilder;
import net.semanticmetadata.lire.ImageSearchHits;
import net.semanticmetadata.lire.ImageSearcher;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.FSDirectory;

public class Searcher {

	public static List<Map<String, String>> search(String searchfile) {
		List<Map<String, String>> arr = new ArrayList<Map<String, String>>(50);
		BufferedImage img = null;
		// String searchfile = "/images/1.jpg";

		String indexPath = Constant.indexPath;

		File f = new File(searchfile);

		if (f.exists()) {
			try {
				img = ImageIO.read(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			IndexReader ir = DirectoryReader.open(FSDirectory.open(new File(
					indexPath)));
			ImageSearcher searcher = Constant.searcher;
			ImageSearchHits hits = searcher.search(img, ir);

			for (int i = 0; i < hits.length(); i++) {
				String fileName = hits.doc(i).getValues(
						DocumentBuilder.FIELD_NAME_IDENTIFIER)[0];
				System.out.println(i + "\t" + (hits.score(i)) + ":\t"
						+ fileName);

				Map<String, String> m = new HashMap<String, String>();
				m.put("name", fileName);
				m.put("score", "" + hits.score(i));
				arr.add(m);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return arr;
	}

	public static void main(String[] args) {
		search(Constant.searchfile);
	}

}
