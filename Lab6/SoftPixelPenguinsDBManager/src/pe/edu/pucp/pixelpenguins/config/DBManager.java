
package pe.edu.pucp.pixelpenguins.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import pe.edu.pucp.pixelpenguins.util.Cifrado;
import static pe.edu.pucp.pixelpenguins.util.Cifrado.descifrarMD5;

public class DBManager {
    private static DBManager dbManager;
    private String url = "jdbc:mysql://" +
    "softiepixelpenguins-1inf30-0682.cz2bk0coctwl.us-east-1.rds.amazonaws.com" + 
            ":3306/" + "softiepixelpenguins";
    private String usuario = "admin";
    private String password = "PddCHv14qTj7gQgQyfzMYB+bSmh6cTUNTBJLM7LGKzE=";
    private Connection con;
    
    // constructor privado para que no se pueda instanciar
    private DBManager(){};
    
    public static DBManager getInstance(){
        if(dbManager == null)
            createInstance();
        return dbManager;
    }
    
    private static void createInstance(){
        dbManager = new DBManager();
    }
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario,descifrarMD5(password));
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
}
