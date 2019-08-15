/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_rules;

import DAO.AdmDAO;
import Model.ADM;
import Model.Colaborador;
import Model.MyEmail;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author mayk-
 */
public class ADMRules {

    private final ADM adm = new ADM();
    private final AdmDAO admDAO = new AdmDAO();

    public void addADM(int tipoUsuario, String nome, String email, String senha, String obs) {

        this.adm.setTipoUsuario(tipoUsuario);
        this.adm.setNome(nome);
        this.adm.setEmail(email);
        this.adm.setSenha(senha);
        this.adm.setObs(obs);
        
        this.admDAO.addColaborador(this.adm);
    }
    
    public ADM getOneForEmail(String email) {

        return this.admDAO.getOneForEmail(email);
    }
    
    public void alterarSenha(ADM adm, String senha) {

        this.admDAO.alterarSenha(adm, senha);
    }
    
    public void emailRecuperarSenha(ADM adm) throws EmailException {

        String htmlText = "<div class=\"media-body\">\n"
                + "                        <h3><b>CCET - UFS: RECUPERAÇÃO DE SENHA</b></h3>\n"
                + "                        <br>\n"
                + "                        <h3 class=\"media-heading\"><b>Estamos enviando o seu login e senha de acesso ao nosso sistema, conforme solicitado:</b></h3>\n"
                + "                        <b>Login: </b> " + adm.getEmail() + "\n"
                + "                        <br>\n"
                + "                        <b>Senha: </b> " + adm.getSenha() + "\n"
                + "                        <br>\n"
                + "                        <br>\n"
                + "                        <b>Agradeço pela compreensão e qualquer dúvida e/ou esclarecimento entre em contato.</b>\n"
                + "                        <br>\n"
                + "                        <b>Direção do CCET: secretaria.ccet@ufs.br / direcao.ccet@ufs.br</b>\n"
                + "                        <br>\n"
                + "                    </div>";

        MyEmail myEmail = new MyEmail();
        myEmail.setRemetente("cceteventosufs@gmail.com");
        myEmail.setSenha("cceteventos");
        myEmail.setDestinatario(adm.getEmail());
        myEmail.setTitulo("CCET - UFS: Recuperação de senha");
        myEmail.setConteudo(htmlText);

        HtmlEmail email = new HtmlEmail();
        email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
        email.addTo(myEmail.getDestinatario()); //destinatário
        email.setFrom(myEmail.getRemetente()); // remetente
        email.setSubject(myEmail.getTitulo()); // assunto do e-mail
        email.setHtmlMsg(myEmail.getConteudo()); //conteudo do e-mail
        email.setAuthentication(myEmail.getRemetente(), myEmail.getSenha()); // Autenticação
        email.setSmtpPort(465);
        email.setSSL(true);
        email.setTLS(true);
        email.send();
    }
    
    public void emailDivulgacao() throws EmailException {
        
        String htmlText = "<div class=\"media-body\">\n"
                + "                        <h4>Acesse nosso site para visualizar os eventos do CCET: http://www.ccetnews.ufs.br</h4>\n"
                + "                        <br>\n"
                + "                        <b>Agradeço pela compreensão e qualquer dúvida e/ou esclarecimento entre em contato.</b>\n"
                + "                        <br>\n"
                + "                        <b>Direção do CCET: secretaria.ccet@ufs.br / direcao.ccet@ufs.br</b>\n"
                + "                        <br>\n"
                + "                    </div>";

        List<String> listEmails = new ArrayList();

        List<ADM> listADMs = new ADMRules().listAll();
        List<Colaborador> listColaborador = new ColaboradorRules().listAll();
//        List<Visitante> listVisitante = new VisitanteRules().listAll();

        for (int i = 0; i < listADMs.size(); i++) {

            listEmails.add(listADMs.get(i).getEmail());
        }
        
        for (int i = 0; i < listColaborador.size(); i++) {
            
            listEmails.add(listColaborador.get(i).getEmail());
        }
//        for (int i = 0; i < listVisitante.size(); i++) {
//            
//            listEmails.add(listVisitante.get(i).getEmail());
//        }
        
        for (int i = 0; i < listEmails.size(); i++) {
            
            MyEmail myEmail = new MyEmail();
            myEmail.setRemetente("cceteventosufs@gmail.com");
            myEmail.setSenha("cceteventos");
            myEmail.setDestinatario(listEmails.get(i));
            myEmail.setTitulo("CCET - UFS, Novos eventos confirmados");
            myEmail.setConteudo(htmlText);

            HtmlEmail email = new HtmlEmail();
            email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
            email.addTo(myEmail.getDestinatario()); //destinatário
            email.setFrom(myEmail.getRemetente()); // remetente
            email.setSubject(myEmail.getTitulo()); // assunto do e-mail
            email.setHtmlMsg(myEmail.getConteudo()); //conteudo do e-mail
            email.setAuthentication(myEmail.getRemetente(), myEmail.getSenha()); // Autenticação
            email.setSmtpPort(465);
            email.setSSL(true);
            email.setTLS(true);
            email.send();
        }
    }
    
    public List<ADM> listAll() {
        
        return this.admDAO.listAll();
    }
}