package pe.edu.pucp.lp2soft.rrhh.mysql;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.lp2soft.rrhh.config.DBManager;
import pe.edu.pucp.lp2soft.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Area;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;
public class EmpleadoMySQL implements EmpleadoDAO{

    Connection con;
    ResultSet rs;
    CallableStatement cs;
    
    @Override
    public ArrayList<Empleado> listar() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.urlMySQL, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call LISTAR_EMPLEADOS()}");
            rs = cs.executeQuery();
            while(rs.next()){
                Empleado empleado = new Empleado();
                empleado.setIdPersona(rs.getInt("id_persona"));
                empleado.setNombreCompleto(rs.getString("nombre_completo"));
                empleado.setDNI(rs.getString("DNI"));
                empleado.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                empleado.setEdad(rs.getInt("edad"));
                empleado.setGenero(rs.getString("genero").charAt(0));
                empleado.setCargo(rs.getString("cargo"));
                empleado.setSueldo(rs.getDouble("sueldo"));
                empleado.setArea(new Area());
                empleado.getArea().setIdArea(rs.getInt("id_area"));
                empleado.getArea().setNombre(rs.getString("nombre_area"));
                empleado.setActivo(true);
                empleados.add(empleado);
            }
            rs.close();
            cs.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return empleados;
    }

    @Override
    public int insertar(Empleado empleado) {
        int resultado = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.urlMySQL, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call INSERTAR_EMPLEADO(?,?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_empleado", java.sql.Types.INTEGER);
            cs.setInt("_fid_area", empleado.getArea().getIdArea());
            cs.setString("_nombre_completo", empleado.getNombreCompleto());
            cs.setString("_DNI", empleado.getDNI());
            cs.setDate("_fecha_nacimiento", new java.sql.Date(empleado.getFechaNacimiento().getTime()));
            cs.setInt("_edad", empleado.getEdad());
            cs.setString("_genero", String.valueOf(empleado.getGenero()));
            cs.setString("_cargo", empleado.getCargo());
            cs.setDouble("_sueldo", empleado.getSueldo());
            cs.executeUpdate();
            empleado.setIdPersona(cs.getInt("_id_empleado"));
            resultado = 1;
            cs.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Empleado empleado) {
        int resultado = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.urlMySQL, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call MODIFICAR_EMPLEADO(?,?,?,?,?,?,?,?,?)}");
            cs.setInt("_id_empleado", empleado.getIdPersona());
            cs.setInt("_fid_area", empleado.getArea().getIdArea());
            cs.setString("_nombre_completo", empleado.getNombreCompleto());
            cs.setString("_DNI", empleado.getDNI());
            cs.setDate("_fecha_nacimiento", new java.sql.Date(empleado.getFechaNacimiento().getTime()));
            cs.setInt("_edad", empleado.getEdad());
            cs.setString("_genero", String.valueOf(empleado.getGenero()));
            cs.setString("_cargo", empleado.getCargo());
            cs.setDouble("_sueldo", empleado.getSueldo());
            cs.executeUpdate();
            resultado = 1;
            cs.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());};
        }
        return resultado;
    }

    @Override
    public int eliminar(int idEmpleado) {
        int resultado = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DBManager.urlMySQL, DBManager.user, DBManager.password);
            cs = con.prepareCall("{call ELIMINAR_EMPLEADO(?)}");
            cs.setInt("_id_empleado", idEmpleado);
            cs.executeUpdate();
            resultado = 1;
            cs.close();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());};
        }
        return resultado;
    }
    
}