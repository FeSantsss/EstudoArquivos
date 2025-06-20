package application;

import java.io.*;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter folder path:");
		String strPath = sc.nextLine();

		File path = new File(strPath);

		File[] folders = path.listFiles(File::isDirectory);

		System.out.println("FOLDERS:");
		for (File folder : folders) {
			System.out.println(folder);
		}
		
		File[] files = path.listFiles(File::isFile);
		if (files != null) {
			System.out.println("FILES:");
			for (File file : files) {
				System.out.println(file);
			}
		}
	}

}
