package br.com.wservices.gpv.faturamento.domain.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CondicaoPagamento implements Serializable {
	
	private static final long serialVersionUID = -4131406225137609L;

	@Column(name = "COD_CONDICAO_PAGAMENTO")
	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
