/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import FlightOrder.*;
import java.io.File;
import java.util.*;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;
import modulewebservices.CurrencyConversionWSService;

/**
 *
 * @author abadi
 */
@WebService(serviceName = "TravelAgencyWS")
@Stateless()
public class TravelAgencyWS {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_9090/CurrencyConvertor/CurrencyConversionWSService.wsdl")
    private CurrencyConversionWSService service;


    /**
     * Web service operation
     */
    @WebMethod(operationName = "SearchFlight")
    public List SearchFlight(@WebParam(name = "origin") String origin, @WebParam(name = "destination") String destination,@WebParam(name = "currency") String currency) {
        // Create root XML node 'OfferAvailable' and get its main element 'OfferType'
        FlightOrder.TravelAgencyRoot todayFlight = new FlightOrder.TravelAgencyRoot();
        //instance from list
        OfferType NextJourney = new OfferType();
        // display specified offer
        List resultList = new ArrayList();
        
        String flightsXml="C:\\Users\\abadi\\Desktop\\Cloud\\Travel Agency\\Flight Booking WS\\FlightBookingWS\\current_flight.xml";
        
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(todayFlight.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            todayFlight = (TravelAgencyRoot) unmarshaller.unmarshal(new java.io.File(flightsXml)); //NOI18N
            
            List<FlightOrder.OfferType> offer_type = todayFlight.getFlightCollection();
            
            //check all journey  
            Iterator itr = offer_type.iterator();
            while(itr.hasNext()){
                NextJourney= (OfferType) itr.next();
                //print out only journey equals to city
                if(NextJourney.getCity().equals(origin)&& NextJourney.getDestination().equals(destination)){
                    List oneFlight = new ArrayList();
                    oneFlight = Arrays.asList(NextJourney.getAirline(), NextJourney.getCity(),
                            NextJourney.getDestination(),NextJourney.getConnection(),
                            NextJourney.getSeats(),NextJourney.getFare().getCurrency(),
                            NextJourney.getFare().getValue());
                    resultList.addAll(oneFlight);
                }
            }
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        
        return resultList;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "originAirport")
    public String originAirport(@WebParam(name = "origin") String origin) {
         // Create root XML node 'OfferAvailable' and get its main element 'OfferType'
        FlightOrder.TravelAgencyRoot todayFlight = new FlightOrder.TravelAgencyRoot();
        //instance from list
        OfferType NextJourney = new OfferType();
        // display specified offer
        String result = null;
        
        String flightsXml="C:\\Users\\abadi\\Desktop\\Cloud\\Travel Agency\\Flight Booking WS\\FlightBookingWS\\current_flight.xml";
        
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(todayFlight.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            todayFlight = (TravelAgencyRoot) unmarshaller.unmarshal(new java.io.File(flightsXml)); //NOI18N
            
            List<FlightOrder.OfferType> offer_type = todayFlight.getFlightCollection();
            
            //check all journey  
            Iterator itr = offer_type.iterator();
            while(itr.hasNext()){
                NextJourney= (OfferType) itr.next();
                //print out only journey equals to city
                if(NextJourney.getCity().equals(origin)){
                    result=NextJourney.getOriginAirAddress();
                }
            }
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "destinationAirport")
    public String destinationAirport(@WebParam(name = "destination") String destination) {
         // Create root XML node 'OfferAvailable' and get its main element 'OfferType'
        FlightOrder.TravelAgencyRoot todayFlight = new FlightOrder.TravelAgencyRoot();
        //instance from list
        OfferType NextJourney = new OfferType();
        // display specified offer
        String result = null;
        
        String flightsXml="C:\\Users\\abadi\\Desktop\\Cloud\\Travel Agency\\Flight Booking WS\\FlightBookingWS\\current_flight.xml";
        
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(todayFlight.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            todayFlight = (TravelAgencyRoot) unmarshaller.unmarshal(new java.io.File(flightsXml)); //NOI18N
            
            List<FlightOrder.OfferType> offer_type = todayFlight.getFlightCollection();
            
            //check all journey  
            Iterator itr = offer_type.iterator();
            while(itr.hasNext()){
                NextJourney= (OfferType) itr.next();
                //print out only journey equals to city
                if( NextJourney.getDestination().equals(destination)){
                    
                    result= NextJourney.getDistinationAirAddress();
                }
            }
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Book")
    public List Book(@WebParam(name = "origin") String origin, @WebParam(name = "destination") String destination, @WebParam(name = "airline") String airline, @WebParam(name = "passengers") int passengers) {
         // Create root XML node 'OfferAvailable' and get its main element 'OfferType'
        FlightOrder.TravelAgencyRoot todayFlight = new FlightOrder.TravelAgencyRoot();
        //instance from list
        OfferType NextJourney = new OfferType();
        
        String flightsXml="C:\\Users\\abadi\\Desktop\\Cloud\\Travel Agency\\Flight Booking WS\\FlightBookingWS\\current_flight.xml";
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(todayFlight.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            todayFlight = (TravelAgencyRoot) unmarshaller.unmarshal(new java.io.File(flightsXml)); //NOI18N
            List<FlightOrder.OfferType> offer_type = todayFlight.getFlightCollection();
            
            //check all journey  
            Iterator itr = offer_type.iterator();
            
            while(itr.hasNext()){
                NextJourney= (OfferType) itr.next();
                //check only journey equals to origin city, destination city, airline
                // then update seats abailable
                if(NextJourney.getCity().equals(origin)&& NextJourney.getDestination().equals(destination) && (NextJourney.getAirline().equals(airline))){
                    NextJourney.setSeats(NextJourney.getSeats()- passengers);// set seets available
                                     
                }
            }
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        try {            // update flightsXml
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(todayFlight.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(todayFlight, new File(flightsXml));
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return null;
    }
     /**
     * Web service operation
     */
    @WebMethod(operationName = "originCities")
    public List originCities() {
         // Create root XML node 'OfferAvailable' and get its main element 'OfferType'
        FlightOrder.TravelAgencyRoot todayFlight = new FlightOrder.TravelAgencyRoot();
        //instance from list
        OfferType NextJourney = new OfferType();
        // display specified offer
        List resultList = new ArrayList();
        
        String flightsXml="C:\\Users\\abadi\\Desktop\\Cloud\\Travel Agency\\Flight Booking WS\\FlightBookingWS\\current_flight.xml";
        
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(todayFlight.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            todayFlight = (TravelAgencyRoot) unmarshaller.unmarshal(new java.io.File(flightsXml)); //NOI18N
            
            List<FlightOrder.OfferType> offer_type = todayFlight.getFlightCollection();
            
            //check all journey  
            Iterator itr = offer_type.iterator();
            
            while(itr.hasNext()){
                NextJourney= (OfferType) itr.next();
                resultList.add(NextJourney.getCity());
            }
            //deleate the duplicate elements. https://www.w3resource.com/java-tutorial/java-hashset.php
            Set<String> destinationC = new HashSet<>();
            destinationC.addAll(resultList);
            resultList.clear();
            resultList.addAll(destinationC);
            
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        
        return resultList;
    }
    /**
     * Web service operation
     */
    @WebMethod(operationName = "destinationCities")
    public List destinationCities() {
        // Create root XML node 'OfferAvailable' and get its main element 'OfferType'
        FlightOrder.TravelAgencyRoot todayFlight = new FlightOrder.TravelAgencyRoot();
        //instance from list
        OfferType NextJourney = new OfferType();
        // display specified offer
        List resultList = new ArrayList();
        
        String flightsXml="C:\\Users\\abadi\\Desktop\\Cloud\\Travel Agency\\Flight Booking WS\\FlightBookingWS\\current_flight.xml";
        
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(todayFlight.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            todayFlight = (TravelAgencyRoot) unmarshaller.unmarshal(new java.io.File(flightsXml)); //NOI18N
            
            List<FlightOrder.OfferType> offer_type = todayFlight.getFlightCollection();
            
            //check all journey  
            Iterator itr = offer_type.iterator();
            
            while(itr.hasNext()){
                NextJourney= (OfferType) itr.next();
                resultList.add(NextJourney.getDestination());
            }
            //deleate the duplicate elements. https://www.w3resource.com/java-tutorial/java-hashset.php
            Set<String> destinationC = new HashSet<>();
            destinationC.addAll(resultList);
            resultList.clear();
            resultList.addAll(destinationC);
            
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        
        return resultList;
    }
     /**
     * Web service operation
     */
    @WebMethod(operationName = "GetCurrencyCodes")
    public List GetCurrencyCodes() {
        List<String>Currency = getCurrencyCodes();        
        
        return Currency;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "GetConversionRate")
    public Double GetConversionRate(@WebParam(name = "fromCurr") String fromCurr, @WebParam(name = "toCurr") String toCurr) {
        double value= getConversionRate(fromCurr, toCurr);
        
        return value;
    }

    private double getConversionRate(java.lang.String arg0, java.lang.String arg1) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        modulewebservices.CurrencyConversionWS port = service.getCurrencyConversionWSPort();
        return port.getConversionRate(arg0, arg1);
    }

    private java.util.List<java.lang.String> getCurrencyCodes() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        modulewebservices.CurrencyConversionWS port = service.getCurrencyConversionWSPort();
        return port.getCurrencyCodes();
    }

    

    
}
