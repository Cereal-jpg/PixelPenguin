package pe.edu.pucp.lp2soft.rrhh.config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static DBManager dbManager;
    private String url = "jdbc:mysql://" + 
        "mysql-softiepixelpenguins-1inf30-682.cduaj8hcagsx.us-east-1.rds.amazonaws.com"+
            ":3306/"+"pixelPenguins";
    private String user = "admin";
    private String password = "1inf30softiepixelpenguins";
    private Connection con;
    
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
            con = DriverManager.getConnection(url, user, password);
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
}