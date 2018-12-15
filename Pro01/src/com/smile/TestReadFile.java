package com.smile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReadFile {
	public static void main(String[] args) {
		FileReader reader = null;
		try {
			// FileReader reader = new FileReader("D:\\eclipse-workspace\\a.txt");
			reader = new FileReader("D:\\eclipse-workspace\\a.txt");
			char c = (char) reader.read();
			char c2 = (char) reader.read();
			System.out.println("" + c + c2);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
