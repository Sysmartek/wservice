package br.com.wservices.rs.dto;

import java.util.List;

import br.com.wservices.gpv.core.domain.entity.nosql.Parametro;

public class ParametroDTO {
	
	private List<Parametro> listaParametro;

	public List<Parametro> getListaParametro() {
		return listaParametro;
	}

	public void setListaParametro(List<Parametro> listaParametro) {
		this.listaParametro = listaParametro;
	}
	
}
