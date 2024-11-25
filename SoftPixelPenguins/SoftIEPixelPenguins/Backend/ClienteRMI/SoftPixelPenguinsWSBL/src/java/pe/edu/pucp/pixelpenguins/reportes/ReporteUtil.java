
package pe.edu.pucp.pixelpenguins.reportes;

import com.lowagie.text.Image;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.pucp.pixelpenguins.config.DBManager;
import pe.edu.pucp.pixelpenguins.servlet.ReportePagosServlet;

/**
 *
 * @author Admin
 */
public class ReporteUtil {

    public static byte[] InvocarReporte(HttpServletResponse response , String NombreReporte , HashMap parametros) throws IOException {
        
        byte[] reporte = null;
        Connection conexion = DBManager.getInstance().getConnection();
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ReportePagosServlet.class.getResource("/pe/edu/pucp/pixelpenguins/reportes/" + NombreReporte + ".jasper"));
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            if(response !=null)
            JasperExportManager.exportReportToPdfStream(jp, response.getOutputStream());
            else
            reporte = JasperExportManager.exportReportToPdf(jp);
            
        } catch (JRException ex) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReportePagosServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return reporte;
    }
    public static byte[] ReportePagos(HttpServletResponse response , int idGrado) throws IOException{
        HashMap parametros = new HashMap();
        parametros.put("pIdGradoAcademico", idGrado);
        
        return InvocarReporte(response, "ReportePagos", parametros);
    }
    
    public static byte[] reporteMatriculasPorGrado(HttpServletResponse response) throws IOException{
        HashMap parametros = new HashMap();
        URL rutaLogo = ReporteUtil.class.getResource("/pe/edu/pucp/pixelpenguins/resources/logo.png");
        java.awt.Image logo = new ImageIcon(rutaLogo).getImage();
        parametros.put("Logo", logo);
        
        return InvocarReporte(response, "ReporteMatriculasXGrado", parametros);
    }

    
}
