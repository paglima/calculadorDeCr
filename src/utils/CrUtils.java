package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CrUtils {

	private static final int TOTAL_DE_DISCIPLINAS = 49;

	public static void printConteudo(String path) throws FileNotFoundException {
		System.out.format("%13s%14s%14s%14s\n", "NOME","NOTA","CH","SEMESTRE");
		
		Scanner scan = new Scanner(new File(path));
		int cont = 0, cont2 = 0;
		
		while (scan.hasNextLine()) {
			String nome		  = scan.next();
			Double nota 	  = scan.nextDouble();
			boolean ehEstagio = !ehEstagioOuProjeto(nome);
			if(foiAprovado(nota)){
				System.out.format("%13s%14s%14s%14s\n", nome, nota.toString(), scan.nextInt(), scan.next());
				cont += ehEstagio? 1: 0;
			}else{
				System.out.format("%13s%14s%14s%14s\n", nome, nota.toString(), scan.nextInt(), "[REP] "+scan.next());
			}
			cont2 += ehEstagio? 1: 0;
		}
		
		System.out.format("\n%14s\t\t%s","AP:" , cont+"/"+cont2);
		System.out.format("\n%14s\t\t%s","Restantes:"  ,( TOTAL_DE_DISCIPLINAS - (cont)));
		scan.close();
	}

	private static boolean ehEstagioOuProjeto(String nome) {
		return nome.equals("Estagio") || nome.contains("Projeto");
	}

	public static boolean foiAprovado(double nota){
		return nota >= 5;
	}
}