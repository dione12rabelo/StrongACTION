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
@Table(name = "VRECDEVOLVIDOSWEB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vrecdevolvidosweb.findAll", query = "SELECT v FROM Vrecdevolvidosweb v")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByCodcontrib", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.codcontrib = :codcontrib")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByNome", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.nome = :nome")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByDtrepique", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.dtrepique = :dtrepique")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByValorultdoacao", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.valorultdoacao = :valorultdoacao")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByDtultdoacao", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.dtultdoacao = :dtultdoacao")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByDesccategoria", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.desccategoria = :desccategoria")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByTempodescanso", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.tempodescanso = :tempodescanso")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByCodfunc", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.codfunc = :codfunc")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByFuncnome", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.funcnome = :funcnome")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByCodturno", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.codturno = :codturno")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByDescturno", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.descturno = :descturno")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByCidade", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.cidade = :cidade")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByEndereco", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.endereco = :endereco")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByBairro", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.bairro = :bairro")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByUf", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.uf = :uf")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByObservacoes", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.observacoes = :observacoes")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByDtpagto", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.dtpagto = :dtpagto")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByTelefone", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.telefone = :telefone")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByDataultligacao", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.dataultligacao = :dataultligacao")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByCodcategoria", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.codcategoria = :codcategoria")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByCat", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.cat = :cat")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByNrorecibo", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.nrorecibo = :nrorecibo")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByDtcobranca", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.dtcobranca = :dtcobranca")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByCodoperador", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.codoperador = :codoperador")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByOperadorarecdevolv", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.operadorarecdevolv = :operadorarecdevolv")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByMotivodevolucao", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.motivodevolucao = :motivodevolucao")
    , @NamedQuery(name = "Vrecdevolvidosweb.findByDtdevolucao", query = "SELECT v FROM Vrecdevolvidosweb v WHERE v.dtdevolucao = :dtdevolucao")})
public class Vrecdevolvidosweb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "CODCONTRIB")
    @Id
    private Integer codcontrib;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "DTREPIQUE")
    @Temporal(TemporalType.DATE)
    private Date dtrepique;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "VALORULTDOACAO")
    private Double valorultdoacao;
    @Column(name = "DTULTDOACAO")
    @Temporal(TemporalType.DATE)
    private Date dtultdoacao;
    @Column(name = "DESCCATEGORIA")
    private String desccategoria;
    @Column(name = "TEMPODESCANSO")
    private Integer tempodescanso;
    @Column(name = "CODFUNC")
    private Integer codfunc;
    @Column(name = "FUNCNOME")
    private String funcnome;
    @Column(name = "CODTURNO")
    private Integer codturno;
    @Column(name = "DESCTURNO")
    private String descturno;
    @Column(name = "CIDADE")
    private String cidade;
    @Column(name = "ENDERECO")
    private String endereco;
    @Column(name = "BAIRRO")
    private String bairro;
    @Column(name = "UF")
    private String uf;
    @Column(name = "OBSERVACOES")
    private String observacoes;
    @Column(name = "DTPAGTO")
    private String dtpagto;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "DATAULTLIGACAO")
    @Temporal(TemporalType.DATE)
    private Date dataultligacao;
    @Column(name = "CODCATEGORIA")
    private Integer codcategoria;
    @Column(name = "CAT")
    private String cat;
    @Column(name = "NRORECIBO")
    private Integer nrorecibo;
    @Column(name = "DTCOBRANCA")
    @Temporal(TemporalType.DATE)
    private Date dtcobranca;
    @Column(name = "CODOPERADOR")
    private Integer codoperador;
    @Column(name = "OPERADORARECDEVOLV")
    private String operadorarecdevolv;
    @Column(name = "MOTIVODEVOLUCAO")
    private String motivodevolucao;
    @Column(name = "DTDEVOLUCAO")
    @Temporal(TemporalType.DATE)
    private Date dtdevolucao;

    public Vrecdevolvidosweb() {
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

    public Date getDtrepique() {
        return dtrepique;
    }

    public void setDtrepique(Date dtrepique) {
        this.dtrepique = dtrepique;
    }

    public Double getValorultdoacao() {
        return valorultdoacao;
    }

    public void setValorultdoacao(Double valorultdoacao) {
        this.valorultdoacao = valorultdoacao;
    }

    public Date getDtultdoacao() {
        return dtultdoacao;
    }

    public void setDtultdoacao(Date dtultdoacao) {
        this.dtultdoacao = dtultdoacao;
    }

    public String getDesccategoria() {
        return desccategoria;
    }

    public void setDesccategoria(String desccategoria) {
        this.desccategoria = desccategoria;
    }

    public Integer getTempodescanso() {
        return tempodescanso;
    }

    public void setTempodescanso(Integer tempodescanso) {
        this.tempodescanso = tempodescanso;
    }

    public Integer getCodfunc() {
        return codfunc;
    }

    public void setCodfunc(Integer codfunc) {
        this.codfunc = codfunc;
    }

    public String getFuncnome() {
        return funcnome;
    }

    public void setFuncnome(String funcnome) {
        this.funcnome = funcnome;
    }

    public Integer getCodturno() {
        return codturno;
    }

    public void setCodturno(Integer codturno) {
        this.codturno = codturno;
    }

    public String getDescturno() {
        return descturno;
    }

    public void setDescturno(String descturno) {
        this.descturno = descturno;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getDtpagto() {
        return dtpagto;
    }

    public void setDtpagto(String dtpagto) {
        this.dtpagto = dtpagto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataultligacao() {
        return dataultligacao;
    }

    public void setDataultligacao(Date dataultligacao) {
        this.dataultligacao = dataultligacao;
    }

    public Integer getCodcategoria() {
        return codcategoria;
    }

    public void setCodcategoria(Integer codcategoria) {
        this.codcategoria = codcategoria;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public Integer getNrorecibo() {
        return nrorecibo;
    }

    public void setNrorecibo(Integer nrorecibo) {
        this.nrorecibo = nrorecibo;
    }

    public Date getDtcobranca() {
        return dtcobranca;
    }

    public void setDtcobranca(Date dtcobranca) {
        this.dtcobranca = dtcobranca;
    }

    public Integer getCodoperador() {
        return codoperador;
    }

    public void setCodoperador(Integer codoperador) {
        this.codoperador = codoperador;
    }

    public String getOperadorarecdevolv() {
        return operadorarecdevolv;
    }

    public void setOperadorarecdevolv(String operadorarecdevolv) {
        this.operadorarecdevolv = operadorarecdevolv;
    }

    public String getMotivodevolucao() {
        return motivodevolucao;
    }

    public void setMotivodevolucao(String motivodevolucao) {
        this.motivodevolucao = motivodevolucao;
    }

    public Date getDtdevolucao() {
        return dtdevolucao;
    }

    public void setDtdevolucao(Date dtdevolucao) {
        this.dtdevolucao = dtdevolucao;
    }
    
}
