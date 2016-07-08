
package labrestjpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dordonez
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Dato.todos", query = "select d from Dato d" ),
    @NamedQuery(name = "Dato.usuario", query = "select d from Dato d where d.usuario = :par1" )
})
@XmlRootElement
public class Dato {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String usuario;
    private String tipo;
    private String dato;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }
    
}
