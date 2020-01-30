/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.traveagency;

import FlightOrder.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.ws.WebServiceRef;
import modulewebservices.CurrencyConversionWSService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
 // Simple API for XML only allows you to read from an XML
// file. SAX doesn't require you to read the document into memory
import org.xml.sax.*;

/**
 *
 * @author abadi
 */
@WebService(serviceName = "TravelAgencyWS")
@Stateless()
public class TravelAgencyWS {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_9090/CurrencyConvertor/CurrencyConversionWSService.wsdl")
    private CurrencyConversionWSService service;

    OfferType offer;
    Fare fare;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "TonightFlight")
    public List TodayFlight(@WebParam(name = "origin") String origin, 
            @WebParam(name = "destination") String destination, 
            @WebParam(name = "seats") int seats, 
            @WebParam(name = "connection") int connection) {
       // Create root XML node 'OfferAvailable' and get its main element 'OfferType'
        FlightOrder.TravelAgencyRoot todayFlight = new FlightOrder.TravelAgencyRoot();
        //instance from list
        OfferType NextJourney = new OfferType();
        // display specified offer
        List resultList = new ArrayList();
                 
        String xmlFile="C:\\Users\\abadi\\Desktop\\Cloud\\Travel Agency\\TravelAgencyWebApplication\\Current_flights.xml";
        
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(todayFlight.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            todayFlight = (TravelAgencyRoot) unmarshaller.unmarshal(new java.io.File(xmlFile)); //NOI18N
            
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
    @WebMethod(operationName = "FlightBooking")
    public List FlightBooking(@WebParam(name = "origin") String origin, @WebParam(name = "destination") String destination, @WebParam(name = "airline") String airline, @WebParam(name = "passengers") int passengers, @WebParam(name = "connection") int connection) {
        // Create root XML node 'OfferAvailable' and get its main element 'OfferType'
        FlightOrder.TravelAgencyRoot todayFlight = new FlightOrder.TravelAgencyRoot();
        //instance from list
        OfferType NextJourney = new OfferType();
        // display specified offer
        List resultList = new ArrayList();
                 
        String xmlFile="C:\\Users\\abadi\\Desktop\\Cloud\\Travel Agency\\TravelAgencyWebApplication\\Current_flights.xml";
        
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(todayFlight.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            todayFlight = (TravelAgencyRoot) unmarshaller.unmarshal(new java.io.File(xmlFile)); //NOI18N
            
            List<FlightOrder.OfferType> offer_type = todayFlight.getFlightCollection();
            
            //check all journey  
            Iterator itr = offer_type.iterator();
            
            while(itr.hasNext()){
                NextJourney= (OfferType) itr.next();
                //check only journey equals to origin city, destination city, airline
                if(NextJourney.getCity().equals(origin)&& NextJourney.getDestination().equals(destination) && (NextJourney.getAirline().equals(airline))){
                    NextJourney.setSeats(NextJourney.getSeats()- passengers);// set seets available
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
        
        try {            // update xml file after booking
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(todayFlight.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(todayFlight, new File(xmlFile));
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return resultList;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Driving")
    public String Driving(@WebParam(name = "originAir") String Origin, @WebParam(name = "destinationAir") String Destination) {
        // Create root XML node 'OfferAvailable' and get its main element 'OfferType'
        FlightOrder.TravelAgencyRoot todayFlight = new FlightOrder.TravelAgencyRoot();
        //instance from list
        OfferType NextJourney = new OfferType();
        // display specified offer
        List resultList = new ArrayList();
                 //offer flights xml
        String xmlFile="C:\\Users\\abadi\\Desktop\\Cloud\\Travel Agency\\TravelAgencyWebApplication\\Current_flights.xml";
        String direction; //file direction xml
        // set airport address
        String originAir = null, distenationAir = null;
        try {
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(todayFlight.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
            todayFlight = (TravelAgencyRoot) unmarshaller.unmarshal(new java.io.File(xmlFile)); //NOI18N
            
            List<FlightOrder.OfferType> offer_type = todayFlight.getFlightCollection();
            
            //check all journey  
            Iterator itr = offer_type.iterator();
            
            while(itr.hasNext()){
                NextJourney= (OfferType) itr.next();
                //check only journey equals to origin city, destination city
                if(NextJourney.getCity().equals(Origin)&& NextJourney.getDestination().equals(Destination)){
                    originAir= NextJourney.getOriginAirAddress();
                    distenationAir= NextJourney.getDistinationAirAddress();
                }
            }
            // URL connection to invoke GET Request
        final String urlString= "https://maps.googleapis.com/maps/api/directions/xml?origin="+originAir+"&destination="+distenationAir+"&avoid=toll&key=AIzaSyANldeUNjZZIMj4KRoYoddBqsJ3IGZcHd4";
         //setup URL connection for HTTP GET
            URL url= new URL(urlString);// define url: get String (urlString)
            HttpURLConnection connURL= (HttpURLConnection) url.openConnection();//return class URL
            connURL.setRequestMethod("GET"); //Set the method(get) for the URL request
            connURL.connect();
            //read response directly into a String buffer
            // ins will read from url 
            BufferedReader ins= new BufferedReader(new InputStreamReader(connURL.getInputStream()));
            String inString; //declare inString to set what ins read from url
            StringBuilder sb  = new StringBuilder();// to parse url into String
            while((inString= ins.readLine()) != null) { 
                sb.append(inString); // parse url into String
                //add carriage return for clarity (not required for parsing)
                sb.append("\n");
            }
            
            direction = "C:\\Users\\abadi\\Desktop\\Cloud\\Travel Agency\\V_4\\TravelAgencyWebApplication\\AirAddress.xml";
       
            PrintWriter out = new PrintWriter(direction);// declare new file to writ 
            out.println(sb.toString()); // writ text to file
            out.close();
            //make sure you close the stream and the connection
            ins.close();
            connURL.disconnect();

         //create Document instance then set getDocument method on this instance
            Document docXML = getDocument("C:\\Users\\abadi\\Desktop\\Cloud\\Travel Agency\\V_4\\TravelAgencyWebApplication\\AirAddress.xml");
          
            // The nodelist contains all of the nodes in the xml file
            NodeList nodes = docXML.getElementsByTagName("step");
            NodeList nodesD = docXML.getElementsByTagName("distance");
            
            for (int i = 0; i < nodes.getLength(); i++) {
            
            Node nNode= nodes.item(i);// nodes step
            Node nNodeD= nodesD.item(i);// nodes distane
                 if(nNode.getNodeType() == Node.ELEMENT_NODE){
                     Element eElement = (Element)nNode; // to get the instructions node from (step) nodeList
                     Element eElementD = (Element)nNodeD;
                     String distance = eElementD.getElementsByTagName("text").item(0).getTextContent();
                     String instruction= eElement.getElementsByTagName("html_instructions").item(0).getTextContent();
                     String html_instructions = instruction.replaceAll("\\<.*?>"," ");
                     List list = new ArrayList();
                    list = Arrays.asList(html_instructions,distance);
                     resultList.add(list);
                 }
            }
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        } catch (MalformedURLException ex) {
            Logger.getLogger(TravelAgencyWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TravelAgencyWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultList.toString();
    }
    private static Document getDocument(String docString) {
         //reference: http://www.newthinktank.com/2012/06/java-video-tutorial-44/
         //https://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
        try {
			
            // API used to convert XML into a DOM object tree
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Provides access to the documents data
            DocumentBuilder dBuilder = factory.newDocumentBuilder();

            // Takes the document / parse xml 
            Document doc = dBuilder.parse(new InputSource(docString)); 
           
            return doc;
            }

            catch(Exception ex){

                    System.out.println(ex.getMessage());

            }

            return null;
            
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
