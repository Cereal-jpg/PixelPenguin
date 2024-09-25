package pe.edu.pucp.softiepixelpenguins.program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.anioacademico.bo.PlanAcademicoBO;
import pe.edu.pucp.pixelpenguins.institucioneducativa.bo.InstitucioneducativaBO;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;

public class SoftIEPixelPenguinsTest {

    public static void main(String[] args) throws ParseException {
        
        InstitucioneducativaBO institucionBO = new InstitucioneducativaBO();
        PlanAcademicoBO planAcademicoBO = new PlanAcademicoBO();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        
//        if(institucionBO.insertar(1,"Pixel Penguins",1000,"Av. Universitaria 2453",1234567890)==1)
//            System.out.println("La institucion fue agregada correctamente");

        if(planAcademicoBO.insertar(1, 2024,sdf.parse("03/01/2024"),sdf.parse("20/12/2024") , 1)==1)
            System.out.println("El plan académico fue agregado correctamente");
        
//        if(institucionBO.modificar(1, null, -1, null, 1234567890)==1)
//            System.out.println("La institucion fue modificada correctamente");
          
//        ArrayList<InstitucionEducativa> listInstitucion = institucionBO.listarTodos();
//        System.out.println(listInstitucion.get(0).getNombre());
        
//        InstitucionEducativa institucion = institucionBO.obtenerPorId(1);
//        System.out.println(institucion.getNombre());
    }
    
}
