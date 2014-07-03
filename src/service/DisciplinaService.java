package service;

import java.io.File;
import java.util.List;

import model.Disciplina;
import dao.DisciplinaDAO;

public class DisciplinaService {
	
	private DisciplinaDAO disciplinaDao;
	
	public DisciplinaService(File file){
		disciplinaDao = new DisciplinaDAO(file);
	}
	
	public List<Disciplina> findAll() {
		return disciplinaDao.findAll();
	}
	
	public Integer countDisciplinasCursadas(int estMaisProj) {
		return disciplinaDao.findAll().size() - estMaisProj;
	}
	
	public Integer countDisciplinasAprovadas(int estMaisProj) {
		return disciplinaDao.getAprovadas() - estMaisProj;
	}
	
	public List<Disciplina> findByPeriodo(String periodo) {
		return disciplinaDao.findByPeriodo(periodo);
	}

}