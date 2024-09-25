
package pe.edu.pucp.pixelpenguins.usuario.bo;

import java.util.Date;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.SeccionAcademica;
import pe.edu.pucp.pixelpenguins.usuario.dao.AlumnoDAO;
import pe.edu.pucp.pixelpenguins.usuario.daoImpl.AlumnoDAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.model.Alumno;
import pe.edu.pucp.pixelpenguins.usuario.model.Apoderado;

public class AlumnoBO {
    private AlumnoDAO alumnoDAO;
    
    public AlumnoBO(){
        this.alumnoDAO=new AlumnoDAOImpl();
    }
    
    public int insertar(int codigoAlumno, boolean certificadoDeEstudios, 
            boolean certificadoDeSalud, boolean deuda, Apoderado apoderado, 
            Matricula matricula, SeccionAcademica seccion, GradoAcademico grado, 
            int dni, String nombre, Date fechaNacimiento, String direccion, 
            String email, String sexo,String username,String password){
        Alumno alumno=new Alumno(codigoAlumno, certificadoDeEstudios, certificadoDeSalud,
                deuda, apoderado, matricula, seccion, grado, dni, nombre, fechaNacimiento,
                direccion, email, sexo, username, password);
        return this.alumnoDAO.insertar(alumno);
    }
}
