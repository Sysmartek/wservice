package br.com.wservices.gpv.core.domain.enumerations;

public enum TipoMensagem {

	// TODO: REGIONALIZAR ENUMS

	COMERCIAL("C", "Comercial"), FISCAL("F", "Fiscal");

	private String sigla;

	private String descricao;

	private TipoMensagem(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.sigla;
	}

}
