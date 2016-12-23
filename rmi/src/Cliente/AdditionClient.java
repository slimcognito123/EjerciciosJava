package Cliente;

import beans.AdditionInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AdditionClient {
    public static void main(String[] args) {
        System.setProperty("java.security.policy", "file:///C:/Users/curso mañana/IdeaProjects/rmi/java.policy" );
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Addition";
            Registry registry = LocateRegistry.getRegistry("192.168.1.213", 1600);
            AdditionInterface stub = (AdditionInterface) registry.lookup(name);
            int result = stub.add(45, 24);
            System.out.println("Result is :" + result);
        } catch (Exception e) {
            System.out.println("Addition exception: " + e);
        }
    }
}