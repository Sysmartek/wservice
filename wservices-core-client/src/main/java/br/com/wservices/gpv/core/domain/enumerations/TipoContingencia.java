package br.com.wservices.gpv.core.domain.enumerations;

public enum TipoContingencia {

	DPEC("4", "Declaração Prévia da Emissão em Contingência"), FS_DA("5", "impressão do DANFE em formulário de segurança"), SVC_AN("6", "SEFAZ Virtual de Contingência do AN"), EPEC("8",
					"Substituição da DPEC");

	private String codigo;
	private String descricao;

	private TipoContingencia(String codigo, String descricao) {
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
