package br.com.wservices.rs;

import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.sysmartek.framework.exception.DomainException;
import br.com.sysmartek.framework.util.LoockupUtil;
import br.com.wservices.gpv.core.domain.entity.nosql.Parametro;
import br.com.wservices.gpv.core.domain.service.remote.ParametroServiceRemote;
import br.com.wservices.rs.dto.ParametroDTO;

@Path("/parametroGPV")
public class ParametroGPVRest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{chave}")
	public Response obterParametro(@PathParam("chave") String chave) {
		Parametro parametro = getParametroService().findOne(chave);
		return Response.status(Status.ACCEPTED).entity(parametro).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterListaParametro() {
		List<Parametro> listaParametro = getParametroService().findAll();
		ParametroDTO parametroDTO = new ParametroDTO();
		parametroDTO.setListaParametro(listaParametro);
		return Response.status(Status.ACCEPTED).entity(parametroDTO).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response adicionarParametro(Parametro parametro) {
		try {
			parametro = getParametroService().save(parametro);

			return Response.status(Status.ACCEPTED).entity(parametro).build();
		} catch (DomainException e) {
			e.printStackTrace();
			return Response.status(Status.EXPECTATION_FAILED).entity(parametro).build();
		}
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{chave}")
	public Response deletarParametro(@PathParam("chave") String chave) {
		getParametroService().delete(chave);
		return Response.status(Status.OK).build();
	}

	private ParametroServiceRemote getParametroService() {
		try {
			return LoockupUtil.loockup(ParametroServiceRemote.MAPPED_NAME, ParametroServiceRemote.class);
		} catch (NamingException e) {
			return null;
		}
	}

}
