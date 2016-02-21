package br.com.wservices.gpv.faturamento.domain.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.sysmartek.framework.entity.Identifiable;
import br.com.sysmartek.framework.entity.RegionalEntity;
import br.com.wservices.gpv.core.domain.enumerations.TipoItem;

@Entity
@Table(name = "TFAT_PAGTO_NOTA_FISCAL")
public class Pagamento extends RegionalEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SFAT_PAGTO_NOTA_FISCAL", sequenceName = "SFAT_PAGTO_NOTA_FISCAL")
	@GeneratedValue(generator = "SFAT_PAGTO_NOTA_FISCAL", strategy = GenerationType.AUTO)
	@Column(name = "UID_PAGTO_NOTA_FISCAL", length = 4)
	private Integer id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "UID_NOTA_FISCAL", referencedColumnName = "UID_NOTA_FISCAL")
	private NotaFiscal notaFiscal;

	@Column(name = "TIP_FORMA_PAGTO")
	private Integer formaPagamento;

	@Column(name = "QTD_PARCELAS")
	private Integer quantidadeParcelas;

	@Column(name = "VAL_PARCELA")
	private BigDecimal valorParcela;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "pagamento")
	private List<Duplicata> duplicatas;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "codigo", column = @Column(name = "COD_CONDICAO_PAGAMENTO")) })
	private CondicaoPagamento condicaoPagamento;
	
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

	public Integer getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(Integer formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Integer getQuantidadeParcelas() {
		return quantidadeParcelas;
	}

	public void setQuantidadeParcelas(Integer quantidadeParcelas) {
		this.quantidadeParcelas = quantidadeParcelas;
	}

	public BigDecimal getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(BigDecimal valorParcela) {
		this.valorParcela = valorParcela;
	}

	public List<Duplicata> getDuplicatas() {
		return duplicatas;
	}

	public void setDuplicatas(List<Duplicata> duplicatas) {
		this.duplicatas = duplicatas;
	}

	public CondicaoPagamento getCondicaoPagamento() {
		return condicaoPagamento;
	}

	public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
		this.condicaoPagamento = condicaoPagamento;
	}

	public BigDecimal getTotalPagamento() {
		return this.valorParcela.multiply(new BigDecimal(quantidadeParcelas));
	}
	
	public BigDecimal getTotalDuplicatas() {
		BigDecimal totalDuplicatas = new BigDecimal(0);
		if (getDuplicatas() != null && !getDuplicatas().isEmpty()) {
			for (Duplicata duplicata : getDuplicatas()) {
				totalDuplicatas = totalDuplicatas.add(duplicata.getValor());
			}
			return totalDuplicatas;
		} else {
			return null;
		}
	}
}
