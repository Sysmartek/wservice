package br.com.wservices.gpv.core.domain.enumerations;

public enum CategoriaTipoOperacao {

	CONSUMO("CN", "Consumo"), REVENDA("RV", "Revenda");

	private String valor;
	private String descricao;

	private CategoriaTipoOperacao(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getValor() {
		return valor;
	}

	public static CategoriaTipoOperacao getByValor(String valorCategoria) {
		if (valorCategoria != null) {
			for (CategoriaTipoOperacao categoria : CategoriaTipoOperacao.values()) {
				if (categoria.valor.equals(valorCategoria)) {
					return categoria;
				}
			}
		}
		return null;
	}

}
