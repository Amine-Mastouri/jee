package org.dieschnittstelle.jee.esa.jsf.client;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.erp.ejbs.crud.ProductCRUDRemote;
import org.dieschnittstelle.jee.esa.erp.entities.IndividualisedProductItem;

public class CreateProducts {
	
	protected static Logger logger = Logger.getLogger(CreateProducts.class);
	
	public static void main(String[] args) {

		try {

			// obtain the beans using a jndi context
			Context context = new InitialContext();
			
			ProductCRUDRemote productCRUD = (ProductCRUDRemote)context.lookup("ejb:org.dieschnittstelle.jee.esa.ejbs/org.dieschnittstelle.jee.esa.shared.ejbmodule.erp/ProductCRUDStateless!org.dieschnittstelle.jee.esa.erp.ejbs.crud.ProductCRUDRemote");
			
			logger.info("created proxy: " + productCRUD);
			// UE JPA3: lookup eines Remote Interface fuer CRUD bezueglich AbstractProduct
			
			Constants.PRODUCT_1 = (IndividualisedProductItem)productCRUD.createProduct(Constants.PRODUCT_1);
			logger.info("created product: " + Constants.PRODUCT_1);
			
			// TODO: server-seitige Erzeugung von PRODUCT_1/2 und CAMPAIGN_1/2 durch Aufruf der Methoden des Remote Interface
			// PRODUCT_1 = ...
			// PRODUCT_2 = ...
			// CAMPAIGN_1 = ...
			// CAMPAIGN_2 = ...
			
			if (args.length == 0) {
				System.err.println("CreateProducts: done.\n");
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}


}