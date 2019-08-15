/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Evento;
import conexao_db.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mayk-
 */
public class EventoDAO {

    private final Connection con = Conexao.getConnection();

    public void addEvento(Evento evento) {

        PreparedStatement preparador;

        //O nome da tabela no banco precisa estar tudo em minúsculo
        String sql = "INSERT INTO EVENTO (status, nome, tipo, data, hora_inicio, duracao, local, nome_criador, email_criador, nome_responsavel, email_responsavel, tipo_dpt, nome_dpt, resumo, url_img, id_colaborador, acessos, obs) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            preparador = this.con.prepareStatement(sql);

            preparador.setInt(1, evento.getStatus());
            preparador.setString(2, evento.getNome());
            preparador.setInt(3, evento.getTipo());
            preparador.setString(4, evento.getData());
            preparador.setInt(5, evento.getHoraInicio());
            preparador.setInt(6, evento.getDuracao());
            preparador.setString(7, evento.getLocal());
            preparador.setString(8, evento.getNomeCriador());
            preparador.setString(9, evento.getEmailCriador());
            preparador.setString(10, evento.getNomeResponsavel());
            preparador.setString(11, evento.getEmailResponsavel());
            preparador.setInt(12, evento.getTipoDpt());
            preparador.setString(13, evento.getNomeDpt());
            preparador.setString(14, evento.getResusmo());
            preparador.setString(15, evento.getUrlImg());
            preparador.setInt(16, evento.getIdColaborador());
            preparador.setInt(17, evento.getAcessos());
            preparador.setString(18, evento.getObs());

            preparador.execute();
            preparador.close();

            System.out.println("Evento cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }

    // Reprova ou Aprova Evento
    public void updateStatus(int status, int id) {

        Statement stmt;

        try {
            stmt = con.createStatement();
            String sql = "UPDATE evento SET status = '" + status + "' WHERE id = '" + id + "'";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
        }
    }
    
    public void updateAcessos(int acessos, int id) {

        Statement stmt;

        try {
            stmt = con.createStatement();
            String sql = "UPDATE evento SET acessos = '" + acessos + "' WHERE id = '" + id + "'";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
        }
    }

    public Evento getOneForID(int id) {

        Evento eventoEncontrado = new Evento();

        List<Evento> lista = listAll();

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getId() == id) {

                eventoEncontrado = lista.get(i);
            }
        }

        return eventoEncontrado;
    }

    public List<Evento> listAll() {

        List<Evento> lista = new ArrayList<>();

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            String sql = "select * from evento";
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Evento evento = new Evento();

                evento.setId(rs.getInt(1));
                evento.setStatus(rs.getInt(2));
                evento.setNome(rs.getString(3));
                evento.setTipo(rs.getInt(4));
                evento.setData(rs.getString(5));
                evento.setHoraInicio(rs.getInt(6));
                evento.setDuracao(rs.getInt(7));
                evento.setLocal(rs.getString(8));
                evento.setNomeCriador(rs.getString(9));
                evento.setEmailCriador(rs.getString(10));
                evento.setNomeResponsavel(rs.getString(11));
                evento.setEmailResponsavel(rs.getString(12));
                evento.setTipoDpt(rs.getInt(13));
                evento.setNomeDpt(rs.getString(14));
                evento.setResusmo(rs.getString(15));
                evento.setUrlImg(rs.getString(16));
                evento.setIdColaborador(rs.getInt(17));
                evento.setAcessos(rs.getInt(18));
                evento.setObs(rs.getString(19));

                lista.add(evento);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return lista;
    }
    
