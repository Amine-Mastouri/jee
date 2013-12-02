package org.dieschnittstelle.jee.esa.jws4;

import java.util.ArrayList;
import java.util.List;

import javax.jws.*;

import org.dieschnittstelle.jee.esa.erp.entities.AbstractProduct;
import org.dieschnittstelle.jee.esa.erp.entities.IndividualisedProductItem;
import org.dieschnittstelle.jee.esa.erp.entities.ProductType;

/*
 * UE JWS4: machen Sie die Funktionalitaet dieser Klasse als Web Service verfuegbar
 */

@WebService

public class ProductCRUDWebService {

	private static int ID = 0;

	private static List<AbstractProduct> products = new ArrayList<AbstractProduct>();

	static {
		IndividualisedProductItem prod = new IndividualisedProductItem(
		"Baguette", ProductType.BREAD, 360);
		prod.setId(ID++);
		products.add(prod);
	}
	@WebMethod
	public List<AbstractProduct> readAllProducts() {
		return products;
	}
	@WebMethod
	public AbstractProduct createProduct(AbstractProduct product) {
		product.setId(ID++);
		products.add(product);
		return product;
	}

}
