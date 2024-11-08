
package pe.edu.pucp.pixelpenguins.curricula.model;

public class Nota {
    private Integer idNota;
    private int fid_Matricula;
    private int fid_Alumno;
    private String nota;
    private int bimestre;
    private Curso curso; // tendrá un FK fid_curso en la BD
    private Competencia competencia; // tendrá un FK fid_competencia en la BD
    
    public Nota(){}

    public Nota(Integer idNota,int fid_Matricula,int fid_Alumno, String nota,
            int bimestre, Curso curso, Competencia competencia) {
        this.idNota=idNota;
        this.fid_Matricula=fid_Matricula;
        this.fid_Alumno=fid_Alumno;
        this.nota = nota;
        this.bimestre = bimestre;
        this.curso = curso;
        this.competencia = competencia;
    }

    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public int getFid_Matricula() {
        return fid_Matricula;
    }

    public void setFid_Matricula(int fid_Matricula) {
        this.fid_Matricula = fid_Matricula;
    }

    public int getFid_Alumno() {
        return fid_Alumno;
    }

    public void setFid_Alumno(int fid_Alumno) {
        this.fid_Alumno = fid_Alumno;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getBimestre() {
        return bimestre;
    }

    public void setBimestre(int bimestre) {
        this.bimestre = bimestre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }
    
}
