package model.vo;

import java.util.Date;

import model.logic.utils.ComparatorServicio;

import java.util.Calendar;

/**
 * Representation of a Service object
 */
public class Service implements Comparable<Service> {

	
	private String tripId;
	private String taxiId;
	private int tripSeconds;
	private double tripMiles;
	private double tripTotal;
	private int area;
	private Date dateStart;
	private Date dateEnd;
	
	
	public Service(String pTripId, String pTaxiId, int ptripSeconds, double ptripMiles, double pTripTotal, int pArea, Date pStart) {
		// TODO Auto-generated constructor stub
		tripId=pTripId;
		taxiId=pTaxiId;
		tripSeconds=ptripSeconds;
		tripMiles=ptripMiles;
		tripTotal=pTripTotal;
		area=pArea;
		dateStart=pStart;
	}
	/**
	 * @return id - Trip_id
	 */
	public String getTripId() {
		// TODO Auto-generated method stub
		return tripId;
	}	
	
	/**
	 * @return id - Taxi_id
	 */
	public String getTaxiId() {
		// TODO Auto-generated method stub
		return taxiId;
	}	
	
	/**
	 * @return time - Time of the trip in seconds.
	 */
	public int getTripSeconds() {
		// TODO Auto-generated method stub
		return tripSeconds;
	}

	/**
	 * @return miles - Distance of the trip in miles.
	 */
	public double getTripMiles() {
		// TODO Auto-generated method stub
		return tripMiles;
	}
	
	/**
	 * @return total - Total cost of the trip
	 */
	public double getTripTotal() {
		// TODO Auto-generated method stub
		return tripTotal;
	}
	public int getArea() {
		// TODO Auto-generated method stub
		return area;
	}
	public Date getDateStart() {
		// TODO Auto-generated method stub
		return dateStart;
	}
	public Date getDateEnd() {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(this.dateStart); 
		calendar.add(Calendar.SECOND,this.tripSeconds); 
		
		return (Date) calendar.getTime();
	}

	@Override
	public int compareTo(Service o) {
		// TODO Auto-generated method stub
		
		return this.getDateStart().compareTo(o.getDateStart());
	}
}
