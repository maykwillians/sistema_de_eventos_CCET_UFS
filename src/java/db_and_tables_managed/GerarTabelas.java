/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_and_tables_managed;

/**
 *
 * @author Mayk Willians
 */
public class GerarTabelas {
    
    public void criarTabelas() {
        
        new TabelaEvento().criarTabela();
        new TabelaColaborador().criarTabela();
        new TabelaADM().criarTabela();
        new TabelaVisitante().criarTabela();
    }
}