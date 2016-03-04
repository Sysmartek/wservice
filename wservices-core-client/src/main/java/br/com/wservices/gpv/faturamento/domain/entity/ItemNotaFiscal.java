package br.com.wservices.gpv.faturamento.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Target;

import br.com.sysmartek.framework.entity.AuditavelEntity;
import br.com.sysmartek.framework.entity.Identifiable;
import br.com.wservices.gpv.core.domain.enumerations.OrigemProduto;
import br.com.wservices.gpv.core.domain.enumerations.TipoItem;

@Entity
@Table(name = "TFAT_ITEM_NOTA_FISCAL")
public class ItemNotaFiscal extends AuditavelEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SFAT_ITEM_NOTA_FISCAL", sequenceName = "SFAT_ITEM_NOTA_FISCAL")
	@GeneratedValue(generator = "SFAT_ITEM_NOTA_FISCAL", strategy = GenerationType.AUTO)
	@Column(name = "UID_ITEM_NOTA_FISCAL", length = 4)
	private Integer id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "UID_NOTA_FISCAL", referencedColumnName = "UID_NOTA_FISCAL")
	private NotaFiscal notaFiscal;

	@Column(name = "NRO_SEQUENCIAL")
	private Integer numeroSequencial;

	@Column(name = "QTD_ITEM")
	private BigDecimal quantidade;

	@Column(name = "TIP_UNIDADE_MEDIDA")
	private String unidadeMedida;

	@Column(name = "VAL_PRECO_BRUTO_UNIT")
	private BigDecimal precoBrutoUnitario;

	@Column(name = "VAL_PRECO_LIQUIDO_UNIT")
	private BigDecimal precoLiquidoUnitario;

	@Column(name = "VAL_DESCONTO")
	private BigDecimal desconto;

	@Column(name = "VAL_FRETE")
	private BigDecimal frete;

	@Column(name = "DES_TECNICA")
	private String nomeProduto;

	@Column(name = "TIP_ITEM")
	private TipoItem tipoItem;

	@Column(name = "COD_EAN")
	private String ean;

	@Column(name = "COD_NCM")
	private String ncm;

	@Column(name = "COD_SKU")
	private String sku;

	@Column(name = "COD_CFOP")
	private String cfop;

	@Column(name = "TIP_ORIGEM_PRODUTO")
	private OrigemProduto origemProduto;

	@Column(name = "COD_SKU_KIT")
	private String codigoSKUKit;

	@Embedded
	@Target(TributoIRRF.class)
	private Tributo irrf;

	@Embedded
	@Target(TributoICMS.class)
	private Tributo icms;

	@Embedded
	@Target(TributoICMSST.class)
	private Tributo icmsSt;

	@Embedded
	@Target(TributoPIS.class)
	private Tributo pis;

	@Embedded
	@Target(TributoCOFINS.class)
	private Tributo cofins;

	@Embedded
	@Target(TributoISS.class)
	private Tributo iss;

	@Embedded
	@Target(TributoIPI.class)
	private Tributo ipi;

	@Embedded
	@Target(TributoCSLL.class)
	private Tributo csll;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Integer getNumeroSequencial() {
		return numeroSequencial;
	}

	public void setNumeroSequencial(Integer numeroSequencial) {
		this.numeroSequencial = numeroSequencial;
	}

	public BigDecimal getPrecoBrutoUnitario() {
		return precoBrutoUnitario;
	}

	public void setPrecoBrutoUnitario(BigDecimal precoBrutoUnitario) {
		this.precoBrutoUnitario = precoBrutoUnitario;
	}

	public BigDecimal getPrecoLiquidoUnitario() {
		return precoLiquidoUnitario;
	}

	public void setPrecoLiquidoUnitario(BigDecimal precoLiquidoUnitario) {
		this.precoLiquidoUnitario = precoLiquidoUnitario;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public TipoItem getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(TipoItem tipoItem) {
		this.tipoItem = tipoItem;
	}

	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getCfop() {
		return cfop;
	}

	public void setCfop(String cfop) {
		this.cfop = cfop;
	}

	public OrigemProduto getOrigemProduto() {
		return origemProduto;
	}

	public void setOrigemProduto(OrigemProduto origemProduto) {
		this.origemProduto = origemProduto;
	}

	public String getCodigoSKUKit() {
		return codigoSKUKit;
	}

	public void setCodigoSKUKit(String codigoSKUKit) {
		this.codigoSKUKit = codigoSKUKit;
	}

	public Tributo getIrrf() {
		return irrf;
	}

	public void setIrrf(Tributo irrf) {
		this.irrf = irrf;
	}

	public Tributo getIcms() {
		return icms;
	}

	public void setIcms(Tributo icms) {
		this.icms = icms;
	}

	public Tributo getIcmsSt() {
		return icmsSt;
	}

	public void setIcmsSt(Tributo icmsSt) {
		this.icmsSt = icmsSt;
	}

	public Tributo getPis() {
		return pis;
	}

	public void setPis(Tributo pis) {
		this.pis = pis;
	}

	public Tributo getCofins() {
		return cofins;
	}

	public void setCofins(Tributo cofins) {
		this.cofins = cofins;
	}

	public Tributo getIss() {
		return iss;
	}

	public void setIss(Tributo iss) {
		this.iss = iss;
	}

	public Tributo getIpi() {
		return ipi;
	}

	public void setIpi(Tributo ipi) {
		this.ipi = ipi;
	}

	public Tributo getCsll() {
		return csll;
	}

	public void setCsll(Tributo csll) {
		this.csll = csll;
	}

	public BigDecimal getPrecoBrutoTotal() {
		return this.precoBrutoUnitario.multiply(this.getQuantidade());
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public void setFrete(BigDecimal frete) {
		this.frete = frete;
	}

	public BigDecimal getFrete() {
		return frete;
	}
}
