
package pe.edu.pucp.pixelpenguins.test;

import pe.edu.pucp.pixelpenguins.config.DBManager;
import java.sql.Connection;

public class pruebaCifrado {
    public static void main(String[] args) {
        //DBManager dbManager = new DBManager();
        DBManager dbManager = null;
        System.out.println(dbManager);
        dbManager = DBManager.getInstance();
        System.out.println(dbManager);
        dbManager = DBManager.getInstance();
        System.out.println(dbManager);
        dbManager = DBManager.getInstance();
        System.out.println(dbManager);
        Connection conexion = dbManager.getConnection();    
        // comprobamos que se conecta bien 
    }
}
