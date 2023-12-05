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
 *
 * @author Proyecto_3
 */
public class DAOHoteles extends BaseDao<Hotel> {

    @Override
    public ArrayList<Hotel> consultar() throws DAOException {
        MongoCollection<Hotel> collection = this.getColeccion();
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public void insertar(Hotel entidad) throws DAOException {
        MongoCollection<Hotel> collection = getColeccion();
        collection.insertOne(entidad);
    }

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

    @Override
    public Hotel consultarPorId(ObjectId id) throws DAOException {
        MongoCollection<Hotel> collection = getColeccion();
        return collection.find(Filters.eq("_id", id)).first();
    }

    @Override
    public void eliminar(ObjectId id) throws DAOException {
        MongoCollection<Hotel> collection = getColeccion();
        Hotel hotel = collection.findOneAndDelete(Filters.eq("_id", id));
        if (hotel == null) {
            System.out.println("No se encontró el hotel con ID: " + id);
        }
    }

    private MongoCollection<Hotel> getColeccion() throws DAOException {
        MongoCollection<Hotel> hotel = this.generarConexion().getCollection("hotel", Hotel.class);
        return hotel;
    }

}
