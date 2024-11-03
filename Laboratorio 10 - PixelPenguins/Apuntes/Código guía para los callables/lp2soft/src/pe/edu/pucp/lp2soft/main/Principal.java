package pe.edu.pucp.lp2soft.main;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.lp2soft.rrhh.dao.AreaDAO;
import pe.edu.pucp.lp2soft.rrhh.dao.EmpleadoDAO;
import pe.edu.pucp.lp2soft.rrhh.model.Area;
import pe.edu.pucp.lp2soft.rrhh.model.Empleado;
import pe.edu.pucp.lp2soft.rrhh.mysql.AreaMySQL;
import pe.edu.pucp.lp2soft.rrhh.mysql.EmpleadoMySQL;
public class Principal {
    public static void main(String[] args){
        // Area a1 = new Area(1,"Ventas");
        
        
        
        // se listan áreas de las bases de datos (que ya deberían estar insertadas)
        AreaDAO daoArea=new AreaMySQL();
        ArrayList<Area> areas =daoArea.listar();
        for(Area a: areas){
            System.out.println(a);
        }
        Empleado emp = new Empleado("Karla Cordova","77771111",
        new Date(),21,'F',"Vendedor",1500.00,areas.get(0));
        // seteando un área a empleado
        // emp.setArea(areas.get(0));
        EmpleadoDAO daoEmpleado = new EmpleadoMySQL();
        if(daoEmpleado.insertar(emp)==1){
            System.out.println("Se ha registrado con exito");
        }
        else System.out.println("Ha ocurrido un error");
        
        // se ejecuta y debería funcionar...
        
        // Eliminando un área activa y pasándola a inactiva
        // daoArea.eliminar(areas.get(1).getIdArea());
        
        
    }
}
