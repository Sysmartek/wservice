package br.com.wservices.gpv.core.domain.enumerations;

public enum ObjetivoProcessoReversa {

	DEVOLUCAO_DINHEIRO("DD", "Devolução de dinheiro"),
	TROCA("TR", "Troca"),
	VALE_TROCA("VT", "Vale Troca");

	private String valor;
	private String descricao;

	private ObjetivoProcessoReversa(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getValor() {
		return valor;
	}

	public static ObjetivoProcessoReversa getByValor(String valorCategoria) {
		if (valorCategoria != null) {
			for (ObjetivoProcessoReversa categoria : ObjetivoProcessoReversa.values()) {
				if (categoria.valor.equals(valorCategoria)) {
					return categoria;
				}
			}
		}
		return null;
	}

}
