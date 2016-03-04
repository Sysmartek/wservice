package br.com.wservices.gpv.faturamento.domain.repository.remote;

import java.util.List;

import javax.ejb.Remote;

import br.com.sysmartek.framework.exception.DomainException;
import br.com.sysmartek.framework.exception.InfrastructureException;
import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.faturamento.domain.dto.filtro.SerieFiltro;
import br.com.wservices.gpv.faturamento.domain.entity.Serie;

@Remote
public interface SerieRepositoryRemote extends SysmartekRepository<Serie, Integer> {

	String MAPPED_NAME = "SerieRepository";

	List<Serie> findByFilters(SerieFiltro filtro);

	void validarNumeracaoJaUtilizada(Serie entity) throws InfrastructureException;

	void validarNumeroMax(Serie entity) throws InfrastructureException;

	void validarSerieDeMesmoNumero(Serie entity) throws InfrastructureException;

	void validarUltimoNumeroUltilizado(Serie entity) throws InfrastructureException, DomainException;
}
