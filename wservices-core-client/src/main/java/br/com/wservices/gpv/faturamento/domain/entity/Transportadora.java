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
@Table(name = "TFAT_TRANSPORTADORA")
public class Transportadora extends AuditavelEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = -8548712566956189530L;

	@Id
	@NotNull
	@GeneratedValue(generator = "SEQ_ID_TRANSPORTADORA", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "SEQ_ID_TRANSPORTADORA", sequenceName = "SFAT_TRANSPORTADORA")
	@Column(name = "UID_PK", length = 10, nullable = false)
	private Integer id;

	@Valid
	@NotNull
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "UID_PESSOA")
	private Pessoa pessoa;	
	
	@NotNull
	@Column(name = "FLG_EXIBIR_DADOS_TRANSPORT")
	private Boolean exibirDadosDaTransportadora;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Boolean getExibirDadosDaTransportadora() {
		return exibirDadosDaTransportadora;
	}

	public void setExibirDadosDaTransportadora(Boolean exibirDadosDaTransportadora) {
		this.exibirDadosDaTransportadora = exibirDadosDaTransportadora;
	}
	
}
