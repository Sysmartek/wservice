package br.com.wservices.gpv.faturamento.domain.repository.remote;

import javax.ejb.Remote;

import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.faturamento.domain.entity.ServicoEntrega;

@Remote
public interface ServicoEntregaRepositoryRemote extends SysmartekRepository<ServicoEntrega, Integer> {

	String MAPPED_NAME = "ServicoEntregaRepository";

}
