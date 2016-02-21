package br.com.wservices.gpv.core.domain.repository.remote;

import java.util.List;

import javax.ejb.Remote;

import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.core.domain.entity.Dominio;

@Remote
public interface DominioRepositoryRemote extends SysmartekRepository<Dominio, Integer> {

	String MAPPED_NAME = "dominioRepository";

	List<Dominio> obterDominioPorTipo(String tipoDominio);

}
