package br.com.wservices.gpv.core.domain.enumerations;

import java.util.Arrays;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

public enum TipoItem {
	// TODO: REGIONALIZAR ENUMS

	NORMAL("N", "Normal"), BRINDE("B", "Brinde");

	private String sigla;

	private String descricao;

	private TipoItem(String sigla, String descricao) {
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
	
	public static TipoItem getTipoItem(String sigla) {
		TipoItem tipoItem = (TipoItem) CollectionUtils.find(Arrays.asList(TipoItem.values()),
						new Predicate() {
							@Override
							public boolean evaluate(Object obj) {
								TipoItem tipoItem = (TipoItem) obj;
								return tipoItem.getSigla().equals(sigla);
							}
						});
		return tipoItem;
	}
	
}
