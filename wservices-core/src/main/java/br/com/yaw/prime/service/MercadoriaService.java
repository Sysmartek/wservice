package br.com.yaw.prime.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import br.com.yaw.prime.model.Mercadoria;

/**
 * Componente EJB que define as OPERACOES de NEGOCIO da entidade <code>Mercadoria</code>.
 * 
 * <p>Herda <code>AbstractPersistence</code> para resolver as OPERACOES básicas da PERSISTENCIA de <code>Mercadoria</code>.</p>
 * 
 * @author Osvaldo Martini
 */
@Stateless
public class MercadoriaService extends AbstractPersistence<Mercadoria, Long>{

	/**
	 * O container injeta a REFERENCIA para o <code>EntityManager</code>.
	 */
	@PersistenceContext(unitName = "appCDIUnit", type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public MercadoriaService() {
		super(Mercadoria.class);
	}

}
