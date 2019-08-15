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
public class TabelaEvento {

    private final Connection con = Conexao.getConnection();

    public void criarTabela() {

        Statement stmt;

        try {

            DatabaseMetaData dbm = con.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "evento", null);

            if (!tables.next()) {

                stmt = con.createStatement();
                String sql = "CREATE TABLE evento "
                        + "(id serial primary key NOT NULL, "
                        + " status int NOT NULL, "
                        + " nome character varying(256) NOT NULL, "
                        + " tipo int NOT NULL, "
                        + " data character varying(10) NOT NULL, "
                        + " hora_inicio int NOT NULL, " // Em minutos
                        + " duracao int NOT NULL, " // Em minutos
                        + " local character varying(256) NOT NULL, "
                        + " nome_criador character varying(128) NOT NULL, "
                        + " email_criador character varying(64) NOT NULL, "
                        + " nome_responsavel character varying(128) NOT NULL, "
                        + " email_responsavel character varying(64) NOT NULL, "
                        + " tipo_dpt int NOT NULL, "
                        + " nome_dpt character varying(128) NOT NULL, "
                        + " resumo character varying(5000) NOT NULL, "
                        + " url_img character varying(300) NOT NULL, "
                        + " id_colaborador int NOT NULL, "
                        + " acessos int NOT NULL, "
                        + " obs character varying(1000))";

                stmt.executeUpdate(sql);
                stmt.close();
                tables.close();
                con.close();

                System.out.println("Tabela Evento criada");
            }
        } catch (SQLException e) {
            System.out.println("Erro - " + e.getMessage());
        }
    }
}