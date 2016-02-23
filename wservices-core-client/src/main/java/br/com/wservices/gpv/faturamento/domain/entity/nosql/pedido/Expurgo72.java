package br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.ObjectUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import br.com.sysmartek.framework.exception.DomainException;

public class Expurgo72 implements Serializable {

	private static final long serialVersionUID = 1L;

	// Anotação Id do pacote org.springframework.data.annotation
	@Id
	@NotNull(message = "O codigo do expurgo não pode ser nulo")
	private int codigoExpurgo;

	@NotNull(message = "O cpf não pode ser nulo")
	@Size(min = 1, message = "O campo cpf não pode ser nulo")
	private String cpf;

	@NotNull(message = "A conta não pode ser nulo")
	@Size(min = 1, message = "O campo conta não pode ser nulo")
	private String conta;

	@NotNull(message = "Nome do cliente não pode ser nulo")
	@Size(min = 1, message = "Nome do cliente não pode ser nulo")
	private String nomeCliente;

	@NotNull(message = "Data de nascimento não pode ser nulo")
	private Calendar dataNascimento;

	@NotNull(message = "Produto conta não pode ser nulo")
	@Size(min = 1, message = "O campo Produto conta não pode ser nulo")
	private String produtoConta;

	@NotNull(message = "Status conta não pode ser nulo")
	@Size(min = 1, message = "O campo status conta não pode ser nulo")
	private String statusConta;

	@NotNull(message = "Numero do cartao não pode ser nulo")
	@Size(min = 1, message = "O campo numero do cartao não pode ser nulo")
	private String numeroCartao;
	
	//@NotNull(message = "Entregas por Cpf")
	@Size(min = 1, message = "O campo entregas por CPF não pode ser nulo")
	private Long entregasCpf;

	private Boolean erro = Boolean.FALSE;

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

	public int getCodigoExpurgo() {
		return codigoExpurgo;
	}

	public void setCodigoExpurgo(int codigoExpurgo) {
		this.codigoExpurgo = codigoExpurgo;
	}

	public Boolean getErro() {
		return erro;
	}

	public void setErro(Boolean erro) {
		this.erro = erro;
	}

	public Long getEntregasCpf() {
		return entregasCpf;
	}

	public void setEntregasCpf(Long entregasCpf) {
		this.entregasCpf = entregasCpf;
	}
	
	

}
