
package pe.edu.pucp.pixelpenguins.usuario.daoImpl;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.db.DAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.dao.AlumnoDAO;
import pe.edu.pucp.pixelpenguins.usuario.model.Alumno;

public class AlumnoDAOImpl extends DAOImpl implements AlumnoDAO{
    
    private Alumno alumno;
    
    public AlumnoDAOImpl(){
        super("Alumno");
        alumno=null;
    }
    
    @Override
    public int insertar(Alumno alumno) {
        this.alumno=alumno;
        return this.insertar();
    }
    
    @Override
    protected String obtenerListaAtributosParaInsertar() {
        return "codigoAlumno, certificadoDeEstudios, certificadoDeSalud, deuda, " + 
            "apoderado, matricula, seccion, grado, dni, nombre, fechaNacimiento, direccion, "
                + "email, sexo, username, password ";
    }

    @Override
    protected String obtenerListaValoresParaInsertar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public int modificar(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Alumno> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Alumno obtenerPorId(String a) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
