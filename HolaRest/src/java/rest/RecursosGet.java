
package rest;

import javax.ws.rs.*;

@Path("pruebasget")
public class RecursosGet {

    @GET
    public String get() {
        return "Ejecuta solamente GET";
    }     

    @GET
    @Path("interno")
    public String getInterno() {
        return "Ejecuta GET desde path interno";
    }       
    
    @GET
    @Path("otro")
    @Produces("text/plain")
    public String getTextPlain() {
        return "Ejecuta GET y pide text/plain";
    }       
    
    @GET
    @Path("otro")    
    @Produces("minumero/real")//este tipo es inventado: el método debe devolver String o falla el conversor
    public String getStringNumberDouble() {
        return Double.toString(Math.random());
    }    
    
    @GET
    @Path("numbers/int")
    public int getInt() {
        return 20;
    }
    
    @GET
    @Path("numbers/double")
    public double getDouble() {
        return 432.898977989;
    }     
    
    @GET
    @Path("{par1}/{par2}")
    public String getPathStrInt(@PathParam("par1") String s, @PathParam("par2") int i) {
        return String.format("Texto: %s; Int: %d", s, i);
    }     
    
    @GET
    @Path("query")
    public String getQueryStrInt(@QueryParam("x") String s, @QueryParam("y") int i) {
        return String.format("Texto: %s; Int: %d", s, i);
    }
    
    @GET
    @Path("json")
    @Produces("application/json") // ó MediaType.APPLICATION_JSON
    public XmlJsonObject getJson() {
        XmlJsonObject obj = new XmlJsonObject();
        obj.s = "hola";
        obj.i = 10;
        obj.d = 9.76;
        return obj;
    }
    
    @GET
    @Path("xml")
    @Produces("application/xml") // ó MediaType.APPLICATION_XML
    public XmlJsonObject getXml() {
        XmlJsonObject obj = new XmlJsonObject();
        obj.s = "hola";
        obj.i = 10;
        obj.d = 9.76;
        return obj;
    }     
}
