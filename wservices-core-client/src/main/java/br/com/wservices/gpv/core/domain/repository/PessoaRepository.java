package br.com.wservices.gpv.core.domain.repository;

import javax.ejb.Local;

import br.com.wservices.gpv.core.domain.repository.remote.PessoaRepositoryRemote;

@Local
public interface PessoaRepository extends PessoaRepositoryRemote {
}
