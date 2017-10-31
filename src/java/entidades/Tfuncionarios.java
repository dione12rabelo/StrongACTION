/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TFUNCIONARIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tfuncionarios.findAll", query = "SELECT t FROM Tfuncionarios t")
    , @NamedQuery(name = "Tfuncionarios.findByCodfunc", query = "SELECT t FROM Tfuncionarios t WHERE t.codfunc = :codfunc")
    , @NamedQuery(name = "Tfuncionarios.findByNome", query = "SELECT t FROM Tfuncionarios t WHERE t.nome = :nome")
    , @NamedQuery(name = "Tfuncionarios.findBySituacao", query = "SELECT t FROM Tfuncionarios t WHERE t.situacao = :situacao")
    , @NamedQuery(name = "Tfuncionarios.findByComissao", query = "SELECT t FROM Tfuncionarios t WHERE t.comissao = :comissao")
    , @NamedQuery(name = "Tfuncionarios.findBySupervisor", query = "SELECT t FROM Tfuncionarios t WHERE t.supervisor = :supervisor")
    , @NamedQuery(name = "Tfuncionarios.findByEndereco", query = "SELECT t FROM Tfuncionarios t WHERE t.endereco = :endereco")
    , @NamedQuery(name = "Tfuncionarios.findByNumero", query = "SELECT t FROM Tfuncionarios t WHERE t.numero = :numero")
    , @NamedQuery(name = "Tfuncionarios.findByComplemento", query = "SELECT t FROM Tfuncionarios t WHERE t.complemento = :complemento")
    , @NamedQuery(name = "Tfuncionarios.findByBairro", query = "SELECT t FROM Tfuncionarios t WHERE t.bairro = :bairro")
    , @NamedQuery(name = "Tfuncionarios.findByCep", query = "SELECT t FROM Tfuncionarios t WHERE t.cep = :cep")
    , @NamedQuery(name = "Tfuncionarios.findByCidade", query = "SELECT t FROM Tfuncionarios t WHERE t.cidade = :cidade")
    , @NamedQuery(name = "Tfuncionarios.findByUf", query = "SELECT t FROM Tfuncionarios t WHERE t.uf = :uf")
    , @NamedQuery(name = "Tfuncionarios.findByTelefone", query = "SELECT t FROM Tfuncionarios t WHERE t.telefone = :telefone")
    , @NamedQuery(name = "Tfuncionarios.findByObservacoes", query = "SELECT t FROM Tfuncionarios t WHERE t.observacoes = :observacoes")
    , @NamedQuery(name = "Tfuncionarios.findByLoginmensageiro", query = "SELECT t FROM Tfuncionarios t WHERE t.loginmensageiro = :loginmensageiro")
    , @NamedQuery(name = "Tfuncionarios.findByOperadoraremarcarecibo", query = "SELECT t FROM Tfuncionarios t WHERE t.operadoraremarcarecibo = :operadoraremarcarecibo")})
public class Tfuncionarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODFUNC")
    private Integer codfunc;
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private String situacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COMISSAO")
    private Double comissao;
    @Column(name = "SUPERVISOR")
    private String supervisor;
    @Column(name = "ENDERECO")
    private String endereco;
    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Column(name = "BAIRRO")
    private String bairro;
    @Column(name = "CEP")
    private String cep;
    @Column(name = "CIDADE")
    private String cidade;
    @Column(name = "UF")
    private String uf;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "OBSERVACOES")
    private String observacoes;
    @Column(name = "LOGINMENSAGEIRO")
    private String loginmensageiro;
    @Column(name = "OPERADORAREMARCARECIBO")
    private Integer operadoraremarcarecibo;
    @OneToMany(mappedBy = "codfunc")
    private Collection<Tusuarios> tusuariosCollection;
    @JoinColumn(name = "CODCARGO", referencedColumnName = "CODCARGO")
    @ManyToOne(optional = false)
    private Tcargos codcargo;
    @JoinColumn(name = "CODTURNO", referencedColumnName = "CODTURNO")
    @ManyToOne(optional = false)
    private Tturnos codturno;

    public Tfuncionarios() {
    }

    public Tfuncionarios(Integer codfunc) {
        this.codfunc = codfunc;
    }

    public Tfuncionarios(Integer codfunc, String situacao) {
        this.codfunc = codfunc;
        this.situacao = situacao;
    }

    public Integer getCodfunc() {
        return codfunc;
    }

    public void setCodfunc(Integer codfunc) {
        this.codfunc = codfunc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getLoginmensageiro() {
        return loginmensageiro;
    }

    public void setLoginmensageiro(String loginmensageiro) {
        this.loginmensageiro = loginmensageiro;
    }

    public Integer getOperadoraremarcarecibo() {
        return operadoraremarcarecibo;
    }

    public void setOperadoraremarcarecibo(Integer operadoraremarcarecibo) {
        this.operadoraremarcarecibo = operadoraremarcarecibo;
    }

    @XmlTransient
    public Collection<Tusuarios> getTusuariosCollection() {
        return tusuariosCollection;
    }

    public void setTusuariosCollection(Collection<Tusuarios> tusuariosCollection) {
        this.tusuariosCollection = tusuariosCollection;
    }

    public Tcargos getCodcargo() {
        return codcargo;
    }

    public void setCodcargo(Tcargos codcargo) {
        this.codcargo = codcargo;
    }

    public Tturnos getCodturno() {
        return codturno;
    }

    public void setCodturno(Tturnos codturno) {
        this.codturno = codturno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codfunc != null ? codfunc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tfuncionarios)) {
            return false;
        }
        Tfuncionarios other = (Tfuncionarios) object;
        if ((this.codfunc == null && other.codfunc != null) || (this.codfunc != null && !this.codfunc.equals(other.codfunc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tfuncionarios[ codfunc=" + codfunc + " ]";
    }
    
}
