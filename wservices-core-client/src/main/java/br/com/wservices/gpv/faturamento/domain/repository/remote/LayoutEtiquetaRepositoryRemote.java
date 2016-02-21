package br.com.wservices.gpv.faturamento.domain.repository.remote;

import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.faturamento.domain.dto.filtro.LayoutEtiquetaFiltro;
import br.com.wservices.gpv.faturamento.domain.entity.LayoutEtiqueta;
import br.com.wservices.gpv.faturamento.domain.entity.Serie;
import br.com.wservices.gpv.faturamento.domain.entity.ServicoEntrega;

@Remote
public interface LayoutEtiquetaRepositoryRemote extends SysmartekRepository<LayoutEtiqueta, Integer> {

	String MAPPED_NAME = "LayoutEtiquetaRepository";

	List<LayoutEtiqueta> findByFilters(LayoutEtiquetaFiltro filtro);

	List<LayoutEtiqueta> listarLayoutEtiquetaComAlgumaSerieEServicoEntrega(Set<Serie> set, Set<ServicoEntrega> set2);

}
