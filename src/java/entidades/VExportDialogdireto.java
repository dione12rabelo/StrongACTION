/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dione
 */
@Entity
@Table(name = "V_EXPORT_DIALOGDIRETO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VExportDialogdireto.findAll", query = "SELECT v FROM VExportDialogdireto v")
    , @NamedQuery(name = "VExportDialogdireto.findByCodcontrib", query = "SELECT v FROM VExportDialogdireto v WHERE v.codcontrib = :codcontrib")
    , @NamedQuery(name = "VExportDialogdireto.findByNome", query = "SELECT v FROM VExportDialogdireto v WHERE v.nome = :nome")
    , @NamedQuery(name = "VExportDialogdireto.findByTelefone1", query = "SELECT v FROM VExportDialogdireto v WHERE v.telefone1 = :telefone1")
    , @NamedQuery(name = "VExportDialogdireto.findByTelefone2", query = "SELECT v FROM VExportDialogdireto v WHERE v.telefone2 = :telefone2")
    , @NamedQuery(name = "VExportDialogdireto.findByCidade", query = "SELECT v FROM VExportDialogdireto v WHERE v.cidade = :cidade")
    , @NamedQuery(name = "VExportDialogdireto.findByDataImport", query = "SELECT v FROM VExportDialogdireto v WHERE v.dataImport = :dataImport")})
public class VExportDialogdireto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CODCONTRIB")
    @Id
    private Integer codcontrib;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "TELEFONE_1")
    private String telefone1;
    @Column(name = "TELEFONE_2")
    private String telefone2;
    @Column(name = "CIDADE")
    private String cidade;
    @Column(name = "DATA_IMPORT")
    @Temporal(TemporalType.DATE)
    private Date dataImport;

    public VExportDialogdireto() {
    }

    public Integer getCodcontrib() {
        return codcontrib;
    }

    public void setCodcontrib(Integer codcontrib) {
        this.codcontrib = codcontrib;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Date getDataImport() {
        return dataImport;
    }

    public void setDataImport(Date dataImport) {
        this.dataImport = dataImport;
    }
    
}
