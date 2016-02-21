package br.com.wservices.gpv.core.domain.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PessoaVO implements Serializable {

	private static final long serialVersionUID = -3544450052128217383L;

	@Column(name = "CPF_CNPJ")
	private String cpfcnpj;

	@Column(name = "DES_EMAIL")
	private String email;

	@Column(name = "DES_NOME")
	private String nome;

	@Column(name = "COD_IE")
	private String inscricaoEstadual;

	@Column(name = "NOM_FANTASIA")
	private String nomeFantasia;

	@Column(name = "NUM_TELEFONE")
	private String telefone;

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
