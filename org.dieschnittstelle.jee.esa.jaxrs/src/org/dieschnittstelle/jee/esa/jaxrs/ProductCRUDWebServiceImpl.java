package org.dieschnittstelle.jee.esa.jaxrs;

import java.util.ArrayList;
import java.util.List;

import org.dieschnittstelle.jee.esa.crm.entities.StationaryTouchpoint;
import org.dieschnittstelle.jee.esa.erp.entities.AbstractProduct;
import org.dieschnittstelle.jee.esa.erp.entities.IndividualisedProductItem;
import org.dieschnittstelle.jee.esa.erp.entities.ProductType;

/*
UE JRS2: implementieren Sie hier die im Interface deklarierten Methoden
 */

public class ProductCRUDWebServiceImpl implements IProductCRUDWebService {
	
	private static int ID;

	private static List<IndividualisedProductItem> products = new ArrayList<IndividualisedProductItem>();
	
	static {
		IndividualisedProductItem product = new IndividualisedProductItem("Baguette",	ProductType.BREAD, 360);
		product.setId(ID++);
		products.add(product);
	}
	
	@Override
	//public List<IndividualisedProductItem> readAllProducts() { 
	public List<AbstractProduct> readAllProducts() {
		return (List)products;
	}
	@Override
	public IndividualisedProductItem createProduct(IndividualisedProductItem product){
		product.setId(ID++);
		products.add(product);
		return product;
	}
	
}
