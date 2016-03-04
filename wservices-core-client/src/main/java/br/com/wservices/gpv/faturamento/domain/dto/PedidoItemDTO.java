package br.com.wservices.gpv.faturamento.domain.dto;

import java.io.Serializable;

public class PedidoItemDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String sku;

	private String nomeProduto;

	private String ean;

	private PedidoDTO pedido;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public PedidoDTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}
}
