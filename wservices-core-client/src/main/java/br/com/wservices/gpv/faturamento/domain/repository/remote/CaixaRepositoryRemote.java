package br.com.wservices.gpv.faturamento.domain.repository.remote;

import java.util.List;

import javax.ejb.Remote;

import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.faturamento.domain.dto.filtro.CaixaFiltro;
import br.com.wservices.gpv.faturamento.domain.entity.Caixa;
import br.com.wservices.gpv.faturamento.domain.entity.UnidadeFaturamento;

@Remote
public interface CaixaRepositoryRemote extends SysmartekRepository<Caixa, Integer> {

	String MAPPED_NAME = "CaixaRepository";

	Caixa obterCaixaPorNumeroUnidadeFaturamentoStatus(Integer numero, UnidadeFaturamento unidadeFaturamento, String status);

	List<Caixa> pesquisarPorFiltros(CaixaFiltro filtro);

}
