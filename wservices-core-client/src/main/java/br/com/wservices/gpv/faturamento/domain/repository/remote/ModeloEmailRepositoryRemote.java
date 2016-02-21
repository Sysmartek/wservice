package br.com.wservices.gpv.faturamento.domain.repository.remote;

import javax.ejb.Remote;

import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.faturamento.domain.dto.filtro.ModeloEmailFiltro;
import br.com.wservices.gpv.faturamento.domain.entity.ModeloEmail;

@Remote
public interface ModeloEmailRepositoryRemote extends SysmartekRepository<ModeloEmail, Integer> {

	String MAPPED_NAME = "ModeloEmailRepository";

	ModeloEmail buscaPorFiltros(ModeloEmailFiltro modeloEmailFiltro);

}
