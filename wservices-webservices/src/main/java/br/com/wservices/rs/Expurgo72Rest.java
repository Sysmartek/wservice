package br.com.wservices.rs;

import javax.naming.NamingException;
import javax.validation.ValidationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.sysmartek.framework.exception.DomainException;
import br.com.sysmartek.framework.util.LoockupUtil;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido.Expurgo72;
import br.com.wservices.gpv.faturamento.domain.service.remote.Expurgo72ServiceRemote;
import br.com.wservices.helper.GpvWSHelper;

import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/expurgo72Service")
public class Expurgo72Rest {

	private Expurgo72ServiceRemote expurgo72Service;

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response recebeExpurgo72(Expurgo72 expurgo72) throws NamingException, DomainException {
		expurgo72Service = LoockupUtil.loockup(Expurgo72ServiceRemote.MAPPED_NAME, Expurgo72ServiceRemote.class);
		try {
			expurgo72Service.recebeExpurgo72(expurgo72);
		} catch (DomainException | ValidationException excpetion) {
			throw new WebApplicationException(Status.PRECONDITION_FAILED);
		}
		
		return Response.status(Status.ACCEPTED).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSpec() throws JsonProcessingException {
		String schemaJson = GpvWSHelper.gerarSchemaJSON(Expurgo72.class);
		return Response.ok(schemaJson).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{codigoExpurgo72}")
	public Response getExpurto72(@PathParam("codigoExpurgo72") Long codigoExpurgo72) throws NamingException {
		expurgo72Service = LoockupUtil.loockup(Expurgo72ServiceRemote.MAPPED_NAME, Expurgo72ServiceRemote.class);
		Expurgo72 expurgo72 = expurgo72Service.findOne(codigoExpurgo72);
		if (expurgo72 == null) {
			return Response.serverError().entity("Pedido não localizado").build();
		}
		return Response.ok().entity(expurgo72).build();
	}

}
