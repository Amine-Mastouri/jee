package org.dieschnittstelle.jee.esa.servlets.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.dieschnittstelle.jee.esa.crm.entities.AbstractTouchpoint;
import org.dieschnittstelle.jee.esa.crm.entities.Address;
import org.dieschnittstelle.jee.esa.crm.entities.StationaryTouchpoint;

public class TestTouchpointService {

	protected static Logger logger = Logger
			.getLogger(TestTouchpointService.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * create a http client and access the web application to read out the
		 * list of touchpoints
		 */
		HttpClient client = new DefaultHttpClient();

		// 1) read out all touchpoints
		List<AbstractTouchpoint> touchpoints = readAllTouchpoints(client);

		// 2) delete the touchpoint after next console input
		if (touchpoints != null && touchpoints.size() > 0) {
			try {
				System.out.println("/>");
				System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			deleteTouchpoint(client, touchpoints.get(0));
		}

		// 3) wait for input and create a new touchpoint
		try {
			System.out.println("/>");
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Address addr = new Address("Luxemburger Strasse", "10", "13353",
				"Berlin");
		StationaryTouchpoint tp = new StationaryTouchpoint(-1,
				"BHT Labor", addr);

		createNewTouchpoint(client, tp);
		
		System.err.println("TestTouchpointService: done.\n");
	}

	private static List<AbstractTouchpoint> readAllTouchpoints(HttpClient client) {
		logger.info("readAllTouchpoints()");

		try {
 			
			// create a GetMethod
			
			// UE SER1: Aendern Sie die URL von api->gui
			HttpGet get = new HttpGet("http://localhost:8888/org.dieschnittstelle.jee.esa.servlets/api/touchpoints");
			// execute the method and obtain the response
			HttpResponse response = client.execute(get);
			
			// mittels der response.setHeader() Methode koennen Header-Felder gesetzt werden
			
			// check the response status
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

				// try to read out an object from the response entity
				ObjectInputStream ois = new ObjectInputStream(response
						.getEntity().getContent());

				List<AbstractTouchpoint> touchpoints = (List<AbstractTouchpoint>) ois
						.readObject();

				logger.info("read touchpoints: " + touchpoints);
				
				// this is necessary to be able to use the client for a subsequent request
				EntityUtils.consume(response.getEntity());

				return touchpoints;

			} else {
				String err = "could not successfully execute request. Got status code: "
						+ response.getStatusLine().getStatusCode();
				logger.error(err);
				throw new RuntimeException(err);
			}
			
		} catch (Exception e) {
			String err = "got exception: " + e;
			logger.error(err, e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * UE SER3
	 * 
	 * @param client
	 * @param tp
	 */
	private static void deleteTouchpoint(HttpClient client,
			AbstractTouchpoint tp) {
		logger.info("deleteTouchpoint(): " + tp);		
	}

	/**
	 * UE SER4
	 * 
	 * fuer das Schreiben des zu erzeugenden Objekts als Request Body siehe die
	 * Hinweise auf:
	 * http://stackoverflow.com/questions/10146692/how-do-i-write-to
	 * -an-outpustream-using-defaulthttpclient
	 * 
	 * @param client
	 * @param tp
	 */
	private static AbstractTouchpoint createNewTouchpoint(HttpClient client,
			AbstractTouchpoint tp) {
		logger.info("createNewTouchpoint(): " + tp);

		try {

			// create post request for the api/touchpoints uri
			HttpPost post = new HttpPost("http://localhost:8888/org.dieschnittstelle.jee.esa.servlets/api/touchpoints");
			
			// create an ObjectOutputStream from a ByteArrayOutputStream - the
			// latter must be accessible via a variable
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);

			// write the object to the output stream
			oos.writeObject(tp);
			
			// create a ByteArrayEntity and pass it the byte array from the output stream
			ByteArrayEntity body = new ByteArrayEntity(bos.toByteArray());

			// set the entity on the request
			post.setEntity(body);

			// execute the request, which will return a HttpResponse object
			HttpResponse response = client.execute(post);

			// evaluate the result using getStatusLine(), use constants in HttpStatus
				
				/* if successful: */
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				 ObjectInputStream ois = new ObjectInputStream(response.getEntity().getContent());
				// create an object input stream using getContent() from the response entity (accessible via getEntity())
				
				// read the touchpoint object from the input stream
				AbstractTouchpoint touchpointFromServer = (AbstractTouchpoint)ois.readObject();
				// cleanup the request 
				EntityUtils.consume(response.getEntity());			
				
				return touchpointFromServer;
			}
			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
			
}
	
}
