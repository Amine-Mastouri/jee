package org.dieschnittstelle.jee.esa.erp.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/*
 * UE JRS3: entfernen Sie die Auskommentierung der Annotation
 */
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")

/* declare Entity and Inheritance SingleTable - also on the concrete subclasses */
/* declare the Discriminator Column */
/* declare the id as generated value */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="productType", discriminatorType=DiscriminatorType.STRING)

@XmlSeeAlso({IndividualisedProductItem.class})
public abstract class AbstractProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6940403029597060153L;

	@Id
	@GeneratedValue
	private int id;

	private String name;
	
	private int price;

	public AbstractProduct() {

	}

	public AbstractProduct(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}