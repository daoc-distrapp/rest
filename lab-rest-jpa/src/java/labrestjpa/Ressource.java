
package labrestjpa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author dordonez@ute.edu.ec
 */
@Stateless
@Path("datos")
public class Ressource {
    @PersistenceContext(unitName = "lab-rest-jpaPU")
    EntityManager em;
    
    @GET
    public List<Dato> getDatos() {
        return em.createNamedQuery("Dato.todos").getResultList();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getDatoIdTxt(@PathParam("id") int id) {
        return em.find(Dato.class, id).getDato();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Dato getDatoIdXml(@PathParam("id") int id) {
        return em.find(Dato.class, id);
    }    
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Dato getDatoIdJson(@PathParam("id") int id) {
        return em.find(Dato.class, id);
    }    
    
    @GET
    @Path("usr/{usr}")
    public List<Dato> getDatosUsuario(@PathParam("usr") String usr) {
        return em.createNamedQuery("Dato.usuario").setParameter("par1", usr).getResultList();
    }
    
    @POST
    @Path("{usr}/{tipo}/{dato}")
    public Dato newDato(@PathParam("usr") String usr, @PathParam("tipo") String tipo, @PathParam("dato") String dato) {
        Dato d = new Dato();
        d.setUsuario(usr);
        d.setTipo(tipo);
        d.setDato(dato);
        em.persist(d);
        return d;
    }    

    @PUT
    @Path("{id}/{usr}/{tipo}/{dato}")
    public Dato newDato(@PathParam("id") int id, @PathParam("usr") String usr, @PathParam("tipo") String tipo, @PathParam("dato") String dato) {
        Dato d = em.find(Dato.class, id);
        if(d != null) {
            d.setUsuario(usr);
            d.setTipo(tipo);
            d.setDato(dato);
            em.merge(d);
        } else {
            d = new Dato();
            d.setId(id);
            d.setUsuario(usr);
            d.setTipo(tipo);
            d.setDato(dato);
            em.persist(d);
        }
        return d;
    }    
    
    @DELETE
    @Path("{id}")
    public Dato borraDatoId(@PathParam("id") int id) {
        Dato d = em.find(Dato.class, id);
        if(d != null) {
            em.remove(d);
        }
        return d;
    }    
}
