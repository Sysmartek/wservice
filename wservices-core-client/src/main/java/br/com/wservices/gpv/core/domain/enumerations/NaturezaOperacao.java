package br.com.wservices.gpv.core.domain.enumerations;

public enum NaturezaOperacao {

	VENDA("VN", "Venda"),
	DEVOLUCAO_VENDA("DV", "Devolução de Venda");

	private String valor;
	private String descricao;

	private NaturezaOperacao(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getValor() {
		return valor;
	}
	public static NaturezaOperacao getByValor(String valor) {
		for (NaturezaOperacao nat : NaturezaOperacao.values()) {
			if (nat.valor.equals(valor)) {
				return nat;
			}
		}
		return null;
	}
}
