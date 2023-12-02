package Objetos;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Proyecto_3
 */
public class AgenciaDeViajes {
    ObjectId _id;
    int ID_agencia;
    String nombre;
    String direccion;
    String telefono;
    public AgenciaDeViajes() {
    }

    public AgenciaDeViajes(int ID_agencia, String nombre, String direccion, String telefono) {
        this.ID_agencia = ID_agencia;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
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
        final AgenciaDeViajes other = (AgenciaDeViajes) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this._id, other._id)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String toString() {
        return "AgenciaDeViajes{" + "id=" + _id + ", ID_agencia=" + ID_agencia + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
    

}
