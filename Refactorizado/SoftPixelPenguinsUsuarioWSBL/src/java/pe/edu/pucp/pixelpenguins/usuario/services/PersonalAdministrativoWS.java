package pe.edu.pucp.pixelpenguins.usuario.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.usuario.bo.PersonalAdministrativoBO;
import pe.edu.pucp.pixelpenguins.usuario.model.PersonalAdministrativo;

@WebService(serviceName = "PersonalAdministrativoWS", targetNamespace
        = "http://services.usuario.pixelpenguins.pucp.edu.pe")
public class PersonalAdministrativoWS {

    private PersonalAdministrativoBO personalAdministrativoBO = new PersonalAdministrativoBO();
    
    @WebMethod(operationName = "insertarPersonalAdministrativo")
    public Integer insertarPersonalAdministrativo(@WebParam(name = "personalAdministrativo") PersonalAdministrativo personalAdministrativo) {
        Integer resultado = 0;
        try {
            resultado = personalAdministrativoBO.insertar(personalAdministrativo);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "modificarPersonalAdministrativo")
    public Integer modificarPersonalAdministrativo(@WebParam(name = "personalAdministrativo") PersonalAdministrativo personalAdministrativo) {
        Integer resultado = 0;
        try {
            resultado = personalAdministrativoBO.modificar(personalAdministrativo);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "eliminarPersonalAdministrativo")
    public Integer eliminarPersonalAdministrativo(@WebParam(name = "personalAdministrativo") PersonalAdministrativo personalAdministrativo) {
        Integer resultado = 0;
        try {
            resultado = personalAdministrativoBO.eliminar(personalAdministrativo);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @WebMethod(operationName = "listarTodosPersonalAdministrativo")
    public ArrayList<PersonalAdministrativo> listarTodosPersonalAdministrativo() {
        ArrayList<PersonalAdministrativo> personalAdministrativo = null;
        try {
            personalAdministrativo = personalAdministrativoBO.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return personalAdministrativo;
    }
    
    @WebMethod(operationName = "obtenerPersonalAdministrativoPorId")
    public PersonalAdministrativo obtenerPersonalAdministrativoPorId(@WebParam(name = "idUsuario") Integer idUsuario) {
        PersonalAdministrativo personalAdministrativo = null;
        try {
            personalAdministrativo = personalAdministrativoBO.obtenerPorId(idUsuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return personalAdministrativo;
    }
    
    @WebMethod(operationName = "existePersonalAdministrativo")
    public Boolean existePersonalAdministrativo(@WebParam(name = "idUsuario") Integer idUsuario) {
        Boolean resultado = null;
        try {
            resultado = personalAdministrativoBO.existePersonalAdministrativo(idUsuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
}
