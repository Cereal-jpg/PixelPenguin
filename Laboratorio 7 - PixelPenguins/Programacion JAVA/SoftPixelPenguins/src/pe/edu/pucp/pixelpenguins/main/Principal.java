
package pe.edu.pucp.pixelpenguins.main;

import java.text.ParseException;
import pe.edu.pucp.pixelpenguins.usuario.bo.RolBO;

public class Principal {

    public static void main(String[] args) throws ParseException{
        RolBO rolBO=new RolBO();
        if(rolBO.insertar("Profesor")==1)
            System.out.println("El rol fue agregado correctamente");
    }
}