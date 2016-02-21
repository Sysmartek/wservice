package br.com.wservices.gpv.core.domain.repository.remote;

import java.util.List;

import javax.ejb.Remote;

import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.core.domain.entity.Cidade;

@Remote
public interface CidadeRepositoryRemote extends SysmartekRepository<Cidade, Integer> {

	String MAPPED_NAME = "cidadeRepository";

	List<Cidade> buscarCidadesPorUf(String uf);

	Integer buscarCodigoIBGE(String nome, String uf);
}
