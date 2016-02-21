package br.com.wservices.gpv.core.domain.enumerations;

public enum TipoEvento {

	// TODO: REGIONALIZAR ENUMS

	EMITIDA("EMI", "Emitida"), AGUARDANDO_AUTORIZACAO("AGU", "Aguardando Autorização"), CRIADA("CRI",
					"Nota Fiscal Criada"), AUTORIZADA("AUT", "Autoriza Sefaz"), ANALISE_BACKOFFICE("ANB", "Aguardando análise BackOffice");

	private String sigla;

	private String descricao;

	private TipoEvento(String sigla, String descricao) {
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
