package com.company;

import net.semanticmetadata.lire.DocumentBuilder;
import net.semanticmetadata.lire.DocumentBuilderFactory;
import net.semanticmetadata.lire.ImageSearcher;
import net.semanticmetadata.lire.ImageSearcherFactory;
import net.semanticmetadata.lire.impl.SimpleImageSearchHits;

public class Constant {

	public static int hits = 50;// �����������
	// ͼƬ��������ȡ�㷨
	// public static DocumentBuilder builder
	// =DocumentBuilderFactory.getCEDDDocumentBuilder();
	public static DocumentBuilder builder = DocumentBuilderFactory
			.getGaborDocumentBuilder();
	// ͼƬ�������㷨
	// public static ImageSearcher searcher =
	// ImageSearcherFactory.createCEDDImageSearcher(hits);
	public static ImageSearcher searcher = ImageSearcherFactory
			.createCEDDImageSearcher(hits);
	// ������������ͼƬ
	public static String imagePath = ".//pics";
	// ͼƬ�������λ��
	public static String indexPath = ".//pics//cedd-index";
	// ��������ͼƬ
	public static String searchfile = ".//pics//ɫ����//Image 037.jpg";

}
