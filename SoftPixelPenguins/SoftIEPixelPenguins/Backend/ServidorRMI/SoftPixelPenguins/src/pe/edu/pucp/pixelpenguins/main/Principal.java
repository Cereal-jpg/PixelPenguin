
package pe.edu.pucp.pixelpenguins.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.bo.AnioAcademicoBO;
import pe.edu.pucp.pixelpenguins.anioacademico.bo.CursoXMatriculaBO;
import pe.edu.pucp.pixelpenguins.anioacademico.bo.MatriculaBO;
import pe.edu.pucp.pixelpenguins.anioacademico.bo.PagoBO;
import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;
import pe.edu.pucp.pixelpenguins.anioacademico.model.CursoXMatricula;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Pago;
import pe.edu.pucp.pixelpenguins.config.DBManager;
import pe.edu.pucp.pixelpenguins.curricula.bo.CompetenciaBO;
import pe.edu.pucp.pixelpenguins.curricula.bo.CursoBO;
import pe.edu.pucp.pixelpenguins.curricula.bo.GradoAcademicoBO;
import pe.edu.pucp.pixelpenguins.curricula.bo.NotaBO;
import pe.edu.pucp.pixelpenguins.curricula.model.Competencia;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.NivelEducativo;
import pe.edu.pucp.pixelpenguins.curricula.model.Nota;
import pe.edu.pucp.pixelpenguins.usuario.bo.AlumnoBO;
import pe.edu.pucp.pixelpenguins.usuario.bo.ApoderadoBO;
import pe.edu.pucp.pixelpenguins.usuario.bo.RolBO;
import pe.edu.pucp.pixelpenguins.usuario.bo.UsuarioBO;
import pe.edu.pucp.pixelpenguins.usuario.model.Alumno;
import pe.edu.pucp.pixelpenguins.usuario.model.Apoderado;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;
import pe.edu.pucp.pixelpenguins.usuario.model.Usuario;
import pe.edu.pucp.pixelpenguins.util.Cifrado;

public class Principal {

