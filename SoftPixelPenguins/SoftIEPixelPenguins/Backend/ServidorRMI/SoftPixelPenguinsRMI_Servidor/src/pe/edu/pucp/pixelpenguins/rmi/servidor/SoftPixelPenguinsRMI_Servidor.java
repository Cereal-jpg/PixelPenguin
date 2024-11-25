package pe.edu.pucp.pixelpenguins.rmi.servidor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.AdministradorBO;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.AlumnoBO;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.AnioAcademicoBO;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.ApoderadoBO;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.CompetenciaBO;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.CursoBO;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.CursoXMatriculaBO;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.GradoAcademicoBO;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.HoraAcademicaBO;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.MatriculaBO;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.NotaBO;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.PagoBO;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.PersonalAdministrativoBO;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.ProfesorBO;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.RolBO;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.SeccionAcademicaBO;
import pe.edu.pucp.pixelpenguins.rmi.interfaces.UsuarioBO;
import pe.edu.pucp.pixelpenguins.rmi.interfacesImpl.AdministradorBOImpl;
import pe.edu.pucp.pixelpenguins.rmi.interfacesImpl.AlumnoBOImpl;
import pe.edu.pucp.pixelpenguins.rmi.interfacesImpl.AnioAcademicoBOImpl;
import pe.edu.pucp.pixelpenguins.rmi.interfacesImpl.ApoderadoBOImpl;
import pe.edu.pucp.pixelpenguins.rmi.interfacesImpl.CompetenciaBOImpl;
import pe.edu.pucp.pixelpenguins.rmi.interfacesImpl.CursoBOImpl;
import pe.edu.pucp.pixelpenguins.rmi.interfacesImpl.CursoXMatriculaBOImpl;
import pe.edu.pucp.pixelpenguins.rmi.interfacesImpl.GradoAcademicoBOImpl;
import pe.edu.pucp.pixelpenguins.rmi.interfacesImpl.HoraAcademicaBOImpl;
import pe.edu.pucp.pixelpenguins.rmi.interfacesImpl.MatriculaBOImpl;
import pe.edu.pucp.pixelpenguins.rmi.interfacesImpl.NotaBOImpl;
import pe.edu.pucp.pixelpenguins.rmi.interfacesImpl.PagoBOImpl;
import pe.edu.pucp.pixelpenguins.rmi.interfacesImpl.PersonalAdministrativoBOImpl;
import pe.edu.pucp.pixelpenguins.rmi.interfacesImpl.ProfesorBOImpl;
import pe.edu.pucp.pixelpenguins.rmi.interfacesImpl.RolBOImpl;
import pe.edu.pucp.pixelpenguins.rmi.interfacesImpl.SeccionAcademicaBOImpl;
import pe.edu.pucp.pixelpenguins.rmi.interfacesImpl.UsuarioBOImpl;

public class SoftPixelPenguinsRMI_Servidor {

    private static final String ARCHIVO_CONFIGURACION = "rmi.properties";
    private static String IP;
    private static Integer puerto;

