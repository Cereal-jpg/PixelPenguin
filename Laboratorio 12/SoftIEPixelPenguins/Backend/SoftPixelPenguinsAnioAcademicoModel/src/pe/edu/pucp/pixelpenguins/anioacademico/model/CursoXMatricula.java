
package pe.edu.pucp.pixelpenguins.anioacademico.model;

import pe.edu.pucp.pixelpenguins.curricula.model.Curso;

public class CursoXMatricula {
    private Curso curso;
    private Matricula matricula;
    private Integer fid_Alumno;
    private String notaBimestre1;
    private String notaBimestre2;
    private String notaBimestre3;
    private String notaBimestre4;    
    private String notaFinal;    

    public CursoXMatricula(){}
    
    public CursoXMatricula(Curso curso, Matricula matricula, Integer fid_Alumno, String notaBimestre1, String notaBimestre2, String notaBimestre3, String notaBimestre4, String notaFinal) {
        this.curso = curso;
        this.matricula = matricula;
        this.fid_Alumno = fid_Alumno;
        this.notaBimestre1 = notaBimestre1;
        this.notaBimestre2 = notaBimestre2;
        this.notaBimestre3 = notaBimestre3;
        this.notaBimestre4 = notaBimestre4;
        this.notaFinal = notaFinal;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Integer getFid_Alumno() {
        return fid_Alumno;
    }

    public void setFid_Alumno(Integer fid_Alumno) {
        this.fid_Alumno = fid_Alumno;
    }

    public String getNotaBimestre1() {
        return notaBimestre1;
    }

    public void setNotaBimestre1(String notaBimestre1) {
        this.notaBimestre1 = notaBimestre1;
    }

    public String getNotaBimestre2() {
        return notaBimestre2;
    }

    public void setNotaBimestre2(String notaBimestre2) {
        this.notaBimestre2 = notaBimestre2;
    }

    public String getNotaBimestre3() {
        return notaBimestre3;
    }

    public void setNotaBimestre3(String notaBimestre3) {
        this.notaBimestre3 = notaBimestre3;
    }

    public String getNotaBimestre4() {
        return notaBimestre4;
    }

    public void setNotaBimestre4(String notaBimestre4) {
        this.notaBimestre4 = notaBimestre4;
    }

    public String getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(String notaFinal) {
        this.notaFinal = notaFinal;
    }
    
    
}
