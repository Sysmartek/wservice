//package br.com.yaw.prime.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//
///**
// * Classe de modelo que representa uma mercadoria. A mercadoria é um objeto persistido, por isso utilizamos o nome entidade.
// * 
// * <p>As funcionalidades desse sistema demonstração são concentradas no cadastro (CRUD) de mercadorias.</p>
// * 
// * <p>Essa entidade é mapeada com anotações da <code>JPA</code>, o mecanismo padrão Java para resolver o Mapeamento Objeto Relacional (<code>ORM</code>).</p>
// * 
// * @author Osvaldo Martini
// */
//@Entity
//@Table(name="Mercadoria_prime_ejb") //, catalog="swing"
//public class Mercadoria implements AbstractEntity {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	
//	private String nome;
//	
//	private String descricao;
//	
//	private Integer quantidade;
//	
//	private Double preco;
//	
//	public String getNome() {
//		return nome;
//	}
//
//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//
//	public String getDescricao() {
//		return descricao;
//	}
//
//	public void setDescricao(String descricao) {
//		this.descricao = descricao;
//	}
//	
//	public Long getId() {
//		return id;
//	}
//	
//	public Double getPreco() {
//		return preco;
//	}
//	
//	public void setPreco(Double preco) {
//		this.preco = preco;
//	}
//	
//	public Integer getQuantidade() {
//		return quantidade;
//	}
//	
//	public void setQuantidade(Integer quantidade) {
//		this.quantidade = quantidade;
//	}
//	
//}
