package br.com.wservices.gpv.core.domain.repository.remote;

import javax.ejb.Remote;

import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.core.domain.entity.Pessoa;

@Remote
public interface PessoaRepositoryRemote extends SysmartekRepository<Pessoa, Integer> {

	String MAPPED_NAME = "pessoaRepository";

}
