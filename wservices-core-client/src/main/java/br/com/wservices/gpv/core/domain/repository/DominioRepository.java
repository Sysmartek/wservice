package br.com.wservices.gpv.core.domain.repository;

import javax.ejb.Local;

import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.core.domain.entity.Dominio;
import br.com.wservices.gpv.core.domain.repository.remote.DominioRepositoryRemote;

@Local
public interface DominioRepository extends SysmartekRepository<Dominio, Integer>, DominioRepositoryRemote {

}
