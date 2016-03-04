package br.com.wservices.gpv.faturamento.domain.entity;

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

import br.com.sysmartek.framework.entity.RegionalEntity;
import br.com.wservices.gpv.core.domain.enumerations.TipoMensagem;

@Entity
@Table(name = "TFAT_MENSAGEM")
public class Mensagem extends RegionalEntity {

	private static final long serialVersionUID = -583510451998884262L;

	@Id
	@SequenceGenerator(name = "SFAT_MENSAGEM", sequenceName = "SFAT_MENSAGEM")
	@GeneratedValue(generator = "SFAT_MENSAGEM", strategy = GenerationType.AUTO)
	@Column(name = "UID_MENSAGEM", length = 4)
	private Integer id;

	@NotNull
	@Column(name = "DES_TIPO")
	private TipoMensagem tipo;

	@NotNull
	@Column(name = "DES_TEXTO")
	private String texto;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "UID_NOTA_FISCAL", referencedColumnName = "UID_NOTA_FISCAL")
	private NotaFiscal notaFiscal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoMensagem getTipo() {
		return tipo;
	}

	public void setTipo(TipoMensagem tipo) {
		this.tipo = tipo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

}
