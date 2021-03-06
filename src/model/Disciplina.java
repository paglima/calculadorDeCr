package model;

public class Disciplina {
	
	private Double nota;
	private Integer cargaHoraria;
	private String nome;
	private String periodo;
	private String situacao;
	
	public Disciplina(){
		
	}
	
	public Disciplina(String nome , Double nota, Integer cargaHoraria, String periodo,String situacao) {
		this.nome = nome;
		this.nota = nota;
		this.cargaHoraria = cargaHoraria;
		this.periodo = periodo;
		this.situacao = situacao;
	}
	
	public Double getNota() {
		return nota;
	}
	
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getPeriodo() {
		return periodo;
	}
	
	public Disciplina setNota(Double nota) {
		this.nota = nota;
		return this;
	}
	
	public Disciplina setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
		return this;
	}
	
	public Disciplina setNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public Disciplina setPeriodo(String periodo) {
		this.periodo = periodo;
		return this;
	}
	
	public String toString(){
		return getNome()+" "+getNota() +" "+ getCargaHoraria()+" ";
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
}
