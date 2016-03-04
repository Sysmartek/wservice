package br.com.wservices.gpv.faturamento.domain.repository;

import javax.ejb.Local;

import br.com.sysmartek.framework.repository.SysmartekRepository;
import br.com.wservices.gpv.faturamento.domain.entity.Contingencia;

@Local
public interface ContingenciaRepository extends SysmartekRepository<Contingencia, Integer> {

}
