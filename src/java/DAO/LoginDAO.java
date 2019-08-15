/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.ADM;
import Model.Colaborador;
import Model.Usuario;
import conexao_db.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mayk-
 */
public class LoginDAO {

    private final Connection con = Conexao.getConnection();

    public Usuario getUsuarioForLogin(String email, String senha) {

        Usuario usuario;

        usuario = verificaADM(email, senha);
        if (usuario != null) {

            return usuario;
        }

        usuario = verificaColaborador(email, senha);
        if (usuario != null) {

            return usuario;
        }

        return null;
    }

    public ADM verificaADM(String email, String senha) {

        PreparedStatement preparador;
        ResultSet rs;

        ADM adm = new ADM();

        String sqlADM = "select * from administrador where email = ? and senha = ? ";

        try {
            preparador = this.con.prepareStatement(sqlADM);

            preparador.setString(1, email);
            preparador.setString(2, senha);

            rs = preparador.executeQuery();

            if (rs.next()) {

                PreparedStatement preparador2;
                ResultSet rs2;
                
                //Faz o acesso ao DB e carrega os dados do usuário
                String sqlADMaux = "select id, tipo_usuario, nome, email, senha, obs from administrador where email = '" + email + "' and senha = '" + senha + "'";
                preparador2 = this.con.prepareStatement(sqlADMaux);
                rs2 = preparador2.executeQuery();

                while (rs2.next()) {

                    adm.setId(rs2.getInt("id"));
                    adm.setTipoUsuario(rs2.getInt("tipo_usuario"));
                    adm.setNome(rs2.getString("nome"));
                    adm.setEmail(rs2.getString("email"));
                    adm.setSenha(rs2.getString("senha"));
                    adm.setObs(rs2.getString("obs"));
                }
                
                preparador.close();
                rs.close();

                preparador2.close();
                rs2.close();
                
                return adm;
            }

            preparador.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return null;
    }

    public Colaborador verificaColaborador(String email, String senha) {

        PreparedStatement preparador;
        ResultSet rs;

        Colaborador colaborador = new Colaborador();

        String sqlColaborador = "select * from colaborador where email = ? and senha = ? ";

        try {
            preparador = this.con.prepareStatement(sqlColaborador);

            preparador.setString(1, email);
            preparador.setString(2, senha);

            rs = preparador.executeQuery();

            if (rs.next()) {

                PreparedStatement preparador2;
                ResultSet rs2;
                
                //Faz o acesso ao DB e carrega os dados do usuário
                String sqlColaboradorAux = "select id, tipo_usuario, tipo_colaborador, nome, dpt, nome_dpt, email, senha, obs from colaborador where email = '" + email + "' and senha = '" + senha + "'";
                preparador2 = this.con.prepareStatement(sqlColaboradorAux);
                rs2 = preparador2.executeQuery();

                while (rs2.next()) {

                    colaborador.setId(rs2.getInt("id"));
                    colaborador.setTipoUsuario(rs2.getInt("tipo_usuario"));
                    colaborador.setTipoColaborador(rs2.getInt("tipo_colaborador"));
                    colaborador.setNome(rs2.getString("nome"));
                    colaborador.setDpt(rs2.getInt("dpt"));
                    colaborador.setNomeDpt(rs2.getString("nome_dpt"));
                    colaborador.setEmail(rs2.getString("email"));
                    colaborador.setSenha(rs2.getString("senha"));
                    colaborador.setObs(rs2.getString("obs"));
                }
                
                preparador.close();
                rs.close();

                preparador2.close();
                rs2.close();
                
                return colaborador;
            }

            preparador.close();
            rs.close();
            
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }

        return null;
    }
}