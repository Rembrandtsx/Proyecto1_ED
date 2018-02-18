package view;




import java.util.Scanner;

import controller.Controller;
import model.data_structures.LinkedList;
import model.data_structures.LinkedSimpleList;
import model.vo.Taxi;
import model.vo.Service;

public class TaxiTripsManagerView 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		boolean fin=false;
		while(!fin)
		{
			printMenu();
			
			int option = sc.nextInt();
			
			switch(option)
			{
				case 1:
					System.out.println("Cargar el subconjunto de datos small de servicios:");
					Controller.loadServices( );
					break;
				case 2:
					System.out.println("Ingrese el nombre de la compa�ia:");
					sc.nextLine();
					String companyName = sc.nextLine();
					LinkedList<Taxi> taxiList = Controller.getTaxisOfCompany(companyName);
					
					System.out.println("Se encontraron "+ taxiList.size() + " elementos");
					
					// TODO
					// Show each taxi in the taxiList 
					System.out.println("--------------------------------------------------------------------------------------------");
					System.out.println(companyName);
					System.out.println("--------------------------------------------------------------------------------------------");

					
					
					Taxi[] listaElementos= new Taxi[taxiList.size()];
					
					taxiList.listing(listaElementos);
					
					for (Taxi taxi : listaElementos) {
						
						System.out.println("----------------------------------------------------------------------------------------");
						System.out.println("Id:  "+taxi.getTaxiId());
						System.out.println("Company: "+taxi.getCompany());
							
						
					}
					
					break;
				case 3:
					System.out.println("Ingrese el identificador de la comunidad");
					int companyId = Integer.parseInt(sc.next());
					LinkedSimpleList<Service> taxiServicesList = Controller.getTaxiServicesToCommunityArea(companyId);
					
					System.out.println("Se encontraron " + taxiServicesList.size() + " elementos");

					// TODO
					// Show each service in the taxiServicesList 
					System.out.println("--------------------------------------------------------------------------------------------");
					System.out.println("Area : "+ companyId);
					System.out.println("--------------------------------------------------------------------------------------------");

					
					
					Service[] listaElementos2= new Service[taxiServicesList.size()];
					
					taxiServicesList.listing(listaElementos2);
					
					for (Service service : listaElementos2) {
						
						System.out.println("----------------------------------------------------------------------------------------");
						System.out.println("Trip Id: "+service.getTripId());
						System.out.println("Taxi Id: "+service.getTaxiId());
						System.out.println("Trip Miles: "+service.getTripMiles());
						System.out.println("Trip Seconds: "+service.getTripSeconds());
						System.out.println("Trip Total "+service.getTripTotal());
						System.out.println("Area: "+service.getArea());
						

						}
					
					
					break;
				case 4:	
					fin=true;
					sc.close();
					break;
			}
		}
	}

	private static void printMenu() {
		System.out.println("---------ISIS 1206 - Estructuras de datos----------");
		System.out.println("---------------------Taller 2----------------------");
		System.out.println("1. Cargar un subconjunto de datos de servicios de taxis");
		System.out.println("2. Dar lista de taxis de una compa�ia");
		System.out.println("3. Dar listado de servicios que finalizan en un �rea espec�fica de la ciudad");
		System.out.println("4. Salir");
		System.out.println("Digite el n�mero de opci�n para ejecutar la tarea, luego presione enter: (Ej., 1):");
		
	}
}
