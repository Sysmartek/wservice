package br.com.yaw.prime.model;

import java.io.Serializable;

/**
 * Estipula um contrato base para as entidades persistentes da APLICACAO.
 * 
 * <p>Esse contrato E utilizado pelo componente RESPONSAVEL pelas OPERACOES BASICAS de PERSISTENCIA: <code>AbstractPersistence</code>.</p>
 * 
 * @see br.com.yaw.prime.service.AbstractPersistence
 * 
 * @author Osvaldo Martini
 */
public interface AbstractEntity extends Serializable {

	/**
	 * @return A REFERENCIA para a chave PRIMARIA (Primary Key) de cada objeto persistido.
	 * 		   Caso o objeto ainda NAO tenha sido persistido, deve retornar <code>null</code>.
	 */
	public Number getId();

}
