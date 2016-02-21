package br.com.wservices.gpv.core.client.helper;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import br.com.sysmartek.framework.util.CollectionsUtil;
import br.com.wservices.gpv.core.domain.entity.Dominio;

/**
 * Classe utilitaria par amanipulacao de elementos de dominio.
 * 
 * @author Sysmartek.
 */
public class DominioHelper {

	/**
	 * Metodo desiguinado para buscar o valor a descricao do dominio de acordo com o valor.
	 * 
	 * @param valor
	 * @param listaDominio
	 * @return
	 */
	public String getDescricaDominio(String valor, List<Dominio> listaDominio) {
		String resultado = "";

		if (!CollectionsUtil.isNullOrEmpy(listaDominio) && !StringUtils.isEmpty(valor)) {
			Dominio dominio = (listaDominio.stream().filter(x -> x.getValor().equals(valor)).collect(Collectors.toList())).get(0);
			resultado = dominio.getDescricao();
		}

		return resultado;
	}

}
