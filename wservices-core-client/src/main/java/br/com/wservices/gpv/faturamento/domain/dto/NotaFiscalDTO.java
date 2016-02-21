package br.com.wservices.gpv.faturamento.domain.dto;

import java.io.Serializable;

import org.dozer.Mapping;

import br.com.sysmartek.framework.enumeration.PaisEnum;

public class NotaFiscalDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private PaisEnum codigoPais;
	
	@Mapping("idEntrega")
	private Long codigoEntrega;
	
	private Integer numero;
	
	private Long numeroPedido;
	
	private String status;
	
	private Boolean envioBackOffice = Boolean.FALSE;
	
	private String tipoEmissao;

	public Long getCodigoEntrega() {
		return codigoEntrega;
	}

	public void setCodigoEntrega(Long codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Long getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(Long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getEnvioBackOffice() {
		return envioBackOffice;
	}

	public void setEnvioBackOffice(Boolean envioBackOffice) {
		this.envioBackOffice = envioBackOffice;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PaisEnum getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(PaisEnum codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getTipoEmissao() {
		return tipoEmissao;
	}

	public void setTipoEmissao(String tipoEmissao) {
		this.tipoEmissao = tipoEmissao;
	}
}
