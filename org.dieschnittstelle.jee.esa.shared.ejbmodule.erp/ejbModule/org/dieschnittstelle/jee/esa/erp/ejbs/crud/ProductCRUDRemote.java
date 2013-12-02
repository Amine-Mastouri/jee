package org.dieschnittstelle.jee.esa.erp.ejbs.crud;

import javax.ejb.Remote;

import org.dieschnittstelle.jee.esa.erp.entities.AbstractProduct;

@Remote
public interface ProductCRUDRemote {
	
	public AbstractProduct createProduct(AbstractProduct prod);

}