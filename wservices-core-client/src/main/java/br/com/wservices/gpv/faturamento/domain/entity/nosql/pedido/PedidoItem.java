package br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.ObjectUtils;

public class PedidoItem implements Serializable {

	private static final long serialVersionUID = 5018286464168893944L;

	private Integer numeroSequencialItemNota;
	
	private String sku;

	private String codigoSKUKit;

	@NotNull(message = "O nome do produto não pode ser nulo")
	@Size(min = 1,  message = "O campo cfop não pode ser nulo")
	private String nomeProduto;

	@NotNull(message = "O ean do produto não pode ser nulo")
	@Size(min = 1,  message = "O ean não pode ser nulo")
	private String ean;

	@NotNull(message = "O ncm do produto não pode ser nulo")
	@Size(min = 1,  message = "O ncm não pode ser nulo")
	private String ncm;

	@NotNull(message = "O origem do Produto não pode ser nulo")
	@Pattern(regexp = "0|1|2|3|4|5")
	private String origemProduto;

	@NotNull(message = "O preço do produto não pode ser nulo")
	private BigDecimal precoBrutoUnitario;

	@NotNull(message = "A quantidade do produto não pode ser nulo")
	private BigDecimal quantidade;

	@NotNull(message = "O encago do produto não pode ser nulo")
	private BigDecimal encargo;

	@NotNull(message = "O origem do Produto não pode ser nulo")
	@Pattern(regexp = "N|B")
	private String tipoItem;

	@NotNull(message = "A unidade de medida não pode ser nulo")
	@Size(min = 1,  message = "A unidade de medida não pode ser nulo")
	private String unidadeMedida;

	@NotNull(message = "O desconto condicional não pode ser nulo")
	private BigDecimal valorDescontoCondicional;

	@NotNull(message = "O desconto incondicional não pode ser nulo")
	private BigDecimal valorDescontoIncondicional;

	
	private List<AssociacaoPedido> associacoes = new ArrayList<AssociacaoPedido>();
	
	public String getCodigoSKUKit() {
		return codigoSKUKit;
	}

	public void setCodigoSKUKit(String codigoSKUKit) {
		this.codigoSKUKit = codigoSKUKit;
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

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public String getOrigemProduto() {
		return origemProduto;
	}

	public void setOrigemProduto(String origemProduto) {
		this.origemProduto = origemProduto;
	}

	public BigDecimal getPrecoBrutoUnitario() {
		return ObjectUtils.defaultIfNull(precoBrutoUnitario, BigDecimal.ZERO);
	}

	public void setPrecoBrutoUnitario(BigDecimal precoBrutoUnitario) {
		this.precoBrutoUnitario = precoBrutoUnitario;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public void setValorDescontoCondicional(BigDecimal valorDescontoCondicional) {
		this.valorDescontoCondicional = valorDescontoCondicional;
	}

	public void setValorDescontoIncondicional(BigDecimal valorDescontoIncondicional) {
		this.valorDescontoIncondicional = valorDescontoIncondicional;
	}
	
	public BigDecimal getEncargo() {
		return ObjectUtils.defaultIfNull(encargo, BigDecimal.ZERO);
	}

	public void setEncargo(BigDecimal encargo) {
		this.encargo = encargo;
	}
	
	public Integer getNumeroSequencialItemNota() {
		return numeroSequencialItemNota;
	}

	public void setNumeroSequencialItemNota(Integer numeroSequencialItemNota) {
		this.numeroSequencialItemNota = numeroSequencialItemNota;
	}

	public List<AssociacaoPedido> getAssociacoes() {
		return associacoes;
	}

	public void setAssociacoes(List<AssociacaoPedido> associacoes) {
		this.associacoes = associacoes;
	}

	public BigDecimal getValorDescontoCondicional() {
		return ObjectUtils.defaultIfNull(valorDescontoCondicional, BigDecimal.ZERO);
	}

	public BigDecimal getValorDescontoIncondicional() {
		return ObjectUtils.defaultIfNull(valorDescontoIncondicional, BigDecimal.ZERO);
	}
}
