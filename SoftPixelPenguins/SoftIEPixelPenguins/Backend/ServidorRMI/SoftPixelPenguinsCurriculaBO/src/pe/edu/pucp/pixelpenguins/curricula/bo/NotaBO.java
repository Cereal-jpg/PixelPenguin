package pe.edu.pucp.pixelpenguins.curricula.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.dao.NotaDAO;
import pe.edu.pucp.pixelpenguins.curricula.daoImp.NotaDAOImpl;
import pe.edu.pucp.pixelpenguins.curricula.model.Nota;

public class NotaBO {
    
    private NotaDAO notaDAO;

    public NotaBO() {
        this.notaDAO = new NotaDAOImpl();
    }

    public Integer insertar(Nota nota) {
        return this.notaDAO.insertar(nota);
    }
    
    public Integer modificar(Nota nota) {
        return this.notaDAO.modificar(nota);
    }

    public Integer eliminar(Nota nota) {
        return this.notaDAO.eliminar(nota);
    }

    public ArrayList<Nota> listarTodos() {
        return this.notaDAO.listarTodos();
    }

    public Nota obtenerPorId(Integer idNota) {
        return this.notaDAO.obtenerPorId(idNota);
    }
    
    public ArrayList<Nota> listarPorAlumnoYCurso(Integer idAlumno,Integer idCurso){
        return this.notaDAO.listarPorAlumnoYCurso(idAlumno, idCurso);
    }
    
    public ArrayList<Nota> listarPorAlumnoCursoYBimestre(Integer idAlumno,
            Integer idCurso, Integer bimestre){
        return this.notaDAO.listarPorAlumnoCursoYBimestre(idAlumno, idCurso, bimestre);
    }
    
    public Nota obtenerNotaPorParametros(Integer idMatricula, Integer idAlumno,Integer idCurso,
            Integer bimestre,Integer idCompetencia){
        return this.notaDAO.obtenerNotaPorParametros(idMatricula, idAlumno, idCurso, bimestre, idCompetencia);
    }
}