    public List<Evento> listByStatus(int status) {

        List<Evento> lista = new ArrayList<>();

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            String sql = "select * from evento where status = " + status;
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Evento evento = new Evento();

                evento.setId(rs.getInt(1));
                evento.setStatus(rs.getInt(2));
                evento.setNome(rs.getString(3));
                evento.setTipo(rs.getInt(4));
                evento.setData(rs.getString(5));
                evento.setHoraInicio(rs.getInt(6));
                evento.setDuracao(rs.getInt(7));
                evento.setLocal(rs.getString(8));
                evento.setNomeCriador(rs.getString(9));
                evento.setEmailCriador(rs.getString(10));
                evento.setNomeResponsavel(rs.getString(11));
                evento.setEmailResponsavel(rs.getString(12));
                evento.setTipoDpt(rs.getInt(13));
                evento.setNomeDpt(rs.getString(14));
                evento.setResusmo(rs.getString(15));
                evento.setUrlImg(rs.getString(16));
                evento.setIdColaborador(rs.getInt(17));
                evento.setAcessos(rs.getInt(18));
                evento.setObs(rs.getString(19));

                lista.add(evento);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return lista;
    }
    
    public List<Evento> listByStatusAndDpt(int status, int dpt) {

        List<Evento> lista = new ArrayList<>();

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            String sql = "select * from evento where status = " + status + " and tipo_dpt = " + dpt;
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Evento evento = new Evento();

                evento.setId(rs.getInt(1));
                evento.setStatus(rs.getInt(2));
                evento.setNome(rs.getString(3));
                evento.setTipo(rs.getInt(4));
                evento.setData(rs.getString(5));
                evento.setHoraInicio(rs.getInt(6));
                evento.setDuracao(rs.getInt(7));
                evento.setLocal(rs.getString(8));
                evento.setNomeCriador(rs.getString(9));
                evento.setEmailCriador(rs.getString(10));
                evento.setNomeResponsavel(rs.getString(11));
                evento.setEmailResponsavel(rs.getString(12));
                evento.setTipoDpt(rs.getInt(13));
                evento.setNomeDpt(rs.getString(14));
                evento.setResusmo(rs.getString(15));
                evento.setUrlImg(rs.getString(16));
                evento.setIdColaborador(rs.getInt(17));
                evento.setAcessos(rs.getInt(18));
                evento.setObs(rs.getString(19));

                lista.add(evento);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return lista;
    }
    
    public List<Evento> listByColaborador(String emailColaborador) {

        List<Evento> lista = new ArrayList<>();

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            String sql = "select * from evento where email_criador = '" + emailColaborador + "'";
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Evento evento = new Evento();

                evento.setId(rs.getInt(1));
                evento.setStatus(rs.getInt(2));
                evento.setNome(rs.getString(3));
                evento.setTipo(rs.getInt(4));
                evento.setData(rs.getString(5));
                evento.setHoraInicio(rs.getInt(6));
                evento.setDuracao(rs.getInt(7));
                evento.setLocal(rs.getString(8));
                evento.setNomeCriador(rs.getString(9));
                evento.setEmailCriador(rs.getString(10));
                evento.setNomeResponsavel(rs.getString(11));
                evento.setEmailResponsavel(rs.getString(12));
                evento.setTipoDpt(rs.getInt(13));
                evento.setNomeDpt(rs.getString(14));
                evento.setResusmo(rs.getString(15));
                evento.setUrlImg(rs.getString(16));
                evento.setIdColaborador(rs.getInt(17));
                evento.setAcessos(rs.getInt(18));
                evento.setObs(rs.getString(19));

                lista.add(evento);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return lista;
    }
    
    public List<Evento> listByIdColaborador(int id) {

        List<Evento> lista = new ArrayList<>();

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            String sql = "select * from evento where id_colaborador = " + id;
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Evento evento = new Evento();

                evento.setId(rs.getInt(1));
                evento.setStatus(rs.getInt(2));
                evento.setNome(rs.getString(3));
                evento.setTipo(rs.getInt(4));
                evento.setData(rs.getString(5));
                evento.setHoraInicio(rs.getInt(6));
                evento.setDuracao(rs.getInt(7));
                evento.setLocal(rs.getString(8));
                evento.setNomeCriador(rs.getString(9));
                evento.setEmailCriador(rs.getString(10));
                evento.setNomeResponsavel(rs.getString(11));
                evento.setEmailResponsavel(rs.getString(12));
                evento.setTipoDpt(rs.getInt(13));
                evento.setNomeDpt(rs.getString(14));
                evento.setResusmo(rs.getString(15));
                evento.setUrlImg(rs.getString(16));
                evento.setIdColaborador(rs.getInt(17));
                evento.setAcessos(rs.getInt(18));
                evento.setObs(rs.getString(19));

                lista.add(evento);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return lista;
    }
    
