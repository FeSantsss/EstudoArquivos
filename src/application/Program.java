package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {

		FileReader fr = null;
		BufferedReader br = null;

		try {
			File file = new File("/home/santsss/Documentos/in.txt");
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				System.out.println("Error closing FileReader: " + e.getMessage());
			}
		}

	}

}
