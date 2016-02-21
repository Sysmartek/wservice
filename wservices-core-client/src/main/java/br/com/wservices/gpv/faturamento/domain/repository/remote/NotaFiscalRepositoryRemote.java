package br.com.wservices.gpv.faturamento.domain.repository.remote;

import javax.ejb.Remote;

import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.faturamento.domain.entity.NotaFiscal;

@Remote
public interface NotaFiscalRepositoryRemote extends SysmartekRepository<NotaFiscal, Integer> {

	String MAPPED_NAME = "NotaFiscalRepository";

}
