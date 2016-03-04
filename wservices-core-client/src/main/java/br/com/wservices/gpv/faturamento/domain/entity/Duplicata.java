package br.com.wservices.gpv.faturamento.domain.entity;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.sysmartek.framework.entity.Identifiable;
import br.com.sysmartek.framework.entity.RegionalEntity;

@Entity
@Table(name = "TFAT_DUPLICATA_PAGTO")
public class Duplicata extends RegionalEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = -6285084361018279642L;
	
	@Id
	@SequenceGenerator(name = "SFAT_DUPLICATA_PAGTO", sequenceName = "SFAT_DUPLICATA_PAGTO")
	@GeneratedValue(generator = "SFAT_DUPLICATA_PAGTO", strategy = GenerationType.AUTO)
	@Column(name = "UID_DUPLICATA_PAGTO", length = 4)
	private Integer id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "UID_PAGTO_NOTA_FISCAL", referencedColumnName = "UID_PAGTO_NOTA_FISCAL")
	private Pagamento pagamento;
	
	@Column(name = "NRO_DUPLICATA")
	private Integer numeroDuplicata;

	@Column(name = "DAT_VENCIMENTO")
	private Calendar dataVencimento;

	@Column(name = "VAL_VALOR_DUPLICATA")
	private BigDecimal valor;
	
	public Pagamento getPagamento() {
		return pagamento;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public Integer getNumeroDuplicata() {
		return numeroDuplicata;
	}

	public void setNumeroDuplicata(Integer numeroDuplicata) {
		this.numeroDuplicata = numeroDuplicata;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}
}
