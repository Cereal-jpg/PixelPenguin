package pe.edu.pucp.pixelpenguins.usuario.bo;

import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.usuario.dao.AlumnoDAO;
import pe.edu.pucp.pixelpenguins.usuario.daoImp.AlumnoDAOImpl;
import pe.edu.pucp.pixelpenguins.usuario.model.Alumno;
import pe.edu.pucp.pixelpenguins.usuario.model.Apoderado;
import pe.edu.pucp.pixelpenguins.usuario.model.Rol;

public class AlumnoBO {
    
    private final AlumnoDAO alumnoDAO;

    public AlumnoBO() {
        this.alumnoDAO = new AlumnoDAOImpl();
    }

    public Integer insertar(int codigoAlumno, boolean conCertificadoDeEstudios, boolean conCertificadoDeSalud,
                            boolean conDeuda, Apoderado apoderado, GradoAcademico gradoAcademico,
                            String dni, String nombreCompleto, Date fechaNacimiento, String direccion,
                            String email, String sexo, String username, String password, Rol rol) {
        UsuarioBO usuarioBO=new UsuarioBO();
        if(usuarioBO.insertar(dni, nombreCompleto, fechaNacimiento, direccion, email, sexo, username, password, rol)!=0)
            System.out.println("El usuario fue insertado correctamente");
        Alumno alumno = new Alumno(codigoAlumno, conCertificadoDeEstudios, conCertificadoDeSalud, 
                                    conDeuda, apoderado, gradoAcademico, dni, nombreCompleto, 
                                    fechaNacimiento, direccion, email, sexo, username, password, rol);
        return this.alumnoDAO.insertar(alumno);
    }
    
    public Integer insertar(Alumno alumno) {
        return this.alumnoDAO.insertar(alumno);
    }

    public Integer modificar(int codigoAlumno, boolean conCertificadoDeEstudios, boolean conCertificadoDeSalud,
                             boolean conDeuda, Apoderado apoderado, GradoAcademico gradoAcademico,
                             Integer idUsuario, String dni, String nombreCompleto, Date fechaNacimiento, 
                             String direccion, String email, String sexo, String username, String password, 
                             Rol rol) {
        Alumno alumno = new Alumno(codigoAlumno, conCertificadoDeEstudios, conCertificadoDeSalud,
                                    conDeuda, apoderado, gradoAcademico, idUsuario, dni, 
                                    nombreCompleto, fechaNacimiento, direccion, email, sexo, 
                                    username, password, rol);
        return this.alumnoDAO.modificar(alumno);
    }
    
    public Integer modificar(Alumno alumno) {
        return this.alumnoDAO.modificar(alumno);
    }

    public Integer eliminar(Integer idUsuario) {
        Alumno alumno = new Alumno();
        alumno.setIdUsuario(idUsuario);
        return this.alumnoDAO.eliminar(alumno);
    }
    
    public Integer eliminar(Alumno alumno) {
        return this.alumnoDAO.eliminar(alumno);
    }

    public ArrayList<Alumno> listarTodos() {
        return this.alumnoDAO.listarTodos();
    }

    public Alumno obtenerPorId(Integer idUsuario) {
        return this.alumnoDAO.obtenerPorId(idUsuario);
    }

    public Boolean existeAlumno(Integer idUsuario) {
        Alumno alumno = new Alumno();
        alumno.setIdUsuario(idUsuario);
        return this.alumnoDAO.existeAlumno(alumno);
    }
    
}
