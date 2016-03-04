package br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class PagamentoPedido implements Serializable {

	private static final long serialVersionUID = -4614137671003113475L;

	@NotNull(message = "A forma de pagamento pode ser nulo")
	private Integer formaPagamento;

	@NotNull(message = "A quantidade de parcelas pode ser nulo")
	private Integer quantidadeParcelas;

	@NotNull(message = "O valor de parcelas pode ser nulo")
	private BigDecimal valorParcela;

	@Valid
	private List<DuplicataPedido> duplicatas;
	
	private CondicaoPagamentoPedido condicaoPagamentoPedido;
	
	public Integer getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(Integer formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Integer getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	public void setQuantidadeParcelas(Integer quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}

	public BigDecimal getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}
	
	public List<DuplicataPedido> getDuplicatas() {
		return duplicatas;
	}

	public void setDuplicatas(List<DuplicataPedido> duplicatas) {
		this.duplicatas = duplicatas;
	}

	public CondicaoPagamentoPedido getCondicaoPagamentoPedido() {
		return condicaoPagamentoPedido;
	}

	public void setCondicaoPagamentoPedido(CondicaoPagamentoPedido condicaoPagamentoPedido) {
		this.condicaoPagamentoPedido = condicaoPagamentoPedido;
	}

	public BigDecimal getTotalPagamento() {
		return this.valorParcela.multiply(new BigDecimal(quantidadeParcelas));
	}
}
