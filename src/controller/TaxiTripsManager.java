package controller;

import model.vo.Taxi;
import model.vo.Service;
import model.data_structures.LinkedList;
import model.data_structures.LinkedSimpleList;
import model.logic.utils.ComparatorServicio;
import model.logic.utils.Ordenamiento;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Queue;
import java.util.Stack;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class TaxiTripsManager implements ITaxiTripsManager {

	// TODO
	// Definition of data model 
	
	private LinkedSimpleList<Service> services;
	private LinkedSimpleList<Taxi> taxis;
	private Ordenamiento<Service> hola = new Ordenamiento<Service>();
	
	
	
	
	public void loadServices (String serviceFile) {
		// TODO Auto-generated method stub
		services= new LinkedSimpleList<Service>();
		taxis= new LinkedSimpleList<Taxi>();
		
		
		JsonParser parser = new JsonParser();
		int suma = 0;
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
				
				
				int area = 0;
				if ( obj.get("pickup_community_area") != null )
				{ area = obj.get("pickup_community_area").getAsInt(); }
				
				
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
				
				String pDateStart= "1970-01-01T00:00:00.000+0000";
				Date pDateStart2= new Date(0);
				if ( obj.get("trip_start_timestamp") != null )
				{ 
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
					pDateStart = obj.get("trip_start_timestamp").getAsString(); 
					pDateStart2=  df.parse(pDateStart);
				
				}
				
				
				services.add(new Service(tripId, taxiId, tripSeconds, tripMiles, tripTotal, area, pDateStart2));
				
				taxis.add(new Taxi(taxiId, company));
				
				suma ++;
				
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
		System.out.println("Se Cargaron :"+services.size());
		for(int i = 0; i < services.size(); i+=100) {
			
			
			System.out.println("SERVICIO " +i  +"   "+ services.get(i).getDateStart().toString());
		}
			System.out.println("Hola ::"+ suma );
			
			services.mergesort(services.getFirst());
			for(int i = 0; i < services.size(); i+=100) {
				
				
				System.out.println("SERVICIO " +i  +"   "+ services.get(i).getDateStart().toString());
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
	
	public Queue<Service> getListWithStartAndEndDate(Date pInicio, Date pfinal){
		// Implementacion.
		Queue<Service> rta= null;
		
		 return rta;
	}
	
	public Taxi getInfoTaxi(String pIdentificador, Date pInicio, Date pfinal){
		// Implementacion.
		Taxi rta= null;
		
		 return rta;
	}
	
	public LinkedSimpleList<Service> getListRangoDistance(Date pInicio, Date pfinal){
		// Implementacion.
		LinkedSimpleList<Service> rta= null;
		
		 return rta;
	}
	
	public LinkedSimpleList<String> getCompanhiaTaxiInscrito(){
		
		LinkedSimpleList<String> rta= null;
		
		 return rta;
	}
	
	public int getTaxiQuePrestanServicioACompanhia(){
		
		int rta= 0;
		
		 return rta;
	}
	
	public LinkedSimpleList<String> getListaAlfabetica(LinkedSimpleList<String> pCompanhiaTaxiinscrito){
		
		LinkedSimpleList<String> rta= null;
		
		 return rta;
	}
	
	public Taxi getTaxiMayorGanacia(String pCompanhia, Date pInicio, Date pfinal){
		
		Taxi rta= null;
		
		 return rta;
	}
	
	public String getInfoZonaCiudad(int pZona, Date pInicio, Date pfinal){
		
		String rta= "";
		
		 return rta;
	}
	
	public LinkedSimpleList<Integer> getInfoZonasCiudad( ){
		
		LinkedSimpleList<Integer> rta= null;
		
		 return rta;
	}
	
	public LinkedSimpleList<String> getTopX( int pNumero,Date pInicio, Date pfinal){
		
		LinkedSimpleList<String> rta= null;
		
		 return rta;
	}
	
	public Stack<Service> getTop( Date pInicio, Date pfinal){
		
		Stack<Service> rta= null;
		
		 return rta;
	}

	
}
