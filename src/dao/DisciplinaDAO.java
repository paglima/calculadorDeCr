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

	public DisciplinaDAO(File file){
		try {
			this.file = file;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	public List<Disciplina> findAll(){
		List<Disciplina> disciplinas = null;
		try {
			abreConexao(file);
			disciplinas = new ArrayList<Disciplina>();
			while(scanner.hasNextLine()){
				disciplinas.add(new Disciplina(scanner.next(), scanner.nextDouble(),scanner.nextInt(),scanner.next()));          
			}
			
		} catch (Exception e) {

		}
		fechaConexao();
		return disciplinas;
	}
	private void abreConexao(File file) throws FileNotFoundException {
		scanner = new Scanner(file);
	}

	private void fechaConexao() {
		scanner.close();
	} 
	
}