package Dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import Exceptions.DAOException;
import org.bson.Document;
import org.bson.types.ObjectId;
import ObjetosGUI.Categoria;
import java.util.ArrayList;

/*
 * Clase que implementa un Data Access Object (DAO) para la entidad Categoria,
 * proporcionando métodos específicos para realizar operaciones CRUD en una base
 * de datos MongoDB. Extiende la clase BaseDao<T> para aprovechar la
 * funcionalidad común proporcionada por la misma.
 *
 * @author Proyecto_3
 */
public class DAOCategoria extends BaseDao<Categoria> {

    /*
     * Consulta y devuelve todas las categorías en la base de datos.
     *
     * @return ArrayList de Categoria representando todas las categorías.
     * @throws DAOException Si hay algún error durante la consulta.
     */
    @Override
    public ArrayList<Categoria> consultar() throws DAOException {
        MongoCollection<Categoria> collection = this.getColeccion();
        return collection.find().into(new ArrayList<>());
    }

    /*
     * Inserta una nueva categoría en la base de datos.
     *
     * @param entidad Categoria a ser insertada.
     * @throws DAOException Si hay algún error durante la inserción.
     */
    @Override
    public void insertar(Categoria entidad) throws DAOException {
        MongoCollection<Categoria> collection = this.getColeccion();
        collection.insertOne(entidad);
    }

    /*
     * Actualiza la información de una categoría en la base de datos.
     *
     * @param entidad Categoria con la información actualizada.
     * @throws DAOException Si hay algún error durante la actualización.
     */
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

    /*
     * Consulta y devuelve una categoría por su identificador único.
     *
     * @param id Identificador único de la categoría.
     * @return La Categoria consultada o null si no se encuentra.
     * @throws DAOException Si hay algún error durante la consulta por
     * identificador.
     */
    @Override
    public Categoria consultarPorId(ObjectId id) throws DAOException {
        MongoCollection<Categoria> collection = getColeccion();
        return collection.find(Filters.eq("_id", id)).first();
    }

    /*
     * Elimina una categoría de la base de datos por su identificador único.
     *
     * @param id Identificador único de la categoría a ser eliminada.
     * @throws DAOException Si hay algún error durante la eliminación.
     */
    @Override
    public void eliminar(ObjectId id) throws DAOException {
        MongoCollection<Categoria> collection = getColeccion();
        Categoria categoria = collection.findOneAndDelete(Filters.eq("_id", id));
        if (categoria == null) {
            System.out.println("No se encontró la categoría con ID: " + id);
        }
    }

    /*
     * Obtiene la colección específica de Categoria en la base de datos.
     *
     * @return MongoCollection de Categoria.
     * @throws DAOException Si hay algún error durante la obtención de la
     * colección.
     */
    protected MongoCollection<Categoria> getColeccion() throws DAOException {
        MongoCollection<Categoria> Categoria = this.generarConexion().getCollection("categoria", Categoria.class);
        return Categoria;
    }
}
