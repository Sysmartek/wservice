package br.com.wservices.gpv.seguranca.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.sysmartek.framework.enumeration.PaisEnum;

public class UsuarioDTO implements UserDetails, Serializable {

	private static final long serialVersionUID = 8542259545116794846L;

	private Integer id;

	@NotNull
	private String login;

	private String senha;

	@NotNull
	private Boolean ativo;

	@NotNull
	private PaisEnum codigoPais;

	@NotNull
	private String locale;

	private Collection<PerfilTelaFuncionalidadeDTO> autorizacoes = new ArrayList<PerfilTelaFuncionalidadeDTO>(0);

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	public void setPassword(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Collection<PerfilTelaFuncionalidadeDTO> getAutorizacoes() {
		return autorizacoes;
	}

	public void setAutorizacoes(Collection<PerfilTelaFuncionalidadeDTO> autorizacoes) {
		this.autorizacoes = autorizacoes;
	}

	public PaisEnum getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(PaisEnum codigoPais) {
		this.codigoPais = codigoPais;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.ativo;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return autorizacoes;
	}

}
