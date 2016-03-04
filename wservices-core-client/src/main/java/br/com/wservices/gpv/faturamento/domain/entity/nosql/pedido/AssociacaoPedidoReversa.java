package br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido;

public class AssociacaoPedidoReversa implements AssociacaoPedido {

	private static final long serialVersionUID = 1L;

	private Integer idPedidoItem;

	private Integer idPedidoItemReversa;

	private Integer idPedidoItemNFDevolucao;

	public AssociacaoPedidoReversa() {
	}

	public AssociacaoPedidoReversa(Integer idPedidoItem, Integer idPedidoItemReversa) {
		super();
		this.idPedidoItem = idPedidoItem;
		this.idPedidoItemReversa = idPedidoItemReversa;
	}

	public AssociacaoPedidoReversa(Integer idPedidoItem, Integer idPedidoItemReversa, Integer idPedidoItemNFDevolucao) {
		super();
		this.idPedidoItem = idPedidoItem;
		this.idPedidoItemReversa = idPedidoItemReversa;
		this.idPedidoItemNFDevolucao = idPedidoItemNFDevolucao;
	}

	public Integer getIdPedidoItem() {
		return idPedidoItem;
	}

	public void setIdPedidoItem(Integer idPedidoItem) {
		this.idPedidoItem = idPedidoItem;
	}

	public Integer getIdPedidoItemReversa() {
		return idPedidoItemReversa;
	}

	public void setIdPedidoItemReversa(Integer idPedidoItemReversa) {
		this.idPedidoItemReversa = idPedidoItemReversa;
	}

	public Integer getIdPedidoItemNFDevolucao() {
		return idPedidoItemNFDevolucao;
	}

	public void setIdPedidoItemNFDevolucao(Integer idPedidoItemNFDevolucao) {
		this.idPedidoItemNFDevolucao = idPedidoItemNFDevolucao;
	}

}
