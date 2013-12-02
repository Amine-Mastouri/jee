
package org.dieschnittstelle.jee.esa.jws4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.dieschnittstelle.jee.esa.jws4 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReadAllProducts_QNAME = new QName("http://jws4.esa.jee.dieschnittstelle.org/", "readAllProducts");
    private final static QName _CreateProductResponse_QNAME = new QName("http://jws4.esa.jee.dieschnittstelle.org/", "createProductResponse");
    private final static QName _ReadAllProductsResponse_QNAME = new QName("http://jws4.esa.jee.dieschnittstelle.org/", "readAllProductsResponse");
    private final static QName _CreateProduct_QNAME = new QName("http://jws4.esa.jee.dieschnittstelle.org/", "createProduct");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.dieschnittstelle.jee.esa.jws4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReadAllProducts }
     * 
     */
    public ReadAllProducts createReadAllProducts() {
        return new ReadAllProducts();
    }

    /**
     * Create an instance of {@link CreateProduct }
     * 
     */
    public CreateProduct createCreateProduct() {
        return new CreateProduct();
    }

    /**
     * Create an instance of {@link ReadAllProductsResponse }
     * 
     */
    public ReadAllProductsResponse createReadAllProductsResponse() {
        return new ReadAllProductsResponse();
    }

    /**
     * Create an instance of {@link CreateProductResponse }
     * 
     */
    public CreateProductResponse createCreateProductResponse() {
        return new CreateProductResponse();
    }

    /**
     * Create an instance of {@link IndividualisedProductItem }
     * 
     */
    public IndividualisedProductItem createIndividualisedProductItem() {
        return new IndividualisedProductItem();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadAllProducts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jws4.esa.jee.dieschnittstelle.org/", name = "readAllProducts")
    public JAXBElement<ReadAllProducts> createReadAllProducts(ReadAllProducts value) {
        return new JAXBElement<ReadAllProducts>(_ReadAllProducts_QNAME, ReadAllProducts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateProductResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jws4.esa.jee.dieschnittstelle.org/", name = "createProductResponse")
    public JAXBElement<CreateProductResponse> createCreateProductResponse(CreateProductResponse value) {
        return new JAXBElement<CreateProductResponse>(_CreateProductResponse_QNAME, CreateProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReadAllProductsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jws4.esa.jee.dieschnittstelle.org/", name = "readAllProductsResponse")
    public JAXBElement<ReadAllProductsResponse> createReadAllProductsResponse(ReadAllProductsResponse value) {
        return new JAXBElement<ReadAllProductsResponse>(_ReadAllProductsResponse_QNAME, ReadAllProductsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateProduct }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jws4.esa.jee.dieschnittstelle.org/", name = "createProduct")
    public JAXBElement<CreateProduct> createCreateProduct(CreateProduct value) {
        return new JAXBElement<CreateProduct>(_CreateProduct_QNAME, CreateProduct.class, null, value);
    }

}
