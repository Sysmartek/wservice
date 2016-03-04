package br.com.wservices.gpv.faturamento.domain.repository.remote;

import javax.ejb.Remote;

import br.com.sysmartek.framework.exception.DomainException;
import br.com.sysmartek.framework.exception.InfrastructureException;
import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.faturamento.domain.entity.UnidadeNegocio;

@Remote
public interface UnidadeNegocioRepositoryRemote extends SysmartekRepository<UnidadeNegocio, Integer> {

	String MAPPED_NAME = "UnidadeNegocioRepository";
	
	UnidadeNegocio gravar(UnidadeNegocio unidadeNegocio) throws InfrastructureException, DomainException;

}
