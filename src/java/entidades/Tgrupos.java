/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dione
 */
@Entity
@Table(name = "TGRUPOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tgrupos.findAll", query = "SELECT t FROM Tgrupos t")
    , @NamedQuery(name = "Tgrupos.findByCodgrupo", query = "SELECT t FROM Tgrupos t WHERE t.codgrupo = :codgrupo")
    , @NamedQuery(name = "Tgrupos.findByDescricao", query = "SELECT t FROM Tgrupos t WHERE t.descricao = :descricao")
    , @NamedQuery(name = "Tgrupos.findByPermissao1", query = "SELECT t FROM Tgrupos t WHERE t.permissao1 = :permissao1")
    , @NamedQuery(name = "Tgrupos.findByPermissao2", query = "SELECT t FROM Tgrupos t WHERE t.permissao2 = :permissao2")
    , @NamedQuery(name = "Tgrupos.findByPermissao3", query = "SELECT t FROM Tgrupos t WHERE t.permissao3 = :permissao3")
    , @NamedQuery(name = "Tgrupos.findByPermissao4", query = "SELECT t FROM Tgrupos t WHERE t.permissao4 = :permissao4")
    , @NamedQuery(name = "Tgrupos.findByPermissao5", query = "SELECT t FROM Tgrupos t WHERE t.permissao5 = :permissao5")
    , @NamedQuery(name = "Tgrupos.findByPermissao6", query = "SELECT t FROM Tgrupos t WHERE t.permissao6 = :permissao6")})
public class Tgrupos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODGRUPO")
    private Integer codgrupo;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "PERMISSAO1")
    private String permissao1;
    @Column(name = "PERMISSAO2")
    private String permissao2;
    @Column(name = "PERMISSAO3")
    private String permissao3;
    @Column(name = "PERMISSAO4")
    private String permissao4;
    @Column(name = "PERMISSAO5")
    private String permissao5;
    @Column(name = "PERMISSAO6")
    private String permissao6;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codgrupo")
    private Collection<Tusuarios> tusuariosCollection;

    public Tgrupos() {
    }

    public Tgrupos(Integer codgrupo) {
        this.codgrupo = codgrupo;
    }

    public Tgrupos(Integer codgrupo, String descricao) {
        this.codgrupo = codgrupo;
        this.descricao = descricao;
    }

    public Integer getCodgrupo() {
        return codgrupo;
    }

    public void setCodgrupo(Integer codgrupo) {
        this.codgrupo = codgrupo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPermissao1() {
        return permissao1;
    }

    public void setPermissao1(String permissao1) {
        this.permissao1 = permissao1;
    }

    public String getPermissao2() {
        return permissao2;
    }

    public void setPermissao2(String permissao2) {
        this.permissao2 = permissao2;
    }

    public String getPermissao3() {
        return permissao3;
    }

    public void setPermissao3(String permissao3) {
        this.permissao3 = permissao3;
    }

    public String getPermissao4() {
        return permissao4;
    }

    public void setPermissao4(String permissao4) {
        this.permissao4 = permissao4;
    }

    public String getPermissao5() {
        return permissao5;
    }

    public void setPermissao5(String permissao5) {
        this.permissao5 = permissao5;
    }

    public String getPermissao6() {
        return permissao6;
    }

    public void setPermissao6(String permissao6) {
        this.permissao6 = permissao6;
    }

    @XmlTransient
    public Collection<Tusuarios> getTusuariosCollection() {
        return tusuariosCollection;
    }

    public void setTusuariosCollection(Collection<Tusuarios> tusuariosCollection) {
        this.tusuariosCollection = tusuariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codgrupo != null ? codgrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tgrupos)) {
            return false;
        }
        Tgrupos other = (Tgrupos) object;
        if ((this.codgrupo == null && other.codgrupo != null) || (this.codgrupo != null && !this.codgrupo.equals(other.codgrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tgrupos[ codgrupo=" + codgrupo + " ]";
    }
    
}
