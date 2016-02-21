package br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class PedidoItemReversa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull(message = "O ID do item reversa não pode ser nulo")
	private Integer id;

	@NotNull(message = "A sku do item reversa não pode ser nulo")
	private String sku;

	@NotNull(message = "A quantidade do item reversa não pode ser nulo")
	private BigDecimal quantidade;

	@NotNull(message = "A data checkin do item reversa não pode ser nulo")
	private Calendar dataCheckin;

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public Calendar getDataCheckin() {
		return dataCheckin;
	}

	public void setDataCheckin(Calendar dataCheckin) {
		this.dataCheckin = dataCheckin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
