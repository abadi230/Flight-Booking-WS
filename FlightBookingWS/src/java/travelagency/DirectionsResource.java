/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelagency;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.jms.Destination;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author abadi
 */
@Path("directions")
public class DirectionsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DirectionsResource
     */
    public DirectionsResource() {
    }

    /**
     * Retrieves representation of an instance of org.me.travelagency.DirectionsResource
     * @param Origin
     * @param Destination
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml(@QueryParam("Origin")String Origin,@QueryParam("Destination")String Destination) throws FileNotFoundException {
        String oC= Origin.replaceAll(" ", "+"); String dC= Destination.replaceAll(" ","+");
        // URL connection to invoke GET Request
        final String urlString= "https://maps.googleapis.com/maps/api/directions/xml?origin="+oC+"&destination="+dC+"&avoid=toll&key=AIzaSyANldeUNjZZIMj4KRoYoddBqsJ3IGZcHd4";
        String direction = "C:\\Users\\abadi\\Desktop\\Cloud\\Travel Agency\\Flight Booking WS\\AirAddress.xml";
        
        
         try{
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
            PrintWriter out = new PrintWriter(direction);// declare new file to write 
            out.println(sb.toString()); // write text to file
            out.close();
            //make sure you close the stream and the connection
            ins.close();
            connURL.disconnect();
         }catch (MalformedURLException me) {
                System.out.println("MalformedURLException: " + me);
                }
          catch (IOException ioe) {
                System.out.println("IOException: " + ioe);
                }
         // read file by line. \\Z mean read the hole web page as String
         //http://natch3z.blogspot.co.uk/2008/11/read-text-file-using-javautilscanner.html
//         direction= new Scanner(new File(direction)).useDelimiter("\\Z").next();
         
        return direction;
    }

    /**
     * PUT method for updating or creating an instance of DirectionsResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
