package br.com.wservices.gpv.core.domain.repository.remote;

import javax.ejb.Remote;

import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.core.domain.entity.Estado;

@Remote
public interface EstadoRepositoryRemote extends SysmartekRepository<Estado, Integer> {

	String MAPPED_NAME = "estadoRepository";

	Integer buscarCodigoIBGE(String uf);

}
