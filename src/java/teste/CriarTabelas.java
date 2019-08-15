/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import db_and_tables_managed.GerarTabelas;

/**
 *
 * @author Mayk Willians
 */
public class CriarTabelas {
    
    public static void main (String[] args) {
        
        new GerarTabelas().criarTabelas();
    }
}