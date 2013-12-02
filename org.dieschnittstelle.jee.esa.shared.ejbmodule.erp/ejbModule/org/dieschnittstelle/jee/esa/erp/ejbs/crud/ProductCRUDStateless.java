package org.dieschnittstelle.jee.esa.erp.ejbs.crud;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.dieschnittstelle.jee.esa.erp.entities.AbstractProduct;

@Stateless
public class ProductCRUDStateless implements ProductCRUDRemote {

	@PersistenceContext(name="crm_erp_PU")
	private EntityManager em;
	
	@Override
	public AbstractProduct createProduct(AbstractProduct prod) {
		em.persist(prod);
		return prod;
	}

}
