/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Directions;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:DirectionsResource
 * [directions]<br>
 * USAGE:
 * <pre>
        instructions client = new instructions();
        Object response = client.XXX(...);
        // do whatever with response
        client.close();
 </pre>
 *
 * @author abadi
 */
public class instructions {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:9090/FlightBookingWS/webresources";

    public instructions() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("directions");
    }

    public String getXml(String Origin, String Destination) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (Origin != null) {
            resource = resource.queryParam("Origin", Origin);
        }
        if (Destination != null) {
            resource = resource.queryParam("Destination", Destination);
        }
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(String.class);
    }

    public void putXml(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void close() {
        client.close();
    }
    
}
