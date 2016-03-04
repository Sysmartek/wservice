package br.com.wservices.gpv.faturamento.domain.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import br.com.sysmartek.framework.entity.AuditavelEntity;
import br.com.sysmartek.framework.entity.Identifiable;

@Table(name = "TFAT_UNIDADE_NEGOCIO")
@Entity(name = "UnidadeNegocio")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "cacheDefault")
public class UnidadeNegocio extends AuditavelEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = -8083295723175109381L;

	@Id
	@Column(name = "UID_UNIDADE_NEGOCIO", length = 4)
	private Integer id;

	@NotNull
	@Size(max = 50)
	@Column(name = "NOM_UNIDADE_NEGOCIO")
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
