/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Exceptions.DAOException;
import ObjetosGUI.Habitaciones;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

/*
 *Clase que implementa un Data Access Object (DAO) para la entidad Habitaciones,
 * proporcionando métodos específicos para realizar operaciones CRUD en una base de datos MongoDB.
 * Extiende la clase BaseDao<T> para aprovechar la funcionalidad común proporcionada por la misma.
 *
 * @author Proyecto_3
 */
public class DAOHabitaciones extends BaseDao<Habitaciones> {

    /**
     * Consulta y devuelve todas las habitaciones en la base de datos.
     *
     * @return ArrayList de Habitaciones representando todas las habitaciones.
     * @throws DAOException Si hay algún error durante la consulta.
     */
    @Override
    public ArrayList<Habitaciones> consultar() throws DAOException {
        MongoCollection<Habitaciones> collection = this.getColeccion();
        return collection.find().into(new ArrayList<>());
    }

    /**
     * Inserta una nueva habitación en la base de datos.
     *
     * @param entidad Habitaciones a ser insertada.
     * @throws DAOException Si hay algún error durante la inserción.
     */
    @Override
    public void insertar(Habitaciones entidad) throws DAOException {
        MongoCollection<Habitaciones> collection = getColeccion();
        collection.insertOne(entidad);
    }

    /**
     * Actualiza la información de una habitación en la base de datos.
     *
     * @param entidad Habitaciones con la información actualizada.
     * @throws DAOException Si hay algún error durante la actualización.
     */
    @Override
    public void actualizar(Habitaciones entidad) throws DAOException {
        MongoCollection<Habitaciones> collection = getColeccion();
        collection.updateOne(Filters.eq("_id", entidad.getId()),
                new Document("$set", new Document()
                        .append("ID_habitacion", entidad.getID_habitacion())
                        .append("numero", entidad.getNumero())
                        .append("tipo", entidad.getTipo())
                        .append("planta", entidad.getPlanta())
                        .append("ID_hotel", entidad.getID_hotel())
                )
        );
    }

    /**
     * Consulta y devuelve una habitación por su identificador único.
     *
     * @param id Identificador único de la habitación.
     * @return Habitaciones consultada o null si no se encuentra.
     * @throws DAOException Si hay algún error durante la consulta por
     * identificador.
     */
    @Override
    public Habitaciones consultarPorId(ObjectId id) throws DAOException {
        MongoCollection<Habitaciones> collection = getColeccion();
        return collection.find(Filters.eq("_id", id)).first();
    }

    /**
     * Elimina una habitación de la base de datos por su identificador único.
     *
     * @param id Identificador único de la habitación a ser eliminada.
     * @throws DAOException Si hay algún error durante la eliminación.
     */
    @Override
    public void eliminar(ObjectId id) throws DAOException {
        MongoCollection<Habitaciones> collection = getColeccion();
        Habitaciones habitacion = collection.findOneAndDelete(Filters.eq("_id", id));
        if (habitacion == null) {
            System.out.println("No se encontró la habitación con ID: " + id);
        }
    }

    /**
     * Obtiene la colección específica de Habitaciones en la base de datos.
     *
     * @return MongoCollection de Habitaciones.
     * @throws DAOException Si hay algún error durante la obtención de la
     * colección.
     */
    private MongoCollection<Habitaciones> getColeccion() throws DAOException {
        MongoCollection<Habitaciones> Habitaciones = this.generarConexion().getCollection("habitaciones", Habitaciones.class);
        return Habitaciones;
    }

}
