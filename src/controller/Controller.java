package controller;

import model.data_structures.LinkedList;
import model.data_structures.LinkedSimpleList;
import model.vo.Taxi;
import model.vo.Service;

public class Controller {

	/**
	 * Reference to the services manager
	 */
	private static ITaxiTripsManager  manager = new TaxiTripsManager();
	
	public static void loadServices( ) {
		// To define the dataset file's name 
		String serviceFile = "./data/taxi-trips-wrvz-psew-subset-small.json";
		
		manager.loadServices( serviceFile );
	}
		
	public static LinkedList<Taxi> getTaxisOfCompany (String company) {
		return manager.getTaxisOfCompany(company);
	}
	
	public static LinkedSimpleList<Service> getTaxiServicesToCommunityArea(int communityArea) {
		return manager.getTaxiServicesToCommunityArea( communityArea );
	}
}
