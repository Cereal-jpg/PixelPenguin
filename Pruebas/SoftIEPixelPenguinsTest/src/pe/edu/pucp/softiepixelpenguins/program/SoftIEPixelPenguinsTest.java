package pe.edu.pucp.softiepixelpenguins.program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import pe.edu.pucp.pixelpenguins.anioacademico.bo.MatriculaBO;
import pe.edu.pucp.pixelpenguins.anioacademico.bo.PagoBO;
import pe.edu.pucp.pixelpenguins.anioacademico.bo.PlanAcademicoBO;
import pe.edu.pucp.pixelpenguins.anioacademico.model.EstadoDeMatricula;
import pe.edu.pucp.pixelpenguins.anioacademico.model.EstadoDePago;
import pe.edu.pucp.pixelpenguins.anioacademico.model.Matricula;
import pe.edu.pucp.pixelpenguins.anioacademico.model.PlanAcademico;
import pe.edu.pucp.pixelpenguins.anioacademico.model.TipoDeComprobante;
import pe.edu.pucp.pixelpenguins.anioacademico.model.TipoDePago;
import pe.edu.pucp.pixelpenguins.institucioneducativa.bo.InstitucioneducativaBO;
import pe.edu.pucp.pixelpenguins.institucioneducativa.model.InstitucionEducativa;

public class SoftIEPixelPenguinsTest {

    public static void main(String[] args) throws ParseException {
        
        InstitucioneducativaBO institucionBO = new InstitucioneducativaBO();
        MatriculaBO matriculaBO = new MatriculaBO();
        PlanAcademicoBO planAcademicoBO = new PlanAcademicoBO();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
//        if(matriculaBO.insertar(1, true, sdf.parse("02/21/2024"), sdf.parse("02/28/2024"), EstadoDeMatricula.PENDIENTE)==1)
//            System.out.println("La matricula fue agregada correctamente");
    
//        if(matriculaBO.modificar(1, true, sdf.parse("02/25/2024"), null, null)==1);
//            System.out.println("La matricula fue modificada correctamente");

//        ArrayList<Matricula> listMatricula = matriculaBO.listarTodos();
//        System.out.println(listMatricula.get(0).getFechaInicio());
//
//        Matricula matricula = matriculaBO.obtenerPorId(1);
//        System.out.println(matricula.getFechaFin());

//        if(matriculaBO.eliminar(1, false, null, null, null)==1)
//            System.out.println("La matricula fue eliminada correctamente");
        
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
