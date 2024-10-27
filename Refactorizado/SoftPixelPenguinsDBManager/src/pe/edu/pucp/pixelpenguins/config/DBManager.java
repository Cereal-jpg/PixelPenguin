package pe.edu.pucp.pixelpenguins.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import static pe.edu.pucp.pixelpenguins.util.Cifrado.descifrarMD5;
import static pe.edu.pucp.pixelpenguins.util.Cifrado.cifrarMD5;
import static pe.edu.pucp.pixelpenguins.util.CifradoAux.cifrar;
import static pe.edu.pucp.pixelpenguins.util.CifradoAux.descifrar;

public class DBManager {
    
    private static final String ARCHIVO_CONFIGURACION = "jdbc.properties";
    private static DBManager dbManager = null;
    private String driver;
    private String tipo_de_driver;
    private String base_de_datos;
    private String nombre_de_host;
    private String puerto;
    private String username;
    private String password;
    private Connection con;
    
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
        leer_archivo_propiedades();
        try{
            Class.forName(this.driver);
            con = DriverManager.getConnection(getURL(), username, this.password);
            System.out.println(this.password);
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
    private String getURL(){
        String url = this.tipo_de_driver.concat("://");
        url = url.concat(this.nombre_de_host);
        url = url.concat(":");
        url = url.concat(this.puerto);
        url = url.concat("/");
        url = url.concat(this.base_de_datos);
        return url;
    }
    
    private void leer_archivo_propiedades(){
        Properties properties = new Properties();
        String nmArchivoConf = "resources/"+ARCHIVO_CONFIGURACION;
        try {
            properties.load(new FileInputStream(new File(nmArchivoConf)));
            this.driver = properties.getProperty("driver");
            this.tipo_de_driver = properties.getProperty("tipo_de_driver");
            this.base_de_datos = properties.getProperty("base_de_datos");
            this.nombre_de_host = properties.getProperty("nombre_de_host");
            this.puerto = properties.getProperty("puerto");
            this.username = properties.getProperty("usuario");
            this.password = properties.getProperty("contrasenha");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
    
}
