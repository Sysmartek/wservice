package br.com.wservices.gpv.core.domain.enumerations;

import java.util.Arrays;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;

public enum OrigemProduto {

	NACIONAL("0", "Nacional"), 
	IMPORTADO_DIRETA("1", "Importação direta"), 
	IMPORTADO_INDIRETA("2", "Importada - Adquirida no mercado interno"),
	NACIONAL_40_70("3", "mercadoria ou bem com Conteúdo de Importação superior a 40% e inferior ou igual a 70%"),
	NACIONAL_CONFORMIDADE("4", "cuja produção tenha sido feita em conformidade com os processos produtivos básicos"),
	NACIONAL_IMPORTACAO("5", "mercadoria ou bem com Conteúdo de Importação inferior ou igual a 40%;");

	private String codigo;

	private String descricao;

	private OrigemProduto(String codigo, String descricao) {
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

	public static OrigemProduto getOrigemProduto(String codigo) {
		OrigemProduto origemProduto = (OrigemProduto) CollectionUtils.find(Arrays.asList(OrigemProduto.values()),
						new Predicate() {
							@Override
							public boolean evaluate(Object obj) {
								OrigemProduto origemProduto = (OrigemProduto) obj;
								return origemProduto.getCodigo().equals(codigo);
							}
						});
		return origemProduto;
	}

}
