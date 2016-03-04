package br.com.wservices.gpv.core.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.sysmartek.framework.entity.AuditavelEntity;
import br.com.sysmartek.framework.entity.Identifiable;
import br.com.wservices.gpv.core.domain.enumerations.TipoPessoa;

@Entity
@Table(name = "TGPV_PESSOA")
public class Pessoa extends AuditavelEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "UID_PK")
	@SequenceGenerator(name = "SGPV_PESSOA", sequenceName = "SGPV_PESSOA")
	@GeneratedValue(generator = "SGPV_PESSOA", strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@Column(name = "NOM_PESSOA")
	private String nome;

	@NotNull
	@Column(name = "NIC_PESSOA")
	private String nic;

	@NotNull
	@Column(name = "TIP_PESSOA", length = 1)
	@Enumerated(EnumType.STRING)
	private TipoPessoa tipo;

	@NotNull
	@Column(name = "COD_DOC_NAC")
	private String codigoDocumento;

	@NotNull
	@Column(name = "COD_DOC_EST")
	private String inscricaoEstadual;

	@NotNull
	@Column(name = "COD_DOC_MUN")
	private String inscricaoMunicipal;

	@Valid
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "UID_ENDERECO")
	private Endereco endereco;

	public Pessoa() {
		super();
	}

	// TODO: EXCESSO DE PARAMETROS
	public Pessoa(Integer id, String nome, String nic, TipoPessoa tipo, String codigoDocumento, String inscricaoEstadual, String inscricaoMunicipal, Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.nic = nic;
		this.tipo = tipo;
		this.codigoDocumento = codigoDocumento;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscricaoMunicipal = inscricaoMunicipal;
		this.endereco = endereco;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	public String getCodigoDocumento() {
		return codigoDocumento;
	}

	public void setCodigoDocumento(String codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
