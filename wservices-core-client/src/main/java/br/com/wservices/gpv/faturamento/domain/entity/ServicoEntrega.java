package br.com.wservices.gpv.faturamento.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.sysmartek.framework.entity.AuditavelEntity;
import br.com.sysmartek.framework.entity.Identifiable;

@Entity
@Table(name = "TFAT_SERV_ENTR")
public class ServicoEntrega extends AuditavelEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 6798901398329151688L;

	@Id
	@GeneratedValue(generator = "SEQ_ID_SERVICO_ENTREGA", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "SEQ_ID_SERVICO_ENTREGA", sequenceName = "SFAT_SERVICO_ENTREGA")
	@Column(name = "UID_PK", length = 10, nullable = false)
	@NotNull
	private Integer id;

	@NotNull
	@Column(name = "NOM_SERVICO_ENTREGA")
	private String nome;

	@NotNull
	@Column(name = "TIP_SERVICO_ENTREGA")
	private String tipo;

	@NotNull
	@OneToOne
	@JoinColumn(name = "UID_TRANSPORTADORA")
	private Transportadora transportadora;

	@ManyToMany(mappedBy = "listaServicoEntrega")
	private Set<LayoutEtiqueta> listaLayout;

	@Override
	public Integer getId() {
		return id;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Transportadora getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}

	public Set<LayoutEtiqueta> getListaLayout() {
		return listaLayout;
	}

	public void setListaLayout(Set<LayoutEtiqueta> listaLayout) {
		this.listaLayout = listaLayout;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((transportadora == null) ? 0 : transportadora.hashCode());
		return result;
	}

	// TODO: TRATAR CHECKSTYLE
	// CHECKSTYLE:OFF
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		ServicoEntrega other = (ServicoEntrega) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (transportadora == null) {
			if (other.transportadora != null)
				return false;
		} else if (!transportadora.equals(other.transportadora))
			return false;
		return true;
	}

	// CHECKSTYLE:ON

	@Override
	public String toString() {
		return "ServicoEntrega [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", transportadora=" + transportadora + "]";
	}

}
