
package pe.edu.pucp.pixelpenguins.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.bo.AnioAcademicoBO;
import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;
import pe.edu.pucp.pixelpenguins.institucioneducativa.bo.InstitucionEducativaBO;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;
import pe.edu.pucp.pixelpenguins.usuario.bo.RolBO;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;
public class Principal {

    public static void main(String[] args) throws ParseException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        RolBO rolBO=new RolBO();
//        rolBO.insertar("Rol 1");
//        rolBO.modificar(19, "Estudiante",false);
//        rolBO.eliminar(19);
//        Rol rol = rolBO.obtenerPorId(20);
//        System.out.println(rol.getIdRol());
//        System.out.println(rol.getNombre());
//        System.out.println(rol.isActivo());
//        ArrayList<Rol> roles = rolBO.listarTodos();
//        for(Rol rol: roles){
//            System.out.println(rol.getIdRol());
//            System.out.println(rol.getNombre());
//            System.out.println(rol.isActivo());
//        }


    }
}
