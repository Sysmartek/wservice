package br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido;

public class AssociacaoPedidoNotaFiscal implements AssociacaoPedido {

	private static final long serialVersionUID = 4746679807162401677L;

	private Integer itemNotaFiscal;

	public AssociacaoPedidoNotaFiscal() {

	}

	public AssociacaoPedidoNotaFiscal(Integer itemNotaFiscal) {
		super();
		this.itemNotaFiscal = itemNotaFiscal;
	}

	public Integer getItemNotaFiscal() {
		return itemNotaFiscal;
	}

	public void setItemNotaFiscal(Integer itemNotaFiscal) {
		this.itemNotaFiscal = itemNotaFiscal;
	}

}
