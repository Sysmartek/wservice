package br.com.wservices.gpv.faturamento.domain.dto.filtro;

import java.io.Serializable;

public class UnidadeFaturamentoFiltro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1258209220598661775L;

	private String nomeUnidade;

	private String nic;

	private String razaoSocial;

	private String cnpj;

	public String getNomeUnidade() {
		return nomeUnidade;
	}

	public void setNomeUnidade(String nome) {
		this.nomeUnidade = nome;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

}
