package controller;

import model.data_structures.LinkedSimpleList;
import model.vo.Taxi;
import model.vo.Service;

/**
 * Basic API for testing the functionality of the TaxiTrip manager
 */
public interface ITaxiTripsManager {

	/**
	 * Method to load taxi services
	 * @param servicesFile - path to the file 
	 */
	void loadServices(String serviceFile);
	

    /**
	 * Method to return all the taxis for a given comapany
	 * @param company - Taxi company
	 * @return List of taxis
	 */
	public LinkedSimpleList<Taxi> getTaxisOfCompany(String company);
	
	/**
	 * Method to return all the services finished in a communityArea
	 * @param communityArea 
	 * @return List of services
	 */
	public LinkedSimpleList<Service> getTaxiServicesToCommunityArea(int communityArea);
	
	


	
}
