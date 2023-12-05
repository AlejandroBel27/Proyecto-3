package ObjetosGUI;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase que representa la entidad AgenciaDeViajes en el sistema. Contiene
 * atributos que describen una agencia de viajes y métodos para acceder y
 * modificar estos atributos. Además, implementa hashCode, equals y toString
 * para proporcionar funcionalidad adicional.
 *
 * @author Proyecto_3
 */
public class AgenciaDeViajes {
    // Identificador único de la agencia de viajes en la base de datos MongoDB

    ObjectId _id;
    // Atributos que describen una agencia de viajes

    int ID_agencia;
    String usuario;
    String direccion;
    String telefono;
    String contraseña;
    // Constructores

    public AgenciaDeViajes() {
    }

    public AgenciaDeViajes(int ID_agencia, String usuario, String direccion, String telefono, String contraseña) {
        this.ID_agencia = ID_agencia;
        this.usuario = usuario;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contraseña = contraseña;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public int getID_agencia() {
        return ID_agencia;
    }

    public void setID_agencia(int ID_agencia) {
        this.ID_agencia = ID_agencia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Genera un código hash único basado en el identificador de la agencia de
     * viajes.
     *
     * @return Código hash de la instancia.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this._id);
        return hash;
    }

    /**
     * Compara dos instancias de AgenciaDeViajes para verificar su igualdad. Dos
     * instancias son iguales si tienen el mismo identificador (_id) o el mismo
     * usuario.
     *
     * @param obj Objeto a comparar con la instancia actual.
     * @return true si las instancias son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AgenciaDeViajes other = (AgenciaDeViajes) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        if (!Objects.equals(this._id, other._id)) {
            return false;
        }
        return true;
    }

    /**
     * Genera una representación en cadena de la instancia AgenciaDeViajes.
     *
     * @return Cadena que representa la instancia.
     */
    @Override
    public String toString() {
        return "AgenciaDeViajes{" + "_id=" + _id + ", ID_agencia=" + ID_agencia + ", usuario=" + usuario + ", direccion=" + direccion + ", telefono=" + telefono + ", contrase\u00f1a=" + contraseña + '}';
    }

}
