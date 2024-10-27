package pe.edu.pucp.pixelpenguins.curricula.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.curricula.dao.NotaDAO;
import pe.edu.pucp.pixelpenguins.curricula.daoImp.NotaDAOImpl;
import pe.edu.pucp.pixelpenguins.curricula.model.Competencia;
import pe.edu.pucp.pixelpenguins.curricula.model.Curso;
import pe.edu.pucp.pixelpenguins.curricula.model.Nota;

public class NotaBO {
    
    private NotaDAO notaDAO;

    public NotaBO() {
        this.notaDAO = new NotaDAOImpl();
    }

    public Integer insertar(Integer bimestre, String nota, Integer idCurso, Integer idCompetencia) {
        Nota nuevaNota = this.crearNota(bimestre, nota, idCurso, idCompetencia);
        return this.notaDAO.insertar(nuevaNota);
    }

    public Integer modificar(Integer idNota, Integer bimestre, String nota, Integer idCurso, Integer idCompetencia) {
        Nota notaModificada = this.crearNota(bimestre, nota, idCurso, idCompetencia);
        notaModificada.setIdNota(idNota);
        return this.notaDAO.modificar(notaModificada);
    }

    public Integer eliminar(Integer idNota) {
        Nota notaAEliminar = new Nota();
        notaAEliminar.setIdNota(idNota);
        return this.notaDAO.eliminar(notaAEliminar);
    }

    public ArrayList<Nota> listarTodos() {
        return this.notaDAO.listarTodos();
    }

    public Nota obtenerPorId(Integer idNota) {
        return this.notaDAO.obtenerPorId(idNota);
    }

    private Nota crearNota(Integer bimestre, String nota, Integer idCurso, Integer idCompetencia) {
        Nota nuevaNota = new Nota();
        nuevaNota.setBimestre(bimestre);
        nuevaNota.setNota(nota);

        Curso curso = new Curso();
        curso.setIdCurso(idCurso);
        nuevaNota.setCurso(curso);

        Competencia competencia = new Competencia();
        competencia.setIdCompetencia(idCompetencia);
        nuevaNota.setCompetencia(competencia);

        return nuevaNota;
    }
    
}
