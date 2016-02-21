package br.com.wservices.gpv.core.domain.service.remote;

import java.util.List;

import javax.ejb.Remote;

import br.com.sysmartek.framework.exception.DomainException;
import br.com.wservices.gpv.core.domain.entity.nosql.Parametro;

@Remote
public interface ParametroServiceRemote {

	String MAPPED_NAME = "ParametroService";

	Parametro findOne(String chave);

	Parametro save(Parametro parametro) throws DomainException;

	void delete(String chave);

	List<Parametro> findAll();

}