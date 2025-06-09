package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		File file = new File("/home/santsss/Documentos/in.txt");

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			System.out.println("Finally block executed.");
		}
	}

}
