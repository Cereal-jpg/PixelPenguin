package pe.edu.pucp.pixelpenguins.curricula.model;

public class Nota {
    private int idNota;
    private String nota;
    private int bimestre;
    private String idCurso;
    private int idCompetencia;
    
    public Nota(){
        
    }

    public Nota(int idNota, String nota, int bimestre, String idCurso, int idCompetencia) {
        this.idNota = idNota;
        this.nota = nota;
        this.bimestre = bimestre;
        this.idCurso = idCurso;
        this.idCompetencia = idCompetencia;
    }

    public String getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(String idCurso) {
        this.idCurso = idCurso;
    }

    public int getIdCompetencia() {
        return idCompetencia;
    }

    public void setIdCompetencia(int idCompetencia) {
        this.idCompetencia = idCompetencia;
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
    
}
