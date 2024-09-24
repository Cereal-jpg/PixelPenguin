package pe.edu.pucp.pixelpenguins.curricula;

public class Nota {
    private int idNota;
    private String nota;
    private int bimestre;

    public Nota(int idNota, String nota, int bimestre) {
        this.idNota = idNota;
        this.nota = nota;
        this.bimestre = bimestre;
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
