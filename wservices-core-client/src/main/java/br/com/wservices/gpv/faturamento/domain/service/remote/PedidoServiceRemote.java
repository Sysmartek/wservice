package br.com.wservices.gpv.faturamento.domain.service.remote;

import javax.ejb.Remote;

import br.com.sysmartek.framework.exception.DomainException;
import br.com.wservices.gpv.faturamento.domain.entity.NotaFiscal;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido.Pedido;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido.ProcessoReversa;

@Remote
public interface PedidoServiceRemote {

	String MAPPED_NAME = "PedidoService";

	void notificaPedidoFaturado(NotaFiscal notaFiscal);

	void recebePedido(Pedido pedido)  throws DomainException;
	
	Pedido findOne(Long numeroPedido);

	void recebeProcessoReversa(ProcessoReversa processoReversa) throws DomainException;

}
