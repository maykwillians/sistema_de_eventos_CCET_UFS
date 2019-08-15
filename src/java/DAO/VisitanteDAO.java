/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Visitante;
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
public class VisitanteDAO {

    private final Connection con = Conexao.getConnection();

    public void addVisitante(Visitante visitante) {

        //O nome da tabela no banco precisa estar tudo em minúsculo
        String sql = "INSERT INTO VISITANTE (tipo_usuario, nome, email, obs) values (?, ?, ?, ?)";

        PreparedStatement preparador;

        try {
            preparador = this.con.prepareStatement(sql);

            preparador.setInt(1, visitante.getTipoUsuario());
            preparador.setString(2, visitante.getNome());
            preparador.setString(3, visitante.getEmail());
            preparador.setString(4, visitante.getObs());

            preparador.execute();
            preparador.close();

            System.out.println("Visitante cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }

    public Visitante getOneForID(int id) {

        List<Visitante> lista = listAll();

        Visitante visitante = null;

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getId() == id) {

                visitante = lista.get(i);
            }
        }

        return visitante;
    }

    public Visitante getOneForEmail(String email) {

        List<Visitante> lista = listAll();

        Visitante visitante = null;

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getEmail().equals(email)) {

                visitante = lista.get(i);
            }
        }

        return visitante;
    }

    public List<Visitante> listAll() {

        List<Visitante> lista = new ArrayList<>();

        Statement st;
        ResultSet rs;

        try {

            st = con.createStatement();
            String sql = "select * from visitante";
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Visitante visitante = new Visitante();

                visitante.setId(rs.getInt(1));
                visitante.setTipoUsuario(rs.getInt(2));
                visitante.setNome(rs.getString(3));
                visitante.setEmail(rs.getString(4));
                visitante.setObs(rs.getString(5));

                lista.add(visitante);
            }

            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return lista;
    }
}