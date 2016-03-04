package br.com.wservices.rs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.sysmartek.framework.enumeration.PaisEnum;
import br.com.wservices.gpv.faturamento.domain.entity.TipoOperacao;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.propriedadeSefaz.PropriedadeSefaz;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.propriedadeSefaz.TipoAmbiente;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.propriedadeSefaz.WebServiceEstado;

@Path("test")
public class RestTest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTest() {
//		TipoOperacao tipoOperacao = new TipoOperacao();
//		tipoOperacao.setCodigoPais(PaisEnum.BRASIL);
//		tipoOperacao.setDescricao("Teste JSON");
//		tipoOperacao.setId(1);
//		tipoOperacao.setUsuarioUltimaAlteracao("rodrigo.bernardo");
//

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://192.168.100.119:7001/gpv-webservices/resources/").path("propriedadeSefaz");
		PropriedadeSefaz propriedade = new PropriedadeSefaz();
		propriedade.setTipoAmbiente(TipoAmbiente.HOMOLOGACAO);
		propriedade.setVersao("3.10");
		propriedade.setNameSpace("http://www.portalfiscal.inf.br/nfe");
		propriedade.setEnderecoSVC("caminho svc");
		propriedade.getWebServiceEstados().add(new WebServiceEstado("SP", "caminho ws São Paulo"));
		propriedade.getWebServiceEstados().add(new WebServiceEstado("PE", "caminho ws Pernambuco"));
		
		PropriedadeSefaz propriedadeRestorno = target.request(MediaType.APPLICATION_JSON_TYPE)
		  .buildPut(Entity.json(propriedade))
		  .invoke(PropriedadeSefaz.class);
		
		return Response.ok(propriedadeRestorno).build();
	}
}
