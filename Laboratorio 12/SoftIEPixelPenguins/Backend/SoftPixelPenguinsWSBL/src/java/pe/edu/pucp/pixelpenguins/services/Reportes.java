/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.pixelpenguins.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import java.io.IOException;
import pe.edu.pucp.pixelpenguins.reportes.ReporteUtil;

/**
 *
 * @author Admin
 */
@WebService(serviceName = "Reportes")
public class Reportes {

    
    @WebMethod(operationName = "reportePagos")
    public byte[] reportePagos(Integer idGradoAcademico) throws IOException {
        return ReporteUtil.ReportePagos(null,idGradoAcademico);
    }
    @WebMethod(operationName = "reporteMatriculasXGrado")
    public byte[] reportereporteMatriculasXGrado() throws IOException {
        return ReporteUtil.reporteMatriculasPorGrado(null);
    }
}
