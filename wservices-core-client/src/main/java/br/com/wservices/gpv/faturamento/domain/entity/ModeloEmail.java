package br.com.wservices.gpv.faturamento.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import br.com.sysmartek.framework.entity.AuditavelEntity;
import br.com.sysmartek.framework.entity.Identifiable;

@Table(name = "TFAT_MODELO_EMAIL")
@Entity(name = "ModeloEmail")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "cacheDefault")
public class ModeloEmail extends AuditavelEntity implements Identifiable<Integer> {

	public static final String TIPO_MODELO_EMAIL_DANFE = "D";
	public static final String TIPO_MODELO_EMAIL_SERVICO = "S";

	@Id
	@SequenceGenerator(name = "SFAT_MODELO_EMAIL", sequenceName = "SFAT_MODELO_EMAIL")
	@GeneratedValue(generator = "SFAT_MODELO_EMAIL", strategy = GenerationType.AUTO)
	@Column(name = "UID_MODELO_EMAIL", length = 4)
	private Integer id;

	@NotNull
	@Column(name = "TIP_MODELO_EMAIL", length = 1)
	private String tipoModeloEmail;

	@ManyToOne
	@JoinColumn(name = "UID_UNIDADE_NEGOCIO")
	private UnidadeNegocio unidadeNegocio;

	@Lob
	@NotNull
	@Column(name = "TXT_MODELO", columnDefinition = "CLOB NOT NULL")
	private String modelo;

	@ManyToOne
	@JoinColumn(name = "UID_CONFIGURACAO_EMAIL")
	private ConfiguracaoEmail configuracaoEmail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoModeloEmail() {
		return tipoModeloEmail;
	}

	public void setTipoModeloEmail(String tipoModeloEmail) {
		this.tipoModeloEmail = tipoModeloEmail;
	}

	public UnidadeNegocio getUnidadeNegocio() {
		return unidadeNegocio;
	}

	public void setUnidadeNegocio(UnidadeNegocio unidadeNegocio) {
		this.unidadeNegocio = unidadeNegocio;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public ConfiguracaoEmail getConfiguracaoEmail() {
		return configuracaoEmail;
	}

	public void setConfiguracaoEmail(ConfiguracaoEmail configuracaoEmail) {
		this.configuracaoEmail = configuracaoEmail;
	}
}
