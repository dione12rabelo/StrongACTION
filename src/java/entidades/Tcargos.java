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
@Table(name = "TCARGOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tcargos.findAll", query = "SELECT t FROM Tcargos t")
    , @NamedQuery(name = "Tcargos.findByCodcargo", query = "SELECT t FROM Tcargos t WHERE t.codcargo = :codcargo")
    , @NamedQuery(name = "Tcargos.findByDesccargo", query = "SELECT t FROM Tcargos t WHERE t.desccargo = :desccargo")})
public class Tcargos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODCARGO")
    private Integer codcargo;
    @Basic(optional = false)
    @Column(name = "DESCCARGO")
    private String desccargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codcargo")
    private Collection<Tfuncionarios> tfuncionariosCollection;

    public Tcargos() {
    }

    public Tcargos(Integer codcargo) {
        this.codcargo = codcargo;
    }

    public Tcargos(Integer codcargo, String desccargo) {
        this.codcargo = codcargo;
        this.desccargo = desccargo;
    }

    public Integer getCodcargo() {
        return codcargo;
    }

    public void setCodcargo(Integer codcargo) {
        this.codcargo = codcargo;
    }

    public String getDesccargo() {
        return desccargo;
    }

    public void setDesccargo(String desccargo) {
        this.desccargo = desccargo;
    }

    @XmlTransient
    public Collection<Tfuncionarios> getTfuncionariosCollection() {
        return tfuncionariosCollection;
    }

    public void setTfuncionariosCollection(Collection<Tfuncionarios> tfuncionariosCollection) {
        this.tfuncionariosCollection = tfuncionariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcargo != null ? codcargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tcargos)) {
            return false;
        }
        Tcargos other = (Tcargos) object;
        if ((this.codcargo == null && other.codcargo != null) || (this.codcargo != null && !this.codcargo.equals(other.codcargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tcargos[ codcargo=" + codcargo + " ]";
    }
    
}
