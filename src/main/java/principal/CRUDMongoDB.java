package principal;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.awt.event.MouseMotionAdapter;

public class CRUDMongoDB {

    public static void main(String[] args) {
        MongoClient mongo = crearConexion();
        //sino existe la base de datos la creamos
        if (mongo !=null){
            DB db = mongo.getDB("prueba");
            System.out.println("base de datos creada");
            //crear coleccion(tabla) sino existe e
            // inserta el documento(registro) a la coleccionn
            insertUsuario(db,"usuarios","Sergio","Mexico");
            insertUsuario(db,"usuarios","Laura","Colombia");
            insertUsuario(db,"usuarios","Franco","Chile");
        }

    }


    private static MongoClient crearConexion() {

        System.out.println("prueba de conexion mongodb");

        MongoClient mongo = null;

        mongo= new MongoClient("localhost",27017);

        return mongo;
    }

    public static void insertUsuario(DB db, String coleccion, String nombre, String pais) {
        DBCollection colec = db.getCollection(coleccion);
        //crea el documento registro e inserta la informacion recibida
        BasicDBObject documento = new BasicDBObject();
        documento.put("nombre",nombre);
        documento.put("pais",pais);

        colec.insert(documento);

    }
}
