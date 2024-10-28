    package pe.edu.pucp.pixelpenguins.anioacademico.services;

    import jakarta.jws.WebService;
    import jakarta.jws.WebMethod;
    import jakarta.jws.WebParam;
    import java.util.ArrayList;
    import pe.edu.pucp.pixelpenguins.anioacademico.bo.AnioAcademicoBO;
    import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;

    @WebService(serviceName = "AnioAcademicoWS", targetNamespace
            = "http://services.anioacademico.pixelpenguins.pucp.edu.pe")
    public class AnioAcademicoWS {

        AnioAcademicoBO anioAcademicoBO = new AnioAcademicoBO();

        @WebMethod(operationName = "insertarAnioAcademico")
        public Integer insertarAnioAcademico(@WebParam(name = "anioAcademico") AnioAcademico anioAcademico) {
            Integer resultado = 0;
            try {
                resultado = anioAcademicoBO.insertar(anioAcademico);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return resultado;
        }

        @WebMethod(operationName = "modificarAnioAcademico")
        public Integer modificarAnioAcademico(@WebParam(name = "anioAcademico") AnioAcademico anioAcademico) {
            Integer resultado = 0;
            try {
                resultado = anioAcademicoBO.modificar(anioAcademico);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return resultado;
        }

        @WebMethod(operationName = "eliminarAnioAcademico")
        public Integer eliminarAnioAcademico(@WebParam(name = "anioAcademico") AnioAcademico anioAcademico) {
            Integer resultado = 0;
            try {
                resultado = anioAcademicoBO.eliminar(anioAcademico);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return resultado;
        }

        @WebMethod(operationName = "listarTodosAniosAcademicos")
        public ArrayList<AnioAcademico> listarTodosAniosAcademicos() {
            ArrayList<AnioAcademico> aniosAcademicos = null;
            try {
                aniosAcademicos = anioAcademicoBO.listarTodos();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return aniosAcademicos;
        }

        @WebMethod(operationName = "obtenerAnioAcademicoPorId")
        public AnioAcademico obtenerAnioAcademicoPorId(@WebParam(name = "idAnioAcademico") Integer idAnioAcademico) {
            AnioAcademico anioAcademico = null;
            try {
                anioAcademico = anioAcademicoBO.obtenerPorId(idAnioAcademico);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            return anioAcademico;
        }

    }
