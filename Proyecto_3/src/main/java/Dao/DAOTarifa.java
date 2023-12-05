/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Exceptions.DAOException;
import ObjetosGUI.Tarifa;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 ** Clase que implementa un Data Access Object (DAO) para la entidad Tarifa,
 * proporcionando métodos específicos para realizar operaciones CRUD en una base
 * de datos MongoDB. Extiende la clase BaseDao<T> para aprovechar la
 * funcionalidad común proporcionada por la misma.
 *
 * @author Proyecto_3
 */
public class DAOTarifa extends BaseDao<Tarifa> {

    /**
     * Consulta y devuelve todas las tarifas en la base de datos.
     *
     * @return ArrayList de Tarifa representando todas las tarifas.
     * @throws DAOException Si hay algún error durante la consulta.
     */
    @Override
    public ArrayList<Tarifa> consultar() throws DAOException {
        MongoCollection<Tarifa> collection = this.getColeccion();
        return collection.find().into(new ArrayList<>());
    }

    /**
     * Inserta una nueva tarifa en la base de datos.
     *
     * @param entidad Tarifa a ser insertada.
     * @throws DAOException Si hay algún error durante la inserción.
     */
    @Override
    public void insertar(Tarifa entidad) throws DAOException {
        MongoCollection<Tarifa> collection = getColeccion();
        collection.insertOne(entidad);
    }

    /**
     * Actualiza la información de una tarifa en la base de datos.
     *
     * @param entidad Tarifa con la información actualizada.
     * @throws DAOException Si hay algún error durante la actualización.
     */
    @Override
    public void actualizar(Tarifa entidad) throws DAOException {
        MongoCollection<Tarifa> collection = getColeccion();
        collection.updateOne(Filters.eq("_id", entidad.getId()),
                new Document("$set", new Document()
                        .append("ID_habitacion", entidad.getID_habitacion())
                        .append("ID_hotel", entidad.getID_hotel())
                        .append("tipo", entidad.getTipo())
                        .append("temporada", entidad.getTemporada())
                )
        );
    }

    /**
     * Consulta y devuelve una tarifa por su identificador único.
     *
     * @param id Identificador único de la tarifa.
     * @return Tarifa consultada o null si no se encuentra.
     * @throws DAOException Si hay algún error durante la consulta por
     * identificador.
     */
    @Override
    public Tarifa consultarPorId(ObjectId id) throws DAOException {
        MongoCollection<Tarifa> collection = getColeccion();
        return collection.find(Filters.eq("_id", id)).first();
    }

    /**
     * Elimina una tarifa de la base de datos por su identificador único.
     *
     * @param id Identificador único de la tarifa a ser eliminada.
     * @throws DAOException Si hay algún error durante la eliminación.
     */
    @Override
    public void eliminar(ObjectId id) throws DAOException {
        MongoCollection<Tarifa> collection = getColeccion();
        Tarifa tarifa = collection.findOneAndDelete(Filters.eq("_id", id));
        if (tarifa == null) {
            System.out.println("No se encontró la tarifa con ID: " + id);
        }
    }

    /**
     * Obtiene la colección específica de Tarifa en la base de datos.
     *
     * @return MongoCollection de Tarifa.
     * @throws DAOException Si hay algún error durante la obtención de la
     * colección.
     */
    private MongoCollection<Tarifa> getColeccion() throws DAOException {
        MongoCollection<Tarifa> tarifa = this.generarConexion().getCollection("tarifa", Tarifa.class);
        return tarifa;
    }

}
