package Modelo.DAO.Contactos;

import Beans.Contacto;
import Beans.Usuario;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository(value = "contactoDAO")
public class ContactoDAOMongo implements ContactoDAO {
    private MongoClient mongoClient = new MongoClient();
    private MongoDatabase db = mongoClient.getDatabase("MonguiAgenda");
    private MongoCollection<Document> contactos = db.getCollection("contactos");
    @Override
    public Boolean borrarPersona(ObjectId _id) {

        return null;
    }

    @Override
    public void modificarPersona(Contacto contacto) {

    }

    @Override
    public ArrayList<Contacto> recuperarTodasLasPersonas(String mes, String usuario) {
    return new ArrayList<>();
    }

    @Override
    public ArrayList<ObjectId> recuperarTodasLasId(Usuario usuario) {
        return null;
    }

    @Override
    public Contacto recuperarPersona(ObjectId _id) {
        Document buscador = new Document();
        buscador.put("_id",_id);
        FindIterable<Document> documents=null;
        try{
            documents= contactos.find(buscador);
        }catch(Exception e){
            System.out.println("\033[35m"+e);
        }
        Contacto contacto = new Contacto();
        Document first = documents.first();
        String nombre = first.get("nombre", String.class);
        String apellidos = first.get("apellidos", String.class);
        String fechaNacimiento = first.get("fechaNacimiento", String.class);
        String telefono = first.get("telefono", String.class);
        String user = first.get("usuario", String.class);
        contacto = new Contacto(_id,nombre,apellidos,telefono,fechaNacimiento,user);
        return contacto;
    }

    @Override
    public void guardarPersona(Contacto contacto) {
        Document document = new Document();
        document.put("nombre", contacto.getNombre());
        document.put("apellidos", contacto.getApellidos());
        document.put("telefono", contacto.getTelefono());
        document.put("fechaNacimiento", contacto.getFecha());
        document.put("user", contacto.getUser());
        contactos.insertOne(document);
    }

    @Override
    public ArrayList<Contacto> recuperarTodasLasPersonas(String usuario) {

        FindIterable<Document> listaContactos = contactos.find();
        ArrayList<Contacto> resultados = new ArrayList<>();
        for (Document contacto : listaContactos) {
            ObjectId _id = contacto.get("_id", ObjectId.class);
            String nombre = contacto.get("nombre", String.class);
            String apellidos = contacto.get("apellidos", String.class);
            String telefono= contacto.get("telefono", String.class);
            String fecha= contacto.get("fechaNacimiento", String.class);
            String user= contacto.get("user", String.class);
            resultados.add(new Contacto(_id,nombre,apellidos,telefono,fecha,user));
        }
        System.out.println("\033[36m"+resultados.get(0).getNombre());
        return resultados;
    }
}
