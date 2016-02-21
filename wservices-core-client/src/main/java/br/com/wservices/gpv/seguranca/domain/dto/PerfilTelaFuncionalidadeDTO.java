package br.com.wservices.gpv.seguranca.domain.dto;

import java.io.Serializable;

import org.dozer.Mapping;
import org.springframework.security.core.GrantedAuthority;

public class PerfilTelaFuncionalidadeDTO implements Serializable, GrantedAuthority {

	private static final long serialVersionUID = -7292437290483659218L;

	@Mapping("telaFuncionalidade.tela")
	private TelaDTO tela;

	@Mapping("telaFuncionalidade.funcionalidade")
	private FuncionalidadeDTO funcionalidade;

	public FuncionalidadeDTO getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(FuncionalidadeDTO funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

	public TelaDTO getTela() {
		return tela;
	}

	public void setTela(TelaDTO tela) {
		this.tela = tela;
	}

	@Override
	public String getAuthority() {
		return this.tela.getChave() + "." + this.funcionalidade.getChave();
	}

}
