package br.com.wservices.gpv.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.sysmartek.framework.entity.Identifiable;
import br.com.sysmartek.framework.entity.RegionalEntity;
import br.com.sysmartek.framework.enumeration.PaisEnum;

@Entity
@Table(name = "TGPV_ENDERECO")
public class Endereco extends RegionalEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 3493626034205338230L;

	@Id
	@Column(name = "UID_PK")
	@SequenceGenerator(name = "SCOR_ENDERECO", sequenceName = "SCOR_ENDERECO")
	@GeneratedValue(generator = "SCOR_ENDERECO", strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@Column(name = "LOGRADOURO")
	private String logradouro;

	@NotNull
	@Column(name = "NUMERO")
	private Integer numero;

	@Column(name = "COMPLEMENTO")
	private String complemento;

	@NotNull
	@Column(name = "BAIRRO")
	private String bairro;

	@NotNull
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UID_CIDADE")
	private Cidade cidade;

	@NotNull
	@Column(name = "CEP")
	private String cep;

	public Endereco(String logradouro, Integer numero, String complemento, String bairro, Cidade cidade, String cep, PaisEnum pais) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		super.setCodigoPais(pais);
	}

	public Endereco() {
		super();
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
}
