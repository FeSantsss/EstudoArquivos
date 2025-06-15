package application;

import java.io.*;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Adicione a pasta que deseja: ");
			String strPath = sc.nextLine();

			File path = new File(strPath);

			try (BufferedReader br = new BufferedReader(new FileReader(path))) {

				String line = br.readLine();

				System.out.println("Veja o que tem dentro:");
				System.out.println();

				while (line != null) {
					System.out.println(line);
					line = br.readLine();
				}
			}
			
			System.out.println();
			System.out.print("Deseja adicionar algo ao arquivo(s/n)? ");
			char escolhaMudar = sc.next().toLowerCase().charAt(0);

			if (escolhaMudar == 's') {
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
					System.out.print("Deseja adicionar quantas linhas? ");
					Integer linhaDesejada = sc.nextInt();
					sc.nextLine();
					
					System.out.println("Escreva o que deseja:");

					for (int i = 0; i < linhaDesejada; i++) {
						bw.write(sc.nextLine());
						bw.newLine();
					}
					System.out.println("Adicionado com sucesso!");
				}
			} else {
				System.out.println("[Não quis mudar nada ao arquivo!]");
			}

			try (BufferedReader br = new BufferedReader(new FileReader(path))) {
				System.out.println();
				System.out.println("Leitura do arquivo novamente:");
				String line = br.readLine();
				
				System.out.println();

				while (line != null) {
					System.out.println(line);
					line = br.readLine();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			sc.close();
		}
	}

}
