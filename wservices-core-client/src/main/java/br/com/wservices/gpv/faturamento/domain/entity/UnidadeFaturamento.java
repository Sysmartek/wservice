package br.com.wservices.gpv.faturamento.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.sysmartek.framework.entity.AuditavelEntity;
import br.com.sysmartek.framework.entity.Identifiable;
import br.com.wservices.gpv.core.domain.entity.Pessoa;

@Entity
@Table(name = "TFAT_UNIDADE_FATURAMENTO")
public class UnidadeFaturamento extends AuditavelEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "UID_PK")
	@SequenceGenerator(name = "SFAT_UNIDADE_FATURAMENTO", sequenceName = "SFAT_UNIDADE_FATURAMENTO")
	@GeneratedValue(generator = "SFAT_UNIDADE_FATURAMENTO", strategy = GenerationType.AUTO)
	private Integer id;

	@Valid
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "UID_PESSOA")
	private Pessoa pessoa;

	@NotNull
	@Column(name = "NOM_UNID_FATURAMENTO")
	private String nome;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
