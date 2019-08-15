/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_and_tables_managed;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import conexao_db.Conexao;

/**
 *
 * @author Mayk Willians
 */
public class TabelaVisitante {

    private final Connection con = Conexao.getConnection();

    public void criarTabela() {

        Statement stmt;

        try {

            DatabaseMetaData dbm = con.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "visitante", null);

            if (!tables.next()) {

                stmt = con.createStatement();
                String sql = "CREATE TABLE visitante "
                        + "(id serial primary key NOT NULL, "
                        + " tipo_usuario int NOT NULL, "
                        + " nome character varying(128) NOT NULL, "
                        + " email character varying(64) NOT NULL, "
                        + " obs character varying(1000))";

                stmt.executeUpdate(sql);
                stmt.close();
                tables.close();
                con.close();

                System.out.println("Tabela Visitante criada");
            }
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }
}