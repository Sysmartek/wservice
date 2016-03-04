package br.com.wservices.gpv.faturamento.domain.service.remote;

import javax.ejb.Remote;

import br.com.sysmartek.framework.exception.SysmartekException;

@Remote
public interface GeradorDanfeServiceRemote {

	String MAPPED_NAME = "GeradorDanfeService";

	byte[] gerar(String xml) throws SysmartekException;

	byte[] gerar(String xml, String fileOutput) throws SysmartekException;
}
