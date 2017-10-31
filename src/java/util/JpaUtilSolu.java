/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import relatorio.Relatorio;

/**
 *
 * @author dione Classe utilizada para fazer realizar as operações de banco de
 * dados
 */
public class JpaUtilSolu {

    private static EntityManagerFactory factory = null;
    private static Connection con;

    public static EntityManager getManager() {

        try {
            //if (factory == null) {
                //Obtém o factory a partir da unidade de persistência.
            factory = Persistence.createEntityManagerFactory("TimeExportSO");
            //}//Cria um entity manager
            //return factory.createEntityManager();


        } finally {
            //factory.close();
        }
        return factory.createEntityManager();
    }

    public static void closeManager(EntityManager manager) {
        //Fecha o factory para liberar os recursos utilizado.
        try {
            manager.close();
            factory.close();
            //manager.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*Conexao Banco*/
    public static Connection getConexao() {
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            con = DriverManager.getConnection("jdbc:firebirdsql://192.168.0.207:3050//DadosSolutions/SOLUTIONSPROD.FDB", "sysdba", "glpvmaster");
            return con;

        } catch (SQLException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return con;
    }

    public static void fecharConexao() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
