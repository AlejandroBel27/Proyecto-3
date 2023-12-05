/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Exceptions.DAOException;
import ObjetosGUI.Hotel;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Clase que implementa un Data Access Object (DAO) para la entidad Hotel,
 * proporcionando métodos específicos para realizar operaciones CRUD en una base
 * de datos MongoDB. Extiende la clase BaseDao<T> para aprovechar la
 * funcionalidad común proporcionada por la misma.
 *
 * @author Proyecto_3
 */
public class DAOHoteles extends BaseDao<Hotel> {

    /**
     * Consulta y devuelve todos los hoteles en la base de datos.
     *
     * @return ArrayList de Hotel representando todos los hoteles.
     * @throws DAOException Si hay algún error durante la consulta.
     */
    @Override
    public ArrayList<Hotel> consultar() throws DAOException {
        MongoCollection<Hotel> collection = this.getColeccion();
        return collection.find().into(new ArrayList<>());
    }

    /**
     * Inserta un nuevo hotel en la base de datos.
     *
     * @param entidad Hotel a ser insertado.
     * @throws DAOException Si hay algún error durante la inserción.
     */
    @Override
    public void insertar(Hotel entidad) throws DAOException {
        MongoCollection<Hotel> collection = getColeccion();
        collection.insertOne(entidad);
    }

    /**
     * Actualiza la información de un hotel en la base de datos.
     *
     * @param entidad Hotel con la información actualizada.
     * @throws DAOException Si hay algún error durante la actualización.
     */
    @Override
    public void actualizar(Hotel entidad) throws DAOException {
        MongoCollection<Hotel> collection = getColeccion();
        collection.updateOne(Filters.eq("_id", entidad.getId()),
                new Document("$set", new Document()
                        .append("ID_hotel", entidad.getID_hotel())
                        .append("nombre", entidad.getNombre())
                        .append("direccion", entidad.getDireccion())
                        .append("telefono", entidad.getTelefono())
                        .append("ano_construccion", entidad.getAno_construccion())
                        .append("ID_categoria", entidad.getID_categoria())
                )
        );
    }

    /**
     * Consulta y devuelve un hotel por su identificador único.
     *
     * @param id Identificador único del hotel.
     * @return Hotel consultado o null si no se encuentra.
     * @throws DAOException Si hay algún error durante la consulta por
     * identificador.
     */
    @Override
    public Hotel consultarPorId(ObjectId id) throws DAOException {
        MongoCollection<Hotel> collection = getColeccion();
        return collection.find(Filters.eq("_id", id)).first();
    }

    /**
     * Elimina un hotel de la base de datos por su identificador único.
     *
     * @param id Identificador único del hotel a ser eliminado.
     * @throws DAOException Si hay algún error durante la eliminación.
     */
    @Override
    public void eliminar(ObjectId id) throws DAOException {
        MongoCollection<Hotel> collection = getColeccion();
        Hotel hotel = collection.findOneAndDelete(Filters.eq("_id", id));
        if (hotel == null) {
            System.out.println("No se encontró el hotel con ID: " + id);
        }
    }

    /**
     * Obtiene la colección específica de Hotel en la base de datos.
     *
     * @return MongoCollection de Hotel.
     * @throws DAOException Si hay algún error durante la obtención de la
     * colección.
     */
    private MongoCollection<Hotel> getColeccion() throws DAOException {
        MongoCollection<Hotel> hotel = this.generarConexion().getCollection("hotel", Hotel.class);
        return hotel;
    }

}
