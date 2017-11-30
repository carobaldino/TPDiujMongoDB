package tpDiujMongoDB;


import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

/**
 * Java + MongoDB Hello world Example
 * 
 */
public class App {
	public static void main(String[] args) {		

		try {

			/** Conexión a MongoDB **/
			MongoClient mongo = new MongoClient("localhost", 27017);

			/** Crear-Obtener base de datos **/ // Si la base no existe, MongoDB la crea.
			DB tpDiujMongoDB = mongo.getDB("tpDiujMongoDB");
			
			System.out.println("La base de datos 'tpDiujMongoDB' está creda y conectada.");
			
			System.out.println("Creando tablas 'Empresas', 'Cuentas', 'Indicadores'...");
			
			/** Creación de colecciones (tablas) de la base "tpDiujMongoDB" **/ //Si la colección no existe, MongoDB la crea.

			DBCollection tablaEmpresas = tpDiujMongoDB.getCollection("Empresas");
			tablaEmpresas.drop();
			tablaEmpresas = tpDiujMongoDB.getCollection("Empresas");
			
			DBCollection tablaCuentas = tpDiujMongoDB.getCollection("Cuentas");
			tablaCuentas.drop();
			tablaCuentas = tpDiujMongoDB.getCollection("Cuentas");
			
			DBCollection tablaIndicadores = tpDiujMongoDB.getCollection("Indicadores");
			tablaIndicadores.drop();
			tablaIndicadores = tpDiujMongoDB.getCollection("Indicadores");
			
			System.out.println("Iniciando carga de datos...");
			
			Alta i = new Alta();
			i.inicializar(tablaEmpresas);
			i.inicializar(tablaCuentas);
			i.inicializar(tablaIndicadores);
			
			
			
			/** Lectura de elementos de una tabla**/
			System.out.println("Empresas:");
			
			DBCursor cursor1 = tablaEmpresas.find();
			while (cursor1.hasNext()) {
			   DBObject obj = cursor1.next();
			   System.out.println(obj);
			}
			
			System.out.println("Cuentas:");
			
			DBCursor cursor2 = tablaCuentas.find();
			while (cursor2.hasNext()) {
			   DBObject obj = cursor2.next();
			   System.out.println(obj);
			}
			
			System.out.println("Indicadores:");
			
			DBCursor cursor3 = tablaIndicadores.find();
			while (cursor3.hasNext()) {
			   DBObject obj = cursor3.next();
			   System.out.println(obj);
			}
		
			System.out.println("");
			System.out.println("");
			
		
			
		
			/** Encontrar y mostrar **/ 
			System.out.println("Busco entre las empresas a 'Facebook:'");
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("Nombre", "Facebook");

			DBCursor cursor = tablaEmpresas.find(searchQuery);

			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}

			
			/** Update **/
			System.out.println("");
			System.out.println("Busco entre las empresas a 'Arcor' y le cambio los valores:");
			System.out.println("Antes: ");
			//Busco a Arcor pars mostrar cómo estaba:
			BasicDBObject searchQuery1 = new BasicDBObject();
			searchQuery1.put("Nombre", "Arcor");

			DBCursor cursor4 = tablaEmpresas.find(searchQuery1);

			while (cursor4.hasNext()) {
				System.out.println(cursor4.next());
			}
			
		
			BasicDBObject query = new BasicDBObject();
			query.put("Nombre", "Arcor");

			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("Nombre", "ARCOR SA");

			BasicDBObject updateObj = new BasicDBObject();
			updateObj.put("$set", newDocument);

			tablaEmpresas.update(query, updateObj);
			
			System.out.println("Después: ");
			
			BasicDBObject searchQuery2 = new BasicDBObject();
			searchQuery2.put("Nombre", "ARCOR SA");

			DBCursor cursor5 = tablaEmpresas.find(searchQuery2);

			while (cursor5.hasNext()) {
				System.out.println(cursor5.next());
			}
			
			

			/**** Done ****/
			System.out.println("");
			System.out.println("Done");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}

	}


}
