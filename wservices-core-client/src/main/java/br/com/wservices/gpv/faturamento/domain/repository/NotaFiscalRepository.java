package br.com.wservices.gpv.faturamento.domain.repository;

import java.util.List;

import javax.ejb.Local;

import br.com.sysmartek.framework.exception.DomainException;
import br.com.sysmartek.framework.exception.InfrastructureException;
import br.com.wservices.gpv.core.domain.enumerations.TipoEvento;
import br.com.wservices.gpv.faturamento.domain.dto.filtro.NotaFiscalFiltro;
import br.com.wservices.gpv.faturamento.domain.entity.NotaFiscal;
import br.com.wservices.gpv.faturamento.domain.repository.remote.NotaFiscalRepositoryRemote;

@Local
public interface NotaFiscalRepository extends NotaFiscalRepositoryRemote {

	NotaFiscal buscarNotaFiscalPorCodigoEntrega(Long codigoEntrega);

	NotaFiscal buscarNotaFiscalPorCaixaAzul(Long numCaixaAzul);

	List<NotaFiscal> buscarNotaFiscalPorCaixa(Integer numeroCaixa);
	
	List<NotaFiscal> findByFilters(NotaFiscalFiltro filtro);
	
	void tramitarNotaFiscal(NotaFiscal notaFiscal, TipoEvento status) throws InfrastructureException, DomainException;

}
