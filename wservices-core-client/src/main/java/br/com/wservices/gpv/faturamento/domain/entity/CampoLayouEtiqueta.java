package br.com.wservices.gpv.faturamento.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.sysmartek.framework.entity.AuditavelEntity;
import br.com.sysmartek.framework.entity.Identifiable;

@Entity
@Table(name = "TFAT_CAMPO_LAYOUT_ET")
public class CampoLayouEtiqueta extends AuditavelEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 5647781704840390323L;

	@Id
	@NotNull
	@GeneratedValue(generator = "SEQ_ID_CAMPO_LAYOUT_ET", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "SEQ_ID_CAMPO_LAYOUT_ET", sequenceName = "SFAT_CAMPO_LAYOUT_ET")
	@Column(name = "UID_PK", length = 10, nullable = false)
	private Integer id;
	
	@NotNull
	@Column(name = "TIP_CAMPO")
	private String tipo;

	@NotNull
	@Column(name = "DES_CAMPO")
	private String descricaoCampo;
	
	@NotNull
	@Column(name = "NOM_CAMPO")
	private String campoReflection;
	
	@NotNull
	@Column(name = "COD_CAMPO", unique = true)
	private String codigo;
	
	@NotNull
	@Column(name = "VAL_DADO_FAKE")
	private String dadoFake;

	@Column(name = "VAL_FORMATO")
	private String formato;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCampoReflection() {
		return campoReflection;
	}

	public void setCampoReflection(String campoReflection) {
		this.campoReflection = campoReflection;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDadoFake() {
		return dadoFake;
	}

	public void setDadoFake(String dadoFake) {
		this.dadoFake = dadoFake;
	}

	public String getDescricaoCampo() {
		return descricaoCampo;
	}

	public void setDescricaoCampo(String descricaoCampo) {
		this.descricaoCampo = descricaoCampo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		CampoLayouEtiqueta other = (CampoLayouEtiqueta) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

}
