package br.com.wservices.gpv.faturamento.domain.repository.remote;

import java.util.List;

import javax.ejb.Remote;

import br.com.sysmartek.framework.exception.DomainException;
import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.faturamento.domain.dto.filtro.TipoOperacaoFiltro;
import br.com.wservices.gpv.faturamento.domain.entity.TipoOperacao;

@Remote
public interface TipoOperacaoRepositoryRemote extends SysmartekRepository<TipoOperacao, Integer> {

	String MAPPED_NAME = "TipoOperacaoRepository";

	List<TipoOperacao> findByFilters(TipoOperacaoFiltro filtro);

	TipoOperacao buscarPorCategoria(String categoriaOperacao);

	void validarTipoOperacaoComCategoriaDuplicada(TipoOperacao entity) throws DomainException;

}
