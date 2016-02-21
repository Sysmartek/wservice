package br.com.wservices.gpv.faturamento.domain.dto.filtro;

import java.io.Serializable;

public class LayoutEtiquetaFiltro implements Serializable {

	private static final long serialVersionUID = 2804728767633723926L;

	private String nome;

	private String tipoLinguagem;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoLinguagem() {
		return tipoLinguagem;
	}

	public void setTipoLinguagem(String tipoLinguagem) {
		this.tipoLinguagem = tipoLinguagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipoLinguagem == null) ? 0 : tipoLinguagem.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		LayoutEtiquetaFiltro other = (LayoutEtiquetaFiltro) obj;
		if (nome == null) {
			if (other.nome != null) {
				return false;
			}
		} else if (!nome.equals(other.nome)) {
			return false;
		}
		if (tipoLinguagem == null) {
			if (other.tipoLinguagem != null) {
				return false;
			}
		} else if (!tipoLinguagem.equals(other.tipoLinguagem)) {
			return false;
		}
		return true;
	}

}
