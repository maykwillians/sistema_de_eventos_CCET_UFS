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
public class Evento implements Comparable<Evento>{

    private int id;
    private int status; // 0 - Solicitado, 1 - Aprovado, 2 - Reprovado, 3 - Cancelado
    private String nome;
    private int tipo; // 1 - Palestra, 2 - Seminário, 3 - Congresso, 4 - Simpósio,
                      // 5 - Minicurso, 6 - Apresentação de Projeto ou Estágio, 7 - Apresentação de TCC,
                      // 8 - Defesa de Mestrado, 9 - Defesa de Doutorado, 10 - Outro
    private String data;
    private int horaInicio;
    private int duracao;
    private String local;
    private String nomeCriador;
    private String emailCriador;
    private String nomeResponsavel;
    private String emailResponsavel;
    private int tipoDpt;
    private String nomeDpt;
    private String resusmo;
    private String urlImg;
    private int idColaborador;
    private int acessos;
    private String obs;

    public Evento() {

    }

    public Evento(int id, int status, String nome, int tipo, String data, int horaInicio, int duracao, String local, String nomeCriador, String emailCriador, String nomeResponsavel, String emailResponsavel, int tipoDpt, String nomeDpt, String resusmo, String urlImg, int idColaborador, int acessos, String obs) {
        this.id = id;
        this.status = status;
        this.nome = nome;
        this.tipo = tipo;
        this.data = data;
        this.horaInicio = horaInicio;
        this.duracao = duracao;
        this.local = local;
        this.nomeCriador = nomeCriador;
        this.emailCriador = emailCriador;
        this.nomeResponsavel = nomeResponsavel;
        this.emailResponsavel = emailResponsavel;
        this.tipoDpt = tipoDpt;
        this.nomeDpt = nomeDpt;
        this.resusmo = resusmo;
        this.urlImg = urlImg;
        this.idColaborador = idColaborador;
        this.acessos = acessos;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getNomeCriador() {
        return nomeCriador;
    }

    public void setNomeCriador(String nomeCriador) {
        this.nomeCriador = nomeCriador;
    }

    public String getEmailCriador() {
        return emailCriador;
    }

    public void setEmailCriador(String emailCriador) {
        this.emailCriador = emailCriador;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getEmailResponsavel() {
        return emailResponsavel;
    }

    public void setEmailResponsavel(String emailResponsavel) {
        this.emailResponsavel = emailResponsavel;
    }

    public int getTipoDpt() {
        return tipoDpt;
    }

    public void setTipoDpt(int tipoDpt) {
        this.tipoDpt = tipoDpt;
    }

    public String getNomeDpt() {
        return nomeDpt;
    }

    public void setNomeDpt(String nomeDpt) {
        this.nomeDpt = nomeDpt;
    }

    public String getResusmo() {
        return resusmo;
    }

    public void setResusmo(String resusmo) {
        this.resusmo = resusmo;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
    }

    public int getAcessos() {
        return acessos;
    }

    public void setAcessos(int acessos) {
        this.acessos = acessos;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", status=" + status + ", nome=" + nome + ", tipo=" + tipo + ", data=" + data + ", horaInicio=" + horaInicio + ", duracao=" + duracao + ", local=" + local + ", nomeCriador=" + nomeCriador + ", emailCriador=" + emailCriador + ", nomeResponsavel=" + nomeResponsavel + ", emailResponsavel=" + emailResponsavel + ", tipoDpt=" + tipoDpt + ", nomeDpt=" + nomeDpt + ", resusmo=" + resusmo + ", urlImg=" + urlImg + ", idColaborador=" + idColaborador + ", acessos=" + acessos + ", obs=" + obs + '}';
    }

    @Override
    public int compareTo(Evento evento) {
        
        if (this.acessos > evento.getAcessos()) {
            
            return -1;
        } else {
            
            if (this.acessos < evento.getAcessos()) {
                
                return 1;
            }
        }
        
        return 0;
    }
}