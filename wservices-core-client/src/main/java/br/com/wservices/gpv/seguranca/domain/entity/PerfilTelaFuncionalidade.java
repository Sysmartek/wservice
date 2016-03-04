package br.com.wservices.gpv.seguranca.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import br.com.sysmartek.framework.entity.Identifiable;
import br.com.sysmartek.framework.entity.RegionalEntity;

@Entity(name = "TSEG_PERFILTELAFUNCIONALIDADE")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "UID_PERFIL", "UID_TELA_FUNC" }))
public class PerfilTelaFuncionalidade extends RegionalEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SSEG_PERFIL_TELA_FUNC", sequenceName = "SSEG_PERFIL_TELA_FUNC")
	@GeneratedValue(generator = "SSEG_PERFIL_TELA_FUNC", strategy = GenerationType.AUTO)
	@Column(name = "UID_PERFIL_TELA_FUNC", length = 4)
	private Integer id;

	@NotNull
	@JoinColumn(name = "UID_PERFIL", referencedColumnName = "UID_PERFIL")
	@ManyToOne(fetch = FetchType.LAZY)
	private Perfil perfil;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "UID_TELA_FUNC", referencedColumnName = "UID_TELA_FUNC") })
	private TelaFuncionalidade telaFuncionalidade;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public TelaFuncionalidade getTelaFuncionalidade() {
		return telaFuncionalidade;
	}

	public void setTelaFuncionalidade(TelaFuncionalidade telaFuncionalidade) {
		this.telaFuncionalidade = telaFuncionalidade;
	}
}
