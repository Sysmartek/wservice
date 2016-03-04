package br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.validator.constraints.NotEmpty;

public class Entrega implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private boolean simplesRemessa = false;
	
	public boolean isSimplesRemessa() {
		return simplesRemessa;
	}

	public void setSimplesRemessa(boolean simplesRemessa) {
		this.simplesRemessa = simplesRemessa;
	}

	@NotNull(message = "O código da entrega não pode ser nulo")
	private Long codigoEntrega;

	@NotNull(message = "O tipo de operação não pode ser nulo")
	private Integer tipoOperacao;

	@NotNull(message = "O cnpj do emitente não pode ser nulo")
	@Size(min = 1, message = "O cnpj do emitente não pode ser nulo")
	private String cnpjEmitente;

	@NotNull(message = "A unidade de negócio não pode ser nulo")
	private Integer unidadeNegocio;

	@NotNull(message = "O nome da unidade de negócio não pode ser nulo")
	@Size(min = 1, message = "O nome da unidade de negócio não pode ser nulo")
	private String nomeNegocio;

	@NotNull(message = "O valor do frete não pode ser nulo")
	private BigDecimal valorFrete;

	@NotNull(message = "O endereço do destinatário não pode ser nulo")
	@Valid
	private EnderecoPedido enderecoDestinatario;

	@NotNull(message = "Deve existir pelo menos um item na entrega")
	@NotEmpty(message = "Deve existir pelo menos um item na entrega")
	@Valid
	private List<PedidoItem> itens;

	@NotNull(message = "A minuta de tranporte não pode ser nulo")
	private Integer minutaTransporte;

	@NotNull(message = "O transportadora não pode ser nulo")
	@Valid
	private PessoaPedido transportadora;

	@NotNull(message = "Deve existir pelo menos uma mensgaem para a entrega")
	@NotEmpty(message = "Deve existir pelo menos uma mensgaem para a entrega")
	@Valid
	private List<MensagemPedido> mensagens;

	@Valid
	private List<PagamentoPedido> pagamentos;

	private List<ProcessoReversa> processosReversa;

	public EnderecoPedido getEnderecoDestinatario() {
		return enderecoDestinatario;
	}

	public void setEnderecoDestinatario(EnderecoPedido enderecoDestinatario) {
		this.enderecoDestinatario = enderecoDestinatario;
	}

	public String getCnpjEmitente() {
		return cnpjEmitente;
	}

	public void setCnpjEmitente(String cnpjEmitente) {
		this.cnpjEmitente = cnpjEmitente;
	}

	public Long getCodigoEntrega() {
		return codigoEntrega;
	}

	public void setCodigoEntrega(Long codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}

	public List<PedidoItem> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItem> itens) {
		this.itens = itens;
	}

	public Integer getMinutaTransporte() {
		return minutaTransporte;
	}

	public void setMinutaTransporte(Integer minutaTransporte) {
		this.minutaTransporte = minutaTransporte;
	}

	public PessoaPedido getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(PessoaPedido transportadora) {
		this.transportadora = transportadora;
	}

	public Integer getUnidadeNegocio() {
		return unidadeNegocio;
	}

	public void setUnidadeNegocio(Integer unidadeNegocio) {
		this.unidadeNegocio = unidadeNegocio;
	}

	public List<MensagemPedido> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<MensagemPedido> mensagens) {
		this.mensagens = mensagens;
	}

	public Integer getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(Integer tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public List<PagamentoPedido> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<PagamentoPedido> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public BigDecimal getValorFrete() {
		return ObjectUtils.defaultIfNull(valorFrete, BigDecimal.ZERO);
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	public String getNomeNegocio() {
		return nomeNegocio;
	}

	public void setNomeNegocio(String nomeNegocio) {
		this.nomeNegocio = nomeNegocio;
	}

	public List<ProcessoReversa> getProcessosReversa() {
		return processosReversa;
	}

	public void setProcessosReversa(List<ProcessoReversa> processosReversa) {
		this.processosReversa = processosReversa;
	}

	public BigDecimal getValorTotalPagamentos() {
		BigDecimal totalPagamentos = BigDecimal.ZERO;
		for (PagamentoPedido pagamentoPedido : pagamentos) {
			totalPagamentos = totalPagamentos.add(pagamentoPedido.getTotalPagamento());
		}
		return totalPagamentos;
	}

	public BigDecimal getValorTotalEntregaParaCobrarCliente() {
		BigDecimal totalEntregaCobrarCliente = BigDecimal.ZERO;
		for (PedidoItem item : itens) {
			// Diferente de Brinde
			if (!item.getTipoItem().equals("B")) {
				totalEntregaCobrarCliente = totalEntregaCobrarCliente.add((item.getPrecoBrutoUnitario()
								.subtract(item.getValorDescontoCondicional())
								.subtract(item.getValorDescontoIncondicional()).multiply(item.getQuantidade()))
								.add(item.getEncargo()));
			}

		}
		return totalEntregaCobrarCliente.add(this.getValorFrete());
	}

	public BigDecimal getValorTotalEntregaSemDesconto() {
		BigDecimal totalEntrega = BigDecimal.ZERO;
		for (PedidoItem item : itens) {
			totalEntrega = totalEntrega.add((item.getPrecoBrutoUnitario().subtract(item.getValorDescontoCondicional())
							.multiply(item.getQuantidade())).add(item.getEncargo()));
		}
		return totalEntrega.add(this.getValorFrete());
	}

	public Boolean isPossuiDuplicatas() {
		Integer quantidade = 0;
		for (PagamentoPedido pagamentoPedido : pagamentos) {
			if (pagamentoPedido.getDuplicatas() != null) {
				quantidade = quantidade + pagamentoPedido.getDuplicatas().size();
			}
		}
		return quantidade > 0;
	}
}
