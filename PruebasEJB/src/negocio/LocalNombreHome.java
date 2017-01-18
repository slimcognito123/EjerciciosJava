package negocio;

/**
 * Created by curso mañana on 18/01/2017.
 */
public interface LocalNombreHome extends javax.ejb.EJBLocalHome {
    negocio.LocalNombre findByPrimaryKey(String key) throws javax.ejb.FinderException;
}
