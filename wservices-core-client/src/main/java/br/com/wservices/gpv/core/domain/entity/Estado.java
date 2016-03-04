package br.com.wservices.gpv.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.sysmartek.framework.entity.Identifiable;
import br.com.sysmartek.framework.entity.RegionalEntity;

@Entity
@Table(name = "TGPV_ESTADO")
public class Estado extends RegionalEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = -6525300847435674865L;

	@Id
	@Column(name = "UID_PK")
	@SequenceGenerator(name = "SCOR_ESTADO", sequenceName = "SCOR_ESTADO")
	@GeneratedValue(generator = "SCOR_ESTADO", strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@Column(name = "NOM_ESTADO")
	private String nome;

	@NotNull
	@Column(name = "UF_ESTADO")
	private String uf;

	@Column(name = "COD_IBGE")
	private Integer codigoIBGE;

	public Estado(String nome, String uf) {
		super();
		this.nome = nome;
		this.uf = uf;
	}

	public Estado(Integer id, String nome, String uf) {
		super();
		this.id = id;
		this.nome = nome;
		this.uf = uf;
	}

	public Estado() {
		super();
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(final String uf) {
		this.uf = uf;
	}

	public Integer getCodigoIBGE() {
		return codigoIBGE;
	}

	public void setCodigoIBGE(Integer codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}

}
