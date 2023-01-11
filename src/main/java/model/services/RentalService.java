package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	
    private Double pricePerHour;
    private Double pricePerDay;
    
    private BrazilTaxServices taxService;

	public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxServices taxService) {
	//Nao coloca o construtor vazio pois estou obrigando a ter um BrazilTaxServices	
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}
    
   public void processInvoice (CarRental carRental) {	   
	   	   
	    double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();		
		double hours = minutes / 60.0;
		
		//System.out.println("minutes: " + String.format("%.2f", minutes));
		//System.out.println("hours: " + String.format("%.2f", hours));
		//System.out.println("pricePerHour: " + String.format("%.2f", pricePerHour));
		//System.out.println("pricePerDay: " + String.format("%.2f", pricePerDay));
		
		double basicPayment;
		if (hours <= 12.0) {
			basicPayment = pricePerHour * Math.ceil(hours);
			//ceil - API que arredonda as frações de hora para cima
		}
		else {
			basicPayment = pricePerDay * Math.ceil(hours / 24);
		}
        
		//System.out.println("basicPayment: " + String.format("%.2f", basicPayment));
		double tax = taxService.tax(basicPayment);
		

		carRental.setInvoice(new Invoice(basicPayment, tax));
	   
   }
}
