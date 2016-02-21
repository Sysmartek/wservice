package br.com.wservices.gpv.seguranca.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import br.com.sysmartek.framework.entity.BaseEntity;
import br.com.sysmartek.framework.entity.Identifiable;

@Entity(name = "TSEG_PERFIL")
public class Perfil extends BaseEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SSEG_PERFIL", sequenceName = "SSEG_PERFIL")
	@GeneratedValue(generator = "SSEG_PERFIL", strategy = GenerationType.AUTO)
	@Column(name = "UID_PERFIL", length = 4)
	private Integer id;

	@NotNull
	@Column(name = "PER_DES", length = 30)
	private String descricao;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "perfil")
	private Set<Usuario> usuario;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "perfil")
	private Set<PerfilTelaFuncionalidade> perfilTelaFuncionalidade;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(Set<Usuario> usuario) {
		this.usuario = usuario;
	}

	public Set<PerfilTelaFuncionalidade> getPerfilTelaFuncionalidade() {
		return perfilTelaFuncionalidade;
	}

	public void setPerfilTelaFuncionalidade(Set<PerfilTelaFuncionalidade> perfilTelaFuncionalidade) {
		this.perfilTelaFuncionalidade = perfilTelaFuncionalidade;
	}

}
