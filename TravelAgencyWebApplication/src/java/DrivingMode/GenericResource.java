/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DrivingMode;

import FlightOrder.OfferType;
import FlightOrder.TravelAgencyRoot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import org.me.traveagency.TravelAgencyWS;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * REST Web Service
 *
 * @author abadi
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of DrivingMode.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/query/")
    @Produces(MediaType.APPLICATION_XML)
    public String getXml(@QueryParam("Origin")String Origin,@QueryParam("Destination")String Destination) throws MalformedURLException, IOException {
//        // Create root XML node 'OfferAvailable' and get its main element 'OfferType'
//        FlightOrder.TravelAgencyRoot todayFlight = new FlightOrder.TravelAgencyRoot();
//        //instance from list
//        OfferType NextJourney = new OfferType();
//        // display specified offer
//        List resultList = new ArrayList();
//                 //offer flights xml
//        String xmlFile="C:\\Users\\abadi\\Desktop\\Cloud\\Travel Agency\\TravelAgencyWebApplication\\Current_flights.xml";
//        // set airport address
//        String originAir = null, distenationAir = null;
        String direction = null;
        try {
//            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(todayFlight.getClass().getPackage().getName());
//            javax.xml.bind.Unmarshaller unmarshaller = jaxbCtx.createUnmarshaller();
//            todayFlight = (TravelAgencyRoot) unmarshaller.unmarshal(new java.io.File(xmlFile)); //NOI18N
//            
//            List<FlightOrder.OfferType> offer_type = todayFlight.getFlightCollection();
//            
//            //check all journey  
//            Iterator itr = offer_type.iterator();
//            
//            while(itr.hasNext()){
//                NextJourney= (OfferType) itr.next();
//                //check only journey equals to origin city, destination city
//                if(NextJourney.getCity().equals(Origin)&& NextJourney.getDestination().equals(Destination)){
//                    originAir= NextJourney.getOriginAirAddress();
//                    distenationAir= NextJourney.getDistinationAirAddress();
//                }
//            }
        
            // URL connection to invoke GET Request
        final String urlString= "https://maps.googleapis.com/maps/api/directions/xml?origin="+Origin+"&destination="+Destination+"&avoid=toll&key=AIzaSyANldeUNjZZIMj4KRoYoddBqsJ3IGZcHd4";
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
       
//            System.out.println(sb.toString());// print the xml file
            PrintWriter out = new PrintWriter(direction);// declare new file to write 
            out.println(sb.toString()); // write text to file
            out.close();
            //make sure you close the stream and the connection
            ins.close();
            connURL.disconnect();
//            String dirXml;
//            dirXml = passString(sb);
            
         
//        } catch (javax.xml.bind.JAXBException ex) {
//            // XXXTODO Handle exception
//            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        } catch (MalformedURLException ex) {
            Logger.getLogger(TravelAgencyWS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TravelAgencyWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        // 
        direction= new Scanner(new File(direction)).useDelimiter("\\Z").next();
        return direction;
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
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
            Document doc = dBuilder.parse(new org.xml.sax.InputSource(docString)); 
           
            return doc;
            }

            catch(Exception ex){

                    System.out.println(ex.getMessage());

            }

            return null;
            
    }
        private static void passString(StringBuilder returnValue){
        //reference: https://stackoverflow.com/questions/34166732/passing-a-stringbuilder-to-a-doc
        Document doc;
        // pull in the XML data into a new doc
        try {
            doc = loadXMLFromString(returnValue.toString());
            
            System.out.println(doc);
        } catch (Exception e) {
//            Logger.getLogger(BrowseHTTP.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
     private static Document loadXMLFromString(String xml) throws Exception{
         // API used to convert XML into a DOM object tree
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         
         // Provides access to the documents data

         DocumentBuilder dBuilder = factory.newDocumentBuilder();
          //for parse StringBulder
            InputSource inputSource= new InputSource(new StringReader(xml));
            
            return dBuilder.parse(inputSource);
     }
    
}
