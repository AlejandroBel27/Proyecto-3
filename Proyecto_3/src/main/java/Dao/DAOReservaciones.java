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
 *
 * @author Proyecto_3
 */
public class DAOReservaciones extends BaseDao<Reservaciones> {

    @Override
    public ArrayList<Reservaciones> consultar() throws DAOException {
        MongoCollection<Reservaciones> collection = this.getColeccion();
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public void insertar(Reservaciones entidad) throws DAOException {
        MongoCollection<Reservaciones> collection = getColeccion();
        collection.insertOne(entidad);
    }

    @Override
    public void actualizar(Reservaciones entidad) throws DAOException {
        MongoCollection<Reservaciones> collection = getColeccion();
        collection.updateOne(Filters.eq("_id", entidad.getId()),
                new Document("$set", new Document()
                        .append("ID_reserva", entidad.getID_reserva())
                        .append("fecha_inicio", entidad.getFecha_inicio())
                        .append("fecha_final", entidad.getFecha_fin())
                        .append("ID_cliente", entidad.getID_cliente())
                        .append("ID_agencia", entidad.getID_agencia())
                        .append("ID_hotel", entidad.getID_hotel())
                        .append("ID_categoria", entidad.getID_categoria())
                        .append("ID_habitacion", entidad.getID_habitacion())
                )
        );

    }

    @Override
    public Reservaciones consultarPorId(ObjectId id) throws DAOException {
        MongoCollection<Reservaciones> collection = getColeccion();
        return collection.find(Filters.eq("_id", id)).first();
    }

    @Override
    public void eliminar(ObjectId id) throws DAOException {
        MongoCollection<Reservaciones> collection = getColeccion();
        Reservaciones reservaciones = collection.findOneAndDelete(Filters.eq("_id", id));
        if (reservaciones == null) {
            System.out.println("No se encontró la reservación con ID: " + id);
        }
    }

    private MongoCollection<Reservaciones> getColeccion() throws DAOException {
        MongoCollection<Reservaciones> reservaciones = this.generarConexion().getCollection("Reservaciones", Reservaciones.class);
        return reservaciones;
    }

}
