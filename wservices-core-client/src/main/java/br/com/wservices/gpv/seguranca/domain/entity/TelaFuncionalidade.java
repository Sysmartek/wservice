package br.com.wservices.gpv.seguranca.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import br.com.sysmartek.framework.entity.BaseEntity;
import br.com.sysmartek.framework.entity.Identifiable;

@Entity(name = "TSEG_TELAFUNCIONALIDADE")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "UID_FUNCIONALIDADE", "UID_TELA" }))
public class TelaFuncionalidade extends BaseEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SSEG_TELA_FUNC", sequenceName = "SSEG_TELA_FUNC")
	@GeneratedValue(generator = "SSEG_TELA_FUNC", strategy = GenerationType.AUTO)
	@Column(name = "UID_TELA_FUNC", length = 4)
	private Integer id;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UID_FUNCIONALIDADE", referencedColumnName = "UID_FUNCIONALIDADE")
	private Funcionalidade funcionalidade;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UID_TELA", referencedColumnName = "UID_TELA")
	private Tela tela;

	@NotNull
	@Column(name = "TELA_FUNC_DESCRICAO")
	private String descricao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "telaFuncionalidade")
	private Set<PerfilTelaFuncionalidade> perfilTelaFuncionalidade;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Funcionalidade getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(Funcionalidade funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

	public Tela getTela() {
		return tela;
	}

	public void setTela(Tela tela) {
		this.tela = tela;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<PerfilTelaFuncionalidade> getPerfilTelaFuncionalidade() {
		return perfilTelaFuncionalidade;
	}

	public void setPerfilTelaFuncionalidade(Set<PerfilTelaFuncionalidade> perfilTelaFuncionalidade) {
		this.perfilTelaFuncionalidade = perfilTelaFuncionalidade;
	}

}
