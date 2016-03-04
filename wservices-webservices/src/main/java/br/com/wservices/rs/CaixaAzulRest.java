package br.com.wservices.rs;

import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.sysmartek.framework.util.LoockupUtil;
import br.com.wservices.gpv.core.domain.repository.remote.CaixaAzulService;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.CaixaAzul;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.CaixaAzulId;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.ControleEntrega;
import br.com.wservices.rs.dto.CaixaAzulDTO;

@Path("/caixaAzul")
public class CaixaAzulRest {

	private CaixaAzulService caixaAzulService;

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response persistirCaixaAzul(CaixaAzulDTO caixaAzul) {
		this.caixaAzulService = getCaixaAzulService();
		CaixaAzulId id = new CaixaAzulId(caixaAzul.getCnpjCD(), caixaAzul.getNumeroCaixa());
		CaixaAzul entity = caixaAzulService.findOne(id);
		if (entity == null) {
			entity = new CaixaAzul();
			entity.setId(id);
		}
		entity.getEntregas().add(new ControleEntrega(caixaAzul.getEntrega(), Boolean.FALSE));
		caixaAzulService.save(entity);
		return Response.ok().entity(entity).build();
		
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}/{cnpj}")
	public Response obterCaixaAzul(@PathParam("id") long numeroCaixa, @PathParam("cnpj") String cnpj) {

		this.caixaAzulService = getCaixaAzulService();
		CaixaAzul entity = caixaAzulService.findOne(new CaixaAzulId(cnpj, numeroCaixa));
		if (entity == null) {
			return Response.serverError().entity("Caixa não localizada").build();
		}
		return Response.ok().entity(entity).build();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterCaixaAzul() {

		// TODO: Mock
		// CHECKSTYLE:OFF
		CaixaAzulDTO caixaAzul = new CaixaAzulDTO();

		caixaAzul.setCnpjCD("01006487000182");
		caixaAzul.setEntrega(10L);
		caixaAzul.setNumeroCaixa(20L);
		return Response.status(Status.OK).entity(caixaAzul).build();
		// CHECKSTYLE:ON
	}

	private CaixaAzulService getCaixaAzulService() {
		if (caixaAzulService != null) {
			return caixaAzulService;
		} else {
			try {
				this.caixaAzulService = LoockupUtil.loockup(CaixaAzulService.MAPPED_NAME, CaixaAzulService.class);
			} catch (NamingException e) {
				// TODO: Tratamento de excessão
				e.printStackTrace();
			}
		}
		return this.caixaAzulService;
	}

}
