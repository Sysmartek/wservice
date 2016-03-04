package br.com.wservices.gpv.faturamento.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import br.com.sysmartek.framework.entity.AuditavelEntity;
import br.com.sysmartek.framework.entity.Identifiable;

@Table(name = "TFAT_IMPRESSORA")
@Entity(name = "Impressora")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "cacheDefault")
public class Impressora extends AuditavelEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 1L;

	public static final String TIPO_IMPRESSORA_LASER = "L";
	public static final String TIPO_IMPRESSORA_TERMICA = "T";

	@Id
	@SequenceGenerator(name = "SFAT_IMPRESSORA", sequenceName = "SFAT_IMPRESSORA")
	@GeneratedValue(generator = "SFAT_IMPRESSORA", strategy = GenerationType.AUTO)
	@Column(name = "UID_IMPRESSORA", length = 4)
	private Integer id;

	@NotNull
	@Column(name = "TIP_IMPRESSORA", length = 1)
	private String tipoImpressora;

	@NotNull
	@Size(max = 50)
	@Column(name = "NOM_IMPRESSORA")
	private String nome;

	@Size(max = 100)
	@Column(name = "TXT_CAMINHO_IMPRESSORA")
	private String caminhoFisico;

	@Column(name = "VAL_TEMPERATURA")
	private Integer temperatura;

	@Column(name = "VAL_VELOCIDADE")
	private Double velocidade;

	@Column(name = "FLG_RIBBON", length = 1)
	private boolean ribbon;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoImpressora() {
		return tipoImpressora;
	}

	public void setTipoImpressora(String tipoImpressora) {
		this.tipoImpressora = tipoImpressora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCaminhoFisico() {
		return caminhoFisico;
	}

	public void setCaminhoFisico(String caminhoFisico) {
		this.caminhoFisico = caminhoFisico;
	}

	public Integer getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Integer temperatura) {
		this.temperatura = temperatura;
	}

	public Double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(Double velocidade) {
		this.velocidade = velocidade;
	}

	public boolean getRibbon() {
		return ribbon;
	}

	public void setRibbon(boolean ribbon) {
		this.ribbon = ribbon;
	}

}
