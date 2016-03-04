package br.com.wservices.gpv.faturamento.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.sysmartek.framework.entity.AuditavelEntity;
import br.com.sysmartek.framework.entity.Identifiable;
import br.com.wservices.gpv.core.domain.enumerations.CategoriaTipoOperacao;
import br.com.wservices.gpv.core.domain.enumerations.NaturezaOperacao;

@Entity
@Table(name = "TFAT_TIPO_OPERACAO")
public class TipoOperacao extends AuditavelEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 4749756734741536329L;
    
	@Id
	@SequenceGenerator(name = "SFAT_TIPO_OPERACAO", sequenceName = "SFAT_TIPO_OPERACAO")
	@GeneratedValue(generator = "SFAT_TIPO_OPERACAO", strategy = GenerationType.AUTO)
	@Column(name = "UID_TIPO_OPERACAO", length = 4)
	private Integer id;

	 @NotNull
    @Column(name = "CAT_OPERACAO", length = 2)
    private String categoriaOperacao;

    @NotNull
    @Column(name = "NAT_OPERACAO", length = 2)
    private String naturezaOperacao;

    @NotNull
    @Column(name = "ENV_INTEGRACAO_SAP", length = 1)
    private Boolean enviarDadosIntegracaoSAP;

    @NotNull
    @Column(name="DES_TIPO_OPERACAO")
    private String descricao;

    public CategoriaTipoOperacao getCategoriaOperacaoEnum() {
        if (getCategoriaOperacao() != null) {
            return CategoriaTipoOperacao.getByValor(getCategoriaOperacao());
        }
        return null;
    }

    public NaturezaOperacao getNaturezaOperacaoEnum() {
        if (getNaturezaOperacao() != null) {
            return NaturezaOperacao.getByValor(getNaturezaOperacao());
        }
        return null;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoriaOperacao() {
		return categoriaOperacao;
	}

	public void setCategoriaOperacao(String categoriaOperacao) {
		this.categoriaOperacao = categoriaOperacao;
	}

	public String getNaturezaOperacao() {
		return naturezaOperacao;
	}

	public void setNaturezaOperacao(String naturezaOperacao) {
		this.naturezaOperacao = naturezaOperacao;
	}

	public Boolean getEnviarDadosIntegracaoSAP() {
		return enviarDadosIntegracaoSAP;
	}

	public void setEnviarDadosIntegracaoSAP(Boolean enviarDadosIntegracaoSAP) {
		this.enviarDadosIntegracaoSAP = enviarDadosIntegracaoSAP;
	}

}
