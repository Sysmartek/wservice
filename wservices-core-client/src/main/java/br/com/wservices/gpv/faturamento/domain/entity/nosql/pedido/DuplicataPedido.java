package br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.validation.constraints.NotNull;

public class DuplicataPedido implements Serializable {

	private static final long serialVersionUID = 8876322175409874981L;

	private String numeroDuplicata;
	
	@NotNull(message = "Data de vencimento não pode ser nulo")
	private Calendar dataVencimento;
	
	@NotNull(message = "Valor não pode ser nulo")
	private BigDecimal valor;

	public String getNumeroDuplicata() {
		return numeroDuplicata;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setNumeroDuplicata(String numeroDuplicata) {
		this.numeroDuplicata = numeroDuplicata;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
}
