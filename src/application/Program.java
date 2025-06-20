package application;

import model.entities.Product;

import java.io.*;
import java.util.*;

public class Program {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();
		
		System.out.println("Adicione o caminho do arquivo:");
		String pathStr = sc.nextLine();
		File path = new File(pathStr);
		String pathParent = path.getParent();
		
		Boolean exists = new File(pathParent + "/out").mkdir();
		
		String outPath = pathParent + "/out/summary.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while(line != null) {
				
				String[] fields = line.split(",");
				String name = fields[0];
				Double price = Double.parseDouble(fields[1]);
				Integer quant = Integer.parseInt(fields[2]);
				Product product = new Product(name, price, quant);
				
				list.add(product);
				
				line = br.readLine();
			}
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(outPath))) {
				for(Product p : list) {
					bw.write(p.toString());
					bw.newLine();
				}
				
				System.out.println("Arquivo criado: " + outPath);
			} catch(IOException e) {
				System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
				
			}
			
			System.out.println();
			
			try (BufferedReader brFinally = new BufferedReader(new FileReader(outPath))) {
				String lineOut = brFinally.readLine();
				while(lineOut != null) {
					System.out.println(lineOut);
					lineOut = brFinally.readLine();
				}
			} catch(IOException e) {
				System.out.println("Erro ao ler o arquivo: " + e.getMessage());
			}
			
		} catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

}
