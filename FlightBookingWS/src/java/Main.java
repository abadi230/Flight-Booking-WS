
import FlightOrder.*;
import java.io.File;
import java.util.*;


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
        
        
        offer = new OfferType();
        fare = new Fare();
        fare.setCurrency("GBP");
        fare.setValue(700);
        offer.setCity("Nottingham");
        offer.setOriginAirAddress("place_id:ChIJ55zFpnzEeUgRsrQcL1Zx0SQ");
        offer.setDestination("Milan");
        offer.setDistinationAirAddress("place_id:ChIJAaVFUqbIhkcRzZD_dtY76BQ");
        offer.setAirline("Air Italy");
        offer.setSeats(200);
        offer.setConnection(2);
        offer.setFare(fare);
        ListFlight.add(offer);
        
        
        offer = new OfferType();
        fare = new Fare();
        offer.setCity("London");
        offer.setDestination("Paris");
        offer.setOriginAirAddress("place_id:ChIJhza7Doio2EcRSxpLpqDodAc");
        offer.setDistinationAirAddress("place_id:ChIJW89MjgM-5kcRLKZbL5jgKwQ");
        offer.setAirline("British Airways");
        offer.setSeats(70);
        offer.setConnection(0);
        fare.setCurrency("GBP");
        fare.setValue(200);
        offer.setFare(fare);
        ListFlight.add(offer);
        
        offer = new OfferType();
        fare = new Fare();
        offer.setCity("London");
        offer.setDestination("Paris");
        offer.setOriginAirAddress("place_id:ChIJhza7Doio2EcRSxpLpqDodAc");
        offer.setDistinationAirAddress("place_id:ChIJW89MjgM-5kcRLKZbL5jgKwQ");
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
        
        
        try {            
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(todayFlight.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(todayFlight, new File("C:\\Users\\abadi\\Desktop\\Cloud\\Travel Agency\\Flight Booking WS\\FlightBookingWS\\current_flight.xml"));
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
    }
    
}
