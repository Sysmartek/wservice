package br.com.wservices.gpv.faturamento.domain.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import br.com.sysmartek.framework.entity.AuditavelEntity;
import br.com.sysmartek.framework.entity.Identifiable;

@Table(name = "tFatTarefa")
@Entity(name = "Tarefa")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "cacheDefault")
public class Tarefa extends AuditavelEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 1L;

	
	@Id
	@SequenceGenerator(name = "SFAT_TAREFA", sequenceName = "SFAT_TAREFA")
	@GeneratedValue(generator = "SFAT_TAREFA", strategy = GenerationType.AUTO)
	@Column(name = "UID_TAREFA", length = 4)
	private Integer id;
	  
	@NotNull
	@Size(max = 50)
	@Column(name = "NOME_TAREFA")
	private String nome;
	  
	@Transient
	private boolean finalizado;
	  
	@Temporal(TemporalType.DATE)
	@Column(name = "data_finalizacao", nullable = true)
	private Calendar dataFinalizacao;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_inicio", nullable = true)
	private Calendar dataInicio;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}  
	
	
}
