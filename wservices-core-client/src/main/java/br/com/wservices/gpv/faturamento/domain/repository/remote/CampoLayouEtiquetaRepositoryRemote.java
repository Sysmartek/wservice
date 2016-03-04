package br.com.wservices.gpv.faturamento.domain.repository.remote;

import javax.ejb.Remote;

import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.faturamento.domain.entity.CampoLayouEtiqueta;

@Remote
public interface CampoLayouEtiquetaRepositoryRemote extends SysmartekRepository<CampoLayouEtiqueta, Integer> {

	public static final String MAPPED_NAME = "CampoLayouEtiquetaRepository";
	
}
