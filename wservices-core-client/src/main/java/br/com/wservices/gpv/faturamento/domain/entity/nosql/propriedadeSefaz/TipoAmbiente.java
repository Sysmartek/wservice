package br.com.wservices.gpv.faturamento.domain.entity.nosql.propriedadeSefaz;

public enum TipoAmbiente {
	PRODUCAO("1"), HOMOLOGACAO("2");

	private String codigo;

	private TipoAmbiente(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return this.codigo;
	}
}
