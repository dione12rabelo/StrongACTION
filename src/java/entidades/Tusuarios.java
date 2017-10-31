/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dione
 */
@Entity
@Table(name = "TUSUARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tusuarios.findAll", query = "SELECT t FROM Tusuarios t")
    , @NamedQuery(name = "Tusuarios.findByCodusuario", query = "SELECT t FROM Tusuarios t WHERE t.codusuario = :codusuario")
    , @NamedQuery(name = "Tusuarios.findByLogin", query = "SELECT t FROM Tusuarios t WHERE t.login = :login")
    , @NamedQuery(name = "Tusuarios.findBySenha", query = "SELECT t FROM Tusuarios t WHERE t.senha = :senha")
    , @NamedQuery(name = "Tusuarios.findByDtultalteracao", query = "SELECT t FROM Tusuarios t WHERE t.dtultalteracao = :dtultalteracao")
    , @NamedQuery(name = "Tusuarios.findByCodagente", query = "SELECT t FROM Tusuarios t WHERE t.codagente = :codagente")
    , @NamedQuery(name = "Tusuarios.findBySenhajava", query = "SELECT t FROM Tusuarios t WHERE t.senhajava = :senhajava")})
public class Tusuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODUSUARIO")
    private Integer codusuario;
    @Basic(optional = false)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @Column(name = "SENHA")
    private String senha;
    @Column(name = "DTULTALTERACAO")
    @Temporal(TemporalType.DATE)
    private Date dtultalteracao;
    @Column(name = "CODAGENTE")
    private Integer codagente;
    @Column(name = "SENHAJAVA")
    private String senhajava;
    @JoinColumn(name = "CODFUNC", referencedColumnName = "CODFUNC")
    @ManyToOne
    private Tfuncionarios codfunc;
    @JoinColumn(name = "CODGRUPO", referencedColumnName = "CODGRUPO")
    @ManyToOne(optional = false)
    private Tgrupos codgrupo;

    @Transient
    private boolean logado;

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    public Tusuarios() {
    }

    public Tusuarios(Integer codusuario) {
        this.codusuario = codusuario;
    }

    public Tusuarios(Integer codusuario, String login, String senhajava) {
        this.codusuario = codusuario;
        this.login = login;
        this.senhajava = senhajava;
    }

    public Integer getCodusuario() {
        return codusuario;
    }

    public void setCodusuario(Integer codusuario) {
        this.codusuario = codusuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
            this.login = login.toUpperCase();
    }

    public String getSenha() {
         return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenhajava() {
        return senhajava;
    }

    public void setSenhajava(String senhajava) {
        this.senhajava = senhajava.toUpperCase();
    }

    public Date getDtultalteracao() {
        return dtultalteracao;
    }

    public void setDtultalteracao(Date dtultalteracao) {
        this.dtultalteracao = dtultalteracao;
    }

    public Integer getCodagente() {
        return codagente;
    }

    public void setCodagente(Integer codagente) {
        this.codagente = codagente;
    }

    public Tfuncionarios getCodfunc() {
        return codfunc;
    }

    public void setCodfunc(Tfuncionarios codfunc) {
        this.codfunc = codfunc;
    }

    public Tgrupos getCodgrupo() {
        return codgrupo;
    }

    public void setCodgrupo(Tgrupos codgrupo) {
        this.codgrupo = codgrupo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codusuario != null ? codusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tusuarios)) {
            return false;
        }
        Tusuarios other = (Tusuarios) object;
        if ((this.codusuario == null && other.codusuario != null) || (this.codusuario != null && !this.codusuario.equals(other.codusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tusuarios[ codusuario=" + codusuario + " ]";
    }

}
