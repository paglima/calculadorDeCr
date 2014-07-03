package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

import service.CrService;
import service.DisciplinaService;
import utils.CrUtils;

public class CrController {
	
	private static final int TOTAL_DE_DISCIPLINAS = 49;
	
	private static DisciplinaService disciplinaService;
	
	private static CrService crService;
	
	private static File file;
	
	public static void main(String[] args) {
		try{
			String    nome  	= Arrays.asList(new String[]{"meu.txt","crPaula.txt","parcial.txt"}).get(0);
			
			file			  = new File(nome);
			
			crService 		  = new CrService(file);
			
			disciplinaService = new DisciplinaService(file);
			
//			CrUtils.printConteudo(disciplinaService.findByPeriodo("14.1"));
			CrUtils.printConteudo(disciplinaService.findAll());
			
			Integer disciplinasAprovadas 	= disciplinaService.countDisciplinasAprovadas(1);
			Integer disciplinasCursadas 	= disciplinaService.countDisciplinasCursadas(1);
			
			System.out.format("\n%-16s%s","AP:" , disciplinasAprovadas +"/"+ disciplinasCursadas);
			System.out.format("\n%-16s%s","Restantes:"  ,( TOTAL_DE_DISCIPLINAS - disciplinasAprovadas ));
			
			System.out.format("\n%-16s%s","CR: ",crService.calculaCr());
			System.out.format("\n%-16s%.0f/3524","CHC/CHT: ",crService.getChCursada());
			System.out.format("\n%-16s%.2f","(%): ",crService.calculaPorcentagem());
			
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	public static void formataArquivo(File file) throws FileNotFoundException{
		Scanner scan = new Scanner(file);
		Formatter form =  new Formatter(new File("backup.txt"));
		while(scan.hasNextLine()){
			String linha = scan.nextLine();
			String[] celula = linha.split(" ");
			String newLine = celula[2]+" "+celula[0]+" "+celula[1]+" "+celula[3]+" ";
			form.format("%s", newLine+"\n");
		}
		form.close();
		scan.close();
	}

}