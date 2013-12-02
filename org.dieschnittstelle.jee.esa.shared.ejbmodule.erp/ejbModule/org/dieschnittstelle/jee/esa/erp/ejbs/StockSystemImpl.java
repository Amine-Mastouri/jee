package org.dieschnittstelle.jee.esa.erp.ejbs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import org.dieschnittstelle.jee.esa.erp.ejbs.crud.PointOfSaleCRUDLocal;
import org.dieschnittstelle.jee.esa.erp.entities.IndividualisedProductItem;
import org.dieschnittstelle.jee.esa.erp.entities.PointOfSale;
import org.dieschnittstelle.jee.esa.erp.entities.StockItem;
import org.jboss.logging.Logger;

@Singleton
public class StockSystemImpl implements StockSystem {

	protected static Logger logger = Logger.getLogger(StockSystemImpl.class);

	/* use StockItemCRUD and PointOfSaleCRUD */
	
	@Override
	public void addToStock(IndividualisedProductItem product,
			int pointOfSaleId, int units) {
		logger.info("addToStock(): " + product);
	}

	@Override
	public void removeFromStock(IndividualisedProductItem product,
			int pointOfSaleId, int units) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<IndividualisedProductItem> getProductsOnStock(int pointOfSaleId) {
		return null;		
	}

	@Override
	public List<IndividualisedProductItem> getAllProductsOnStock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUnitsOnStock(IndividualisedProductItem product,
			int pointOfSaleId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalUnitsOnStock(IndividualisedProductItem product) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Integer> getPointsOfSale(IndividualisedProductItem product) {
		// TODO Auto-generated method stub
		return null;
	}

}