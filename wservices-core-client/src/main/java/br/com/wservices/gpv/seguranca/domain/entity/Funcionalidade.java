package br.com.wservices.gpv.seguranca.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.sysmartek.framework.entity.BaseEntity;
import br.com.sysmartek.framework.entity.Identifiable;

@Entity(name = "TSEG_FUNCIONALIDADE")
public class Funcionalidade extends BaseEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SSEG_FUNCIONALIDADE", sequenceName = "SSEG_FUNCIONALIDADE")
	@GeneratedValue(generator = "SSEG_FUNCIONALIDADE", strategy = GenerationType.AUTO)
	@Column(name = "UID_FUNCIONALIDADE", length = 4)
	private Integer id;

	@NotNull
	@Size(min = 3, max = 30)
	@Column(name = "FUN_CHAVE", unique = true, length = 30)
	private String chave;

	@NotNull
	@Column(name = "FUN_DES", length = 30)
	private String descricao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "funcionalidade")
	private Set<TelaFuncionalidade> telas;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<TelaFuncionalidade> getTelas() {
		return telas;
	}

	public void setTelas(Set<TelaFuncionalidade> telas) {
		this.telas = telas;
	}

}
