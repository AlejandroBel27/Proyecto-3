package Exceptions;

/**
 * Clase de excepción personalizada para manejar errores específicos en el
 * contexto de DAO (Data Access Object). Puede ser lanzada en situaciones donde
 * ocurran problemas durante las operaciones de acceso a la base de datos.
 *
 * @author Proyecto_3
 */
public class DAOException extends Exception {

    /**
     * Constructor predeterminado de la excepción.
     */
    public DAOException() {
    }

    /**
     * Constructor que acepta un mensaje descriptivo para la excepción.
     *
     * @param string Mensaje descriptivo de la excepción.
     */
    public DAOException(String string) {
        super(string);
    }

    /**
     * Constructor que acepta un mensaje descriptivo y una causa (Throwable)
     * para la excepción.
     *
     * @param string Mensaje descriptivo de la excepción.
     * @param thrwbl Causa de la excepción.
     */
    public DAOException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    /**
     * Constructor que acepta una causa (Throwable) para la excepción.
     *
     * @param thrwbl Causa de la excepción.
     */
    public DAOException(Throwable thrwbl) {
        super(thrwbl);
    }
}
