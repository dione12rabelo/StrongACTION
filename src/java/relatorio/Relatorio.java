/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.query.JRJdbcQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRLoader;
import util.JpaUtil;



public class Relatorio {
    
    private HttpServletResponse response;
    private FacesContext context;
    private ByteArrayOutputStream baos;
    private InputStream stream;
    private Connection con;
    
    
    public Relatorio() {
        this.context = FacesContext.getCurrentInstance();
        this.response = (HttpServletResponse) context.getExternalContext().getResponse();
    }
    
    /*
    defina um parametro: List<Objeto> lista, se usar JavaBean DataSource
    */
    
    
    public void getRelatorio(Date data){       
          
            
        stream = this.getClass().getResourceAsStream("/report/report3.jasper");
        //Map<String, Object> params = new HashMap<String, Object>();
        Map<String, Object> params = new HashMap<String, Object>();
        
        params.put("DATA_IMPORT", data);
        
        baos = new ByteArrayOutputStream();
        
        try {
            
            //JRBeanCollectionDataSource colecao = new JRBeanCollectionDataSource(list);                    
            
            JasperReport report = (JasperReport) JRLoader.loadObject(stream);
            //JasperPrint print = JasperFillManager.fillReport(report, params, new JRBeanCollectionDataSource(list));

            
            /*Para usar JavaBeanDataSource defina: new JRBeanCollectionDataSource(lista)
            mude a string do getResourceAsStream("/report/reportPessoaJavaBeanDS.jasper")
            
            */
            
            //EntityManager manager = JpaUtil.getManager();
            //manager.getTransaction().begin();
            
            JasperPrint print = JasperFillManager.fillReport(report, params, JpaUtil.getConexao());

            JasperExportManager.exportReportToPdfStream(print, baos);
            
            response.reset();
            response.setContentType("application/pdf");
            response.setContentLength(baos.size());
            response.setHeader("Content-disposition", "inline; filename=relatorio.pdf");
            response.getOutputStream().write(baos.toByteArray());
            response.getOutputStream().flush();
            response.getOutputStream().close();
            
            context.responseComplete();
            JpaUtil.fecharConexao();
            
        } catch (JRException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    /*public Connection getConexao(){        
        try {            
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            con = DriverManager.getConnection("jdbc:firebirdsql://192.168.0.2:3050/D:/tlmkt/TLMKT.FDB", "sysdba", "glpvmaster");
            return con;
            
        } catch (SQLException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;
    }
    
    public void fecharConexao(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    
    
}
