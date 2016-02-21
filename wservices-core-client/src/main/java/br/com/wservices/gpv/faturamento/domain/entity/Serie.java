package br.com.wservices.gpv.faturamento.domain.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import br.com.sysmartek.framework.entity.AuditavelEntity;
import br.com.sysmartek.framework.entity.Identifiable;
import br.com.sysmartek.framework.exception.DomainException;
import br.com.sysmartek.framework.util.IntegerUtil;

@Entity
@Table(name = "TFAT_SERIE")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "cacheDefault")
public class Serie extends AuditavelEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = -4172445341506515759L;

	public static final String STATUS_ATIVO = "A";
	public static final String STATUS_INATIVO = "I";

	@Id
	@GeneratedValue(generator = "SEQ_ID_SERIE", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "SEQ_ID_SERIE", sequenceName = "SFAT_SERIE")
	@Column(name = "UID_PK", length = 10, nullable = false)
	@NotNull
	private Integer id;

	@NotNull
	@Column(name = "TIP_SERIE")
	private String tipo;

	@NotNull
	@Column(name = "TIP_OPERACAO")
	private String tipoOperacao;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "UID_UNIDADE_FATURAMENTO")
	private UnidadeFaturamento unidadeFaturamento;

	@Size(max = 50)
	@NotNull
	@Column(name = "NOM_SERIE")
	private String nome;

	@Column(name = "DES_FINALIDADE")
	private String descricaoFinalidade;

	@Max(value = 999)
	@Column(name = "NRO_SERIE")
	private Integer numeroSerie;

	@Column(name = "QTD_MAX_ITEM_POR_PAG")
	private Integer qtdMaxItemPorPag;

	@Column(name = "QTD_MAX_PAG_POR_NF")
	private Integer qtdMaxPagPorNF;

	@Column(name = "NRO_MAX_UTILIZADO")
	private Integer numeroMaxUtilizado;

	@Column(name = "NRO_FATURADO_POR_ULTIMO")
	private Integer ultimoNumeroFaturado;

	@Column(name = "DAT_ULTIMA_EMISSAO_NF")
	private Date dataEmissaoUltimaNF;

	@Column(name = "STA_SERIE")
	private String status;

	@Column(name = "DAT_DESATIVACAO")
	private Date dataDesativacao;

	@ManyToMany(mappedBy = "listaSerie")
	private Set<LayoutEtiqueta> listaLayout;

	public void incrementarNumeracao() throws DomainException {
		Integer proximoUltimoNumero = IntegerUtil.obterConversaoNuloParaZero(this.getUltimoNumeroFaturado()) + 1;
		if (IntegerUtil.obterConversaoNuloParaZero(this.getNumeroMaxUtilizado()) < proximoUltimoNumero) {
			throw new DomainException("Foi ultrapassado o limite de numeracao para essa serie");
		}
		this.setUltimoNumeroFaturado(proximoUltimoNumero);
	}

	// Get & Set
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public UnidadeFaturamento getUnidadeFaturamento() {
		return unidadeFaturamento;
	}

	public void setUnidadeFaturamento(UnidadeFaturamento unidadeFaturamento) {
		this.unidadeFaturamento = unidadeFaturamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricaoFinalidade() {
		return descricaoFinalidade;
	}

	public void setDescricaoFinalidade(String descricaoFinalidade) {
		this.descricaoFinalidade = descricaoFinalidade;
	}

	public Integer getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(Integer numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public Integer getQtdMaxItemPorPag() {
		return qtdMaxItemPorPag;
	}

	public void setQtdMaxItemPorPag(Integer qtdMaxItemPorPag) {
		this.qtdMaxItemPorPag = qtdMaxItemPorPag;
	}

	public void setUltimoNumeroFaturado(Integer numero) throws DomainException {
		if (IntegerUtil.obterConversaoNuloParaZero(numero) > IntegerUtil.obterConversaoNuloParaZero(this.getNumeroMaxUtilizado())) {
			throw new DomainException("O ultimo numero ultilizado deve ser menor ou" + " igual ao numero maximo que pode ser utilizado.");
		}
		this.ultimoNumeroFaturado = numero;
	}

	public Integer getQtdMaxPagPorNF() {
		return qtdMaxPagPorNF;
	}

	public void setQtdMaxPagPorNF(Integer qtdMaxPagPorNF) {
		this.qtdMaxPagPorNF = qtdMaxPagPorNF;
	}

	public Integer getNumeroMaxUtilizado() {
		return numeroMaxUtilizado;
	}

	public void setNumeroMaxUtilizado(Integer numeroMaxUtilizado) throws DomainException {
		if (IntegerUtil.obterConversaoNuloParaZero(this.getUltimoNumeroFaturado()) > IntegerUtil.obterConversaoNuloParaZero(numeroMaxUtilizado)) {
			throw new DomainException("O numero maximo que pode ser utilizado nao pode ser menor que o ultimo numero faturado.");
		}
		this.numeroMaxUtilizado = numeroMaxUtilizado;
	}

	public Integer getUltimoNumeroFaturado() {
		return ultimoNumeroFaturado;
	}

	public Date getDataEmissaoUltimaNF() {
		return dataEmissaoUltimaNF;
	}

	public void setDataEmissaoUltimaNF(Date dataEmissaoUltimaNF) {
		this.dataEmissaoUltimaNF = dataEmissaoUltimaNF;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		if (STATUS_INATIVO.equals(status)) {
			this.setDataDesativacao(new Date());
		} else {
			this.setDataDesativacao(null);
		}
	}

	public Date getDataDesativacao() {
		return dataDesativacao;
	}

	public void setDataDesativacao(Date dataDesativacao) {
		this.dataDesativacao = dataDesativacao;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Set<LayoutEtiqueta> getListaLayout() {
		return listaLayout;
	}

	public void setListaLayout(Set<LayoutEtiqueta> listaLayout) {
		this.listaLayout = listaLayout;
	}

	// TODO: TRATAR CHECKSTYLE
	// CHECKSTYLE:OFF
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataDesativacao == null) ? 0 : dataDesativacao.hashCode());
		result = prime * result + ((dataEmissaoUltimaNF == null) ? 0 : dataEmissaoUltimaNF.hashCode());
		result = prime * result + ((descricaoFinalidade == null) ? 0 : descricaoFinalidade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroMaxUtilizado == null) ? 0 : numeroMaxUtilizado.hashCode());
		result = prime * result + ((numeroSerie == null) ? 0 : numeroSerie.hashCode());
		result = prime * result + ((qtdMaxItemPorPag == null) ? 0 : qtdMaxItemPorPag.hashCode());
		result = prime * result + ((qtdMaxPagPorNF == null) ? 0 : qtdMaxPagPorNF.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((tipoOperacao == null) ? 0 : tipoOperacao.hashCode());
		result = prime * result + ((ultimoNumeroFaturado == null) ? 0 : ultimoNumeroFaturado.hashCode());
		result = prime * result + ((unidadeFaturamento == null) ? 0 : unidadeFaturamento.hashCode());
		return result;
	}

	// CHECKSTYLE:ON

	// TODO: TRATAR CHECKSTYLE
	// CHECKSTYLE:OFF
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		if (dataDesativacao == null) {
			if (other.dataDesativacao != null)
				return false;
		} else if (!dataDesativacao.equals(other.dataDesativacao))
			return false;
		if (dataEmissaoUltimaNF == null) {
			if (other.dataEmissaoUltimaNF != null)
				return false;
		} else if (!dataEmissaoUltimaNF.equals(other.dataEmissaoUltimaNF))
			return false;
		if (descricaoFinalidade == null) {
			if (other.descricaoFinalidade != null)
				return false;
		} else if (!descricaoFinalidade.equals(other.descricaoFinalidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroMaxUtilizado == null) {
			if (other.numeroMaxUtilizado != null)
				return false;
		} else if (!numeroMaxUtilizado.equals(other.numeroMaxUtilizado))
			return false;
		if (numeroSerie == null) {
			if (other.numeroSerie != null)
				return false;
		} else if (!numeroSerie.equals(other.numeroSerie))
			return false;
		if (qtdMaxItemPorPag == null) {
			if (other.qtdMaxItemPorPag != null)
				return false;
		} else if (!qtdMaxItemPorPag.equals(other.qtdMaxItemPorPag))
			return false;
		if (qtdMaxPagPorNF == null) {
			if (other.qtdMaxPagPorNF != null)
				return false;
		} else if (!qtdMaxPagPorNF.equals(other.qtdMaxPagPorNF))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (tipoOperacao == null) {
			if (other.tipoOperacao != null)
				return false;
		} else if (!tipoOperacao.equals(other.tipoOperacao))
			return false;
		if (ultimoNumeroFaturado == null) {
			if (other.ultimoNumeroFaturado != null)
				return false;
		} else if (!ultimoNumeroFaturado.equals(other.ultimoNumeroFaturado))
			return false;
		if (unidadeFaturamento == null) {
			if (other.unidadeFaturamento != null)
				return false;
		} else if (!unidadeFaturamento.equals(other.unidadeFaturamento))
			return false;
		return true;
	}

	// CHECKSTYLE:ON

	@Override
	public String toString() {
		return "Serie [id=" + id + ", tipo=" + tipo + ", tipoOperacao=" + tipoOperacao + ", unidadeFaturamento=" + unidadeFaturamento + ", nome=" + nome + ", descricaoFinalidade="
						+ descricaoFinalidade + ", numeroSerie=" + numeroSerie + ", qtdMaxItemPorPag=" + qtdMaxItemPorPag + ", qtdMaxPagPorNF=" + qtdMaxPagPorNF + ", numeroMaxUtilizado="
						+ numeroMaxUtilizado + ", ultimoNumeroFaturado=" + ultimoNumeroFaturado + ", dataEmissaoUltimaNF=" + dataEmissaoUltimaNF + ", status=" + status + ", dataDesativacao="
						+ dataDesativacao + "]";
	}

}
