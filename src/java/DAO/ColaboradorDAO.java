/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Colaborador;
import conexao_db.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mayk-
 */
public class ColaboradorDAO {

    private final Connection con = Conexao.getConnection();

    public void addColaborador(Colaborador colaborador) {
        
        //O nome da tabela no banco precisa estar tudo em minúsculo
        String sql = "INSERT INTO COLABORADOR (tipo_usuario, tipo_colaborador, nome, dpt, nome_dpt, email, senha, obs) values (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparador;

        try {
            
            preparador = this.con.prepareStatement(sql);

            preparador.setInt(1, colaborador.getTipoUsuario());
            preparador.setInt(2, colaborador.getTipoColaborador());
            preparador.setString(3, colaborador.getNome());
            preparador.setInt(4, colaborador.getDpt());
            preparador.setString(5, colaborador.getNomeDpt());
            preparador.setString(6, colaborador.getEmail());
            preparador.setString(7, colaborador.getSenha());
            preparador.setString(8, colaborador.getObs());

            preparador.execute();
            preparador.close();

            System.out.println("Colaborador cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }
    
    public void alterarSenha(Colaborador colaborador, String senha) {

        Statement stmt;

        try {
            stmt = con.createStatement();
            String sql = "UPDATE colaborador SET senha = '" + senha + "' WHERE email = '" + colaborador.getEmail() + "'";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
        }
    }

    public List<Colaborador> listAll() {

        List<Colaborador> lista = new ArrayList<>();

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            String sql = "select * from colaborador";
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Colaborador colaborador = new Colaborador();

                colaborador.setId(rs.getInt(1));
                colaborador.setTipoUsuario(rs.getInt(2));
                colaborador.setTipoColaborador(rs.getInt(3));
                colaborador.setNome(rs.getString(4));
                colaborador.setDpt(rs.getInt(5));
                colaborador.setNomeDpt(rs.getString(6));
                colaborador.setEmail(rs.getString(7));
                colaborador.setSenha(rs.getString(8));
                colaborador.setObs(rs.getString(9));
                
                lista.add(colaborador);
            }
            
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return lista;
    }

    public Colaborador getOneForEmail(String email) {

        Colaborador colaborador = null;
        List<Colaborador> lista = listAll();

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getEmail().equals(email)) {

                colaborador = lista.get(i);
            }
        }

        return colaborador;
    }

    public Colaborador getOneForID(int id) {

        Colaborador colaborador = null;
        List<Colaborador> lista = listAll();

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getId() == id) {

                colaborador = lista.get(i);
            }
        }

        return colaborador;
    }
    
    public boolean deleteOneForID(int id) {

        Statement st;
        String sql = "DELETE FROM colaborador WHERE id = " + id;
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(ColaboradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}