/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ADM;
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
public class AdmDAO {

    private final Connection con = Conexao.getConnection();

    public void addColaborador(ADM adm) {

        PreparedStatement preparador;

        //O nome da tabela no banco precisa estar tudo em minúsculo
        String sql = "INSERT INTO administrador (tipo_usuario, nome, email, senha, obs) values (?, ?, ?, ?, ?)";

        try {
            preparador = this.con.prepareStatement(sql);

            preparador.setInt(1, adm.getTipoUsuario());
            preparador.setString(2, adm.getNome());
            preparador.setString(3, adm.getEmail());
            preparador.setString(4, adm.getSenha());
            preparador.setString(5, adm.getObs());

            preparador.execute();
            preparador.close();

            System.out.println("Administrador cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }
    
    public List<ADM> listAll() {

        List<ADM> lista = new ArrayList<>();

        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            String sql = "select * from administrador";
            rs = st.executeQuery(sql);

            while (rs.next()) {

                ADM adm = new ADM();

                adm.setId(rs.getInt(1));
                adm.setTipoUsuario(rs.getInt(2));
                adm.setNome(rs.getString(3));
                adm.setEmail(rs.getString(4));
                adm.setSenha(rs.getString(5));
                adm.setObs(rs.getString(6));
                lista.add(adm);
            }
            
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return lista;
    }
    
    public void alterarSenha(ADM adm, String senha) {

        Statement stmt;

        try {
            stmt = con.createStatement();
            String sql = "UPDATE administrador SET senha = '" + senha + "' WHERE email = '" + adm.getEmail() + "'";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
        }
    }

    public ADM getOneForEmail(String email) {

        ADM adm = null;
        List<ADM> lista = listAll();

        for (int i = 0; i < lista.size(); i++) {

            if (lista.get(i).getEmail().equals(email)) {

                adm = lista.get(i);
            }
        }

        return adm;
    }
}