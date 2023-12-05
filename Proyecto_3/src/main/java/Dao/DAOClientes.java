/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Exceptions.DAOException;
import ObjetosGUI.Clientes;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import org.bson.Document;
import org.bson.types.ObjectId;

/*
 * Clase que implementa un Data Access Object (DAO) para la entidad Clientes,
 * proporcionando métodos específicos para realizar operaciones CRUD en una base
 * de datos MongoDB. Extiende la clase BaseDao<T> para aprovechar la
 * funcionalidad común proporcionada por la misma.
 *
 * @author Proyecto_3
 */
public class DAOClientes extends BaseDao<Clientes> {

    /*
     * Consulta y devuelve todos los clientes en la base de datos.
     *
     * @return ArrayList de Clientes representando todos los clientes.
     * @throws DAOException Si hay algún error durante la consulta.
     */
    @Override
    public ArrayList consultar() throws DAOException {
        MongoCollection<Clientes> collection = this.getColeccion();
        return collection.find().into(new ArrayList<>());
    }

    /*
     * Inserta un nuevo cliente en la base de datos.
     *
     * @param entidad Clientes a ser insertado.
     * @throws DAOException Si hay algún error durante la inserción.
     */
    @Override
    public void insertar(Clientes entidad) throws DAOException {
        MongoCollection<Clientes> collection = this.getColeccion();
        collection.insertOne(entidad);
    }

    /*
     * Actualiza la información de un cliente en la base de datos.
     *
     * @param entidad Clientes con la información actualizada.
     * @throws DAOException Si hay algún error durante la actualización.
     */
    @Override
    public void actualizar(Clientes entidad) throws DAOException {
        MongoCollection<Clientes> collection = getColeccion();
        collection.updateOne(Filters.eq("_id", entidad.getId()),
                new Document("$set", new Document()
                        .append("ID_cliente", entidad.getID_cliente())
                        .append("usuario", entidad.getUsuario())
                        .append("direccion", entidad.getDireccion())
                        .append("telefono", entidad.getTelefono())
                        .append("contraseña", entidad.getContraseña())
                )
        );
    }

    /*
     * Consulta y devuelve un cliente por su identificador único.
     *
     * @param id Identificador único del cliente.
     * @return Clientes consultado o null si no se encuentra.
     * @throws DAOException Si hay algún error durante la consulta por
     * identificador.
     */
    @Override
    public Clientes consultarPorId(ObjectId id) throws DAOException {
        MongoCollection<Clientes> collection = getColeccion();
        return collection.find(Filters.eq("_id", id)).first();
    }

    /*
     * Elimina un cliente de la base de datos por su identificador único.
     *
     * @param id Identificador único del cliente a ser eliminado.
     * @throws DAOException Si hay algún error durante la eliminación.
     */
    @Override
    public void eliminar(ObjectId id) throws DAOException {
        MongoCollection<Clientes> collection = getColeccion();
        Clientes cliente = collection.findOneAndDelete(Filters.eq("_id", id));
        if (cliente == null) {
            System.out.println("No se encontró el cliente con ID: " + id);
        }
    }

    /*
     * Obtiene la colección específica de Clientes en la base de datos.
     *
     * @return MongoCollection de Clientes.
     * @throws DAOException Si hay algún error durante la obtención de la
     * colección.
     */
    private MongoCollection<Clientes> getColeccion() throws DAOException {
        MongoCollection<Clientes> Clientes = this.generarConexion().getCollection("clientes", Clientes.class);
        return Clientes;
    }

}
