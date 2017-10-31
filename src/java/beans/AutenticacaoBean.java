/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entidades.Tusuarios;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;
import util.JpaUtil;

/**
 *
 * @author dione
 */
@ManagedBean
@SessionScoped
public class AutenticacaoBean implements Serializable {

    public AutenticacaoBean() {
    }

    private Tusuarios tusuarios = new Tusuarios();

    public String logar() {

        try {

            EntityManager manager = JpaUtil.getManager();
            Tusuarios usuarioBuscado = null;
            String senha;

            try {
                       
                // Inicia uma transação com o banco de dados.
                manager.getTransaction().begin();
                //Busca usuário
                usuarioBuscado = manager.createNamedQuery("Tusuarios.findByLogin", Tusuarios.class)
                        .setParameter("login", tusuarios.getLogin())
                        .getSingleResult();
                // Finaliza a transação.
                manager.getTransaction().commit();
                
                //JpaUtil.closeManager(manager);
            } catch (Exception e) {
               //Finaliza transãção.
            }finally{
                JpaUtil.closeManager(manager);
               
            }

            //Verifica usuário
            if (usuarioBuscado.getSenhajava() != null) {

                senha = criptografa(tusuarios.getSenhajava());
                // Valida Usuário
                if (usuarioBuscado != null
                        && usuarioBuscado.getSenhajava().equals(senha)) {
                    tusuarios = usuarioBuscado;
                    tusuarios.setLogado(true);
                    limpar();
                    return "index?faces-redirect=true";
                } else {
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage("Login ou senha inválido!"));
                    limpar();
                    return null;
                }
            } if(usuarioBuscado.getSenhajava() == null){
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage("Altere sua senha no primeiro!"));
                limpar();
                return null;
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contate o Suporte Técnico!", e.getMessage()));
        }
        return null;

    }

    public String logout() {

        tusuarios.setLogado(false);
        HttpSession session
                = (HttpSession) FacesContext.getCurrentInstance()
                        .getExternalContext().getSession(true);
        if (session != null) {
            session.invalidate();
        }
        return "login?faces-redirect=true";
    }

    public String criptografa(String senha) {

        MessageDigest mDigest;

        try {
            //Instanciamos o nosso HASH MD5, poderíamos usar outro como
            //SHA, por exemplo, mas optamos por MD5.
            mDigest = MessageDigest.getInstance("MD5");

            //Convert a String valor para um array de bytes em MD5
            byte[] valorMD5 = mDigest.digest(senha.getBytes("UTF-8"));

            //Convertemos os bytes para hexadecimal, assim podemos salvar
            //no banco para posterior comparação se senhas
            StringBuffer sb = new StringBuffer();
            for (byte b : valorMD5) {
                sb.append(Integer.toHexString((b & 0xFF)
                        | 0x100).substring(1, 3));
            }
            //FacesContext contexto = FacesContext.getCurrentInstance();
            //contexto.addMessage(null, new FacesMessage("Mensagem: " + sb));

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AutenticacaoBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void limpar() {

        tusuarios = new Tusuarios();
    }

    public Tusuarios getTusuarios() {
        return tusuarios;
    }

    public void setTusuarios(Tusuarios tusuarios) {
        this.tusuarios = tusuarios;
    }

}
