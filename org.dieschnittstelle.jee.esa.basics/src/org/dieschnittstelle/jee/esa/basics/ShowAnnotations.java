package org.dieschnittstelle.jee.esa.basics;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.dieschnittstelle.jee.esa.basics.annotations.AnnotatedStockItemBuilder;
import org.dieschnittstelle.jee.esa.basics.annotations.DisplayAs;
import org.dieschnittstelle.jee.esa.basics.annotations.StockItemProxyImpl;

public class ShowAnnotations {

	public static void main(String[] args) {
		// we initialise the collection
		StockItemCollection collection = new StockItemCollection(
				"stockitems_annotations.xml", new AnnotatedStockItemBuilder());
		// we load the contents into the collection
		collection.load();

		for (IStockItem consumable : collection.getStockItems()) {
			;
			showAttributes(((StockItemProxyImpl)consumable).getProxiedObject());
		}

		// we initialise a consumer
		Consumer consumer = new Consumer();
		// ... and let them consume
		consumer.doShopping(collection.getStockItems());
	}

	/*
	 * UE BAS2 
	 */
	private static void showAttributes(Object consumable) {
		Class<?> klass = consumable.getClass();
		System.err.print("\n");
		System.err.print(consumable.getClass().getSimpleName()+" ");
		for (Field field :klass.getDeclaredFields()) {
		DisplayAs displayAs;	
		field.setAccessible(true);
		//System.err.println("found field: " + field.getClass() + " of name " + field.getName());
		if((displayAs = field.getAnnotation(DisplayAs.class)) != null){
			System.err.print(displayAs.value());	        
		}else{
			System.err.print(" ");
			System.err.print(field.getName());
		}
		try {
			System.err.print(":"+field.get(consumable).toString()+" ");
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	for (Method method : klass.getDeclaredMethods()) {
		//System.err.println("found method: " + method.getClass() + " of name " + method.getName());
	}
	
	}
}
