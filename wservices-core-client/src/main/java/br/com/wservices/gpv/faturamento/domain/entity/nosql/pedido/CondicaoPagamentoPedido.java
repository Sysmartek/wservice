package br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido;

import java.io.Serializable;

public class CondicaoPagamentoPedido implements Serializable {
	
	private static final long serialVersionUID = 2042853993043995292L;

	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
