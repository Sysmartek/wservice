package br.com.wservices.rs.dto;

import java.io.Serializable;
import java.util.Calendar;


public class Expurgo72DTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	
	private String cpf;

	private String conta;
	
	private String nomeCliente;
	
	private Calendar dataNascimento;
	
	private String produtoConta;
	
	private String statusConta;

	private String numeroCartao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getProdutoConta() {
		return produtoConta;
	}

	public void setProdutoConta(String produtoConta) {
		this.produtoConta = produtoConta;
	}

	public String getStatusConta() {
		return statusConta;
	}

	public void setStatusConta(String statusConta) {
		this.statusConta = statusConta;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	
	
	


}
