package br.com.wservices.gpv.core.domain.enumerations;

public enum ServicoEntrega {

	// TODO: REGIONALIZAR ENUMS

	NORMAL("N", "Normal"), EXPRESSA("E", "Expressa"), SUPER_EXPRESSAO("S", "Super expressa"), AGENDADA("A", "Agendada");

	private String sigla;

	private String descricao;

	private ServicoEntrega(String sigla, String descricao) {
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
