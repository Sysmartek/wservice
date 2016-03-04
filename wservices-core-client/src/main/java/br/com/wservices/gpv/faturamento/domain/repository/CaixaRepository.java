package br.com.wservices.gpv.faturamento.domain.repository;

import java.util.List;

import javax.ejb.Local;

import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.faturamento.domain.dto.filtro.CaixaFiltro;
import br.com.wservices.gpv.faturamento.domain.entity.Caixa;
import br.com.wservices.gpv.faturamento.domain.entity.UnidadeFaturamento;

@Local
public interface CaixaRepository extends SysmartekRepository<Caixa, Integer> {

	Caixa obterCaixaPorNumeroUnidadeFaturamentoStatus(Integer numero, UnidadeFaturamento unidadeFaturamento, String status);

	List<Caixa> pesquisarPorFiltros(CaixaFiltro filtro);

}
