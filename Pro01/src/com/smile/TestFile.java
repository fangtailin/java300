package com.smile;

import java.io.File;
import java.io.IOException;

public class TestFile {

	public static void main(String[] args) {
		File f = new File("D:\\eclipse-workspace\\Pro01\\src\\com\\smile\\TestFile.java");
		File f2 = new File("D:\\eclipse-workspace\\Pro01\\src\\com\\smile");
		File f3 = new File(f2, "TestFile.java");

		File f4 = new File(f2, "TestFile444.java");
		// f5.mkdir();
		// f5.mkdirs();
		File f6 = new File("D:\\eclipse-workspace\\Pro01\\src");
		
		try {
			f4.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}

		f4.delete();

		if (f.isFile()) {
			System.out.println("is a file");
		}

		if (f2.isDirectory()) {
			System.out.println("is a Dictionary");
		}
		
		printFile(f6, 0);

	}

	// File Tree
	public static void printFile(File file, int level) {
		for (int i = 0; i < level; i++) {
			System.out.print("-");
		}
		System.out.println(file.getName());

		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File temp : files) {
				printFile(temp, level + 1);
			}
		}

	}
}
