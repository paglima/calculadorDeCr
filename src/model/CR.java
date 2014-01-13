package model;

import java.math.BigDecimal;

public class CR {
	
	private BigDecimal somaProdutoNotaECH;
	private BigDecimal chConcluida;
	private BigDecimal chTotal;
	
	public CR(BigDecimal somaProdutoNotaECH, BigDecimal chConcluida, BigDecimal chTotal) {
		this.somaProdutoNotaECH = somaProdutoNotaECH;
		this.chConcluida 		= chConcluida;
		this.chTotal			= chTotal;
	}

	public BigDecimal getChTotal() {
		return chTotal;
	}

	public void setChTotal(BigDecimal chTotal) {
		this.chTotal = chTotal;
	}

	public CR() {
	}

	public BigDecimal getProdutoEntreNotaECH() {
		return somaProdutoNotaECH;
	}

	public CR setProdutoEntreNotaECH(BigDecimal produtoEntreNotaECH) {
		this.somaProdutoNotaECH = produtoEntreNotaECH;
		return this;
	}

	public BigDecimal getChConcluida() {
		return chConcluida;
	}

	public CR setChConcluida(BigDecimal chTotal) {
		this.chConcluida = chTotal;
		return this;
	}

}