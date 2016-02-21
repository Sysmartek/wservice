package br.com.wservices.gpv.faturamento.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.sysmartek.framework.entity.AuditavelEntity;
import br.com.sysmartek.framework.entity.Identifiable;

@Entity
@Table(name = "TFAT_LAYOUT_ET")
public class LayoutEtiqueta extends AuditavelEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 6743610765590319168L;

	@Id
	@NotNull
	@GeneratedValue(generator = "SEQ_ID_LAYOUT_ETIQUETA", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "SEQ_ID_LAYOUT_ETIQUETA", sequenceName = "SFAT_LAYOUT_ETIQUETA")
	@Column(name = "UID_PK", length = 10, nullable = false)
	private Integer id;
	
	@NotNull
	@Column(name = "NOM_LAYOUT_ETIQUETA")
	private String nome;

	@NotNull
	@Column(name = "TIP_LINGUAGEM")
	private String tipoLinguagem;
	
	@NotNull
	@Column(name = "VAL_LAYOUT", length = 2500)
	private String layout;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Serie> listaSerie;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<ServicoEntrega> listaServicoEntrega;

	@Column(name = "FLG_RETIRAR_ACENTO", nullable = false)
	private boolean retirarAcento;
	
	@Column(name = "FLG_IMPRIMIR_CAIXA_ALTA", nullable = false)
	private boolean imprimirCaixaAlta;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Serie> getListaSerie() {
		return listaSerie;
	}

	public void setListaSerie(Set<Serie> listaSerie) {
		this.listaSerie = listaSerie;
	}

	public Set<ServicoEntrega> getListaServicoEntrega() {
		return listaServicoEntrega;
	}

	public void setListaServicoEntrega(Set<ServicoEntrega> listaServicoEntrega) {
		this.listaServicoEntrega = listaServicoEntrega;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoLinguagem() {
		return tipoLinguagem;
	}

	public void setTipoLinguagem(String tipoLinguagem) {
		this.tipoLinguagem = tipoLinguagem;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public boolean isRetirarAcento() {
		return retirarAcento;
	}

	public void setRetirarAcento(boolean retirarAcento) {
		this.retirarAcento = retirarAcento;
	}

	public boolean isImprimirCaixaAlta() {
		return imprimirCaixaAlta;
	}

	public void setImprimirCaixaAlta(boolean imprimirCaixaAlta) {
		this.imprimirCaixaAlta = imprimirCaixaAlta;
	}
	
}
