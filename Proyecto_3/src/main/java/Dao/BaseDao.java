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

/**
 *
 * @author alejandrobel
 * @param <T>
 */
public abstract class BaseDao<T> {

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


    public abstract ArrayList<T> consultar() throws DAOException;

    public abstract void insertar(T entidad) throws DAOException;

    public abstract void actualizar(T entidad) throws DAOException;

    public abstract T consultarPorId(ObjectId id) throws DAOException;

    public abstract void eliminar(ObjectId id) throws DAOException;
    //protected abstract MongoCollection<T> getColeccion() throws DAOException;    
}
