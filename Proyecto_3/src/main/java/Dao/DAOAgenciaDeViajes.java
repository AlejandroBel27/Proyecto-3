package Dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import Exceptions.DAOException;
import org.bson.Document;
import org.bson.types.ObjectId;
import ObjetosGUI.AgenciaDeViajes;
import java.util.ArrayList;

/*
 * Clase que implementa un Data Access Object (DAO) para la entidad
 * AgenciaDeViajes, proporcionando métodos específicos para realizar operaciones
 * CRUD en una base de datos MongoDB. Extiende la clase BaseDao<T> para
 * aprovechar la funcionalidad común proporcionada por la misma.
 *
 * @author Proyecto_3
 */
public class DAOAgenciaDeViajes extends BaseDao<AgenciaDeViajes> {

    /*
     * Consulta y devuelve todas las agencias de viajes en la base de datos.
     *
     * @return ArrayList de AgenciaDeViajes representando todas las agencias de
     * viajes.
     * @throws DAOException Si hay algún error durante la consulta.
     */
    @Override
    public ArrayList<AgenciaDeViajes> consultar() throws DAOException {
        MongoCollection<AgenciaDeViajes> A = this.getColeccion();
        ArrayList<AgenciaDeViajes> AgenciaDeViajes = new ArrayList<>();
        A.find().into(AgenciaDeViajes);
        return AgenciaDeViajes;
    }

    /*
     * Inserta una nueva agencia de viajes en la base de datos.
     *
     * @param entidad AgenciaDeViajes a ser insertada.
     * @throws DAOException Si hay algún error durante la inserción.
     */
    @Override
    public void insertar(AgenciaDeViajes entidad) throws DAOException {
        MongoCollection<AgenciaDeViajes> a = this.getColeccion();
        a.insertOne(entidad);
    }

    /*
     * Actualiza la información de una agencia de viajes en la base de datos.
     *
     * @param entidad AgenciaDeViajes con la información actualizada.
     * @throws DAOException Si hay algún error durante la actualización.
     */
    @Override
    public void actualizar(AgenciaDeViajes entidad) throws DAOException {
        MongoCollection<AgenciaDeViajes> ag = this.getColeccion();
        ag.updateOne(Filters.eq("_id", entidad.getId()),
                new Document("$set", new Document()
                        .append("ID_agencia", entidad.getID_agencia())
                        .append("usuario", entidad.getUsuario())
                        .append("direccion", entidad.getDireccion())
                        .append("telefono", entidad.getTelefono())
                        .append("contraseña", entidad.getContraseña())
                )
        );

    }

    /*
     * Consulta y devuelve una agencia de viajes por su identificador único.
     *
     * @param id Identificador único de la agencia de viajes.
     * @return La AgenciaDeViajes consultada o null si no se encuentra.
     * @throws DAOException Si hay algún error durante la consulta por
     * identificador.
     */
    @Override
    public AgenciaDeViajes consultarPorId(ObjectId id) throws DAOException {
        MongoCollection<AgenciaDeViajes> a = this.getColeccion();
        ArrayList<AgenciaDeViajes> Ag = new ArrayList<>();
        a.find(Filters.eq("_id", id)).into(Ag);
        for (AgenciaDeViajes agenciaDeViajes : Ag) {
            return agenciaDeViajes;
        }
        return null;
    }

    /*
     * Elimina una agencia de viajes de la base de datos por su identificador
     * único.
     *
     * @param id Identificador único de la agencia de viajes a ser eliminada.
     * @throws DAOException Si hay algún error durante la eliminación.
     */
    @Override
    public void eliminar(ObjectId id) throws DAOException {
        MongoCollection<AgenciaDeViajes> a = this.getColeccion();
        AgenciaDeViajes h = a.findOneAndDelete(Filters.eq("_id", id));
        if (h == null) {
            throw new DAOException("No fue posible eliminar la agencia de viajes " + id);
        }
    }

    /*
     * Obtiene la colección específica de AgenciaDeViajes en la base de datos.
     *
     * @return MongoCollection de AgenciaDeViajes.
     * @throws DAOException Si hay algún error durante la obtención de la
     * colección.
     */
    protected MongoCollection<AgenciaDeViajes> getColeccion() throws DAOException {
        MongoCollection<AgenciaDeViajes> AgenciaDeViajes = this.generarConexion().getCollection("agencia de viajes", AgenciaDeViajes.class);
        return AgenciaDeViajes;
    }

}
