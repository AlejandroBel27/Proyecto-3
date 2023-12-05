/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Exceptions.DAOException;
import ObjetosGUI.Reservaciones;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Clase que implementa un Data Access Object (DAO) para la entidad
 * Reservaciones, proporcionando métodos específicos para realizar operaciones
 * CRUD en una base de datos MongoDB. Extiende la clase BaseDao<T> para
 * aprovechar la funcionalidad común proporcionada por la misma.
 *
 * @author Proyecto_3
 */
public class DAOReservaciones extends BaseDao<Reservaciones> {

    /**
     * Consulta y devuelve todas las reservaciones en la base de datos.
     *
     * @return ArrayList de Reservaciones representando todas las reservaciones.
     * @throws DAOException Si hay algún error durante la consulta.
     */
    @Override
    public ArrayList<Reservaciones> consultar() throws DAOException {
        MongoCollection<Reservaciones> collection = this.getColeccion();
        return collection.find().into(new ArrayList<>());
    }

    /**
     * Inserta una nueva reservación en la base de datos.
     *
     * @param entidad Reservaciones a ser insertada.
     * @throws DAOException Si hay algún error durante la inserción.
     */
    @Override
    public void insertar(Reservaciones entidad) throws DAOException {
        MongoCollection<Reservaciones> collection = getColeccion();
        collection.insertOne(entidad);
    }

    /**
     * Actualiza la información de una reservación en la base de datos.
     *
     * @param entidad Reservaciones con la información actualizada.
     * @throws DAOException Si hay algún error durante la actualización.
     */
    @Override
    public void actualizar(Reservaciones entidad) throws DAOException {
        MongoCollection<Reservaciones> collection = getColeccion();
        collection.updateOne(Filters.eq("_id", entidad.getId()),
                new Document("$set", new Document()
                        .append("nombreHotel", entidad.getNombreHotel())
                        .append("fecha_inicio", entidad.getFecha_inicio())
                        .append("fecha_final", entidad.getFecha_fin())
                        .append("tipoHabitacion", entidad.getTipoHabitacion())
                )
        );

    }

    /**
     * Consulta y devuelve una reservación por su identificador único.
     *
     * @param id Identificador único de la reservación.
     * @return Reservaciones consultada o null si no se encuentra.
     * @throws DAOException Si hay algún error durante la consulta por
     * identificador.
     */
    @Override
    public Reservaciones consultarPorId(ObjectId id) throws DAOException {
        MongoCollection<Reservaciones> collection = getColeccion();
        return collection.find(Filters.eq("_id", id)).first();
    }

    /**
     * Elimina una reservación de la base de datos por su identificador único.
     *
     * @param id Identificador único de la reservación a ser eliminada.
     * @throws DAOException Si hay algún error durante la eliminación.
     */
    @Override
    public void eliminar(ObjectId id) throws DAOException {
        MongoCollection<Reservaciones> collection = getColeccion();
        Reservaciones reservaciones = collection.findOneAndDelete(Filters.eq("_id", id));
        if (reservaciones == null) {
            System.out.println("No se encontró la reservación con ID: " + id);
        }
    }

    /**
     * Obtiene la colección específica de Reservaciones en la base de datos.
     *
     * @return MongoCollection de Reservaciones.
     * @throws DAOException Si hay algún error durante la obtención de la
     * colección.
     */
    private MongoCollection<Reservaciones> getColeccion() throws DAOException {
        MongoCollection<Reservaciones> reservaciones = this.generarConexion().getCollection("Reservaciones", Reservaciones.class);
        return reservaciones;
    }

}
