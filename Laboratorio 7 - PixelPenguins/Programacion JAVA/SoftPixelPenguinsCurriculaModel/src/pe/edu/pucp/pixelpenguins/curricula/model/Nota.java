
package pe.edu.pucp.pixelpenguins.curricula.model;

public class Nota {
    private int idNota;
    private String nota;
    private int bimestre;
    private Curso curso; // tendrá un FK fid_curso en la BD
    private Competencia competencia; // tendrá un FK fid_competencia en la BD
    
    public Nota(){}

    public Nota(int idNota, String nota, int bimestre, Curso curso, Competencia competencia) {
        this.idNota = idNota;
        this.nota = nota;
        this.bimestre = bimestre;
        this.curso = curso;
        this.competencia = competencia;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
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
