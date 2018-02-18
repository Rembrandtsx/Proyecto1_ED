package model.vo;

/**
 * Representation of a taxi object
 */
public class Taxi implements Comparable<Taxi>{

	
	private String taxi_id;
	
	private String company;
	
	
	public Taxi(String pTaxi_id,String pcompany ) {
		// TODO Auto-generated constructor stub
		taxi_id= pTaxi_id;
		company=pcompany;
	}
	/**
	 * @return id - taxi_id
	 */
	public String getTaxiId() {
		// TODO Auto-generated method stub
		return taxi_id;
	}

	/**
	 * @return company
	 */
	public String getCompany() {
		// TODO Auto-generated method stub
		return company;
	}
	
	@Override
	public int compareTo(Taxi o) {
		// TODO Auto-generated method stub
		if(this.getTaxiId().equals(o.getTaxiId())){
			return 0;
		}
		return 1;
	}	
}
