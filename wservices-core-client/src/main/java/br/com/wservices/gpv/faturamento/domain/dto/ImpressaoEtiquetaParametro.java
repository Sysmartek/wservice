package br.com.wservices.gpv.faturamento.domain.dto;

import java.io.Serializable;

import br.com.wservices.gpv.faturamento.domain.entity.NotaFiscal;
import br.com.wservices.gpv.faturamento.domain.entity.Transportadora;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido.Pedido;

public class ImpressaoEtiquetaParametro implements Serializable {

	private static final long serialVersionUID = 6964716365850407606L;

	private NotaFiscal notaFiscal;
	
	private Pedido pedido;
	
	private Transportadora transportadora;

	
	public ImpressaoEtiquetaParametro(NotaFiscal notaFiscal, Pedido pedido, Transportadora transportadora) {
		super();
		this.notaFiscal = notaFiscal;
		this.pedido = pedido;
		this.transportadora = transportadora;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Transportadora getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}
	
}
