/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.VExportDialogdireto;
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

/**
 *
 * @author dione
 */
@ManagedBean
@ViewScoped
public class DialogoBean implements Serializable {

    private VExportDialogdireto dialogo = new VExportDialogdireto();
    private List<VExportDialogdireto> dialogoDir = new ArrayList<>();

    private Date data;

    @PostConstruct
    public void init() {

        listar();
    }

    public void listar() {

        if (data != null) {
            EntityManager manager = JpaUtil.getManager();
            manager.getTransaction().begin();
            dialogoDir = manager.createQuery("select d from VExportDialogdireto d where d.dataImport = :dataimport", VExportDialogdireto.class)
                    .setParameter("dataimport", data)
                    .getResultList();
            manager.getTransaction().commit();
            //manager.getTransaction().begin();
            JpaUtil.closeManager(manager);
            
            //Lista vazia
            if (dialogoDir.isEmpty()) {
                FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Sem dados para Impressão!"));                         
            }
        }

    }

    public void geraRelatorio() {

        Relatorio relatorio = new Relatorio();
        relatorio.getRelatorio(data);
    }

    public VExportDialogdireto getDialogo() {
        return dialogo;
    }

    public void setDialogo(VExportDialogdireto dialogo) {
        this.dialogo = dialogo;
    }

    public List<VExportDialogdireto> getDialogoDir() {
        return dialogoDir;
    }

    public void setDialogoDir(List<VExportDialogdireto> dialogoDir) {
        this.dialogoDir = dialogoDir;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public DialogoBean() {
    }

}
