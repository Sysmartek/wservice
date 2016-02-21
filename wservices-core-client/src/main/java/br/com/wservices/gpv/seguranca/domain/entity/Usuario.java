package br.com.wservices.gpv.seguranca.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.sysmartek.framework.entity.Identifiable;
import br.com.sysmartek.framework.entity.RegionalEntity;

@Entity(name = "TSEG_USUARIO")
public class Usuario extends RegionalEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SSEG_USUARIO", sequenceName = "SSEG_USUARIO")
	@GeneratedValue(generator = "SSEG_USUARIO", strategy = GenerationType.AUTO)
	@Column(name = "UID_USUARIO", length = 4)
	private Integer id;

	@NotNull
	@Size(min = 3, max = 40)
	@Column(name = "USU_NOM_LOGIN", unique = true, length = 15)
	private String login;

	@NotNull
	@Column(name = "USU_FLG_ATIVO", length = 1)
	private Boolean ativo;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Perfil> perfil;

	@NotNull
	@Column(name = "USU_DES_LOCALE", length = 3)
	private String locale;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Set<Perfil> getPerfil() {
		return perfil;
	}

	public void setPerfil(Set<Perfil> papel) {
		this.perfil = papel;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

}
