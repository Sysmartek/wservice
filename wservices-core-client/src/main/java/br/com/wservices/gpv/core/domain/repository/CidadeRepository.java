package br.com.wservices.gpv.core.domain.repository;

import javax.ejb.Local;

import br.com.wservices.gpv.core.domain.repository.remote.CidadeRepositoryRemote;

@Local
public interface CidadeRepository extends CidadeRepositoryRemote {
}
