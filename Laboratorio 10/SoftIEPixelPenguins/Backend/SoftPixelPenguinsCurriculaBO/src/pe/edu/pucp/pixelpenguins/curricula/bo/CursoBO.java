package pe.edu.pucp.pixelpenguins.curricula.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.dao.CursoDAO;
import pe.edu.pucp.pixelpenguins.curricula.daoImp.CursoDAOImpl;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;

public class CursoBO {
    private CursoDAO cursoDAO;
    
    public CursoBO(){
        this.cursoDAO=new CursoDAOImpl();
    }
    
    public Integer insertar(String codigoCurso, String nombre, int horasPorSemana, int horasTotales,
            GradoAcademico gradoAcademico){
        Curso curso=new Curso(codigoCurso, nombre, horasPorSemana, horasTotales,gradoAcademico);
        return cursoDAO.insertar(curso);
    }
    
    public Integer insertar(Curso curso){
        return cursoDAO.insertar(curso);
    }
    
    public Integer modificar(int idCurso, String codigoCurso, String nombre, int horasPorSemana, int horasTotales,
            GradoAcademico gradoAcademico){
        Curso curso=new Curso(idCurso, codigoCurso, nombre, horasPorSemana, horasTotales,gradoAcademico);
        return cursoDAO.modificar(curso);
    }
    
    public Integer modificar(Curso curso){
        return cursoDAO.modificar(curso);
    }
    
    public Integer eliminar(int idCurso, String codigoCurso, String nombre, int horasPorSemana, int horasTotales,
            GradoAcademico gradoAcademico){
        Curso curso=new Curso(idCurso, codigoCurso, nombre, horasPorSemana, horasTotales,gradoAcademico);
        return cursoDAO.eliminar(curso);
    }
    
    public Integer eliminar(Curso curso){
        return cursoDAO.eliminar(curso);
    }
    
    public ArrayList<Curso> listarTodos(){
        return cursoDAO.listarTodos();
    }
    
    public Curso obtenerPorId(Integer idCurso){
        return cursoDAO.obtenerPorId(idCurso);
    }
    
   public ArrayList<Curso> listarCursosPorGrado(Integer idGradoAcademico){
       return cursoDAO.listarCursosPorGrado(idGradoAcademico);
   }
}
