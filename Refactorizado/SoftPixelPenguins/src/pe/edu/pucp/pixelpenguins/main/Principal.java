
package pe.edu.pucp.pixelpenguins.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.bo.AnioAcademicoBO;
import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;
import pe.edu.pucp.pixelpenguins.config.DBManager;
import pe.edu.pucp.pixelpenguins.curricula.bo.GradoAcademicoBO;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.NivelEducativo;
import pe.edu.pucp.pixelpenguins.usuario.bo.AlumnoBO;
import pe.edu.pucp.pixelpenguins.usuario.bo.ApoderadoBO;
import pe.edu.pucp.pixelpenguins.usuario.bo.RolBO;
import pe.edu.pucp.pixelpenguins.usuario.bo.UsuarioBO;
import pe.edu.pucp.pixelpenguins.usuario.model.Alumno;
import pe.edu.pucp.pixelpenguins.usuario.model.Apoderado;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;
import pe.edu.pucp.pixelpenguins.util.Cifrado;

public class Principal {

    public static void main(String[] args) throws ParseException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
//        AnioAcademicoBO anioBO = new AnioAcademicoBO();
//        if(anioBO.insertar(2025, sdf.parse("2025-03-14"), sdf.parse("2025-11-10"))!=0)
//            System.out.println("El anio academico fue insertado correctamente");
//        if(anioBO.modificar(1,2026, sdf.parse("2026-03-14"), sdf.parse("2026-11-10"))!=0)
//            System.out.println("El anio academico fue modificado correctamente");
//        String prueba=Cifrado.descifrarMD5("Fi2ehKwkNK/vyG9ZtsV/NG17zoM7l9Zl1qMHzitTmvQ=");
//        System.out.println(prueba);
        DBManager.getInstance().getConnection();
        System.out.println(DBManager.getInstance());
        ApoderadoBO apoderadoBO= new ApoderadoBO();
//        if(apoderadoBO.insertar("1234", "Juan Perez", "999888777", "Padre")!=0)
//            System.out.println("El apoderado se inserto correctamente");
        ArrayList<Apoderado> apoderados=apoderadoBO.listarTodos();
//        for(Apoderado aux:apoderados){
//            System.out.println(aux.getDni());
//        }
        
        GradoAcademicoBO gradoBO=new GradoAcademicoBO();
//        if(gradoBO.insertar(2, NivelEducativo.PRIMARIO, 60, 90, 1)!=0)
//            System.out.println("El grado academico se inserto correctamente");
        ArrayList<GradoAcademico> grados=gradoBO.listarTodos();
        RolBO rolBO=new RolBO();
//        rolBO.insertar("Estudiante");
//        rolBO.insertar("Profesor");
//        if(rolBO.insertar("P. Admin.")!=0)
//            System.out.println("El rol se inserto correctamente");
        ArrayList<Rol> roles=rolBO.listarTodos();
        for(Rol aux:roles)
            System.out.println(aux.getNombre());
        UsuarioBO usuarioBO=new UsuarioBO();
        System.out.println(usuarioBO.obtenerPorId(1).getNombreCompleto());
        AlumnoBO alumnoBO=new AlumnoBO();
        ArrayList<Alumno> alumnos=alumnoBO.listarTodos();
        for(Alumno alu:alumnos)
            System.out.println(alu.getIdUsuario());
//        if(usuarioBO.insertar("12346", "Manuel Perez", sdf.parse("10-05-2005"), "Av. prueba", "manuel@pucp.edu.pe", "Masculino", "a12345", "password", roles.get(0))!=0)
//            System.out.println("El usuario fue insertado correctamente");
//        AlumnoBO alumnoBO=new AlumnoBO();
//        if(alumnoBO.insertar(2022, true, true, true, apoderados.get(0),grados.get(0),"12346","Manuel Perez",sdf.parse("10-15-2005"),"Av. prueba", "manuel@pucp.edu.pe","Masculino","a12345","password", roles.get(0))!=0)
//            System.out.println("El alumno fue insertado correctamente");
//        if(alumnoBO.modificar(2023, true, true, false, apoderados.get(1) , grados.get(0) ,3, "12346","Manuel Perez",sdf.parse("10-15-2005"),"Av. prueba", "manuel@pucp.edu.pe","Masculino","a12345","password", roles.get(0))!=0)
//            System.out.println("El alumno fue modificado correctamente");
//        if(usuarioBO.insertar("12347","Manuel Lopez",sdf.parse("10-20-2005"),"Av. prueba2", "manuel2@pucp.edu.pe","Masculino","a12346","password2", roles.get(0))!=0)
//            System.out.println("El usuario fue insertado correctamente");
//        if(alumnoBO.insertar(2024, true, true, true, apoderados.get(0),grados.get(0),"12347","Manuel Lopez",sdf.parse("10-20-2005"),"Av. prueba2", "manuel2@pucp.edu.pe","Masculino","a12346","password2", roles.get(0))!=0)
//            System.out.println("El alumno fue insertado correctamente");
        if(alumnoBO.eliminar(4)!=0)
            System.out.println("El alumno fue eliminado correctamente");
    }
}
