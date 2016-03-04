package br.com.wservices.rs;

import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.sysmartek.framework.util.LoockupUtil;
import br.com.wservices.gpv.core.domain.repository.remote.PropriedadeSefazService;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.propriedadeSefaz.PropriedadeSefaz;

@Path("/propriedadeSefaz")
public class PropriedadeSefazRest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterPropriedadeSefazAtivo() {
		PropriedadeSefaz propriedade = getPropriedadeSefazService().findByAtivo();
		return Response.status(Status.ACCEPTED).entity(propriedade).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response adicionarPropriedadeSefaz(PropriedadeSefaz propriedadeSefaz) {
		propriedadeSefaz = getPropriedadeSefazService().save(propriedadeSefaz);
		return Response.status(Status.ACCEPTED).entity(propriedadeSefaz).build();
	}

	private PropriedadeSefazService getPropriedadeSefazService() {
		try {
			return LoockupUtil.loockup(PropriedadeSefazService.MAPPED_NAME, PropriedadeSefazService.class);
		} catch (NamingException e) {
			return null;
		}
	}

}
