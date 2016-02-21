package br.com.wservices.gpv.faturamento.domain.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;

import br.com.sysmartek.framework.entity.AuditavelEntity;
import br.com.sysmartek.framework.entity.Identifiable;
import br.com.wservices.gpv.core.domain.enumerations.TipoItem;
import br.com.wservices.gpv.core.domain.vo.EnderecoVO;
import br.com.wservices.gpv.core.domain.vo.PessoaVO;
import br.com.wservices.gpv.faturamento.domain.entity.nosql.propriedadeSefaz.PropriedadeSefaz;

@Entity
@Table(name = "TFAT_NOTA_FISCAL")
public class NotaFiscal extends AuditavelEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SFAT_NOTA_FISCAL", sequenceName = "SFAT_NOTA_FISCAL")
	@GeneratedValue(generator = "SFAT_NOTA_FISCAL", strategy = GenerationType.AUTO)
	@Column(name = "UID_NOTA_FISCAL", length = 4)
	private Integer id;

	@JoinColumn(name = "UID_SERIE", referencedColumnName = "UID_PK")
	@ManyToOne(fetch = FetchType.EAGER)
	private Serie serieEn;

	@Column(name = "NRO_NOTA")
	private Integer numero;

	@NotNull
	@JoinColumn(name = "UID_TIPO_OPERACAO", referencedColumnName = "UID_TIPO_OPERACAO")
	@ManyToOne(fetch = FetchType.EAGER)
	private TipoOperacao tipoOperacao;

	@NotNull
	@Column(name = "UID_ENTREGA")
	private Long idEntrega;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UID_UNIDADE_FATURAMENTO", referencedColumnName = "UID_PK")
	private UnidadeFaturamento unidadeFaturamento;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "cpfcnpj", column = @Column(name = "DES_DEST_CPF_CNPJ")), @AttributeOverride(name = "email", column = @Column(name = "DES_DEST_EMAIL")),
					@AttributeOverride(name = "nome", column = @Column(name = "DES_DEST_NOME")), @AttributeOverride(name = "inscricaoEstadual", column = @Column(name = "COD_DEST_IE")),
					@AttributeOverride(name = "nomeFantasia", column = @Column(name = "NOM_DEST_FANTASIA")), @AttributeOverride(name = "telefone", column = @Column(name = "NUM_DEST_TELEFONES")) })
	private PessoaVO destinatario;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "logradouro", column = @Column(name = "DES_DEST_LOGRADOURO")), @AttributeOverride(name = "numero", column = @Column(name = "NRO_DEST_NUMERO")),
					@AttributeOverride(name = "complemento", column = @Column(name = "DES_DEST_COMPLEMENTO")), @AttributeOverride(name = "bairro", column = @Column(name = "DES_DEST_BAIRRO")),
					@AttributeOverride(name = "cep", column = @Column(name = "DES_DEST_CEP")), @AttributeOverride(name = "cidade", column = @Column(name = "DES_DES_CIDADE")),
					@AttributeOverride(name = "estado", column = @Column(name = "SGL_DEST_ESTADO")) })
	private EnderecoVO enderecoDestinatario;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "cpfcnpj", column = @Column(name = "DES_TRAN_CPF_CNPJ")), @AttributeOverride(name = "email", column = @Column(name = "DES_TRAN_EMAIL")),
					@AttributeOverride(name = "nome", column = @Column(name = "DES_TRAN_NOME")), @AttributeOverride(name = "inscricaoEstadual", column = @Column(name = "COD_TRAN_IE")),
					@AttributeOverride(name = "nomeFantasia", column = @Column(name = "NOM_TRAN_FANTASIA")), @AttributeOverride(name = "telefone", column = @Column(name = "NUM_TRAN_TELEFONES")) })
	private PessoaVO transportadora;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UID_UNIDADE_NEGOCIO", referencedColumnName = "UID_UNIDADE_NEGOCIO")
	private UnidadeNegocio unidadeNegocio;

	@Column(name = "NRO_MINUTA_TRANSPORTE")
	private Integer minutaTransporte;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UID_CAIXA", referencedColumnName = "UID_CAIXA")
	private Caixa caixa;

	@Embedded
	private VolumesVO volumes;

	@Column(name = "DAT_EMISSAO")
	private Calendar dataEmissao;

	@Column(name = "DAT_CANCELAMENTO")
	private Calendar dataCancelamento;

	@Column(name = "DAT_MOVIMENTACAO")
	private Calendar dataMovimentacao;

	@Column(name = "NRO_PROTOCOLO")
	private String protocolo;

	@Column(name = "COD_CHAVE_AUTORIZACAO")
	private String chaveAutorizacao;

	@Column(name = "DES_NAT_OPERACAO")
	private String descricaoNaturezaOperacao;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "notaFiscal")
	private List<Mensagem> mensagem;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "notaFiscal")
	private List<ItemNotaFiscal> itens;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "notaFiscal")
	private List<EventoNotaFiscal> eventos;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "notaFiscal")
	private List<Pagamento> pagamentos;

	@Transient
	private Contingencia contigencia;

	@Transient
	private PropriedadeSefaz propriedadeSefaz;

	@Transient
	private String xmlAprovado;

	public NotaFiscal() {
		eventos = new ArrayList<EventoNotaFiscal>();
		itens = new ArrayList<ItemNotaFiscal>();
	}

	public BigDecimal getTotalBaseCalculoICMS() {
		BigDecimal total = new BigDecimal(0);
		if (!CollectionUtils.isEmpty(this.getItens())) {
			for (ItemNotaFiscal item : this.getItens()) {
				total = total.add(ObjectUtils.defaultIfNull(item.getIcms().getBase(), new BigDecimal(0)));
			}
		}

		return total;
	}

	public BigDecimal getTotalValorICMS() {
		BigDecimal total = new BigDecimal(0);
		if (!CollectionUtils.isEmpty(this.getItens())) {
			for (ItemNotaFiscal item : this.getItens()) {
				total = total.add(ObjectUtils.defaultIfNull(item.getIcms().getValor(), new BigDecimal(0)));
			}
		}

		return total;
	}

	public BigDecimal getTotalBaseCalculoICMSST() {
		return new BigDecimal(0);
	}

	public BigDecimal getTotalValosICMSST() {
		return new BigDecimal(0);
	}

	public BigDecimal getTotalValorItens() {
		BigDecimal total = new BigDecimal(0);
		if (!CollectionUtils.isEmpty(this.getItens())) {
			for (ItemNotaFiscal item : this.getItens()) {
				total = total.add(ObjectUtils.defaultIfNull(item.getPrecoBrutoTotal(), new BigDecimal(0)));
			}
		}

		return total;
	}

	public BigDecimal getTotalDesconto() {
		BigDecimal total = new BigDecimal(0);
		if (!CollectionUtils.isEmpty(this.getItens())) {
			for (ItemNotaFiscal item : this.getItens()) {
				total = total.add(ObjectUtils.defaultIfNull(item.getDesconto(), new BigDecimal(0)));
			}
		}

		return total;
	}

	public BigDecimal getTotalFrete() {
		BigDecimal total = new BigDecimal(0);
		if (!CollectionUtils.isEmpty(this.getItens())) {
			for (ItemNotaFiscal item : this.getItens()) {
				total = total.add(ObjectUtils.defaultIfNull(item.getFrete(), new BigDecimal(0)));
			}
		}
		return total;
	}

	public BigDecimal getTotalII() {
		return new BigDecimal(0);
	}

	public BigDecimal getTotalIPI() {
		BigDecimal total = new BigDecimal(0);
		if (!CollectionUtils.isEmpty(this.getItens())) {
			for (ItemNotaFiscal item : this.getItens()) {
				total = total.add(ObjectUtils.defaultIfNull(item.getIpi().getValor(), new BigDecimal(0)));
			}
		}

		return total;
	}

	public BigDecimal getTotalPIS() {
		BigDecimal total = new BigDecimal(0);
		if (!CollectionUtils.isEmpty(this.getItens())) {
			for (ItemNotaFiscal item : this.getItens()) {
				total = total.add(ObjectUtils.defaultIfNull(item.getPis().getValor(), new BigDecimal(0)));
			}
		}

		return total;
	}

	public BigDecimal getTotalCOFINS() {
		BigDecimal total = new BigDecimal(0);
		if (!CollectionUtils.isEmpty(this.getItens())) {
			for (ItemNotaFiscal item : this.getItens()) {
				total = total.add(ObjectUtils.defaultIfNull(item.getCofins().getValor(), new BigDecimal(0)));
			}
		}

		return total;
	}

	public BigDecimal getTotalOutrasDespesas() {
		return new BigDecimal(0);
	}

	public BigDecimal getValorTotalNF() {
		return (this.getTotalValorItens().add(this.getTotalFrete())).subtract(this.getTotalDesconto());
	}

	public BigDecimal getTotalPagamentos() {
		BigDecimal total = new BigDecimal(0);
		if (!CollectionUtils.isEmpty(this.getItens())) {
			for (Pagamento pagamento : this.getPagamentos()) {
				total = total.add(ObjectUtils.defaultIfNull(pagamento.getTotalPagamento(), new BigDecimal(0)));
			}
		}

		return total;
	}
	
	public BigDecimal getTotalBrinde() {
		BigDecimal totalBrinde = new BigDecimal(0);
		for (ItemNotaFiscal itemNotaFiscal : this.getItens()) {
			if (itemNotaFiscal.getTipoItem().equals(TipoItem.BRINDE)) {
				totalBrinde = totalBrinde.add(itemNotaFiscal.getPrecoBrutoTotal());
			}
		}
		return totalBrinde;
	}
	
	public BigDecimal getTotalPagamentoDuplicatas() {
		BigDecimal totalPagamentoDuplicatas = new BigDecimal(0);
		if (getPagamentos() != null && !getPagamentos().isEmpty()) {
			for (Pagamento pagamento : getPagamentos()) {
				if (pagamento.getTotalDuplicatas() != null) {
					totalPagamentoDuplicatas = totalPagamentoDuplicatas.add(pagamento.getTotalDuplicatas());
				}
			}
		}
		return totalPagamentoDuplicatas;
	}	
	
	public Boolean isPossuiDuplicatas() {
		return getTotalPagamentoDuplicatas().compareTo(BigDecimal.ZERO) != 0; 
	}
	
	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Serie getSerieEn() {
		return serieEn;
	}

	public void setSerieEn(Serie serieEn) {
		this.serieEn = serieEn;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public TipoOperacao getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(TipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public Long getIdEntrega() {
		return idEntrega;
	}

	public void setIdEntrega(Long idEntrega) {
		this.idEntrega = idEntrega;
	}

	public UnidadeFaturamento getUnidadeFaturamento() {
		return unidadeFaturamento;
	}

	public void setUnidadeFaturamento(UnidadeFaturamento unidadeFaturamento) {
		this.unidadeFaturamento = unidadeFaturamento;
	}

	public PessoaVO getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(PessoaVO destinatario) {
		this.destinatario = destinatario;
	}

	public EnderecoVO getEnderecoDestinatario() {
		return enderecoDestinatario;
	}

	public void setEnderecoDestinatario(EnderecoVO enderecoDestinatario) {
		this.enderecoDestinatario = enderecoDestinatario;
	}

	public PessoaVO getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(PessoaVO transportadora) {
		this.transportadora = transportadora;
	}

	public UnidadeNegocio getUnidadeNegocio() {
		return unidadeNegocio;
	}

	public void setUnidadeNegocio(UnidadeNegocio unidadeNegocio) {
		this.unidadeNegocio = unidadeNegocio;
	}

	public Integer getMinutaTransporte() {
		return minutaTransporte;
	}

	public void setMinutaTransporte(Integer minutaTransporte) {
		this.minutaTransporte = minutaTransporte;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public VolumesVO getVolumes() {
		return volumes;
	}

	public void setVolumes(VolumesVO volumes) {
		this.volumes = volumes;
	}

	public Calendar getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Calendar dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Calendar getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(Calendar dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}

	public Calendar getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Calendar dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public String getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

	public String getChaveAutorizacao() {
		return chaveAutorizacao;
	}

	public void setChaveAutorizacao(String chaveAutorizacao) {
		this.chaveAutorizacao = chaveAutorizacao;
	}

	public List<Mensagem> getMensagem() {
		return mensagem;
	}

	public void setMensagem(List<Mensagem> mensagem) {
		this.mensagem = mensagem;
	}

	public List<ItemNotaFiscal> getItens() {
		return itens;
	}

	public void setItens(List<ItemNotaFiscal> itens) {
		this.itens = itens;
	}

	public List<EventoNotaFiscal> getEventos() {
		return eventos;
	}

	public void setEventos(List<EventoNotaFiscal> eventos) {
		this.eventos = eventos;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

	public EventoNotaFiscal getStatus() {
		EventoNotaFiscal status = null;

		if (this.eventos != null && !this.eventos.isEmpty()) {
			eventos.sort((ev1, ev2) -> ev1.getId().compareTo(ev2.getId()));
			status = eventos.get(eventos.size() - 1);
		}

		return status;
	}

	public Contingencia getContigencia() {
		return contigencia;
	}

	public void setContigencia(Contingencia contigencia) {
		this.contigencia = contigencia;
	}

	public PropriedadeSefaz getPropriedadeSefaz() {
		return propriedadeSefaz;
	}

	public void setPropriedadeSefaz(PropriedadeSefaz propriedadeSefaz) {
		this.propriedadeSefaz = propriedadeSefaz;
	}

	public void setXmlAprovado(String xmlAprovado) {
		this.xmlAprovado = xmlAprovado;
	}

	public String getXmlAprovado() {
		return this.xmlAprovado;
	}

	public String getDescricaoNaturezaOperacao() {
		return descricaoNaturezaOperacao;
	}

	public void setDescricaoNaturezaOperacao(String descricaoNaturezaOperacao) {
		this.descricaoNaturezaOperacao = descricaoNaturezaOperacao;
	}

}
