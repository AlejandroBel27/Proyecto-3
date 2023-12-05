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

/**
 *
 * @author Proyecto_3
 */
public class DAOHabitaciones extends BaseDao<Habitaciones> {

    @Override
    public ArrayList<Habitaciones> consultar() throws DAOException {
        MongoCollection<Habitaciones> collection = this.getColeccion();
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public void insertar(Habitaciones entidad) throws DAOException {
        MongoCollection<Habitaciones> collection = getColeccion();
        collection.insertOne(entidad);
    }

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

    @Override
    public Habitaciones consultarPorId(ObjectId id) throws DAOException {
          MongoCollection<Habitaciones> collection = getColeccion();
        return collection.find(Filters.eq("_id", id)).first();
    }

    @Override
    public void eliminar(ObjectId id) throws DAOException {
          MongoCollection<Habitaciones> collection = getColeccion();
        Habitaciones habitacion = collection.findOneAndDelete(Filters.eq("_id", id));
        if (habitacion == null) {
            System.out.println("No se encontró la habitación con ID: " + id);
        }
    }

    private MongoCollection<Habitaciones> getColeccion() throws DAOException {
        MongoCollection<Habitaciones> Habitaciones = this.generarConexion().getCollection("habitaciones", Habitaciones.class);
        return Habitaciones;
    }

}
