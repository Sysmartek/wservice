package br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class ProcessoReversa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull(message = "O id do processo de reversa não pode ser nulo")
	private Long id;

	@NotNull(message = "O objetivo do processo de reversa não pode ser nulo")
	private String objetivo;

	@NotNull(message = "A data de criação do processo de reversa não pode ser nulo")
	private Calendar dataCriacao;

	@NotNull(message = "O código da entrada do processo reversa não pode ser nulo")
	private Long codigoEntrada;
	
	@NotNull(message = "O id do pedido do processo reversa não pode ser nulo")
	private Long numeroPedido;

	@NotNull(message = "Deve existir pelo menos um pedido reversa")
	@NotEmpty(message = "Deve existir pelo menos um pedido reversa")
	@Valid
	private List<PedidoItemReversa> pedidosReversa;

	public ProcessoReversa() {
		super();
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public List<PedidoItemReversa> getPedidosReversa() {
		return pedidosReversa;
	}

	public void setPedidosReversa(List<PedidoItemReversa> pedidosReversa) {
		this.pedidosReversa = pedidosReversa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigoEntrada() {
		return codigoEntrada;
	}

	public void setCodigoEntrada(Long codigoEntrada) {
		this.codigoEntrada = codigoEntrada;
	}

	public Long getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Long idPedido) {
		this.numeroPedido = idPedido;
	}

}
