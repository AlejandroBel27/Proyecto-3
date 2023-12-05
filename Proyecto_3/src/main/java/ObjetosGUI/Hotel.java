
package ObjetosGUI;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Proyecto_3
 */
public class Hotel {
    ObjectId _id;
    int ID_hotel;
    String nombre;
    String direccion;
    String telefono;
    int ano_construccion;
    int ID_categoria;

    public Hotel() {
    }

    public Hotel(int ID_hotel, String nombre, String direccion, String telefono, int ano_construccion, int ID_categoria) {
        this.ID_hotel = ID_hotel;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ano_construccion = ano_construccion;
        this.ID_categoria = ID_categoria;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public int getID_hotel() {
        return ID_hotel;
    }

    public void setID_hotel(int ID_hotel) {
        this.ID_hotel = ID_hotel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getAno_construccion() {
        return ano_construccion;
    }

    public void setAno_construccion(int ano_construccion) {
        this.ano_construccion = ano_construccion;
    }

    public int getID_categoria() {
        return ID_categoria;
    }

    public void setID_categoria(int ID_categoria) {
        this.ID_categoria = ID_categoria;
    }
    
    /**
     * Eficiencia para almacenamiento de datos.
     * @return retorna el hash.
     */
    @Override
    public int hashCode() {
    int hash = 3;
        hash = 17 * hash + Objects.hashCode(this._id);
        return hash;
    }
    
    /**
     * Sirve para comprobar que no existan dos registros iguales.
     * @param obj
     * @return Retorna true si ambios atrubutos son iguales de lo contrario retorna false.
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
        final Hotel other = (Hotel) obj;
        if (!Objects.equals(this.ID_hotel, other.ID_hotel)) {
            return false;
        }
        if (!Objects.equals(this._id, other._id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Hotel{" + "_id=" + _id + ", ID_hotel=" + ID_hotel + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", ano_construccion=" + ano_construccion + ", ID_categoria=" + ID_categoria + '}';
    }
    
    
}
