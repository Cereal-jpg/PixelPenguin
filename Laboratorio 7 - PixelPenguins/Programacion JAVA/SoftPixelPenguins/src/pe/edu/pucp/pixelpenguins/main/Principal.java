
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

/*
    Proyecto creado por: PixelPeguins B)
*/

public class Principal {

    public static void main(String[] args) throws ParseException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        RolBO rolBO=new RolBO();
//        if(rolBO.insertar("Rol 1")==1) System.out.println("El rol fue agregado correctamente");
//        if(rolBO.insertar("Rol 2")==1) System.out.println("El rol fue agregado correctamente");
//        if(rolBO.insertar("Rol 3")==1) System.out.println("El rol fue agregado correctamente");
//        if(rolBO.insertar("Rol 4")==1) System.out.println("El rol fue agregado correctamente");
//        if(rolBO.modificar(1, "Rol -1")==1) System.out.println("El rol fue modificado correctamente");
//        if(rolBO.eliminar(2, "")==1) System.out.println("El rol fue eliminado correctamente");
//        ArrayList <Rol> roles = rolBO.listarTodos(); for(Rol r: roles) System.out.println(r.getNombre());
//        Rol rol =rolBO.obtenerPorId(5); System.out.println("Rol obtenido: " + rol.getNombre());

        InstitucionEducativaBO ieBO=new InstitucionEducativaBO();
//        if(ieBO.insertar("Institucion Prueba 1", 200, "Av. Bolivar", "20604816123")==1) System.out.println("La institucion educativa fue insertada correctamente");
//        if(ieBO.insertar("Institucion Prueba 2", 300, "Av. Random", "12332112344")==1) System.out.println("La institucion educativa fue insertada correctamente");
//        if(ieBO.modificar(1, "Hackeo nombre", 50, "Direccion falsa","11122233344")==1) System.out.println("La institucion educativa 1 fue modificada correctamente");
//        if(ieBO.eliminar(1, "", 0, "", "")==1) System.out.println("La institucion educativa 1 fue eliminada correctamente");
//        ArrayList<InstitucionEducativa> instituciones = ieBO.listarTodos(); for (InstitucionEducativa i: instituciones) System.out.println(i.getNombre());
//        InstitucionEducativa ie = ieBO.obtenerPorId(2); System.out.println("Institucion obtenida: " + ie.getNombre());

        AnioAcademicoBO anioBO=new AnioAcademicoBO();
        if(anioBO.insertar(2024, sdf.parse("10/03/2024"), sdf.parse("10/11/2024"))==1)
            System.out.println("El anio fue agregado correctamente");
        if(anioBO.insertar(2025, sdf.parse("10/03/2025"), sdf.parse("10/11/2025"))==1)
            System.out.println("El anio fue agregado correctamente");
        if(anioBO.insertar(2026, sdf.parse("10/03/2026"), sdf.parse("10/11/2026"))==1)
            System.out.println("El anio fue agregado correctamente");
        
    }
}
