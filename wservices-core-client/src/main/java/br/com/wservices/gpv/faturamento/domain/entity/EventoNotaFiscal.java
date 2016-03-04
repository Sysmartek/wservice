package br.com.wservices.gpv.faturamento.domain.entity;

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

import br.com.sysmartek.framework.entity.AuditavelEntity;
import br.com.sysmartek.framework.entity.Identifiable;
import br.com.wservices.gpv.core.domain.enumerations.TipoEvento;

@Entity
@Table(name = "TFAT_EVENTO_NOTA_FISCAL")
public class EventoNotaFiscal extends AuditavelEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SFAT_EVENTO_NOTA_FISCAL", sequenceName = "SFAT_EVENTO_NOTA_FISCAL")
	@GeneratedValue(generator = "SFAT_EVENTO_NOTA_FISCAL", strategy = GenerationType.AUTO)
	@Column(name = "UID_EVENTO_NOTA_FISCAL", length = 4)
	private Integer id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "UID_NOTA_FISCAL", referencedColumnName = "UID_NOTA_FISCAL")
	private NotaFiscal notaFiscal;

	@NotNull
	@Column(name = "TIP_EVENTO")
	private TipoEvento tipoEvento;
	
	@NotNull
	@Column(name = "DAT_ALTERACAO")
	private Calendar dataAlteracao = Calendar.getInstance();

	@Column(name = "DES_MENSAGEM")
	private String mensagem;

	@Column(name = "OBS_EVENTO")
	private String observacoes;

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

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

}
