
package pe.edu.pucp.pixelpenguins.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static pe.edu.pucp.pixelpenguins.util.Cifrado.descifrarMD5;

public class DBManager {
    
    private static DBManager dbManager;
    /*private String url = "jdbc:mysql://" +
    "softiepixelpenguins-1inf30-0682.cz2bk0coctwl.us-east-1.rds.amazonaws.com" + 
            ":3306/" + "softiepixelpenguins";*/
    private String url = "jdbc:mysql://" +
    "mysql-softiepixelpenguins-1inf30-682.cduaj8hcagsx.us-east-1.rds.amazonaws.com" + 
            ":3306/" + "pixelPenguins";
    private String username = "admin";
    private String password = "1inf30softiepixelpenguins";
    private Connection con;
    
    // para que no se pueda instanciar y se use necesariamente el getInstance()
    private DBManager(){};
    
    public static DBManager getInstance(){
        if(DBManager.dbManager == null)
            createInstance();
        return DBManager.dbManager;
    }
    
    private static void createInstance(){
        DBManager.dbManager = new DBManager();
    }
    
    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username,password);
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
}
