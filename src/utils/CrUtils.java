package utils;

import java.io.FileNotFoundException;
import java.util.List;

import model.Disciplina;
import service.CrService;

public class CrUtils {

	private static final int TOTAL_DE_DISCIPLINAS = 49;

	public static void printConteudo(CrService crService) throws FileNotFoundException {
		System.out.format("%13s%14s%14s%14s\n", "NOME","NOTA","CH","SEMESTRE");
		
		List<Disciplina> disciplinas = crService.findAll();		
		int cont = 0, cont2 = 0;
		
		for (Disciplina disciplina : disciplinas) {
			String nome		  = disciplina.getNome();
			Double nota 	  = disciplina.getNota();
			boolean ehEstagio = !ehEstagioOuProjeto(nome);
			if(foiAprovado(nota)){
				System.out.format("%13s%14s%14s%14s\n", nome, nota.toString(), disciplina.getCargaHoraria(), disciplina.getPeriodo());
				cont += ehEstagio? 1: 0;
			}else{
				System.out.format("%13s%14s%14s%14s\n", nome, nota.toString(), disciplina.getCargaHoraria(), "[REP] "+disciplina.getPeriodo());
			}
			cont2 += ehEstagio? 1: 0;
		}
		System.out.format("\n%14s\t\t%s","AP:" , cont+"/"+cont2);
		System.out.format("\n%14s\t\t%s","Restantes:"  ,( TOTAL_DE_DISCIPLINAS - (cont)));
			
	}

	private static boolean ehEstagioOuProjeto(String nome) {
		return nome.equals("Estagio") || nome.contains("Projeto");
	}

	public static boolean foiAprovado(double nota){
		return nota >= 5;
	}
}