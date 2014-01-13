package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import model.CR;
import model.Disciplina;

public class CrService {
	
	private DisciplinaService disciplinaService;
	private CR cr;
	
	public CrService(File file){
		disciplinaService = new DisciplinaService(file);
		cr 				  = montaCr();
	}
	
	public BigDecimal calculaCr() throws FileNotFoundException{
		return cr.getProdutoEntreNotaECH().divide(cr.getChTotal(), 2, RoundingMode.HALF_UP);
	} 
	
	private CR montaCr() {
		Double somaProdutoNotaECH = 0.0;
		Double chConcluida = 0.0;
		Double chTotal = 0.0;
		for (Disciplina d : disciplinaService.findAll()) {
			somaProdutoNotaECH += (d.getNota()*d.getCargaHoraria());
			chTotal   		   += d.getCargaHoraria();
			chConcluida		   += d.getNota() >=5 ? d.getCargaHoraria() : 0; 	
		}
		return new CR(BigDecimal.valueOf(somaProdutoNotaECH), BigDecimal.valueOf(chConcluida), BigDecimal.valueOf(chTotal));
	}
	
	public BigDecimal getChCursada() throws FileNotFoundException{
		return cr.getChConcluida();
	}
	
	public BigDecimal calculaPorcentagem() throws FileNotFoundException{
		return BigDecimal.valueOf(cr.getChConcluida().doubleValue()/3524.0).multiply(BigDecimal.valueOf(100));
	}
}
