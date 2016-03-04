package br.com.wservices.gpv.core.domain.enumerations;

public enum TipoCustoFrete {

	EMITENTE("1", "Por conta do emitente"), DESTINATARIO("2", "Frete por conta do destinatário"), NAO_TEM("3", "Não tem frete");

	private String codigo;

	private String descricao;

	private TipoCustoFrete(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.codigo;
	}

}
