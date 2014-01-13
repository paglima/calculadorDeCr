package service;

import java.io.File;
import java.util.List;

import model.Disciplina;
import dao.DisciplinaDAO;

public class DisciplinaService {
	
	private DisciplinaDAO disciplinaDao;
	
	protected DisciplinaService(File file){
		disciplinaDao = new DisciplinaDAO(file);
	}
	
	public List<Disciplina> findAll() {
		return disciplinaDao.findAll();
	}

}