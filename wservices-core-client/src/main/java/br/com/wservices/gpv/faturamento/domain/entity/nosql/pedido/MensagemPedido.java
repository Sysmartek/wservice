package br.com.wservices.gpv.faturamento.domain.entity.nosql.pedido;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MensagemPedido implements Serializable {

	private static final long serialVersionUID = -1856087688199777987L;

	@NotNull(message = "O texto da mensagem não pode ser nulo")
	@Size(min = 1,  message = "O texto da mensagem não pode ser nulo")
	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