    public static void main(String[] args) throws ParseException{
        
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        
//        AnioAcademicoBO anioBO = new AnioAcademicoBO();
//        if(anioBO.insertar(2025, sdf.parse("2025-03-14"), sdf.parse("2025-11-10"))!=0)
//            System.out.println("El anio academico fue insertado correctamente");
//        if(anioBO.modificar(1,2026, sdf.parse("2026-03-14"), sdf.parse("2026-11-10"))!=0)
//            System.out.println("El anio academico fue modificado correctamente");
//        String prueba=Cifrado.descifrarMD5("Fi2ehKwkNK/vyG9ZtsV/NG17zoM7l9Zl1qMHzitTmvQ=");
//        System.out.println(prueba);
//        ApoderadoBO apoderadoBO= new ApoderadoBO();
//        if(apoderadoBO.insertar("1234", "Juan Perez", "999888777", "Padre")!=0)
//            System.out.println("El apoderado se inserto correctamente");
//        ArrayList<Apoderado> apoderados=apoderadoBO.listarTodos();
//        for(Apoderado aux:apoderados){
//            System.out.println(aux.getDni());
//        }
        
//        GradoAcademicoBO gradoBO=new GradoAcademicoBO();
//        if(gradoBO.insertar(2, NivelEducativo.PRIMARIO, 60, 90, 1)!=0)
//            System.out.println("El grado academico se inserto correctamente");
//        ArrayList<GradoAcademico> grados=gradoBO.listarTodos();
//        for(GradoAcademico aux:grados)
//            System.out.println(aux.getNumeroGrado());
        

//        ArrayList<Nota> notas=notaBO.listarPorAlumnoYCurso(31, 1);
//        for(Nota aux: notas)
//            System.out.println(aux.getNota());
        CursoBO cursoBO=new CursoBO();
//        CompetenciaBO competenciaBO=new CompetenciaBO();
//        NotaBO notaBO=new NotaBO();
//        ArrayList<Curso> cursos=cursoBO.listarCursosPorGrado(3);
//        for(Curso aux:cursos){
//            ArrayList<Competencia> competencias=competenciaBO.listarCompetenciasPorCurso(aux.getIdCurso());
//            for(Competencia aux2:competencias){
//                for(int i=1;i<=4;i++){
//                    Nota nota =new Nota();
//                    nota.setFid_Matricula(12);
//                    nota.setFid_Alumno(51);
//                    nota.setNota("-");
//                    nota.setBimestre(i);
//                    nota.setCurso(aux);
//                    nota.setCompetencia(aux2);
//                    if(notaBO.insertar(nota)!=0)
//                        System.out.println(aux.getCodigoCurso()+"-"+aux2.getDescripcion()+" Insertado");
//                }
//            }
//        }
//         MatriculaBO matriculaBO = new MatriculaBO();
//         CursoXMatriculaBO cursoXMatriculaBO = new CursoXMatriculaBO();
//         Curso curso=cursoBO.obtenerPorId(1);
//         Matricula matricula=matriculaBO.obtenerPorId(2);
//         CursoXMatricula cursoXMatricula= new CursoXMatricula(curso, matricula, 33, "A", "A", "A", "A", "A");
//         if(cursoXMatriculaBO.insertar(cursoXMatricula)!=0){
//             System.out.println("Las notas finales fueron insertadas con exito");
//         }
//        MatriculaBO matriculaBO=new MatriculaBO();
//        Matricula matricula=matriculaBO.obtenerPorId(12);

//        PagoBO pagoBO=new PagoBO();
//        Pago auxPago=pagoBO.PagoXAlumnos(1);
//        System.out.println(auxPago.getEstado());
//        
//        ArrayList<Pago> pagos = pagoBO.listarTodosPorIdMatricula(1);
//        System.out.println(pagos.get(0).getFechaPago());
//        
//        ArrayList<Pago>datos =pagoBO.listarTodosPorGrado(1);
//        
//        System.out.println(datos.get(0).getEstado());
//        CursoBO cursoBO=new CursoBO();
//        ArrayList<Curso> cursos=cursoBO.listarCursosPorProfesor(8);
//        for(Curso aux:cursos)
//            System.out.println(aux.getCodigoCurso());
        
//        RolBO rolBO=new RolBO();
//        rolBO.insertar("Estudiante");
//        rolBO.insertar("Profesor");
//        if(rolBO.insertar("P. Admin.")!=0)
//            System.out.println("El rol se inserto correctamente");
//        ArrayList<Rol> roles=rolBO.listarTodos();
//        for(Rol aux:roles)
//            System.out.println(aux.getNombre());
        //UsuarioBO usuarioBO=new UsuarioBO();
//        for(Usuario u : usuarioBO.listarTodos()){
//            System.out.println(u.getNombreCompleto());
//        }
//        if(usuarioBO.insertar("12346", "Manuel Perez", sdf.parse("10-05-2005"), "Av. prueba", "manuel@pucp.edu.pe", "Masculino", "a12345", "password", roles.get(0))!=0)
//            System.out.println("El usuario fue insertado correctamente");
        //int id = usuarioBO.ActualizarContrasena("manuel@pucp.edu.pe", "ola123");
//        PagoBO pagoBO = new PagoBO();
//        
//        Pago prueba;
//        prueba = pagoBO.PagoXAlumnos(6);
//        
//        
//        System.out.println(prueba.getEstado());
//            MatriculaBO matri = new MatriculaBO();
//            int id = matri.obtenerPorIdAlumno(20);
//            System.out.println(id);
//        NotaBO no = new NotaBO();
//        Nota nota = no.obtenerNotaPorParametros(31, 1, 1, 2);
//        
//        System.out.println(nota.getIdNota());

    }
}
