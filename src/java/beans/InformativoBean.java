/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.VExportDialogdireto;
import entidades.VInformativo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import relatorio.Relatorio;
import util.JpaUtil;
import util.JpaUtilSolu;
import util.JpaUtilVirtCon;


/**
 *
 * @author dione
 */
@ManagedBean
@ViewScoped
public class InformativoBean implements Serializable {

    private VInformativo informativo = new VInformativo();
    private List<VInformativo> informativoDir = new ArrayList<>();

    private Date dateini;
    private Date datefim;
    private String empresa;

    @PostConstruct
    public void init() {

        //listar();
    }

    public void listar() {
               
        if (empresa.equals("Solutions")) {
            
             if (dateini != null && datefim != null) {
            EntityManager manager = JpaUtilSolu.getManager();
            manager.getTransaction().begin();
            informativoDir = manager.createQuery("select d from VInformativo d where d.dtcadastro between :datacadini and :datacadfim", VInformativo.class)
                    .setParameter("datacadini", dateini)
                    .setParameter("datacadfim", datefim)
                    .getResultList();
            manager.getTransaction().commit();
            //manager.getTransaction().begin();
            JpaUtilSolu.closeManager(manager);
            
            //Lista vazia
            if (informativoDir.isEmpty()) {
                FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Sem dados para Impressão!"));                         
            }
        }
        /*if (data.equals(null)) {
            
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Sem dados para Impressão!"));
        }*/
        }
        if (empresa.equals("Grupo")) {
            
               if (dateini != null && datefim != null) {
            EntityManager manager = JpaUtil.getManager();
            manager.getTransaction().begin();
            informativoDir = manager.createQuery("select d from VInformativo d where d.dtcadastro between :datacadini and :datacadfim", VInformativo.class)
                    .setParameter("datacadini", dateini)
                    .setParameter("datacadfim", datefim)
                    .getResultList();
            manager.getTransaction().commit();
            //manager.getTransaction().begin();
            JpaUtil.closeManager(manager);
            
            //Lista vazia
            if (informativoDir.isEmpty()) {
                FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Sem dados para Impressão!"));                         
            }
        }
        }
        
           if (empresa.equals("Virtual")) {
            
               if (dateini != null && datefim != null) {
            EntityManager manager = JpaUtilVirtCon.getManager();
            manager.getTransaction().begin();
            informativoDir = manager.createQuery("select d from VInformativo d where d.dtcadastro between :datacadini and :datacadfim", VInformativo.class)
                    .setParameter("datacadini", dateini)
                    .setParameter("datacadfim", datefim)
                    .getResultList();
            manager.getTransaction().commit();
            //manager.getTransaction().begin();
            JpaUtil.closeManager(manager);
            
            //Lista vazia
            if (informativoDir.isEmpty()) {
                FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Sem dados para Impressão!"));                         
            }
        }
        }
        
    }

    public void geraRelatorio() {

        Relatorio relatorio = new Relatorio();
        relatorio.getRelatorio(dateini);
    }

    public VInformativo getInformativo() {
        return informativo;
    }

    public void setInformativo(VInformativo informativo) {
        this.informativo = informativo;
    }

    public List<VInformativo> getInformativoDir() {
        return informativoDir;
    }

    public void setInformativoDir(List<VInformativo> informativoDir) {
        this.informativoDir = informativoDir;
    }

    public Date getDateini() {
        return dateini;
    }

    public void setDateini(Date dateini) {
        this.dateini = dateini;
    }

    public Date getDatefim() {
        return datefim;
    }

    public void setDatefim(Date datefim) {
        this.datefim = datefim;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    

    public InformativoBean() {
    }

}
