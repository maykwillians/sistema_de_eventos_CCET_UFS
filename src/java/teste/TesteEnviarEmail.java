/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import Model.MyEmail;
import business_rules.EventoRules;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author mayk-
 */
public class TesteEnviarEmail {

    public static void main(String args[]) {

        try {
            SimpleEmail email = new SimpleEmail();
            email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e-mail
            email.addTo("maykwillians@gmail.com", "Mayk"); //destinatário
            email.setFrom("cceteventosufs@gmail.com", "CCET"); // remetente
            email.setSubject("Teste -> Email simples"); // assunto do e-mail
            email.setMsg("Teste de Email utilizando commons-email"); //conteudo do e-mail
            email.setAuthentication("cceteventosufs@gmail.com", "cceteventos");
            email.setSmtpPort(465);
            email.setSSL(true);
            email.setTLS(true);
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(TesteEnviarEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}