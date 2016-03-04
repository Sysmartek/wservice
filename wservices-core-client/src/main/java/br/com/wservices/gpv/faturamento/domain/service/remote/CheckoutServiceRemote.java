package br.com.wservices.gpv.faturamento.domain.service.remote;

import java.util.List;

import javax.ejb.Remote;

import br.com.sysmartek.framework.exception.DomainException;
import br.com.sysmartek.framework.exception.InfrastructureException;
import br.com.wservices.gpv.faturamento.domain.dto.NotaFiscalDTO;
import br.com.wservices.gpv.faturamento.domain.dto.PedidoDTO;
import br.com.wservices.gpv.faturamento.domain.entity.Caixa;

@Remote
public interface CheckoutServiceRemote {

	static final String MAPPED_NAME = "CheckoutService";

	PedidoDTO buscarPedidoPorNumero(Long numeroPedido, Caixa caixa) throws DomainException;

	List<PedidoDTO> buscarPedidoPorCaixaAzul(Long numCaixaAzul, Caixa caixa) throws DomainException;

	List<NotaFiscalDTO> buscarNotaFiscalPorCaixa(Integer numeroCaixa) throws DomainException;

	void concluirCheckout(PedidoDTO pedidoDTO) throws DomainException, InfrastructureException;

	void separarPedidoComProblema(List<PedidoDTO> listaPedido) throws DomainException;

	String statusLinkSefaz();
	
	void envioBackOffice(List<NotaFiscalDTO> listaNotaFiscal) throws DomainException, InfrastructureException;
	
	void mockPedido();

}
