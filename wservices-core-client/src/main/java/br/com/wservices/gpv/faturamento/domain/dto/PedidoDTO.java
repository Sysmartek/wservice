package br.com.wservices.gpv.faturamento.domain.dto;

import java.io.Serializable;
import java.util.List;

import br.com.wservices.gpv.faturamento.domain.entity.Caixa;

public class PedidoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long numeroPedido;
	
	private Long codigoEntrega;

	private List<PedidoItemDTO> itens;
	
	private Long numeroCaixaAzul;
	
	private Caixa caixa;

	public Long getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Long getCodigoEntrega() {
		return codigoEntrega;
	}

	public void setCodigoEntrega(Long codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}

	public List<PedidoItemDTO> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItemDTO> pedidos) {
		this.itens = pedidos;
	}

	public Long getNumeroCaixaAzul() {
		return numeroCaixaAzul;
	}

	public void setNumeroCaixaAzul(Long numeroCaixaAzul) {
		this.numeroCaixaAzul = numeroCaixaAzul;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

}
