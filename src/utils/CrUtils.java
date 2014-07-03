package utils;

import java.io.FileNotFoundException;
import java.util.List;

import model.Disciplina;

public class CrUtils {

	public static void printConteudo(List<Disciplina> disciplinas) throws FileNotFoundException {
		
		System.out.format("%-18s%-14s%-14s%-14s\n", "NOME","NOTA","CH","SEMESTRE");
		System.out.println();
		
		for (Disciplina d : disciplinas) {
			String situacao = d.getSituacao().equals("REP") ? " [REP] " : "";
			System.out.format("%-18s%-14s%-14s%-14s\n", d.getNome(), d.getNota().toString(), d.getCargaHoraria(), d.getPeriodo() + situacao );
		}
			
	}
}