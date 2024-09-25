package pe.edu.pucp.softiepixelpenguins.program;

import pe.edu.pucp.pixelpenguins.institucioneducativa.bo.InstitucioneducativaBO;

public class SoftIEPixelPenguinsTest {

    public static void main(String[] args) {
        
        InstitucioneducativaBO institucionBO = new InstitucioneducativaBO();
        
        if(institucionBO.insertar(1,"Pixel Penguins",1000,"Av. Universitaria 2453",1234567890)==1)
            System.out.println("La institucion fue agregada correctamente");
                
    }
    
}
