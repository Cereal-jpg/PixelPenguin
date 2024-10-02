
package pe.edu.pucp.pixelpenguins.curricula.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.dao.CursoDAO;
import pe.edu.pucp.pixelpenguins.curricula.daoImp.CursoDAOImp;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;

public class CursoBO {
    private CursoDAO cursoDAO;
    
    public CursoBO(){
        this.cursoDAO=new CursoDAOImp();
    }
    
    public int insertar(String codigoCurso, String nombre, int horasPorSemana, int horasTotales){
        Curso curso=new Curso(codigoCurso, nombre, horasPorSemana, horasTotales);
        return cursoDAO.insertar(curso);
    }
    
    public int modificar(int idCurso, String codigoCurso, String nombre, int horasPorSemana, int horasTotales){
        Curso curso=new Curso(idCurso, codigoCurso, nombre, horasPorSemana, horasTotales);
        return cursoDAO.modificar(curso);
    }
    
    public int eliminar(int idCurso, String codigoCurso, String nombre, int horasPorSemana, int horasTotales){
        Curso curso=new Curso(idCurso, codigoCurso, nombre, horasPorSemana, horasTotales);
        return cursoDAO.eliminar(curso);
    }
    
    public ArrayList<Curso> listarTodos(){
        return cursoDAO.listarTodos();
    }
    
    public Curso obtenerPorId(int id){
        return cursoDAO.obtenerPorId(id);
    }
}
