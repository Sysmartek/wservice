package br.com.wservices.gpv.faturamento.domain.service.remote;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.ejb.Remote;
import javax.print.PrintException;

import br.com.sysmartek.framework.exception.SysmartekException;
import br.com.wservices.gpv.faturamento.domain.dto.ImpressaoEtiquetaParametro;
import br.com.wservices.gpv.faturamento.domain.entity.Impressora;
import br.com.wservices.gpv.faturamento.domain.entity.LayoutEtiqueta;

@Remote
public interface ImpressaoEtiquetaServiceRemote {

	String MAPPED_NAME = "ImpressaoEtiquetaService";

	void imprimirTesteEtiqueta(Impressora impressora, Integer qtdCopias, LayoutEtiqueta layoutEtiqueta)
					throws SysmartekException, PrintException, IllegalArgumentException, IllegalAccessException,
					NoSuchFieldException, SecurityException, InvocationTargetException, NoSuchMethodException, IOException;

	void imprimirEtiqueta(Impressora impressora, Integer qtdCopias, LayoutEtiqueta layoutEtiqueta,
					ImpressaoEtiquetaParametro impressaoEtiquetaParametro) throws IllegalArgumentException,
					IllegalAccessException, NoSuchFieldException, SecurityException, InvocationTargetException,
					NoSuchMethodException, SysmartekException, PrintException, IOException;

	String construirLayoutParaImpressao(LayoutEtiqueta layoutEtiqueta,
					ImpressaoEtiquetaParametro impressaoEtiquetaParametro, boolean teste)
					throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException,
					InvocationTargetException, NoSuchMethodException;
}
