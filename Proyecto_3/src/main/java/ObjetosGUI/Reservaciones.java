
package ObjetosGUI;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Proyecto_3
 */
public class Reservaciones {
    ObjectId _id;
    int ID_reserva;
    String fecha_inicio;
    String fecha_fin;
    int ID_cliente;
    int ID_agencia;
    int ID_hotel;
    int ID_categoria;
    int ID_habitacion;

    public Reservaciones() {
    }

    public Reservaciones(int ID_reserva, String fecha_inicio, String fecha_fin, int ID_cliente, int ID_agencia, int ID_hotel, int ID_categoria, int ID_habitacion) {
        this.ID_reserva = ID_reserva;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.ID_cliente = ID_cliente;
        this.ID_agencia = ID_agencia;
        this.ID_hotel = ID_hotel;
        this.ID_categoria = ID_categoria;
        this.ID_habitacion = ID_habitacion;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public int getID_reserva() {
        return ID_reserva;
    }

    public void setID_reserva(int ID_reserva) {
        this.ID_reserva = ID_reserva;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
    }

    public int getID_agencia() {
        return ID_agencia;
    }

    public void setID_agencia(int ID_agencia) {
        this.ID_agencia = ID_agencia;
    }

    public int getID_hotel() {
        return ID_hotel;
    }

    public void setID_hotel(int ID_hotel) {
        this.ID_hotel = ID_hotel;
    }

    public int getID_categoria() {
        return ID_categoria;
    }

    public void setID_categoria(int ID_categoria) {
        this.ID_categoria = ID_categoria;
    }

    public int getID_habitacion() {
        return ID_habitacion;
    }

    public void setID_habitacion(int ID_habitacion) {
        this.ID_habitacion = ID_habitacion;
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
        final Reservaciones other = (Reservaciones) obj;
        if (!Objects.equals(this.ID_reserva, other.ID_reserva)) {
            return false;
        }
        if (!Objects.equals(this._id, other._id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reservaciones{" + "_id=" + _id + ", ID_reserva=" + ID_reserva + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", ID_cliente=" + ID_cliente + ", ID_agencia=" + ID_agencia + ", ID_hotel=" + ID_hotel + ", ID_categoria=" + ID_categoria + ", ID_habitacion=" + ID_habitacion + '}';
    }
    
    
}
