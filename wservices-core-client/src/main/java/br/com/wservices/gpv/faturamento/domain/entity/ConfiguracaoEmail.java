package br.com.wservices.gpv.faturamento.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import br.com.sysmartek.framework.entity.AuditavelEntity;
import br.com.sysmartek.framework.entity.Identifiable;

@Table(name = "TFAT_CONFIGURACAO_EMAIL")
@Entity(name = "ConfiguracaoEmail")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "cacheDefault")
public class ConfiguracaoEmail extends AuditavelEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SFAT_CONFIGURACAO_EMAIL", sequenceName = "SFAT_CONFIGURACAO_EMAIL")
	@GeneratedValue(generator = "SFAT_CONFIGURACAO_EMAIL", strategy = GenerationType.AUTO)
	@Column(name = "UID_CONFIGURACAO_EMAIL", length = 4)
	private Integer id;

	@Pattern(regexp = ".+@.+\\.[a-z]+")
	@NotNull
	@Size(max = 50)
	@Column(name = "TXT_EMAIL", length = 50)
	private String email;

	@NotNull
	@Size(max = 20)
	@Column(name = "TXT_USUARIO", length = 20)
	private String usuario;

	@NotNull
	@Size(max = 20)
	@Column(name = "TXT_SENHA", length = 20)
	private String senha;

	@NotNull
	@Size(max = 20)
	@Column(name = "TXT_SERVIDOR", length = 20)
	private String servidor;

	@NotNull
	@Max(value = 99999)
	@Column(name = "NUM_PORTA", length = 5)
	private Integer porta;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getServidor() {
		return servidor;
	}

	public void setServidor(String servidor) {
		this.servidor = servidor;
	}

	public Integer getPorta() {
		return porta;
	}

	public void setPorta(Integer porta) {
		this.porta = porta;
	}

}
