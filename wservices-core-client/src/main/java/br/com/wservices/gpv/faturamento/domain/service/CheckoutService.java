package br.com.wservices.gpv.faturamento.domain.service;

import javax.ejb.Local;
import javax.naming.NamingException;

import br.com.sysmartek.framework.exception.DomainException;
import br.com.sysmartek.framework.exception.InfrastructureException;
import br.com.wservices.gpv.faturamento.domain.dto.PedidoDTO;
import br.com.wservices.gpv.faturamento.domain.service.remote.CheckoutServiceRemote;

@Local
public interface CheckoutService extends CheckoutServiceRemote {

	void prepararNotaFiscalParaEnvio(PedidoDTO pedido) throws InfrastructureException, DomainException;

	void finalizarPedido(PedidoDTO pedidoDTO) throws InfrastructureException, DomainException;

	void liberarCaixa(Long numeroCaixa) throws NamingException;
}
