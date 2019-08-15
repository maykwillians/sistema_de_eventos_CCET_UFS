/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_rules;

import DAO.ColaboradorDAO;
import Model.Colaborador;
import Model.MyEmail;
import java.util.List;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author mayk-
 */
public class ColaboradorRules {

    private final Colaborador colaborador = new Colaborador();
    private final ColaboradorDAO colaboradorDAO = new ColaboradorDAO();

    public boolean addColaborador(int tipoUsuario, int tipoColaborador, String nome, int dpt, String nomeDpt, String email, String senha, String obs) {

        // Primeiro verifica se já existe. Se não existir, cadastra
        if (getOneForEmail(email) == null) {
            
            this.colaborador.setTipoUsuario(tipoUsuario);
            this.colaborador.setTipoColaborador(tipoColaborador);
            this.colaborador.setNome(nome);
            this.colaborador.setDpt(dpt);
            this.colaborador.setNomeDpt(nomeDpt);
            this.colaborador.setEmail(email);
            this.colaborador.setSenha(senha);
            this.colaborador.setObs(obs);

            this.colaboradorDAO.addColaborador(this.colaborador);
            
            return true;
        }
        
        return false;
    }
    
    public List<Colaborador> listAll() {
        
        return this.colaboradorDAO.listAll();
    }
    
    public Colaborador getOneForEmail(String email) {

        return this.colaboradorDAO.getOneForEmail(email);
    }
    
    public Colaborador getOneForID(int id) {

        return this.colaboradorDAO.getOneForID(id);
    }
    
    public void alterarSenha(Colaborador colaborador, String senha) {

        this.colaboradorDAO.alterarSenha(colaborador, senha);
    }
    
    public boolean deleteOne(int id) {

        return this.colaboradorDAO.deleteOneForID(id);
    }
    
    public void emailRecuperarSenha(Colaborador colaborador) throws EmailException {

        String htmlText = "<div class=\"media-body\">\n"
                + "                        <h3><b>CCET - UFS: RECUPERAÇÃO DE SENHA</b></h3>\n"
                + "                        <br>\n"
                + "                        <h3 class=\"media-heading\"><b>Estamos enviando o seu login e senha de acesso ao nosso sistema, conforme solicitado:</b></h3>\n"
                + "                        <b>Login: </b> " + colaborador.getEmail() + "\n"
                + "                        <br>\n"
                + "                        <b>Senha: </b> " + colaborador.getSenha() + "\n"
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
        myEmail.setDestinatario(colaborador.getEmail());
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
}