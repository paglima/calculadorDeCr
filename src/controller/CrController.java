package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

import service.CrService;
import utils.CrUtils;

public class CrController {
	
	public static void main(String[] args) {
		try{
			String    nome  	= Arrays.asList(new String[]{"total.txt","crPaula.txt","parcial.txt"}).get(0);
			File      file		= new File(nome);
			CrService crService =  new CrService(file);
			
			CrUtils.printConteudo(crService);
			
			System.out.format("\n%15s\t\t%s","CR: ",crService.calculaCr());
			System.out.format("\n%15s\t\t%.0f/3524","CHC/CHT: ",crService.getChCursada());
			System.out.format("\n%15s\t\t%.2f","(%): ",crService.calculaPorcentagem());
			
			
		}catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}	
		
	}

}