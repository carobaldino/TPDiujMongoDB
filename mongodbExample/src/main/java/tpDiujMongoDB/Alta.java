package tpDiujMongoDB;



import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

public class Alta {
	
	public void inicializar(DBCollection tabla) {
		
		if (tabla.toString() == "Empresas"){
			
			/** Insert - PUT **/
			
			BasicDBObject documento = new BasicDBObject();
			
			documento.put("Nombre", "Arcor");
			documento.put("CUIT", 2133554534);
			documento.put("Fecha de formación", "14/02/2002");	
				
			tabla.insert(documento);
			
			documento = new BasicDBObject();
			
			documento.put("Nombre", "Empresa_nueva");
			documento.put("CUIT", 1122222221);
			documento.put("Fecha de formación", "02/06/1997");	
			
			tabla.insert(documento);
			
			documento = new BasicDBObject();
			
			documento.put("Nombre", "Facebook");
			documento.put("CUIT", 1200000006);
			documento.put("Fecha de formación", "09/12/1999");	
			
			tabla.insert(documento);
			
		}
		
		if (tabla.toString() == "Cuentas"){
			BasicDBObject documento = new BasicDBObject();
			
			documento.put("Período", 2000);
			documento.put("Empresa","Facebook");
			documento.put("Total en cuentas", 869504);	
				
			tabla.insert(documento);
			
			documento = new BasicDBObject();
			
			documento.put("Período", 2010);
			documento.put("Empresa", "Arcor");
			documento.put("Total en cuentas", 94589403);	
			
			tabla.insert(documento);
			
			documento = new BasicDBObject();
			
			documento.put("Período", 1998);
			documento.put("Empresa", "Arcor");
			documento.put("Total en cuentas", 9009845);	
			
			tabla.insert(documento);
			
			
		}
		
		if (tabla.toString() == "Indicadores"){
			
			BasicDBObject documento = new BasicDBObject();
			
			documento.put("Nombre", "ROE");
			documento.put("Fórmula", "Activo/Pasivo");
			
				
			tabla.insert(documento);
	
			
		}
	
	
	


			
			
			
	}
}
