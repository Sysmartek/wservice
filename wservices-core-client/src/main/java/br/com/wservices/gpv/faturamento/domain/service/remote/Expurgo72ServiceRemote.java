package br.com.wservices.gpv.faturamento.domain.service.remote;

import javax.ejb.Remote;

import br.com.sysmartek.framework.exception.DomainException;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido.Expurgo72;

@Remote
public interface Expurgo72ServiceRemote {

	String MAPPED_NAME = "Expurgo72Service";

	void recebeExpurgo72(Expurgo72 expurgo72)  throws DomainException;

	Expurgo72 findOne(Long codigoExpurgo72);
	

}
