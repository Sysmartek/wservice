package br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import br.com.sysmartek.framework.exception.DomainException;

public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	// Anotação Id do pacote org.springframework.data.annotation
	@Id
	@NotNull(message = "O número do pedido não pode ser nulo")
	private Long numeroPedido;

	@NotNull(message = "Deve existir pelo menos uma entrega")
	@NotEmpty(message = "Deve existir pelo menos uma entrega")
	@Valid
	private List<Entrega> entregas;

	@NotNull(message = "O destinatário não pode ser nulo")
	@Valid
	private PessoaPedido destinatario;

	private Boolean faturado = Boolean.FALSE;

	private Boolean erro = Boolean.FALSE;

	public Long getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public List<Entrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(List<Entrega> entregas) {
		this.entregas = entregas;
	}

	public PessoaPedido getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(PessoaPedido destinatario) {
		this.destinatario = destinatario;
	}

	public Boolean getFaturado() {
		return faturado;
	}

	public void setFaturado(Boolean faturado) {
		this.faturado = faturado;
	}

	public Boolean getErro() {
		return erro;
	}

	public void setErro(Boolean erro) {
		this.erro = erro;
	}

	public void validarRegrasNegocio() throws DomainException {
		for (Entrega entrega : getEntregas()) {
			for (PedidoItem pedidoItem : entrega.getItens()) {
				if (ObjectUtils.defaultIfNull(pedidoItem.getCodigoSKUKit(), "").equals("")
								&& ObjectUtils.defaultIfNull(pedidoItem.getSku(), "").equals("")) {
					throw new DomainException("O sku não pode ser nulo");
				}
			}

			validarPagamentos(entrega);
		}
	}

	private void validarPagamentos(Entrega entrega) throws DomainException {
		BigDecimal totalPagamento = BigDecimal.ZERO;
		for (PagamentoPedido pagamentoPedido : entrega.getPagamentos()) {
			BigDecimal valorPagamento = pagamentoPedido.getValorParcela().multiply(
							new BigDecimal(pagamentoPedido.getQuantidadeParcelas()));
			totalPagamento = totalPagamento.add(valorPagamento);

			validarDuplicatas(pagamentoPedido.getDuplicatas(), valorPagamento);
		}
		if (totalPagamento.compareTo(entrega.getValorTotalEntregaParaCobrarCliente()) != 0) {
			throw new DomainException("Valor total de pagamentos diferente do valor total do pedido");
		}
	}

	private void validarDuplicatas(List<DuplicataPedido> duplicatas, BigDecimal valorPagamento) throws DomainException {
		//validar o total do pagamento com o total de duplicatas qdo existir
		if (duplicatas != null && !duplicatas.isEmpty()) {
			BigDecimal totalDuplicatas = BigDecimal.ZERO;
			for (DuplicataPedido duplicataPedido : duplicatas) {
				totalDuplicatas = totalDuplicatas.add(duplicataPedido.getValor());
			}				
			if (valorPagamento.compareTo(totalDuplicatas) != 0) {
				throw new DomainException("Valor total das duplicatas diferente do valor do pagamento");
			}
		}
	}
	
	
}
