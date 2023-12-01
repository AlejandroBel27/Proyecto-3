/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Exceptions.DAOException;
import Objetos.Tarifa;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author alejandrobel
 */
public class DAOTarifa extends BaseDao<Tarifa> {

    @Override
    public ArrayList<Tarifa> consultar() throws DAOException {
        MongoCollection<Tarifa> collection = this.getColeccion();
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public void insertar(Tarifa entidad) throws DAOException {
        MongoCollection<Tarifa> collection = getColeccion();
        collection.insertOne(entidad);
    }

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

    @Override
    public Tarifa consultarPorId(ObjectId id) throws DAOException {
        MongoCollection<Tarifa> collection = getColeccion();
        return collection.find(Filters.eq("_id", id)).first();
    }

    @Override
    public void eliminar(ObjectId id) throws DAOException {
        MongoCollection<Tarifa> collection = getColeccion();
        Tarifa tarifa = collection.findOneAndDelete(Filters.eq("_id", id));
        if (tarifa == null) {
            System.out.println("No se encontró la tarifa con ID: " + id);
        }
    }

    private MongoCollection<Tarifa> getColeccion() throws DAOException {
        MongoCollection<Tarifa> tarifa = this.generarConexion().getCollection("tarifa", Tarifa.class);
        return tarifa;
    }

}
