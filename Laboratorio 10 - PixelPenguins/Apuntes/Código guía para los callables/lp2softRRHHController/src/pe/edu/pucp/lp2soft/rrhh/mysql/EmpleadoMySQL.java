package pe.edu.pucp.lp2soft.rrhh.mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.lp2soft.rrhh.config.DBManager;
import pe.edu.pucp.lp2soft.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;
public class EmpleadoMySQL implements EmpleadoDAO{

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private CallableStatement cs;
    public ArrayList<Empleado> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertar(Empleado empleado) {
        int resultado = 0;
        try{
            //Establecemos la conexion
            con = DBManager.getInstance().getConnection();
            /*
            //Creamos un Statement
            st = con.createStatement();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            //Instrucción SQL
            String instruccionSQL = "INSERT INTO persona(nombre_completo,"
                    + "DNI,fecha_nacimiento,edad,genero) VALUES("
                    + "'"+ empleado.getNombreCompleto() +"','" + 
                    empleado.getDNI() +"','" + 
                    formato.format(empleado.getFechaNacimiento()) + "',"
                    + empleado.getEdad() + ",'"+ empleado.getGenero()+"')";
            //Ejecutamos la instrucción
            resultado = st.executeUpdate(instruccionSQL); //hasta acá inserta en Persona
            //Select para saber el ID que ha generado el insert, con ese insertamos el empleado
            instruccionSQL="SELECT @@last_insert_id as ID";
            // el resultado se va a colocar en una columna llamada ID
            rs=st.executeQuery(instruccionSQL);
            rs.next();
            // obteniendo el ID generado
            empleado.setIdPersona(rs.getInt("ID"));
            rs.close();
            instruccionSQL="INSERT INTO empleado(id_empleado,fid_area,cargo,sueldo)"
                    + "VALUES("+empleado.getIdPersona()+","+
                    // a través de la navegación, podemos obtener el id del área correspondiente al empleado
                    empleado.getArea().getIdArea()+","+empleado.getCargo()+","+
                    empleado.getCargo()+","+empleado.getSueldo()+")";
            st.executeUpdate(instruccionSQL);
            */
            cs = con.prepareCall("{call INSERTAR_EMPLEADO(?,?,?,?,?,?,?,?,?)}"); //recibe 9 parámetros según nuestro script
            // registrando parámetro de salida y su tipo
            cs.registerOutParameter("p_id_empleado", java.sql.Types.INTEGER);
            // los siguientes parámetros son los de entrada
            cs.setInt("p_fid_area", empleado.getArea().getIdArea());
            cs.setString("p_nombre_completo",empleado.getNombreCompleto());
            cs.setString("p_DNI",empleado.getDNI());
            // los Date se tienen que castear
            cs.setDate("p_fecha_nacimiento", new java.sql.Date(empleado.getFechaNacimiento().getTime()));
            cs.setInt("p_edad", empleado.getEdad());
            // como es char, se convierte a String con valueOf
            cs.setString("p_genero", String.valueOf(empleado.getGenero()));
            cs.setString("p_cargo", empleado.getCargo());
            cs.setDouble("p_sueldo", empleado.getSueldo());
            // una vez seteados, ejecutamos
            cs.executeUpdate();
            // una vez que ya se ejecutó el Callable Statemente,
            // este ya tiene el parámetro de id_empleado, se captura y se envía
            // al objeto Empleado
            empleado.setIdPersona(cs.getInt("p_id_empleado"));
            // si llega al final obtiene el valor de 1
            resultado=1;
            // Cerrar la conexion
            con.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try {con.close();} catch (SQLException ex) {
                Logger.getLogger(EmpleadoMySQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    @Override
    public int modificar(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(int idEmpleado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
