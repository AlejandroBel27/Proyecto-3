package Dao;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import Exceptions.DAOException;
import java.util.ArrayList;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;

/*
 * Clase abstracta que sirve como base para implementar Data Access Objects
 * (DAO) para interactuar con una base de datos MongoDB. Proporciona métodos
 * comunes para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en
 * la base de datos.
 *
 * @author Proyecto_3
 * @param <T>
 */
public abstract class BaseDao<T> {

    /*
     * Genera y devuelve una conexión a la base de datos MongoDB.
     *
     * @return Objeto MongoDatabase que representa la conexión a la base de
     * datos.
     * @throws DAOException Si hay algún error al establecer la conexión.
     */
    protected MongoDatabase generarConexion() throws DAOException {
        try {
            // CONFIGURACION PARA QUE MONGO PUEDA MAPEAR LOS OBJETOS NEGOCIO CON COLECCIONES
            CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());

            CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

            ConnectionString cadenaConexion = new ConnectionString("mongodb://localhost");

            MongoClientSettings configuracionesConexion = MongoClientSettings.builder()
                    .applyConnectionString(cadenaConexion)
                    .codecRegistry(codecRegistry)
                    .build();

            MongoClient clienteBD = MongoClients.create(configuracionesConexion);

            MongoDatabase baseDatos = clienteBD.getDatabase("Hoteles");

            return baseDatos;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            throw new DAOException(ex.getMessage(), ex);
        }
    }

    /*
     * Método abstracto para consultar entidades en la base de datos.
     *
     * @return ArrayList de entidades consultadas.
     * @throws DAOException Si hay algún error durante la consulta.
     */
    public abstract ArrayList<T> consultar() throws DAOException;

    /*
     * Método abstracto para insertar una entidad en la base de datos.
     *
     * @param entidad Entidad a ser insertada.
     * @throws DAOException Si hay algún error durante la inserción.
     */
    public abstract void insertar(T entidad) throws DAOException;

    /*
     * Método abstracto para actualizar una entidad en la base de datos.
     *
     * @param entidad Entidad a ser actualizada.
     * @throws DAOException Si hay algún error durante la actualización.
     */
    public abstract void actualizar(T entidad) throws DAOException;

    /*
     * Método abstracto para consultar una entidad por su identificador.
     *
     * @param id Identificador de la entidad.
     * @return La entidad consultada.
     * @throws DAOException Si hay algún error durante la consulta por
     * identificador.
     */
    public abstract T consultarPorId(ObjectId id) throws DAOException;

    /**
     * Método abstracto para eliminar una entidad por su identificador.
     *
     * @param id Identificador de la entidad a ser eliminada.
     * @throws DAOException Si hay algún error durante la eliminación.
     */
    public abstract void eliminar(ObjectId id) throws DAOException;
    //protected abstract MongoCollection<T> getColeccion() throws DAOException;    
}
