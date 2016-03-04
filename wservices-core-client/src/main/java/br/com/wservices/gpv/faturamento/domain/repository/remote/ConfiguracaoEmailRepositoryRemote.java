package br.com.wservices.gpv.faturamento.domain.repository.remote;

import javax.ejb.Remote;

import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.faturamento.domain.entity.ConfiguracaoEmail;

@Remote
public interface ConfiguracaoEmailRepositoryRemote extends SysmartekRepository<ConfiguracaoEmail, Integer> {

	String MAPPED_NAME = "ConfiguracaoEmailRepository";

}
