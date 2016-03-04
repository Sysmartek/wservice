package br.com.wservices.gpv.faturamento.domain.service;

import java.util.List;

import javax.ejb.Local;
import javax.enterprise.event.Observes;

import br.com.sysmartek.framework.exception.DomainException;
import br.com.sysmartek.framework.exception.InfrastructureException;
import br.com.wservices.gpv.faturamento.domain.entity.NotaFiscal;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido.Pedido;
import br.com.wservices.gpv.faturamento.domain.events.PedidoBaixadoAbacos;
import br.com.wservices.gpv.faturamento.domain.service.remote.NotaFiscalServiceRemote;

@Local
public interface NotaFiscalService extends NotaFiscalServiceRemote {

	List<NotaFiscal> montaNotasFicais(@Observes @PedidoBaixadoAbacos Pedido pedido) throws InfrastructureException, DomainException;
}
