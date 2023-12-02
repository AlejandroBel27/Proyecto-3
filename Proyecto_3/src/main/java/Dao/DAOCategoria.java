package Dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import Exceptions.DAOException;
import org.bson.Document;
import org.bson.types.ObjectId;
import Objetos.Categoria;
import java.util.ArrayList;

/**
 *
 * @author Proyecto_3
 */
public class DAOCategoria extends BaseDao<Categoria> {

    @Override
    public ArrayList<Categoria> consultar() throws DAOException {
        MongoCollection<Categoria> collection = this.getColeccion();
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public void insertar(Categoria entidad) throws DAOException {
         MongoCollection<Categoria> collection = this.getColeccion();
        collection.insertOne(entidad);
    }

    @Override
    public void actualizar(Categoria entidad) throws DAOException {
          MongoCollection<Categoria> collection = getColeccion();
        collection.updateOne(Filters.eq("_id", entidad.getId()),
                new Document("$set", new Document()
                        .append("ID_categoria", entidad.getID_categoria())
                        .append("nombre", entidad.getNombre())
                        .append("tipo_IVA", entidad.getTipo_IVA())
                        .append("estrellas", entidad.getEstrellas())
                )
        );
    }

    @Override
    public Categoria consultarPorId(ObjectId id) throws DAOException {
         MongoCollection<Categoria> collection = getColeccion();
        return collection.find(Filters.eq("_id", id)).first();
    }

    @Override
    public void eliminar(ObjectId id) throws DAOException {
        MongoCollection<Categoria> collection = getColeccion();
        Categoria categoria = collection.findOneAndDelete(Filters.eq("_id", id));
        if (categoria == null) {
            System.out.println("No se encontró la categoría con ID: " + id);
        }
    }

    protected MongoCollection<Categoria> getColeccion() throws DAOException{
         MongoCollection<Categoria> Categoria = this.generarConexion().getCollection("categoria", Categoria.class);
         return Categoria;
    }
}
