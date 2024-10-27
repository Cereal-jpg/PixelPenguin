package pe.edu.pucp.pixelpenguins.institucioneducativa.bo;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.institucioneducativa.dao.InstitucionEducativaDAO;
import pe.edu.pucp.pixelpenguins.institucioneducativa.daoImp.InstitucionEducativaDAOImpl;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;

public class InstitucionEducativaBO {

    private InstitucionEducativaDAO institucionDAO;

    public InstitucionEducativaBO() {
        this.institucionDAO = new InstitucionEducativaDAOImpl();
    }

     public Integer insertar(String nombre, int cantidadAlumnos, String direccion, String ruc) {
        InstitucionEducativa institucion = new InstitucionEducativa(nombre, cantidadAlumnos, direccion, ruc);
        return this.institucionDAO.insertar(institucion);
    }

    public Integer modificar(Integer idInstitucion, String nombre, int cantidadAlumnos, String direccion, String ruc) {
        InstitucionEducativa institucion = new InstitucionEducativa(idInstitucion, nombre, cantidadAlumnos, direccion, ruc);
        return this.institucionDAO.modificar(institucion);
    }

    public Integer eliminar(Integer idInstitucion) {
        InstitucionEducativa institucion = new InstitucionEducativa();
        institucion.setIdInstitucion(idInstitucion);
        return this.institucionDAO.eliminar(institucion);
    }

    public ArrayList<InstitucionEducativa> listarTodos() {
        return this.institucionDAO.listarTodos();
    }

    public InstitucionEducativa obtenerPorId(Integer idInstitucion) {
        return this.institucionDAO.obtenerPorId(idInstitucion);
    }
    
}
