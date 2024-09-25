package pe.edu.pucp.pixelpenguins.añoacademico.bo;


import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.añoacademico.dao.MatriculaDAO;
import pe.edu.pucp.pixelpenguins.añoacademico.daoimpl.MatriculaDAOImpl;
import pe.edu.pucp.pixelpenguins.añoacademico.model.EstadoDeMatricula;
import pe.edu.pucp.pixelpenguins.añoacademico.model.Matricula;

public class MatriculaBO {
    private MatriculaDAO matriculaDAO;
    
    public MatriculaBO(){
        this.matriculaDAO = new MatriculaDAOImpl();
    }
    
    public int insertar(int idMatricula, boolean cumpleRequisitos, Date fechaInicio, Date fechaFin,
            EstadoDeMatricula estado){
        
        Matricula matricula = new Matricula(idMatricula, cumpleRequisitos, fechaInicio, fechaFin, estado);
        return matriculaDAO.insertar(matricula);
    }
    public int modificar(int idMatricula, boolean cumpleRequisitos, Date fechaInicio, Date fechaFin,
            EstadoDeMatricula estado){
        Matricula matricula = new Matricula(idMatricula, cumpleRequisitos, fechaInicio, fechaFin, estado);
        return matriculaDAO.modificar(matricula);
    }
    
    public int eliminar(int idMatricula, boolean cumpleRequisitos, Date fechaInicio, Date fechaFin,
            EstadoDeMatricula estado){
        Matricula matricula = new Matricula(idMatricula, cumpleRequisitos, fechaInicio, fechaFin, estado);
        return matriculaDAO.eliminar(matricula);
    }
    
    public ArrayList<Matricula> listarTodos(){
        return matriculaDAO.listarTodos();
    }
    
    public Matricula obtenerPorId(int idMatricula){
        return matriculaDAO.obtenerPorId(idMatricula);
    }
}
