package br.com.wservices.gpv.core.domain.repository.remote;

import javax.ejb.Remote;

import br.com.wservices.gpv.faturamento.domain.entity.nosql.CaixaAzul;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.CaixaAzulId;

@Remote
public interface CaixaAzulService {
	String MAPPED_NAME = "CaixaAzulService";

	CaixaAzul save(CaixaAzul caixaAzul);

	CaixaAzul findOne(CaixaAzulId id);

	void delete(CaixaAzulId id);

}
