package br.com.wservices.gpv.core.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.sysmartek.framework.entity.Identifiable;
import br.com.sysmartek.framework.entity.RegionalEntity;

@Entity(name = "Dominio")
@Table(name = "TFAT_DOMINIO")
public class Dominio extends RegionalEntity implements Identifiable<Integer> {

	public static final String TIPO_DOMINIO_CAIXA_STATUS = "CAIXA_STATUS";
	public static final String TIPO_DOMINIO_CAIXA_FINALIDADE = "CAIXA_FINALIDADE";
	public static final String SERIE_STATUS = "SERIE_STATUS";
	public static final String SERIE_TIPO = "SERIE_TIPO";
	public static final String SERIE_OPERACAO = "SERIE_OPERACAO";
	public static final String TIPO_DOMINIO_IMPRESSORA_TIPO = "IMPRESSORA_TIPO";
	public static final String TIPO_MODELO_EMAIL = "MODELO_EMAIL_TIPO";
	public static final String SERVICO_ENTREGA = "SERVICO_ENTREGA";
	public static final String LINGUAGEM = "LINGUAGEM";
	public static final String NATUREZA_OPERACAO = "NATUREZA_OPERACAO";
	public static final String CATEGORIA_TIPO_OPERACAO = "CATEGORIA_OPERACAO";
	public static final String CAMPO_LAYOUT = "CAMPO_LAYOUT";

	public Dominio(Integer id) {
		super();
		this.id = id;
	}

	public Dominio() {

	}

	private static final long serialVersionUID = 4839184109630812583L;

	@Id
	@SequenceGenerator(name = "SFAT_DOMINIO", sequenceName = "SFAT_DOMINIO")
	@GeneratedValue(generator = "SFAT_DOMINIO", strategy = GenerationType.AUTO)
	@Column(name = "UID_DOMINIO", length = 4)
	private Integer id;

	@NotNull
	@Size(max = 10)
	@Column(name = "VAL_VALOR")
	private String valor;

	@NotNull
	@Size(max = 50)
	@Column(name = "DES_DESCRICAO")
	private String descricao;

	@NotNull
	@Max(value = 99)
	@Column(name = "VAL_ORDEM", length = 2)
	private Integer ordem;

	@Column(name = "TIP_DOMINIO", length = 20)
	private String tipoDominio;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public String getTipoDominio() {
		return tipoDominio;
	}

	public void setTipoDominio(String tipoDominio) {
		this.tipoDominio = tipoDominio;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

}
