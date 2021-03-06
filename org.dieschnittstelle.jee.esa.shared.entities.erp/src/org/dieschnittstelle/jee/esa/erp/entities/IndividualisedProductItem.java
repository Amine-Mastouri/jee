package org.dieschnittstelle.jee.esa.erp.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

import org.apache.commons.lang.builder.HashCodeBuilder;

/* declare the entity and declare a discriminator value */
@Entity
@DiscriminatorValue("individualisedPI")
public class IndividualisedProductItem extends AbstractProduct implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5109263395081656350L;

	@Column(name="iptype")
	private ProductType productType;

	private int expirationAfterStocked;
	
	public IndividualisedProductItem() {
		
	}
	
	public IndividualisedProductItem(String name,ProductType type,int expirationAfterStocked) {
		super(name);
		this.productType = type;
		this.expirationAfterStocked = expirationAfterStocked;
	}
	
	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	public int getExpirationAfterStocked() {
		return expirationAfterStocked;
	}

	public void setExpirationAfterStocked(int expirationAfterStocked) {
		this.expirationAfterStocked = expirationAfterStocked;
	}
	
	public String toString() {
		return "{IProductItem " + this.getId() + ", " + this.getName() + ", " + this.productType + "}";
	}
	
	public boolean equals(Object other) {
		
		if (other.getClass() != this.getClass()) 
			return false;
		
		return this.getId() == ((IndividualisedProductItem)other).getId();
	}
	
	public int hashCode() {
		int code = HashCodeBuilder.reflectionHashCode(this);
		System.out.println("hashCode of " + this + ": " + hashCode());
		
		return code;
	}

}