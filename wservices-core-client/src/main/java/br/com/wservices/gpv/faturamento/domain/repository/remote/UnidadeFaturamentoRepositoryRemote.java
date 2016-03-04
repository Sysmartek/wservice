package br.com.wservices.gpv.faturamento.domain.repository.remote;

import java.util.List;

import javax.ejb.Remote;

import br.com.sysmartek.framework.exception.DomainException;
import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.faturamento.domain.dto.filtro.UnidadeFaturamentoFiltro;
import br.com.wservices.gpv.faturamento.domain.entity.UnidadeFaturamento;

@Remote
public interface UnidadeFaturamentoRepositoryRemote extends SysmartekRepository<UnidadeFaturamento, Integer> {

	String MAPPED_NAME = "UnidadeFaturamentoRepository";

	UnidadeFaturamento buscarPorCodigoDocumento(String cnpj);

	List<UnidadeFaturamento> buscarPorFiltro(UnidadeFaturamentoFiltro filter);
}
