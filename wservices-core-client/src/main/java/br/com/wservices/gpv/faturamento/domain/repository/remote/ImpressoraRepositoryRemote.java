package br.com.wservices.gpv.faturamento.domain.repository.remote;

import java.util.List;

import javax.ejb.Remote;

import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.faturamento.domain.dto.filtro.ImpressoraFiltro;
import br.com.wservices.gpv.faturamento.domain.entity.Impressora;

@Remote
public interface ImpressoraRepositoryRemote extends SysmartekRepository<Impressora, Integer> {

	String MAPPED_NAME = "ImpressoraRepository";

	List<Impressora> pesquisarPorFiltros(ImpressoraFiltro filtro);

	Impressora pesquisarPorNome(String nome);

	List<Impressora> pesquisarPorTipo(String tipo);

}
