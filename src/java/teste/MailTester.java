/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mayk-
 */
public class MailTester {

    public static void main(String[] args) {
        MailJava mj = new MailJava();
        //configuracoes de envio
        mj.setSmtpHostMail("smtp.gmail.com");
        mj.setSmtpPortMail("587");
        mj.setSmtpAuth("true");
        mj.setSmtpStarttls("true");
        mj.setUserMail("cceteventosufs@gmail.com");
        mj.setFromNameMail("seuNome");
        mj.setPassMail("cceteventos");
        mj.setCharsetMail("ISO-8859-1");
        mj.setSubjectMail("JavaMail");
        mj.setBodyMail(htmlMessage());
        mj.setTypeTextMail(MailJava.TYPE_TEXT_HTML);

        //sete quantos destinatarios desejar
        Map<String, String> map = new HashMap<String, String>();
        map.put("maykwillians@gmail.com", "email bol");
//        map.put("cceteventosufs@gmail.com", "email msn");
        map.put("mayk-menezes@hotmail.com", "email hot");
        map.put("contawarfacelug@gmail.com", "email ig");

        mj.setToMailsUsers(map);

//        //seta quatos anexos desejar
//        List<String> files = new ArrayList<String>();
//        files.add("C:\images\ajax_loader.gif");
//        files.add("C:\images\hover_next.png");
//        files.add("C:\images\hover_prev.png");
//
//        mj.setFileMails(files);
        try {
            new MailJavaSender().senderMail(mj);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static String textMessage() {
        return "Leia o novo tutorial JavaMail do Programando com Java.n"
                + "Saiba como enviar emails com anexo, em formato texto e html.n"
                + "Envie seu email para mais de um destinatario.";
    }

    private static String htmlMessage() {
        return "<html> "
                + "<head>"
                + "<title>Email no formato HTML com Javamail!</title> "
                + "</head> "
                + "<body> "
                + "<div style='background-color:orange; width:28%; height:100px;'>"
                + "<ul>  "
                + "<li>Leia o novo tutorial JavaMail do Programando com Java.</li> "
                + "<li>Aprenda como enviar emails com anexos.</li>"
                + " <li>Aprenda como enviar emails em formato texto simples ou html.</li> "
                + "<li>Aprenda como enviar seu email para mais de um destinatario.</li>"
                + "</ul> "
                + "<p>Visite o blog "
                + "<a href='http://mballem.wordpress.com/' target='new'>Programando com Java</a>"
                + "</p>"
                + "</div>"
                + "<div style='background-color:FFFFF; width:28%; height:50px;' align='center'>"
                + "Download do JavaMail<br/>"
                + "<a href='http://www.oracle.com/technetwork/java/javaee/index-138643.html'>"
                + "<img src='http://www.oracleimg.com/admin/images/ocom/hp/oralogo_small.gif'/>"
                + "</a> "
                + "</div>"
                + "</body> "
                + "</html>";
    }
}