    public static void main(String[] args) {
        try {
            cargarConfiguracionServidorRMI();

            LocateRegistry.createRegistry(puerto);

            AdministradorBO administradorBO = new AdministradorBOImpl(puerto);
            AlumnoBO alumnoBO = new AlumnoBOImpl(puerto);
            AnioAcademicoBO anioAcademicoBO = new AnioAcademicoBOImpl(puerto);
            ApoderadoBO apoderadoBO = new ApoderadoBOImpl(puerto);
            CompetenciaBO competenciaBO = new CompetenciaBOImpl(puerto);
            CursoBO cursoBO = new CursoBOImpl(puerto);
            CursoXMatriculaBO cursoXMatriculaBO = new CursoXMatriculaBOImpl(puerto);
            GradoAcademicoBO gradoAcademicoBO = new GradoAcademicoBOImpl(puerto);
            HoraAcademicaBO horaAcademicaBO = new HoraAcademicaBOImpl(puerto);
            MatriculaBO matriculaBO = new MatriculaBOImpl(puerto);
            NotaBO notaBO = new NotaBOImpl(puerto);
            PagoBO pagoBO = new PagoBOImpl(puerto);
            PersonalAdministrativoBO personalAdministrativoBO = new PersonalAdministrativoBOImpl(puerto);
            ProfesorBO profesorBO = new ProfesorBOImpl(puerto);
            RolBO rolBO = new RolBOImpl(puerto);
            SeccionAcademicaBO seccionAcademicaBO = new SeccionAcademicaBOImpl(puerto);
            UsuarioBO usuarioBO = new UsuarioBOImpl(puerto);

            String nombreServicio = retornarNombreDelServicio("administradorBO");
            Naming.rebind(nombreServicio, administradorBO);

            nombreServicio = retornarNombreDelServicio("alumnoBO");
            Naming.rebind(nombreServicio, alumnoBO);

            nombreServicio = retornarNombreDelServicio("anioAcademicoBO");
            Naming.rebind(nombreServicio, anioAcademicoBO);

            nombreServicio = retornarNombreDelServicio("apoderadoBO");
            Naming.rebind(nombreServicio, apoderadoBO);

            nombreServicio = retornarNombreDelServicio("competenciaBO");
            Naming.rebind(nombreServicio, competenciaBO);

            nombreServicio = retornarNombreDelServicio("cursoBO");
            Naming.rebind(nombreServicio, cursoBO);

            nombreServicio = retornarNombreDelServicio("cursoXMatriculaBO");
            Naming.rebind(nombreServicio, cursoXMatriculaBO);

            nombreServicio = retornarNombreDelServicio("gradoAcademicoBO");
            Naming.rebind(nombreServicio, gradoAcademicoBO);

            nombreServicio = retornarNombreDelServicio("horaAcademicaBO");
            Naming.rebind(nombreServicio, horaAcademicaBO);

            nombreServicio = retornarNombreDelServicio("matriculaBO");
            Naming.rebind(nombreServicio, matriculaBO);

            nombreServicio = retornarNombreDelServicio("notaBO");
            Naming.rebind(nombreServicio, notaBO);

            nombreServicio = retornarNombreDelServicio("pagoBO");
            Naming.rebind(nombreServicio, pagoBO);

            nombreServicio = retornarNombreDelServicio("personalAdministrativoBO");
            Naming.rebind(nombreServicio, personalAdministrativoBO);

            nombreServicio = retornarNombreDelServicio("profesorBO");
            Naming.rebind(nombreServicio, profesorBO);

            nombreServicio = retornarNombreDelServicio("rolBO");
            Naming.rebind(nombreServicio, rolBO);

            nombreServicio = retornarNombreDelServicio("seccionAcademicaBO");
            Naming.rebind(nombreServicio, seccionAcademicaBO);

            nombreServicio = retornarNombreDelServicio("usuarioBO");
            Naming.rebind(nombreServicio, usuarioBO);

            System.out.println("Servidor RMI registrado correctamente...");
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(SoftPixelPenguinsRMI_Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String retornarNombreDelServicio(String nombreDelObjetoRemoto) {
        return "//" + IP + ":" + puerto + "/" + nombreDelObjetoRemoto;
    }
    
    public static void cargarConfiguracionServidorRMI() {
        Properties properties = new Properties();
        try {
            String nmArchivoConf = "c:" + "\\" + ARCHIVO_CONFIGURACION;
            properties.load(new FileInputStream(new File(nmArchivoConf)));
            IP = properties.getProperty("ip");
            puerto = Integer.valueOf(properties.getProperty("puerto"));
            System.out.println("Configuración cargada desde " + nmArchivoConf + ": IP=" + IP + ", Puerto=" + puerto);
        } catch (FileNotFoundException ex) {
            System.err.println("Error: No se encontró el archivo de configuración en " + "C:\\" + ARCHIVO_CONFIGURACION);
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo de configuración: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            System.err.println("Error: El puerto debe ser un número entero válido. Usando puerto por defecto: " + puerto);
        }
    }

}
