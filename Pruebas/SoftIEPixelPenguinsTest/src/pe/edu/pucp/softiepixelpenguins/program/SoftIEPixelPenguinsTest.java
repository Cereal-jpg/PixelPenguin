package pe.edu.pucp.softiepixelpenguins.program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.anioacademico.bo.PlanAcademicoBO;
import pe.edu.pucp.pixelpenguins.anioacademico.model.PlanAcademico;
import pe.edu.pucp.pixelpenguins.institucioneducativa.bo.InstitucioneducativaBO;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;

public class SoftIEPixelPenguinsTest {

    public static void main(String[] args) throws ParseException {
        
        InstitucioneducativaBO institucionBO = new InstitucioneducativaBO();
        PlanAcademicoBO planAcademicoBO = new PlanAcademicoBO();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        
//        if(institucionBO.insertar(1,"Pixel Penguins",1000,"Av. Universitaria 2453",1234567890)==1)
//            System.out.println("La institucion fue agregada correctamente");

//        if(planAcademicoBO.insertar(1, 2024,sdf.parse("03/01/2024"),sdf.parse("20/12/2024") , 1)==1)
//            System.out.println("El plan académico fue agregado correctamente");

//        if(planAcademicoBO.modificar(1, 2024,sdf.parse("03/8/2024"),null , -1)== 1 )
//                System.out.println("El plan académico fue modificado correctamente");  
          
//          ArrayList<PlanAcademico> listPlan = planAcademicoBO.listarTodos();
//          System.out.println(listPlan.get(0).getFechaInicio());
        
//          PlanAcademico plan = planAcademicoBO.obtenerPorId(1);
//          System.out.println(plan.getFechaFin());
          
//        if(planAcademicoBO.eliminar(1, -1, null, null,null)==1)
//            System.out.println("El plan académico fue eliminado correctamente"); 

//        if(institucionBO.modificar(1, null, -1, null, 1234567890)==1)
//            System.out.println("La institucion fue modificada correctamente");
          
//        ArrayList<InstitucionEducativa> listInstitucion = institucionBO.listarTodos();
//        System.out.println(listInstitucion.get(0).getNombre());
        
//        InstitucionEducativa institucion = institucionBO.obtenerPorId(1);
//        System.out.println(institucion.getNombre());
        
//        if(institucionBO.eliminar(1, null, -1, null, -1)==1)
//            System.out.println("La institucion fue eliminada correctamente");
        
    }
    
}
