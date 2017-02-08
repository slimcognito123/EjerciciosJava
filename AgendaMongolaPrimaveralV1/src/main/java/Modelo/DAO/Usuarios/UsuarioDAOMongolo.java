package Modelo.DAO.Usuarios;

import Beans.Usuario;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Repository;

@Repository(value = "usuarioDAO")
public class UsuarioDAOMongolo {
    private MongoClient mongoClient = new MongoClient("localhost",27017 );
    private MongoDatabase db = mongoClient.getDatabase("MonguiAgenda");
    private MongoCollection<Document> usuarios = db.getCollection("user");

    public boolean comprobarUser(String user, String pass) {
        Document searchQuery = new Document();
        searchQuery.put("name", user);
        searchQuery.put("password",pass);
        FindIterable<Document> documents=null;
        try{
            documents= usuarios.find(searchQuery);
        }catch(Exception e){
            System.out.println("\033[35m"+e);
        }

        if(documents.first().get("name")!=null) {
            return true;
        }
        return false;
    }

    public void insertarUsuario(Usuario user) {
        Document document = new Document();
        document.put("name", user.getNombre());
        document.put("password", user.getPassword());
        usuarios.insertOne(document);
    }

    public boolean buscarUsuarioRepetido(String usuario) {

        Document searchQuery = new Document();
        searchQuery.put("name", usuario);
        FindIterable<Document> documents=null;
        try{
            documents= usuarios.find(searchQuery);
        }catch(Exception e){
            System.out.println("\033[35m"+e);
        }
        if(documents.first()!=null) {
            return true;
        }
        return false;
    }
}
