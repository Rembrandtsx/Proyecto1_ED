package model.vo;

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
	
	
	public Service(String pTripId, String pTaxiId, int ptripSeconds, double ptripMiles, double pTripTotal, int pArea) {
		// TODO Auto-generated constructor stub
		tripId=pTripId;
		taxiId=pTaxiId;
		tripSeconds=ptripSeconds;
		tripMiles=ptripMiles;
		tripTotal=pTripTotal;
		area=pArea;
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

	@Override
	public int compareTo(Service o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
