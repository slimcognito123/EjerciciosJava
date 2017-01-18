package negocio;

import java.rmi.RemoteException;

/**
 * Created by curso mañana on 18/01/2017.
 */
public interface NombreHome extends javax.ejb.EJBHome {
    negocio.Nombre findByPrimaryKey(String key) throws RemoteException, javax.ejb.FinderException;
}
