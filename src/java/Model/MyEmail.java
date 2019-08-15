/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author mayk-
 */
public class MyEmail {
    
    private String remetente;
    private String senha;
    
    private String destinatario;
    private String subDestinatario;
    private String titulo;
    private String conteudo;

    public MyEmail() {
    }

    public MyEmail(String remetente, String senha, String destinatario, String subDestinatario, String titulo, String conteudo) {
        this.remetente = remetente;
        this.senha = senha;
        this.destinatario = destinatario;
        this.subDestinatario = subDestinatario;
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getSubDestinatario() {
        return subDestinatario;
    }

    public void setSubDestinatario(String subDestinatario) {
        this.subDestinatario = subDestinatario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}