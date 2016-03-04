package br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PessoaPedido implements Serializable {

	private static final long serialVersionUID = -3544450052128217383L;

	@NotNull(message = "O campo documento não pode ser nulo")
	private String cpfcnpj;

	private String email;

	@NotNull(message = "O nome não pode ser nulo")
	@Size(min = 1,  message = "O nome não pode ser nulo")
	private String nome;

	private String inscricaoEstadual;

	private String nomeFantasia;

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
