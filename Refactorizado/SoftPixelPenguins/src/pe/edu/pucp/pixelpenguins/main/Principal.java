
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
        rolBO.modificar(19, "Estudiante",false);

        InstitucionEducativaBO ieBO=new InstitucionEducativaBO();
//        if(ieBO.insertar("Institucion Prueba 1", 200, "Av. Bolivar", "20604816123")==1) System.out.println("La institucion educativa fue insertada correctamente");
//        if(ieBO.insertar("Institucion Prueba 2", 300, "Av. Random", "12332112344")==1) System.out.println("La institucion educativa fue insertada correctamente");
//        if(ieBO.modificar(1, "Hackeo nombre", 50, "Direccion falsa","11122233344")==1) System.out.println("La institucion educativa 1 fue modificada correctamente");
//        if(ieBO.eliminar(1, "", 0, "", "")==1) System.out.println("La institucion educativa 1 fue eliminada correctamente");
//        ArrayList<InstitucionEducativa> instituciones = ieBO.listarTodos(); for (InstitucionEducativa i: instituciones) System.out.println(i.getNombre());
//        InstitucionEducativa ie = ieBO.obtenerPorId(2); System.out.println("Institucion obtenida: " + ie.getNombre());

        AnioAcademicoBO anioBO=new AnioAcademicoBO();
//        if(anioBO.insertar(2024, sdf.parse("2024-03-10"), sdf.parse("2024-11-10"))==1)
//            System.out.println("El anio fue agregado correctamente");
//        if(anioBO.insertar(2025, sdf.parse("2025-03-10"), sdf.parse("2025-11-10"))==1)
//            System.out.println("El anio fue agregado correctamente");
//        if(anioBO.insertar(2026, sdf.parse("2026-03-10"), sdf.parse("2026-11-10"))==1)
//            System.out.println("El anio fue agregado correctamente");
//        if(anioBO.insertar(2027, sdf.parse("2027-03-10"), sdf.parse("2027-11-10"))==1)
//            System.out.println("El anio fue agregado correctamente");
//        if(anioBO.modificar(3, 2030, sdf.parse("2030-03-10"), sdf.parse("2030-11-10"))==1)
//            System.out.println("El anio fue modificado correctamente");
//        if(anioBO.eliminar(3, 2030, sdf.parse("2030-03-10"), sdf.parse("2030-11-10"))==1)
//            System.out.println("El anio fue eliminado correctamente");
//        ArrayList<AnioAcademico> aniosAcademicos = anioBO.listarTodos(); for(AnioAcademico a: aniosAcademicos) System.out.println(a.getAnio());
//        AnioAcademico auxAnioAcademico= anioBO.obtenerPorId(4); System.out.println("Anio obtenido: "+ auxAnioAcademico.getAnio());

        
    }
}
