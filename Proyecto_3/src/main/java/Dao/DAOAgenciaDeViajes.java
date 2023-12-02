package Dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import Exceptions.DAOException;
import org.bson.Document;
import org.bson.types.ObjectId;
import Objetos.AgenciaDeViajes;
import java.util.ArrayList;

/**
 *
 * @author Proyecto_3
 */
public class DAOAgenciaDeViajes extends BaseDao<AgenciaDeViajes> {

    @Override
    public ArrayList<AgenciaDeViajes> consultar() throws DAOException {
        MongoCollection<AgenciaDeViajes> A = this.getColeccion();
        ArrayList<AgenciaDeViajes> AgenciaDeViajes = new ArrayList<>();
        A.find().into(AgenciaDeViajes);
        return AgenciaDeViajes;
    }

    @Override
    public void insertar(AgenciaDeViajes entidad) throws DAOException {
        MongoCollection<AgenciaDeViajes> a = this.getColeccion();
        a.insertOne(entidad);
    }

    @Override
    public void actualizar(AgenciaDeViajes entidad) throws DAOException {
        MongoCollection<AgenciaDeViajes> ag = this.getColeccion();
        ag.updateOne(Filters.eq("_id", entidad.getId()),
                new Document("$set", new Document()
                        .append("ID_agencia", entidad.getID_agencia())
                        .append("nombre", entidad.getNombre())
                        .append("direccion", entidad.getDireccion())
                        .append("telefono", entidad.getTelefono())
                )
        );
                        
    }

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

    @Override
    public void eliminar(ObjectId id) throws DAOException {
        MongoCollection<AgenciaDeViajes> a = this.getColeccion();
         AgenciaDeViajes h = a.findOneAndDelete(Filters.eq("_id", id));
        if(h == null){
            throw new DAOException("No fue posible eliminar la agencia de viajes " + id);
        }
    }

    protected MongoCollection<AgenciaDeViajes> getColeccion() throws DAOException {
        MongoCollection<AgenciaDeViajes> AgenciaDeViajes = this.generarConexion().getCollection("agencia de viajes", AgenciaDeViajes.class);
        return AgenciaDeViajes;
    }

}
