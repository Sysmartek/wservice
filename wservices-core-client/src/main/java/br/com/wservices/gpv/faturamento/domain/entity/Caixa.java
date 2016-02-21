package br.com.wservices.gpv.faturamento.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import br.com.sysmartek.framework.entity.AuditavelEntity;
import br.com.sysmartek.framework.entity.Identifiable;

@Table(name = "TFAT_CAIXA")
@Entity(name = "Caixa")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "cacheDefault")
public class Caixa extends AuditavelEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 1L;

	public static final String STATUS_ATIVO = "A";
	public static final String STATUS_INATIVO = "I";

	@Id
	@SequenceGenerator(name = "SFAT_CAIXA", sequenceName = "SFAT_CAIXA")
	@GeneratedValue(generator = "SFAT_CAIXA", strategy = GenerationType.AUTO)
	@Column(name = "UID_CAIXA", length = 4)
	private Integer id;

	@NotNull
	@Max(value = 9999)
	@Column(name = "NRO_CAIXA", length = 4)
	private Integer numero;

	@NotNull
	@Size(max = 50)
	@Column(name = "NOME_CAIXA")
	private String nome;

	@NotNull
	@Column(name = "SGL_FINALIDADE_CAIXA", length = 1)
	private String finalidadeCaixa;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UID_UNIDADE_FATURAMENTO")
	private UnidadeFaturamento unidadeFaturamento;

	@ManyToOne
	@JoinColumn(name = "UID_IMPRESSORA_ETIQUETA")
	private Impressora impressoraEtiqueta;

	@ManyToOne
	@JoinColumn(name = "UID_IMPRESSORA_NOTA_FISCAL")
	private Impressora impressoraNotaFiscal;

	@NotNull
	@Column(name = "STA_STATUS", length = 1)
	private String status;

	@Column(name = "DAT_INATIVO")
	private Date dataInativado;

	@Transient
	private String statusAnterior;

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFinalidadeCaixa() {
		return finalidadeCaixa;
	}

	public void setFinalidadeCaixa(String finalidadeCaixa) {
		this.finalidadeCaixa = finalidadeCaixa;
	}

	public UnidadeFaturamento getUnidadeFaturamento() {
		return unidadeFaturamento;
	}

	public void setUnidadeFaturamento(UnidadeFaturamento unidadeFaturamento) {
		this.unidadeFaturamento = unidadeFaturamento;
	}

	public void setImpressoraEtiqueta(Impressora impressoraEtiqueta) {
		this.impressoraEtiqueta = impressoraEtiqueta;
	}

	public void setImpressoraNotaFiscal(Impressora impressoraNotaFiscal) {
		this.impressoraNotaFiscal = impressoraNotaFiscal;
	}

	public Impressora getImpressoraEtiqueta() {
		return impressoraEtiqueta;
	}

	public Impressora getImpressoraNotaFiscal() {
		return impressoraNotaFiscal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataInativado() {
		return dataInativado;
	}

	public void setDataInativado(Date dataInativado) {
		this.dataInativado = dataInativado;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatusAnterior() {
		return statusAnterior;
	}

	public void setStatusAnterior(String statusAnterior) {
		this.statusAnterior = statusAnterior;
	}

	public enum StatusCaixa {
		ATIVO("A"), INATIVO("I");
		private String codigo;

		StatusCaixa(String codigo) {
			this.codigo = codigo;
		}

		public String getCodigo() {
			return this.codigo;
		}
	}

}
