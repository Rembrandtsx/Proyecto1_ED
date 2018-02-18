package controller;

import model.vo.Taxi;
import model.vo.Service;
import model.data_structures.LinkedList;
import model.data_structures.LinkedSimpleList;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class TaxiTripsManager implements ITaxiTripsManager {

	// TODO
	// Definition of data model 
	
	private LinkedList<Service> services;
	private LinkedSimpleList<Taxi> taxis;
	
	
	
	
	public void loadServices (String serviceFile) {
		// TODO Auto-generated method stub
		services= new LinkedSimpleList<Service>();
		taxis= new LinkedSimpleList<Taxi>();
		
		
		JsonParser parser = new JsonParser();
		
		try {
			
			/* Cargar todos los JsonObject (servicio) definidos en un JsonArray en el archivo */
			JsonArray arr= (JsonArray) parser.parse(new FileReader(serviceFile));
			/* Tratar cada JsonObject (Servicio taxi) del JsonArray */
			for (int i = 0; arr != null && i < arr.size(); i++)
			{
				JsonObject obj= (JsonObject) arr.get(i);
				
				String company = "NaN";
				if ( obj.get("company") != null )
				{ company = obj.get("company").getAsString(); }
				System.out.println(company);
				
				int area = 0;
				if ( obj.get("pickup_community_area") != null )
				{ area = obj.get("pickup_community_area").getAsInt(); }
				System.out.println(area);
				
				String taxiId = "NaN";
				if ( obj.get("taxi_id") != null )
				{ taxiId = obj.get("taxi_id").getAsString(); }
				
				
				String tripId = "NaN";
				if ( obj.get("trip_id") != null )
				{ tripId = obj.get("trip_id").getAsString(); }
				
				double tripMiles = 0;
				if ( obj.get("trip_miles") != null )
				{ tripMiles = obj.get("trip_miles").getAsDouble(); }
				
				
				int tripSeconds = 0;
				if ( obj.get("trip_seconds") != null )
				{ tripSeconds = obj.get("trip_seconds").getAsInt(); }
				
				
				double tripTotal = 0;
				if ( obj.get("trip_total") != null )
				{ tripTotal = obj.get("trip_total").getAsDouble(); }
				
				
				
				services.add(new Service(tripId, taxiId, tripSeconds, tripMiles, tripTotal, area));
				taxis.add(new Taxi(taxiId, company));
				
				
				
				}
		}
		catch (JsonIOException e1 ) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (JsonSyntaxException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		catch (Exception e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}
			
	}

	@Override
	public LinkedSimpleList<Taxi> getTaxisOfCompany(String company) {
		// TODO Auto-generated method stub
		System.out.println("Inside getTaxisOfCompany with " + company);
		
		LinkedSimpleList<Taxi> rta= new LinkedSimpleList<Taxi>();
		
		System.out.println(taxis.size());
		
		Taxi[] listaElementos= new Taxi[taxis.size()];
		
		this.taxis.listing(listaElementos);
		
		for (Taxi taxi : listaElementos) {
			
				if(taxi!=null&&taxi.getCompany().equals(company)){
					rta.add(taxi);
					
				}
				
			}
		
		return rta;
	}

	@Override
	public LinkedSimpleList<Service> getTaxiServicesToCommunityArea(int communityArea) {
		// TODO Auto-generated method stub
		System.out.println("Inside getTaxiServicesToCommunityArea with " + communityArea);
		
		LinkedSimpleList<Service> rta= new LinkedSimpleList<Service>();
		
		
		Service[] listaElementos= new Service[services.size()];
		
		this.services.listing(listaElementos);
		for (Service service : listaElementos) {
			
				if(service!=null&&service.getArea()==communityArea){
					rta.add(service);
					
				}
			}
		
		return rta;
	}

	
}
