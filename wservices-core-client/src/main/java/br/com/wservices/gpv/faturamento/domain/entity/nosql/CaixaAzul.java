package br.com.wservices.gpv.faturamento.domain.entity.nosql;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class CaixaAzul implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private CaixaAzulId id;
	private List<ControleEntrega> entregas = new ArrayList<ControleEntrega>();

	public CaixaAzulId getId() {
		return id;
	}

	public void setId(CaixaAzulId id) {
		this.id = id;
	}

	public List<ControleEntrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(List<ControleEntrega> entregas) {
		this.entregas = entregas;
	}

}
