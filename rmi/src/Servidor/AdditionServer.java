package Servidor;

import beans.AdditionInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class AdditionServer {
    public static void main(String[] argv) {
        //System.setProperty("java.rmi.Servidor.codebase", "file:///C:/Users/Victor/workspace/ServerSide/bin/");
        System.setProperty("java.rmi.Servidor.codebase", "file:///C:/Users/curso mañana/IdeaProjects/rmi/src/Servidor/");
        System.setProperty("java.security.policy", "file:///C:\\Users\\curso20%mañana\\IdeaProjects\\rmi\\java.policy");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Addition";
            Addition add = new Addition();
            AdditionInterface skeleton = (AdditionInterface) UnicastRemoteObject.exportObject(add, 0);
            //Registry registry = LocateRegistry.createRegistry(1059);//<- registry local
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1600);
            registry.rebind(name, skeleton);
            System.out.println("Addition Server is ready.");
        } catch (Exception e) {
            System.out.println("Addition Server failed: " + e);
        }
    }
}
