package Servidor;

import beans.AdditionInterface;

import java.rmi.RemoteException;

public class Addition implements AdditionInterface {
    @Override
    public int add(int i, int j) throws RemoteException {
        return i + j;
    }
}
