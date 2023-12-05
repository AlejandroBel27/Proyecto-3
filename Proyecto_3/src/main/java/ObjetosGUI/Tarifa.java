package ObjetosGUI;

import java.util.ArrayList;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Clase que representa la entidad Tarifa en el sistema. Contiene atributos que
 * describen una tarifa y métodos para acceder y modificar estos atributos.
 * Además, implementa hashCode, equals y toString para proporcionar
 * funcionalidad adicional.
 *
 * @author Proyecto_3
 */
public class Tarifa {

    ObjectId _id;
    int ID_habitacion;
    int ID_hotel;
    String tipo;
    ArrayList<String> temporada = new ArrayList();

    public Tarifa() {
    }

    public Tarifa(int ID_habitacion, int ID_hotel, String tipo, String temporada) {
        this.ID_habitacion = ID_habitacion;
        this.ID_hotel = ID_hotel;
        this.tipo = tipo;
        this.temporada.add(temporada);
        _id = new ObjectId();
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

    public int getID_hotel() {
        return ID_hotel;
    }

    public void setID_hotel(int ID_hotel) {
        this.ID_hotel = ID_hotel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<String> getTemporada() {
        return temporada;
    }

    public void setTemporada(ArrayList<String> temporada) {
        this.temporada = temporada;
    }

    /**
     * Eficiencia para almacenamiento de datos.
     *
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
     *
     * @param obj
     * @return Retorna true si ambios atrubutos son iguales de lo contrario
     * retorna false.
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
        final Tarifa other = (Tarifa) obj;
        if (!Objects.equals(this.ID_habitacion, other.ID_habitacion)) {
            return false;
        }
        if (!Objects.equals(this._id, other._id)) {
            return false;
        }
        return true;
    }

    /**
     * Genera una representación en cadena de la instancia Tarifa.
     *
     * @return Cadena que representa la instancia.
     */
    @Override
    public String toString() {
        return "Tarifa{" + "_id=" + _id + ", ID_habitacion=" + ID_habitacion + ", ID_hotel=" + ID_hotel + ", tipo=" + tipo + ", temporada=" + temporada + '}';
    }

}
