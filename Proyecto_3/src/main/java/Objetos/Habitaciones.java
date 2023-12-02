package Objetos;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Proyecto_3
 */
public class Habitaciones {
    ObjectId _id;
    int ID_habitacion;
    int numero;
    String tipo;
    int planta;
    int ID_hotel;

    public Habitaciones() {
    }

    public Habitaciones(int ID_habitacion, int numero, String tipo, int planta, int ID_hotel) {
        this.ID_habitacion = ID_habitacion;
        this.numero = numero;
        this.tipo = tipo;
        this.planta = planta;
        this.ID_hotel = ID_hotel;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public int getID_habitacion() {
        return ID_habitacion;
    }

    public void setID_habitacion(int ID_habitacion) {
        this.ID_habitacion = ID_habitacion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPlanta() {
        return planta;
    }

    public void setPlanta(int planta) {
        this.planta = planta;
    }

    public int getID_hotel() {
        return ID_hotel;
    }

    public void setID_hotel(int ID_hotel) {
        this.ID_hotel = ID_hotel;
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
        final Habitaciones other = (Habitaciones) obj;
        if (!Objects.equals(this.ID_habitacion, other.ID_habitacion)) {
            return false;
        }
        if (!Objects.equals(this._id, other._id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Habitaciones{" + "_id=" + _id + ", ID_habitacion=" + ID_habitacion + ", numero=" + numero + ", tipo=" + tipo + ", planta=" + planta + ", ID_hotel=" + ID_hotel + '}';
    }
    
    
    
    
}
