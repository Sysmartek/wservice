package br.com.wservices.gpv.faturamento.domain.repository.remote;

import java.util.Date;

import javax.ejb.Remote;

import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.faturamento.domain.entity.Contingencia;
import br.com.wservices.gpv.faturamento.domain.entity.UnidadeFaturamento;

@Remote
public interface ContingenciaRepositoryRemote extends SysmartekRepository<Contingencia, Integer> {

	String MAPPED_NAME = "ContingenciaRepository";

	Contingencia obterContingenciaPorData(UnidadeFaturamento unidadeFaturamento, Date data);

}