    public List<Evento> listByDpt(int dpt) {

        List<Evento> lista = new ArrayList<>();

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            String sql = "select * from evento where tipo_dpt = " + dpt;
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Evento evento = new Evento();

                evento.setId(rs.getInt(1));
                evento.setStatus(rs.getInt(2));
                evento.setNome(rs.getString(3));
                evento.setTipo(rs.getInt(4));
                evento.setData(rs.getString(5));
                evento.setHoraInicio(rs.getInt(6));
                evento.setDuracao(rs.getInt(7));
                evento.setLocal(rs.getString(8));
                evento.setNomeCriador(rs.getString(9));
                evento.setEmailCriador(rs.getString(10));
                evento.setNomeResponsavel(rs.getString(11));
                evento.setEmailResponsavel(rs.getString(12));
                evento.setTipoDpt(rs.getInt(13));
                evento.setNomeDpt(rs.getString(14));
                evento.setResusmo(rs.getString(15));
                evento.setUrlImg(rs.getString(16));
                evento.setIdColaborador(rs.getInt(17));
                evento.setAcessos(rs.getInt(18));
                evento.setObs(rs.getString(19));

                lista.add(evento);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return lista;
    }
    
    public List<Evento> listByData(int status, String data) {

        List<Evento> lista = new ArrayList<>();

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            String sql = "select * from evento where status = '" + status + "' and data = '" + data + "'";
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Evento evento = new Evento();

                evento.setId(rs.getInt(1));
                evento.setStatus(rs.getInt(2));
                evento.setNome(rs.getString(3));
                evento.setTipo(rs.getInt(4));
                evento.setData(rs.getString(5));
                evento.setHoraInicio(rs.getInt(6));
                evento.setDuracao(rs.getInt(7));
                evento.setLocal(rs.getString(8));
                evento.setNomeCriador(rs.getString(9));
                evento.setEmailCriador(rs.getString(10));
                evento.setNomeResponsavel(rs.getString(11));
                evento.setEmailResponsavel(rs.getString(12));
                evento.setTipoDpt(rs.getInt(13));
                evento.setNomeDpt(rs.getString(14));
                evento.setResusmo(rs.getString(15));
                evento.setUrlImg(rs.getString(16));
                evento.setIdColaborador(rs.getInt(17));
                evento.setAcessos(rs.getInt(18));
                evento.setObs(rs.getString(19));

                lista.add(evento);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return lista;
    }
    
    public List<Evento> listByTipo(int status, int tipo) {

        List<Evento> lista = new ArrayList<>();

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            String sql = "select * from evento where status = '" + status + "' and tipo = '" + tipo + "'";
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Evento evento = new Evento();

                evento.setId(rs.getInt(1));
                evento.setStatus(rs.getInt(2));
                evento.setNome(rs.getString(3));
                evento.setTipo(rs.getInt(4));
                evento.setData(rs.getString(5));
                evento.setHoraInicio(rs.getInt(6));
                evento.setDuracao(rs.getInt(7));
                evento.setLocal(rs.getString(8));
                evento.setNomeCriador(rs.getString(9));
                evento.setEmailCriador(rs.getString(10));
                evento.setNomeResponsavel(rs.getString(11));
                evento.setEmailResponsavel(rs.getString(12));
                evento.setTipoDpt(rs.getInt(13));
                evento.setNomeDpt(rs.getString(14));
                evento.setResusmo(rs.getString(15));
                evento.setUrlImg(rs.getString(16));
                evento.setIdColaborador(rs.getInt(17));
                evento.setAcessos(rs.getInt(18));
                evento.setObs(rs.getString(19));

                lista.add(evento);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return lista;
    }
}