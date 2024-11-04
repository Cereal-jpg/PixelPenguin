package pe.edu.pucp.pixelpenguins.anioacademico.model;

import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.contrato.model.IConsultable;
import pe.edu.pucp.pixelpenguins.curricula.model.GradoAcademico;
import pe.edu.pucp.pixelpenguins.curricula.model.SeccionAcademica;

public class Matricula implements IConsultable{
    private int idMatricula;
    private int fidAlumno; // para acceder a las notas de un alumno
    private GradoAcademico gradoAcademico; // tendrá un FK fid_GradoAcademico en la BD
    private AnioAcademico anioAcademico; // tendrá un FK fid_AnioAcademico en la BD
    private SeccionAcademica seccionAcademica;
    private ArrayList <Pago> pagos;

    public Matricula(){}
    
    public Matricula(int codigoAlumno, GradoAcademico gradoAcademico, AnioAcademico anioAcademico,SeccionAcademica seccionAcademica) {
        //this.idMatricula = idMatricula;
        this.fidAlumno=codigoAlumno;
        this.gradoAcademico = gradoAcademico;
        this.anioAcademico = anioAcademico;
        this.seccionAcademica = seccionAcademica;
        this.pagos=new ArrayList<Pago>();
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public int getFidAlumno() {
        return fidAlumno;
    }

    public void setFidAlumno(int codigoAlumno) {
        this.fidAlumno = codigoAlumno;
    }

    public GradoAcademico getGradoAcademico() {
        return gradoAcademico;
    }

    public void setGradoAcademico(GradoAcademico gradoAcademico) {
        this.gradoAcademico = gradoAcademico;
    }

    public AnioAcademico getAnioAcademico() {
        return anioAcademico;
    }

    public void setAnioAcademico(AnioAcademico anioAcademico) {
        this.anioAcademico = anioAcademico;
    }
    
    public SeccionAcademica getSeccionAcademica() {
        return seccionAcademica;
    }

    public void setSeccionAcademica(SeccionAcademica seccionAcademica) {
        this.seccionAcademica = seccionAcademica;
    }
    
    
    @Override
    public String consultarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
