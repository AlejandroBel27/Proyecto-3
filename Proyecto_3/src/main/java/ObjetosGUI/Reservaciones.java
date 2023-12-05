
package ObjetosGUI;

import java.util.ArrayList;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author Proyecto_3
 */
public class Reservaciones {
    ObjectId _id;
    ArrayList<String> nombreHotel=new ArrayList();
    String fecha_inicio;
    String fecha_fin;
    ArrayList<String>tipoHabitacion = new ArrayList();
    
    public Reservaciones() {
    }

    public Reservaciones(ObjectId _id, String nombreHotel, String fecha_inicio, String fecha_fin,String tipoHabitacion) {
        this._id = _id;
        this.nombreHotel.add(nombreHotel);
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.tipoHabitacion.add(tipoHabitacion);
    }

    

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public ArrayList<String> getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(ArrayList<String> nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    

    public ArrayList<String> getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(ArrayList<String> tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
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
        if (!Objects.equals(this.nombreHotel, other.nombreHotel)) {
            return false;
        }
        if (!Objects.equals(this._id, other._id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reservaciones{" + "_id=" + _id + ", nombreHotel=" + nombreHotel + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", tipoHabitacion=" + tipoHabitacion + '}';
    }

    
    
    
}
