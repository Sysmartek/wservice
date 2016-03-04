package br.com.wservices.gpv.faturamento.domain.entity;

import java.util.Date;

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
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import br.com.sysmartek.framework.entity.AuditavelEntity;
import br.com.sysmartek.framework.entity.Identifiable;
import br.com.wservices.gpv.core.domain.enumerations.TipoContingencia;

@Table(name = "TFAT_CONTINGENCIA")
@Entity(name = "Contingencia")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "cacheDefault")
public class Contingencia extends AuditavelEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = -1050140978546766677L;

	@Id
	@SequenceGenerator(name = "SFAT_CONTINGENCIA", sequenceName = "SFAT_CONTINGENCIA")
	@GeneratedValue(generator = "SFAT_CONTINGENCIA", strategy = GenerationType.AUTO)
	@Column(name = "UID_CONTINGENCIA", length = 4)
	private Integer id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "UID_UNIDADE_FATURAMENTO")
	private UnidadeFaturamento unidadeFaturamento;

	@Column(name = "TIP_CONTIGENCIA")
	private TipoContingencia tipoContigencia;

	@NotNull
	@Column(name = "DAT_ENTRADA")
	private Date dataEntrada;

	@Column(name = "DAT_SAIDA")
	private Date dataSaida;

	@NotNull
	@Size(min = 15, max = 256)
	@Column(name = "TXT_JUSTIFICATIVA", length = 256)
	private String justificativa;

	@NotNull
	@Size(max = 40, min = 3)
	@Column(name = "USUARIO_ENTRADA", length = 40)
	private String usuarioEntrada;

	@Size(max = 40, min = 3)
	@Column(name = "USUARIO_SAIDA", length = 40)
	private String usuarioSaida;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UnidadeFaturamento getUnidadeFaturamento() {
		return unidadeFaturamento;
	}

	public void setUnidadeFaturamento(UnidadeFaturamento unidadeFaturamento) {
		this.unidadeFaturamento = unidadeFaturamento;
	}

	public TipoContingencia getTipoContigencia() {
		return tipoContigencia;
	}

	public void setTipoContigencia(TipoContingencia tipoContigencia) {
		this.tipoContigencia = tipoContigencia;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public String getUsuarioEntrada() {
		return usuarioEntrada;
	}

	public void setUsuarioEntrada(String usuarioEntrada) {
		this.usuarioEntrada = usuarioEntrada;
	}

	public String getUsuarioSaida() {
		return usuarioSaida;
	}

	public void setUsuarioSaida(String usuarioSaida) {
		this.usuarioSaida = usuarioSaida;
	}

}
