package br.com.wservices.gpv.faturamento.domain.service;

import javax.ejb.Local;

import br.com.wservices.gpv.faturamento.domain.service.remote.GeradorDanfeServiceRemote;

@Local
public interface GeradorDanfeService extends GeradorDanfeServiceRemote {
	
}
