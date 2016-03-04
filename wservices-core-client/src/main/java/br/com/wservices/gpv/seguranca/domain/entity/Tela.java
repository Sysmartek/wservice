package br.com.wservices.gpv.seguranca.domain.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import br.com.sysmartek.framework.entity.BaseEntity;
import br.com.sysmartek.framework.entity.Identifiable;

@Entity(name = "TSEG_TELA")
public class Tela extends BaseEntity implements Identifiable<Integer> {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SSEG_TELA", sequenceName = "SSEG_TELA")
	@GeneratedValue(generator = "SSEG_TELA", strategy = GenerationType.AUTO)
	@Column(name = "UID_TELA", length = 4)
	private Integer id;

	@NotNull
	@Column(name = "TEL_DES_URL", unique = true, length = 100)
	private String url;

	@NotNull
	@Column(name = "TEL_DES_CHAVE", unique = true, length = 30)
	private String chave;

	@NotNull
	@Column(name = "TEL_DES", length = 50)
	private String descricao;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tela")
	private Set<TelaFuncionalidade> funcionalidade;

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
