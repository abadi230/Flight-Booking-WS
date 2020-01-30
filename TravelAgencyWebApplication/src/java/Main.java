

import FlightOrder.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abadi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create root XML node 'OfferAvailable' and get its main element 'OfferType'
        FlightOrder.TravelAgencyRoot todayFlight = new FlightOrder.TravelAgencyRoot();
        List<OfferType> ListFlight = todayFlight.getFlightCollection();
        
        String result = null;
        // display specifid offer
        List resultList = new ArrayList();
        
        // Create offer instances and add them to the 'ListFlight' collection
        OfferType offer;
        Fare fare;
        fare = new Fare();
        fare.setCurrency("GBP");
        fare.setValue(700);
        offer = new OfferType();
        offer.setCity("Nottingham");
        offer.setDestination("Jeddah");
        offer.setAirline("Turkish Airlines");
        offer.setSeats(35);
        offer.setConnection(2);
        offer.setFare(fare);
        ListFlight.add(offer);
        
        
        offer = new OfferType();
        fare = new Fare();
        offer.setCity("London");
        offer.setDestination("Madinah");
        offer.setAirline("Saudi Airline");
        offer.setSeats(50);
        offer.setConnection(1);
        fare.setCurrency("GBP");
        fare.setValue(450);
        offer.setFare(fare);
        ListFlight.add(offer);
       
        
        offer = new OfferType();
        fare = new Fare();
        
        offer.setCity("London");
        offer.setDestination("Madinah");
        offer.setAirline("Jurden Airline");
        offer.setSeats(80);
        offer.setConnection(3);
        fare.setCurrency("GBP");
        fare.setValue(250);
        offer.setFare(fare);
        ListFlight.add(offer);
        
        
        offer = new OfferType();
        fare = new Fare();
        offer.setCity("London");
        offer.setDestination("Paris");
        offer.setAirline("British Airways");
        offer.setSeats(10);
        offer.setConnection(0);
        fare.setCurrency("GBP");
        fare.setValue(200);
        offer.setFare(fare);
        ListFlight.add(offer);
        
        offer = new OfferType();
        fare = new Fare();
        offer.setCity("London");
        offer.setDestination("Paris");
        offer.setAirline("France Airline");
        offer.setSeats(80);
        offer.setConnection(1);
        fare.setCurrency("GBP");
        fare.setValue(100);
        offer.setFare(fare);
        ListFlight.add(offer);
        /* Internal flight */
        //United Kingdom
        offer = new OfferType();
        fare = new Fare();
        offer.setCity("London");
        offer.setOriginAirAddress("place_id:ChIJhza7Doio2EcRSxpLpqDodAc");
        offer.setDistinationAirAddress("place_id:ChIJfQHjkw7Fh0gRm9WxkiUKUxk");
        offer.setDestination("Edinburgh");
        offer.setAirline("British Airways");
        offer.setSeats(120);
        offer.setConnection(0);
        fare.setCurrency("GBP");
        fare.setValue(50);
        offer.setFare(fare);
        ListFlight.add(offer);
        //Belgium
        offer = new OfferType();
        fare = new Fare();
        offer.setCity("Brussels");
        offer.setDestination("Antwerp");
        offer.setOriginAirAddress("place_id:ChIJ7XVSxL7dw0cR5CV_Dj5OUSQ");
        offer.setDistinationAirAddress("place_id:ChIJoRVJ_Vf3w0cRmcqeCv33EYQ");
        offer.setAirline("Air Belgium");
        offer.setSeats(80);
        offer.setConnection(0);
        fare.setCurrency("GBP");
        fare.setValue(30);
        offer.setFare(fare);
        ListFlight.add(offer);
        //Bulgaria
        offer = new OfferType();
        fare = new Fare();
        offer.setCity("Sofia");
        offer.setDestination("Plovdiv");
        offer.setOriginAirAddress("place_id:ChIJz0pxkgSGqkARn9XIvv_gq5A");
        offer.setDistinationAirAddress("place_id:ChIJJ8U5uWPXrBQRJhSHFO_lxbA");
        offer.setAirline("Airea Bulgaria");
        offer.setSeats(80);
        offer.setConnection(0);
        fare.setCurrency("GBP");
        fare.setValue(70);
        offer.setFare(fare);
        ListFlight.add(offer);
        //Canada
        offer = new OfferType();
        fare = new Fare();
        offer.setCity("Toronto");
        offer.setDestination("Montreal");
        offer.setOriginAirAddress("place_id:ChIJ2wuDYXQ5K4gR2LEWU8v8ccs");
        offer.setDistinationAirAddress("place_id:ChIJK8nYU3c9yUwRjWcUEHmoMB4");
        offer.setAirline("Air Canada");
        offer.setSeats(150);
        offer.setConnection(0);
        fare.setCurrency("GBP");
        fare.setValue(40);
        offer.setFare(fare);
        ListFlight.add(offer);
        //china
        offer = new OfferType();
        fare = new Fare();
        offer.setCity("Beijing");
        offer.setDestination("Shanghai");
        offer.setOriginAirAddress("place_id:ChIJGyBw9t0F8TURVL4jTjr1fEk");
        offer.setDistinationAirAddress("place_id:ChIJwVCVdt6PrTURXzUsyXET5Mk");
        offer.setAirline("China Airline");
        offer.setSeats(80);
        offer.setConnection(0);
        fare.setCurrency("GBP");
        fare.setValue(100);
        offer.setFare(fare);
        ListFlight.add(offer);
        //Italy
        offer = new OfferType();
        fare = new Fare();
        offer.setCity("Rome");
        offer.setDestination("Milan");
        offer.setOriginAirAddress("place_id:ChIJHxSYOHnwJRMRbzFY47QT5a8");
        offer.setDistinationAirAddress("place_id:ChIJAaVFUqbIhkcRzZD_dtY76BQ");
        offer.setAirline("Air Italy");
        offer.setSeats(80);
        offer.setConnection(0);
        fare.setCurrency("GBP");
        fare.setValue(80);
        offer.setFare(fare);
        ListFlight.add(offer);
        //Spain
        offer = new OfferType();
        fare = new Fare();
        offer.setCity("Madrid");
        offer.setDestination("Barcelona");
        offer.setOriginAirAddress("place_id:ChIJgTwKgJcpQg0RaSKMYcHeNsQ");
        offer.setDistinationAirAddress("place_id:ChIJpY58hGSepBIR15tv-0LpK_M");
        offer.setAirline("Air Europa Express");
        offer.setSeats(80);
        offer.setConnection(0);
        fare.setCurrency("GBP");
        fare.setValue(20);
        offer.setFare(fare);
        ListFlight.add(offer);
        //Turkey
        offer = new OfferType();
        fare = new Fare();
        offer.setCity("Ankara");
        offer.setDestination("Istanbul");
        offer.setOriginAirAddress("place_id:ChIJqYLJ0NoPgkAR1nZct7rSPvE");
        offer.setDistinationAirAddress("place_id:ChIJ862xnWajyhQRlKCPeUGVgVg");
        offer.setAirline("Turkish Airlines");
        offer.setSeats(80);
        offer.setConnection(0);
        fare.setCurrency("GBP");
        fare.setValue(60);
        offer.setFare(fare);
        ListFlight.add(offer);
        
        
        try {            
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(todayFlight.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//            marshaller.marshal(todayFlight, System.out);
            
            //Writing the whole XML document to file
            String xmlFile="C:\\Users\\abadi\\Desktop\\Cloud\\Travel Agency\\TravelAgencyWebApplication\\Current_flights.xml";
            File flightData = new File(xmlFile);
            marshaller.marshal(todayFlight, flightData);
                    
            //print out all journey produced 
            OfferType NextJourney = new OfferType();
            Iterator itr = ListFlight.iterator();
            // print out all offer price
            
            
            while(itr.hasNext()){
                NextJourney= (OfferType) itr.next();
                
//                System.out.println("Airline: " + NextJourney.getAirline() + "\nFrom: " + NextJourney.getCity() +
//                        "\tTo: " + NextJourney.getDestination() + "\nSeats: "+ NextJourney.getSeats() + 
//                        "\nStop: " + NextJourney.getConnection());
//                
                if(NextJourney.getCity().equals("London")&& NextJourney.getDestination().equals("Madinah")){
                    result = "Airline: " + NextJourney.getAirline() + "\nFrom: " + NextJourney.getCity() +
                        "\tTo: " + NextJourney.getDestination() + "\nSeats: "+ NextJourney.getSeats() + 
                        "\nStop: " + NextJourney.getConnection()+ "\nCurrency: "+NextJourney.getFare().getCurrency()+ 
                                "\nPrice: "+NextJourney.getFare().getValue();
                    resultList.add(result);
                    
//                    break;
                            
            }else {
                    result = "Flight not foun!!"; 
                }
              
            }
            
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
          System.out.println("offer is : ");
          // Display each list element in a separate line (console)
          // https://stackoverflow.com/questions/12887857/display-each-list-element-in-a-separate-line-console
          resultList.forEach(System.out::println);
          
    }
    
}
