package ObjetosGUI;

import java.util.ArrayList;
import java.util.Objects;
import org.bson.types.ObjectId;
import java.util.List;

/**
 * Clase que representa la entidad Categoria en el sistema. Contiene atributos
 * que describen una categoría y métodos para acceder y modificar estos
 * atributos. Además, implementa hashCode, equals y toString para proporcionar
 * funcionalidad adicional.
 *
 * @author Proyecto_3
 */
public class Categoria {

    ObjectId _id;
    int ID_categoria;
    String nombre;
    String tipo_IVA;
    ArrayList<String> estrellas = new ArrayList();

    public Categoria() {
    }

    public Categoria(int ID_categoria, String nombre, String tipo_IVA, String estrellas) {
        this.ID_categoria = ID_categoria;
        this.nombre = nombre;
        this.tipo_IVA = tipo_IVA;
        this.estrellas.add(estrellas);
        _id = new ObjectId();
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public int getID_categoria() {
        return ID_categoria;
    }

    public void setID_categoria(int ID_categoria) {
        this.ID_categoria = ID_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_IVA() {
        return tipo_IVA;
    }

    public void setTipo_IVA(String tipo_IVA) {
        this.tipo_IVA = tipo_IVA;
    }

    public ArrayList<String> getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(ArrayList<String> estrellas) {
        this.estrellas = estrellas;
    }

    /**
     * Genera un código hash único basado en el identificador de la categoría.
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
     * Compara dos instancias de Categoria para verificar su igualdad. Dos
     * instancias son iguales si tienen el mismo identificador (_id) o el mismo
     * nombre.
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
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this._id, other._id)) {
            return false;
        }
        return true;
    }

    /**
     * Genera una representación en cadena de la instancia Categoria.
     *
     * @return Cadena que representa la instancia.
     */
    @Override
    public String toString() {
        return "Categoria{" + "_id=" + _id + ", ID_categoria=" + ID_categoria + ", nombre=" + nombre + ", tipo_IVA=" + tipo_IVA + ", estrellas=" + estrellas + '}';
    }

}
