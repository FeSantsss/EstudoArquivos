package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		File path = new File("/home/santsss/Documentos/in.txt");

		String[] linhas = new String[] { "oi ", "aoba ", "me chamo felipy" };

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

			for (String line : linhas) {
				bw.write(line);
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
