package pe.edu.pucp.pixelpenguins.anioacademico.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.dao.CursoXMatriculaDAO;
import pe.edu.pucp.pixelpenguins.anioacademico.daoImp.CursoXMatriculaDAOImpl;
import pe.edu.pucp.pixelpenguins.anioacademico.model.CursoXMatricula;

public class CursoXMatriculaBO {
    
    private CursoXMatriculaDAO cursoXMatriculaDAO;
    
    public CursoXMatriculaBO(){
        this.cursoXMatriculaDAO=new CursoXMatriculaDAOImpl();
    }
    
    public Integer insertar(CursoXMatricula cursoXMatricula){
        return this.cursoXMatriculaDAO.insertar(cursoXMatricula);
    }
    
    public Integer modificar(CursoXMatricula cursoXMatricula){
        return this.cursoXMatriculaDAO.modificar(cursoXMatricula);
    }
    
    public Integer eliminar(CursoXMatricula cursoXMatricula){
        return this.cursoXMatriculaDAO.eliminar(cursoXMatricula);
    }
    
    public ArrayList<CursoXMatricula> listarTodos(){
        return this.cursoXMatriculaDAO.listarTodos();
    }
    
    public CursoXMatricula obtenerPorCursoYMatricula(Integer idCurso, Integer idMatricula){
        return this.cursoXMatriculaDAO.obtenerPorCursoYMatricula(idCurso, idMatricula);
    }
    
    public ArrayList<CursoXMatricula> listarNotasFinalesCursosXMatricula (Integer idMatricula){
        return this.cursoXMatriculaDAO.listarNotasFinalesCursosXMatricula(idMatricula);
    }
    
    public ArrayList<CursoXMatricula> listarNotasFinalesCursosXAlumno (Integer idAlumno){
        return this.cursoXMatriculaDAO.listarNotasFinalesCursosXAlumno(idAlumno);
    }
    
    public ArrayList<CursoXMatricula> listarNotasFinalesXCurso (Integer idCurso){
        return this.cursoXMatriculaDAO.listarNotasFinalesXCurso(idCurso);
    }
}
