package org.dieschnittstelle.jee.esa.basics.annotations.stockitemtypes;

import org.dieschnittstelle.jee.esa.basics.annotations.Initialise;
import org.dieschnittstelle.jee.esa.basics.annotations.Brandname;
import org.dieschnittstelle.jee.esa.basics.annotations.StockItem;
import org.dieschnittstelle.jee.esa.basics.annotations.Purchase;
import org.dieschnittstelle.jee.esa.basics.annotations.Units;
import org.dieschnittstelle.jee.esa.basics.annotations.DisplayAs;


@StockItem
public class Schokolade {

	@Units
	@DisplayAs(value ="StueckAnzahl")
	private int anzahlStuecke;
	
	@DisplayAs(value ="marke")
	private String marke;
	
	public int getAnzahlStuecke() {
		return anzahlStuecke;
	}

	public void setAnzahlStuecke(int anzahlStuecke) {
		this.anzahlStuecke = anzahlStuecke;
	}

	@Brandname
	public String getMarke() {
		return marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

	@Initialise
	public void insLagerUebernehmen(int units, String name) {
		this.anzahlStuecke = units;
		this.marke = name;
	}

	@Purchase
	public void indenEinkaufswagenLegen(int unitsToPurchase) {
		if (unitsToPurchase > this.anzahlStuecke) {
			throw new RuntimeException(
					"You cannot purchase more than what is available. Got: "
							+ unitsToPurchase
							+ " units to purchase, but have available only: "
							+ this.anzahlStuecke);
		}
		this.anzahlStuecke -= unitsToPurchase;
	}
	
	/**
	 * toString
	 */
	public String toString() {
		return "{Milch " + this.marke + " " + this.anzahlStuecke + "}";
	}
}
