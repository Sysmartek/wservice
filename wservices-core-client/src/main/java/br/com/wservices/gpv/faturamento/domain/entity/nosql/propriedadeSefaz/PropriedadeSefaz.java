package br.com.wservices.gpv.faturamento.domain.entity.nosql.propriedadeSefaz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.springframework.data.annotation.Id;

public class PropriedadeSefaz implements Serializable {

	private static final long serialVersionUID = 6214789096279991162L;

	@Id
	private TipoAmbiente tipoAmbiente;

	private Boolean ativo;

	private String versao;

	private String nameSpace;

	private String enderecoSVC;

	private Boolean utilizaServicoSincrono;

	private List<WebServiceEstado> webServiceEstados = new ArrayList<WebServiceEstado>();

	public String getVersao() {
		return versao;
	}

	public String getNameSpace() {
		return nameSpace;
	}

	public TipoAmbiente getTipoAmbiente() {
		return tipoAmbiente;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getEnderecoSVC() {
		return enderecoSVC;
	}

	public List<WebServiceEstado> getWebServiceEstados() {
		return webServiceEstados;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	public void setTipoAmbiente(TipoAmbiente tipoAmbiente) {
		this.tipoAmbiente = tipoAmbiente;
	}

	public void setEnderecoSVC(String enderecoSVC) {
		this.enderecoSVC = enderecoSVC;
	}

	public void setWebServiceEstados(List<WebServiceEstado> webServiceEstados) {
		this.webServiceEstados = webServiceEstados;
	}

	public Boolean getUtilizaServicoSincrono() {
		return utilizaServicoSincrono;
	}

	public void setUtilizaServicoSincrono(Boolean utilizaServicoSincrono) {
		this.utilizaServicoSincrono = utilizaServicoSincrono;
	}

	public WebServiceEstado getWebServiceEstados(String estado) {
		WebServiceEstado webServiceEstados = (WebServiceEstado) CollectionUtils.find(this.webServiceEstados, new Predicate() {
			@Override
			public boolean evaluate(Object obj) {
				WebServiceEstado webServiceEstados = (WebServiceEstado) obj;
				return webServiceEstados.getEstado().equals(estado);
			}
		});
		return webServiceEstados;
	}

}
