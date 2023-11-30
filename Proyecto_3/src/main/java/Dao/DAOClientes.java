/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Exceptions.DAOException;
import Objetos.Clientes;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author alejandrobel
 */
public class DAOClientes extends BaseDao<Clientes> {

    @Override
    public ArrayList consultar() throws DAOException {
        MongoCollection<Clientes> collection = this.getColeccion();
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public void insertar(Clientes entidad) throws DAOException {
        MongoCollection<Clientes> collection = this.getColeccion();
        collection.insertOne(entidad);
    }

    @Override
    public void actualizar(Clientes entidad) throws DAOException {
        MongoCollection<Clientes> collection = getColeccion();
        collection.updateOne(Filters.eq("_id", entidad.getId()),
                new Document("$set", new Document()
                        .append("ID_cliente", entidad.getID_cliente())
                        .append("nombre", entidad.getNombre())
                        .append("direccion", entidad.getDireccion())
                        .append("telefono", entidad.getTelefono())
                )
        );
    }

    @Override
    public Clientes consultarPorId(ObjectId id) throws DAOException {
        MongoCollection<Clientes> collection = getColeccion();
        return collection.find(Filters.eq("_id", id)).first();
    }

    @Override
    public void eliminar(ObjectId id) throws DAOException {
        MongoCollection<Clientes> collection = getColeccion();
        Clientes cliente = collection.findOneAndDelete(Filters.eq("_id", id));
        if (cliente == null) {
            System.out.println("No se encontró el cliente con ID: " + id);
        }
    }

    private MongoCollection<Clientes> getColeccion() throws DAOException {
        MongoCollection<Clientes> Clientes = this.generarConexion().getCollection("clientes", Clientes.class);
        return Clientes;
    }

}
