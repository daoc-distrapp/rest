
package rest;

import javax.ws.rs.*;

@Path("pruebaspost")
public class RecursosPost {

    @POST
    public String post(String par) {
        return String.format("Ejecuta POST: %s", par);
    }    
    
    @POST
    @Consumes("application/x-www-form-urlencoded")// ó MediaType.APPLICATION_FORM_URLENCODED
    public String postForm(@FormParam("x") String x, @FormParam("y") int y) {
        return String.format("Ejecuta POST desde formulario: x = %s; y = %d", x, y);
    } 
    
    @POST
    @Path("json")
    @Consumes("application/json") // ó MediaType.APPLICATION_JSON
    public String postJson(XmlJsonObject obj) {
        return String.format("XmlJsonObject JSON: String: %s; Int: %d; Double: %f", obj.s, obj.i, obj.d);
    }       
    
    @POST
    @Path("xml")
    @Consumes("application/xml") // ó MediaType.APPLICATION_XML
    public String postXml(XmlJsonObject obj) {
        return String.format("XmlJsonObject XML: String: %s; Int: %d; Double: %f", obj.s, obj.i, obj.d);
    }      

}
