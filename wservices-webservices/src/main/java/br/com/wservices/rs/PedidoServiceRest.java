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
import br.com.wservices.gpv.faturamento.domain.dto.PedidoDTO;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.CaixaAzul;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.CaixaAzulId;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.ControleEntrega;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido.MensagemPedido;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido.Pedido;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido.ProcessoReversa;
import br.com.wservices.gpv.faturamento.domain.service.remote.PedidoServiceRemote;
import br.com.wservices.helper.GpvWSHelper;
import br.com.wservices.rs.dto.CaixaAzulDTO;

import com.fasterxml.jackson.core.JsonProcessingException;

@Path("/pedidoService")
public class PedidoServiceRest {

	private PedidoServiceRemote pedidoService;

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/processoReversa")
	public Response recebeProcessoReversa(ProcessoReversa processoReversa) throws NamingException, DomainException {
		pedidoService = LoockupUtil.loockup(PedidoServiceRemote.MAPPED_NAME, PedidoServiceRemote.class);
		try {
			pedidoService.recebeProcessoReversa(processoReversa);
		} catch (DomainException | ValidationException excpetion) {
			throw new WebApplicationException(Status.PRECONDITION_FAILED);
		}
		
		return Response.status(Status.ACCEPTED).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response recebePedido(Pedido pedido) throws NamingException, DomainException {
		pedidoService = LoockupUtil.loockup(PedidoServiceRemote.MAPPED_NAME, PedidoServiceRemote.class);
		try {
			pedidoService.recebePedido(pedido);
		} catch (DomainException | ValidationException excpetion) {
			throw new WebApplicationException(Status.PRECONDITION_FAILED);
		}
		
		return Response.status(Status.ACCEPTED).build();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSpec() throws JsonProcessingException {
		String schemaJson = GpvWSHelper.gerarSchemaJSON(Pedido.class);
		return Response.ok(schemaJson).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{numeroPedido}")
	public Response getPedido(@PathParam("numeroPedido") Long numeroPedido) throws NamingException {
		pedidoService = LoockupUtil.loockup(PedidoServiceRemote.MAPPED_NAME, PedidoServiceRemote.class);
		Pedido pedido = pedidoService.findOne(numeroPedido);
		if (pedido == null) {
			return Response.serverError().entity("Pedido não localizado").build();
		}
		return Response.ok().entity(pedido).build();
	}

}
