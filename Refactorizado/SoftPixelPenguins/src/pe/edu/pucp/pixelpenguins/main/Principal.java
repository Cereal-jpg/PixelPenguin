
package pe.edu.pucp.pixelpenguins.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import pe.edu.pucp.pixelpenguins.anioacademico.bo.AnioAcademicoBO;
import pe.edu.pucp.pixelpenguins.anioacademico.model.AnioAcademico;
import pe.edu.pucp.pixelpenguins.config.DBManager;
import pe.edu.pucp.pixelpenguins.util.Cifrado;

public class Principal {

    public static void main(String[] args) throws ParseException{
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        //AnioAcademicoBO anio = new AnioAcademicoBO();
        //anio.modificar(5,2026, sdf.parse("2026-03-14"), sdf.parse("2026-11-10"));
        String prueba=Cifrado.descifrarMD5("Fi2ehKwkNK/vyG9ZtsV/NG17zoM7l9Zl1qMHzitTmvQ=");
        System.out.println(prueba);
        //DBManager.getInstance().getConnection();
    }
}
