package br.com.wservices.gpv.core.domain.repository.remote;

import javax.ejb.Remote;

import br.com.wservices.gpv.faturamento.domain.entity.nosql.propriedadeSefaz.PropriedadeSefaz;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.propriedadeSefaz.TipoAmbiente;

@Remote
public interface PropriedadeSefazService {

	String MAPPED_NAME = "PropriedadeSefazService";

	PropriedadeSefaz findOne(TipoAmbiente tipoAmbiente);

	PropriedadeSefaz save(PropriedadeSefaz propriedadeSefaz);

	PropriedadeSefaz findByAtivo();

}
