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
@Table(name = "V_INFORMATIVO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VInformativo.findAll", query = "SELECT v FROM VInformativo v")
    , @NamedQuery(name = "VInformativo.findByCodcontrib", query = "SELECT v FROM VInformativo v WHERE v.codcontrib = :codcontrib")
    , @NamedQuery(name = "VInformativo.findByDoador", query = "SELECT v FROM VInformativo v WHERE v.doador = :doador")
    , @NamedQuery(name = "VInformativo.findByOperador", query = "SELECT v FROM VInformativo v WHERE v.operador = :operador")
    , @NamedQuery(name = "VInformativo.findByStatusCadastro", query = "SELECT v FROM VInformativo v WHERE v.statusCadastro = :statusCadastro")
    , @NamedQuery(name = "VInformativo.findByFormaPagamento", query = "SELECT v FROM VInformativo v WHERE v.formaPagamento = :formaPagamento")
    , @NamedQuery(name = "VInformativo.findByLogradouro", query = "SELECT v FROM VInformativo v WHERE v.logradouro = :logradouro")
    , @NamedQuery(name = "VInformativo.findByNumero", query = "SELECT v FROM VInformativo v WHERE v.numero = :numero")
    , @NamedQuery(name = "VInformativo.findByComplemento", query = "SELECT v FROM VInformativo v WHERE v.complemento = :complemento")
    , @NamedQuery(name = "VInformativo.findByBairro", query = "SELECT v FROM VInformativo v WHERE v.bairro = :bairro")
    , @NamedQuery(name = "VInformativo.findByCep", query = "SELECT v FROM VInformativo v WHERE v.cep = :cep")
    , @NamedQuery(name = "VInformativo.findByCidade", query = "SELECT v FROM VInformativo v WHERE v.cidade = :cidade")
    , @NamedQuery(name = "VInformativo.findByUf", query = "SELECT v FROM VInformativo v WHERE v.uf = :uf")
    , @NamedQuery(name = "VInformativo.findByDtcadastro", query = "SELECT v FROM VInformativo v WHERE v.dtcadastro = :dtcadastro")
    , @NamedQuery(name = "VInformativo.findByCategoria", query = "SELECT v FROM VInformativo v WHERE v.categoria = :categoria")})
public class VInformativo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CODCONTRIB")
    @Id
    private Integer codcontrib;
    @Column(name = "DOADOR")
    private String doador;
    @Column(name = "OPERADOR")
    private String operador;
    @Column(name = "STATUS_CADASTRO")
    private String statusCadastro;
    @Column(name = "FORMA_PAGAMENTO")
    private String formaPagamento;
    @Column(name = "LOGRADOURO")
    private String logradouro;
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
    @Column(name = "DTCADASTRO")
    @Temporal(TemporalType.DATE)
    private Date dtcadastro;
    @Column(name = "CATEGORIA")
    private String categoria;

    public VInformativo() {
    }

    public Integer getCodcontrib() {
        return codcontrib;
    }

    public void setCodcontrib(Integer codcontrib) {
        this.codcontrib = codcontrib;
    }

    public String getDoador() {
        return doador;
    }

    public void setDoador(String doador) {
        this.doador = doador;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getStatusCadastro() {
        return statusCadastro;
    }

    public void setStatusCadastro(String statusCadastro) {
        this.statusCadastro = statusCadastro;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
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

    public Date getDtcadastro() {
        return dtcadastro;
    }

    public void setDtcadastro(Date dtcadastro) {
        this.dtcadastro = dtcadastro;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
}
