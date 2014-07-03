package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Disciplina;

public class DisciplinaDAO {
	
	private Scanner scanner;
	private File file;
	private Integer aprovadas 	= 0;
	private Integer reprovadas 	= 0;

	public DisciplinaDAO(File file){
		try {
			this.file = file;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<Disciplina> findAll(){
		List<Disciplina> disciplinas = null;
		resetSituacao();
		
		try {
			abreConexao();
			disciplinas = new ArrayList<Disciplina>();
			while(scanner.hasNextLine()){
				String nome 	= scanner.next();
				Double nota 	= scanner.nextDouble();
				Integer ch 		= scanner.nextInt();
				String periodo 	= scanner.next();
				String situacao = scanner.next();
				
				if(nome.charAt(0) == '#'){
					continue;
				}
				
				countBySituacao(situacao);
				
				disciplinas.add(new Disciplina(nome,nota,ch,periodo,situacao));          
			}
			
		} catch (Exception e) {

		}
		fechaConexao();
		return disciplinas;
	}
	
	public List<Disciplina> findByPeriodo(String periodo) {
		List<Disciplina> disciplinas = null;
		resetSituacao();
		
		try {
			abreConexao();
			disciplinas = new ArrayList<Disciplina>();
			while(scanner.hasNextLine()){
				String nome 	= scanner.next();
				Double nota 	= scanner.nextDouble();
				Integer ch 		= scanner.nextInt();
				String p 		= scanner.next();
				String situacao = scanner.next();
				
				if(nome.charAt(0) == '#'){
					continue;
				}
				
				if(p.equals(periodo)){
					countBySituacao(situacao);
					disciplinas.add(new Disciplina(nome,nota,ch,periodo,situacao));          
				}
			}
			
		} catch (Exception e) {
			
		}
		fechaConexao();
		return disciplinas;
	} 

	private void countBySituacao(String situacao) {
		if(situacao.equals("AP")){
			aprovadas++;
		}
		
		if(situacao.equals("REP")){
			reprovadas++;
		}
	}
	
	private void resetSituacao(){
		aprovadas 	= 0;
		reprovadas	= 0;
	}
	
	private void abreConexao() throws FileNotFoundException {
		scanner = new Scanner(file);
	}

	private void fechaConexao() {
		scanner.close();
	}

	public Integer getAprovadas() {
		return aprovadas;
	}

	public void setAprovadas(Integer aprovadas) {
		this.aprovadas = aprovadas;
	}

	public Integer getReprovadas() {
		return reprovadas;
	}

	public void setReprovadas(Integer reprovadas) {
		this.reprovadas = reprovadas;
	}
	
}