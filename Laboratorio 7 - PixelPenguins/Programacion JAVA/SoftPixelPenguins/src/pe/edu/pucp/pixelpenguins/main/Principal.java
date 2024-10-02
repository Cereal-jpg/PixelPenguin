
package pe.edu.pucp.pixelpenguins.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.bo.AnioAcademicoBO;
import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;
import pe.edu.pucp.pixelpenguins.curricula.bo.CursoBO;
import pe.edu.pucp.pixelpenguins.curricula.bo.GradoAcademicoBO;
import pe.edu.pucp.pixelpenguins.curricula.bo.JornadaEscolarBO;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.curricula.model.DiaSemana;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.JornadaEscolar;
import pe.edu.pucp.pixelpenguins.curricula.model.NivelEducativo;
import pe.edu.pucp.pixelpenguins.institucioneducativa.bo.InstitucionEducativaBO;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;
import pe.edu.pucp.pixelpenguins.usuario.bo.RolBO;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;

/*
    Proyecto creado por: PixelPeguins B)
*/

public class Principal {

    public static void main(String[] args) throws ParseException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
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
//        ArrayList<AnioAcademico> aniosAcademicos = anioBO.listarTodos(); 
//        for(AnioAcademico a: aniosAcademicos) System.out.println(a.getIdAnioAcademico()+"-"+a.getAnio());
//        AnioAcademico auxAnioAcademico= anioBO.obtenerPorId(4); System.out.println("Anio obtenido: "+ auxAnioAcademico.getAnio());

        GradoAcademicoBO gradoBO= new GradoAcademicoBO();
//        if(gradoBO.insertar(1, NivelEducativo.PRIMARIO, 60, 80, 1)==1)
//            System.out.println("El grado academico fue insertado correctamente");
//        if(gradoBO.insertar(2, NivelEducativo.PRIMARIO, 60, 90, 1)==1)
//            System.out.println("El grado academico fue insertado correctamente");
//        if(gradoBO.insertar(1, NivelEducativo.SECUNDARIO, 60, 80, 1)==1)
//            System.out.println("El grado academico fue insertado correctamente");
//        if(gradoBO.insertar(2, NivelEducativo.SECUNDARIO, 60, 90, 1)==1)
//            System.out.println("El grado academico fue insertado correctamente");
//        if(gradoBO.modificar(5, 4, NivelEducativo.PRIMARIO, 10, 30, 4)==1)
//            System.out.println("El grado academico fue modificado correctamente");
//        if(gradoBO.eliminar(3, 0, NivelEducativo.PRIMARIO, 0, 0, 0)==1)
//            System.out.println("El grado academico fue eliminado correctamente"); 
//        ArrayList<GradoAcademico> grados = gradoBO.listarTodos();
//        for(GradoAcademico auxGrado: grados){
//            String cadena=auxGrado.getIdGradoAcademico()+") "+auxGrado.getNumeroGrado()+"-";
//            for(AnioAcademico auxAnio: aniosAcademicos){
//                if(auxGrado.getIdAnioAcademicoRelacionado()==auxAnio.getIdAnioAcademico()){
//                    cadena += auxAnio.getAnio()+'\n';
//                    System.out.println(cadena);
//                    break;
//                }
//            }
//        }
//         GradoAcademico auxGrado=gradoBO.obtenerPorId(5);
//         System.out.println("El grado con ID = 5 es: " + auxGrado.getNumeroGrado());

        CursoBO cursoBO=new CursoBO();
//        if(cursoBO.insertar("1INF30", "Programacion 3", 4, 60)==1) System.out.println("El curso fue insertado correctamente");
//        if(cursoBO.insertar("1INF31", "ArquiSoft", 2, 30)==1) System.out.println("El curso fue insertado correctamente");
//        if(cursoBO.insertar("1LIN10", "Curso relleno", 2, 30)==1) System.out.println("El curso fue insertado correctamente");
//        if(cursoBO.modificar(3, "1LIN16", "Trabajo Academico", 3, 45)==1) System.out.println("El curso fue modificado correctamente");
//        if(cursoBO.eliminar(2, "", "", 0, 0)==1) System.out.println("El curso fue eliminado correctamente");
//        ArrayList<Curso> cursos=cursoBO.listarTodos(); for(Curso aux: cursos) System.out.println(aux.getNombre());
//        Curso auxCurso=cursoBO.obtenerPorId(3); System.out.println("El curso con ID = 3 es: " + auxCurso.getNombre());

        JornadaEscolarBO jornadaBO=new JornadaEscolarBO();
        GradoAcademico tempGrado=new GradoAcademico();
        tempGrado.setIdGradoAcademico(2);
//        if(jornadaBO.insertar(6, LocalTime.of(8,0), LocalTime.of(15,0), DiaSemana.LUNES, tempGrado)==1)
//            System.out.println("La jornada fue insertada correctamente");
//        if(jornadaBO.insertar(6, LocalTime.of(15,0), LocalTime.of(21,0), DiaSemana.MARTES, tempGrado)==1)
//            System.out.println("La jornada fue insertada correctamente");
//        if(jornadaBO.modificar(2, 7, LocalTime.of(10,0), LocalTime.of(17,0), DiaSemana.MIERCOLES, tempGrado)==1)
//            System.out.println("La jornada fue modificada correctamente");
//        if(jornadaBO.eliminar(2, 0, LocalTime.of(0,0), LocalTime.of(0,0), DiaSemana.LUNES, tempGrado)==1)
//            System.out.println("La jornada fue eliminada correctamente");
//        ArrayList <JornadaEscolar> jornadas = jornadaBO.listarTodos();
//        for(JornadaEscolar auxJor: jornadas) System.out.println(auxJor.getDia().toString());
//        JornadaEscolar auxJornadaEscolar = jornadaBO.obtenerPorId(1); 
//        System.out.println("La jornada con ID = 1 corresponde al dia: " + auxJornadaEscolar.getDia().toString());
    }
}
