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
@Table(name = "TTURNOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tturnos.findAll", query = "SELECT t FROM Tturnos t")
    , @NamedQuery(name = "Tturnos.findByCodturno", query = "SELECT t FROM Tturnos t WHERE t.codturno = :codturno")
    , @NamedQuery(name = "Tturnos.findByAbrevturno", query = "SELECT t FROM Tturnos t WHERE t.abrevturno = :abrevturno")
    , @NamedQuery(name = "Tturnos.findByDescturno", query = "SELECT t FROM Tturnos t WHERE t.descturno = :descturno")
    , @NamedQuery(name = "Tturnos.findByHorainicial", query = "SELECT t FROM Tturnos t WHERE t.horainicial = :horainicial")
    , @NamedQuery(name = "Tturnos.findByHorafinal", query = "SELECT t FROM Tturnos t WHERE t.horafinal = :horafinal")})
public class Tturnos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODTURNO")
    private Integer codturno;
    @Basic(optional = false)
    @Column(name = "ABREVTURNO")
    private String abrevturno;
    @Basic(optional = false)
    @Column(name = "DESCTURNO")
    private String descturno;
    @Basic(optional = false)
    @Column(name = "HORAINICIAL")
    private String horainicial;
    @Basic(optional = false)
    @Column(name = "HORAFINAL")
    private String horafinal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codturno")
    private Collection<Tfuncionarios> tfuncionariosCollection;

    public Tturnos() {
    }

    public Tturnos(Integer codturno) {
        this.codturno = codturno;
    }

    public Tturnos(Integer codturno, String abrevturno, String descturno, String horainicial, String horafinal) {
        this.codturno = codturno;
        this.abrevturno = abrevturno;
        this.descturno = descturno;
        this.horainicial = horainicial;
        this.horafinal = horafinal;
    }

    public Integer getCodturno() {
        return codturno;
    }

    public void setCodturno(Integer codturno) {
        this.codturno = codturno;
    }

    public String getAbrevturno() {
        return abrevturno;
    }

    public void setAbrevturno(String abrevturno) {
        this.abrevturno = abrevturno;
    }

    public String getDescturno() {
        return descturno;
    }

    public void setDescturno(String descturno) {
        this.descturno = descturno;
    }

    public String getHorainicial() {
        return horainicial;
    }

    public void setHorainicial(String horainicial) {
        this.horainicial = horainicial;
    }

    public String getHorafinal() {
        return horafinal;
    }

    public void setHorafinal(String horafinal) {
        this.horafinal = horafinal;
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
        hash += (codturno != null ? codturno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tturnos)) {
            return false;
        }
        Tturnos other = (Tturnos) object;
        if ((this.codturno == null && other.codturno != null) || (this.codturno != null && !this.codturno.equals(other.codturno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tturnos[ codturno=" + codturno + " ]";
    }
    
}
