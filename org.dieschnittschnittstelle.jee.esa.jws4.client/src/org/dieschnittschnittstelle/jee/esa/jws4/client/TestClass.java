package org.dieschnittschnittstelle.jee.esa.jws4.client;
import org.dieschnittschnittstelle.jee.esa.jws4.*;
import org.dieschnittstelle.jee.esa.jws4.AbstractProduct;
import org.dieschnittstelle.jee.esa.jws4.IndividualisedProductItem;
import org.dieschnittstelle.jee.esa.jws4.ProductCRUDWebService;
import org.dieschnittstelle.jee.esa.jws4.ProductCRUDWebServiceService;
import org.dieschnittstelle.jee.esa.jws4.ProductType;
public class TestClass {

	public static void main(String[] args) {
		ProductCRUDWebService client= new ProductCRUDWebServiceService().getProductCRUDWebServicePort();
		IndividualisedProductItem prod1 = new IndividualisedProductItem();
		prod1.setName("SCHRIPPE");
		prod1.setProductType(ProductType.ROLL);
		
		IndividualisedProductItem prod2 = new IndividualisedProductItem();
		//"Kirschplunder",ProductType.PASTRY, 1080);
		
		prod1 = (IndividualisedProductItem)client.createProduct(prod1);
		System.out.println("created: " + prod1);
	}

}
