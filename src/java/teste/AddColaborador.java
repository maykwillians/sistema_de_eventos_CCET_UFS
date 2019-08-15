/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import business_rules.ColaboradorRules;

/**
 *
 * @author Mayk Willians
 */
public class AddColaborador {
    
    public static void main (String[] args) {
        
        ColaboradorRules colaboradorRules = new ColaboradorRules();
        
        colaboradorRules.addColaborador(1, 0, "Mayk Willians Santos Menezes", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "maykwillians@gmail.com", "123123", "");
//        colaboradorRules.addColaborador(1, 0, "Prof. Michelle Cardinale Souza Silva Macedo", 1, "DEPARTAMENTO DE CIÊNCIA E ENGENHARIA DE MATERIAIS - UFS (DCEM/UFS)", "contawarfacelug@gmail.com", "123123", "");
//        colaboradorRules.addColaborador(1, 0, "Richard Andres Estombelo", 5, "DEPARTAMENTO DE ENGENHARIA DE PRODUÇÃO - UFS (DEPRO/UFS)", "cceteventosufs@gmail.com", "123123", "");
//        colaboradorRules.addColaborador(1, 0, "Prof. Edward David Moreno Ordonez", 2, "DEPARTAMENTO DE COMPUTAÇÃO - UFS (DCOMP/UFS)", "maykwillians@gmail.com", "123123", ""); // Colaborador Professor
        
//        colaboradorRules.addColaborador(1, 0, "Prof. Adriano Bof de Oliveira", 13, "Departamento de Química - UFS (DQI/UFS)", "mayk-menezes@hotmail.com", "123123", ""); // Colaborador Professor
//        colaboradorRules.addColaborador(1, 0, "Prof. Emerson Luis de Santa Helena", 10, "Departamento de Física - UFS (DFI/UFS)", "contawarfacelug@gmail.com", "123123", ""); // Colaborador Professor
//        colaboradorRules.addColaborador(1, 0, "Prof. Roberto Souza", 8, "Departamento de Engenharia Química - UFS (DEQ/UFS)", "rrsouza.br@gmail.com", "123123", ""); // Colaborador Professor
//        colaboradorRules.addColaborador(1, 1, "Lucas Azevedo", 2, "mayk-menezes@hotmail.com", "123456", ""); // Colaborador Aluno
//        colaboradorRules.addColaborador(1, 2, "Mayk Willians Santos Menezes", 0, "maykwillians@gmail.com", "123456", ""); // Empresa Júnior ou outro órgão da UFS
//        colaboradorRules.addColaborador(1, 3, "Vanio Matos Azevedo", -1, "mayk-menezes@hotmail.com", "123456", ""); // Colaborador externo à UFS

//        // DEPARTAMENTO DE CIÊNCIA E ENGENHARIA DE MATERIAIS - UFS (DCEM/UFS)
//        colaboradorRules.addColaborador(1, 0, "Prof. Carlos Otavio Damas Martins", 1, "DEPARTAMENTO DE CIÊNCIA E ENGENHARIA DE MATERIAIS - UFS (DCEM/UFS)", "carlosmartinsufs@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Prof. Cristiane Xavier Resende", 1, "DEPARTAMENTO DE CIÊNCIA E ENGENHARIA DE MATERIAIS - UFS (DCEM/UFS)", "cristianexr@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Prof. Eduardo Kirinus Tentardini", 1, "DEPARTAMENTO DE CIÊNCIA E ENGENHARIA DE MATERIAIS - UFS (DCEM/UFS)", "etentardini@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Prof. Euler Araujo dos Santos", 1, "DEPARTAMENTO DE CIÊNCIA E ENGENHARIA DE MATERIAIS - UFS (DCEM/UFS)", "euler.ufs@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Prof. Jose Kaio Max Alves do Rego", 1, "DEPARTAMENTO DE CIÊNCIA E ENGENHARIA DE MATERIAIS - UFS (DCEM/UFS)", "kaiomax2000@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Prof. Ledjane Silva Barreto", 1, "DEPARTAMENTO DE CIÊNCIA E ENGENHARIA DE MATERIAIS - UFS (DCEM/UFS)", "ledjane.ufs@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Prof. Luis Eduardo Almeida", 1, "DEPARTAMENTO DE CIÊNCIA E ENGENHARIA DE MATERIAIS - UFS (DCEM/UFS)", "lealmeida2009@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Prof. Marcelo Massayoshi Ueki", 1, "DEPARTAMENTO DE CIÊNCIA E ENGENHARIA DE MATERIAIS - UFS (DCEM/UFS)", "mm_ueki@yahoo.com.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Prof. Michelle Cardinale Souza Silva Macedo", 1, "DEPARTAMENTO DE CIÊNCIA E ENGENHARIA DE MATERIAIS - UFS (DCEM/UFS)", "michellecardinales@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Prof. Rosane Maria Pessoa Betanio Oliveira", 1, "DEPARTAMENTO DE CIÊNCIA E ENGENHARIA DE MATERIAIS - UFS (DCEM/UFS)", "rosaneboliveira@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Prof. Sandra Andreia Stwart de Araujo Souza", 1, "DEPARTAMENTO DE CIÊNCIA E ENGENHARIA DE MATERIAIS - UFS (DCEM/UFS)", "sasouza.sandra@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Prof. Sandro Griza", 1, "DEPARTAMENTO DE CIÊNCIA E ENGENHARIA DE MATERIAIS - UFS (DCEM/UFS)", "griza@ufs.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Prof. Wilton Walter Batista ", 1, "DEPARTAMENTO DE CIÊNCIA E ENGENHARIA DE MATERIAIS - UFS (DCEM/UFS)", "wiltonwalter@hotmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Prof. Zora Ionara Gama dos Santos", 1, "DEPARTAMENTO DE CIÊNCIA E ENGENHARIA DE MATERIAIS - UFS (DCEM/UFS)", "ionarag@yahoo.com.br", senha(), "");
//        
//        // DEPARTAMENTO DE COMPUTAÇÃO - UFS (DCOMP/UFS)
//        colaboradorRules.addColaborador(1, 0, "", 2, "DEPARTAMENTO DE COMPUTAÇÃO - UFS (DCOMP/UFS)", "", senha(), "");
//        
//        // DEPARTAMENTO DE ENGENHARIA AMBIENTAL - UFS (DEAM/UFS)
//        colaboradorRules.addColaborador(1, 0, "Andrea Novelli", 3, "DEPARTAMENTO DE ENGENHARIA AMBIENTAL - UFS (DEAM/UFS)", "deanovel@yahoo.com.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Andre Luis Dantas Ramos", 3, "DEPARTAMENTO DE ENGENHARIA AMBIENTAL - UFS (DEAM/UFS)", "aldramos@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Bruno Santos Souza", 3, "DEPARTAMENTO DE ENGENHARIA AMBIENTAL - UFS (DEAM/UFS)", "bruffno@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Daniella Rocha", 3, "DEPARTAMENTO DE ENGENHARIA AMBIENTAL - UFS (DEAM/UFS)", "daniellarocha.ufs@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Inaura Carolina Carneiro da Rocha", 3, "DEPARTAMENTO DE ENGENHARIA AMBIENTAL - UFS (DEAM/UFS)", "inaura.rocha@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Jefferson Arlen Freitas", 3, "DEPARTAMENTO DE ENGENHARIA AMBIENTAL - UFS (DEAM/UFS)", "jaf68ster@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Joel Alonso Palomino Romero", 3, "DPT. DE ENGENHARIA AMBIENTAL - UFS (DEAM/UFS)", "joelalonsopr@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Jose Jailton Marques", 3, "DEPARTAMENTO DE ENGENHARIA AMBIENTAL - UFS (DEAM/UFS)", "jjailton@uol.com.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Paulo Sergio de Rezende Nascimento", 3, "DEPARTAMENTO DE ENGENHARIA AMBIENTAL - UFS (DEAM/UFS)", "psrn.geologia@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Rosemeri Melo e Souza", 3, "DEPARTAMENTO DE ENGENHARIA AMBIENTAL - UFS (DEAM/UFS)", "rosemerimeloesouza@gmail.com", senha(), "");
//        
//        // DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)
//        colaboradorRules.addColaborador(1, 0, "Alcigeimes Batista Celeste", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "geimes@yahoo.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Alexsandro Tenorio Porangaba", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "soualex@hotmail.com.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Ana Maria de Souza Martins Faria", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "anmsmfarias@yahoo.com.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Angela Teresa Costa Sales ", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "angelasales19@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Carlos Resende Cardozo Junior", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "Eng.carlosrezende@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Daniel Moureira Fontes Lima", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "danielmfl@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "David Leonardo Nascimento de Figueiredo Amorim", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "davidnf2@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Debora de Gois Santos", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "deboragois@yahoo.com.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Demostenes de Araujo Cavalcante Junior", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "geotec.csl@uol.com.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Denise Conceição de Gois Santos Michelan", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "denise_gois@yahoo.com.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Emerson Meireles de Carvalho", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "emerson@mecengenhariase.com.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Erinaldo Hilario Cavalcante", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "erinaldohc@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Fabio Carlos da Rocha", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "fabioengcivil@yahoo.com.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Fernando Luiz de Bragança Ferro", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "fernandoferroaju@uol.com.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Fernando Marcio de Oliveira", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "fernandomarcio@hotmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Fernando Silva Albuquerque", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "albuquerque.f.s@ufs.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Franciely Abati Miranda", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "Franciely.miranda@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Guilherme Bravo de Oliveira Almeida", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "gbravo1982@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Higor Sergio Dantas de Argolo", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "higorsergio@ufs.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Joelson Hora Costa", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "joelsonhcosta@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Jorge Carvalho Costa", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "jorgecostase@gmail.com  ", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Josinaide Silva Martins Maciel", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "arqjosi0105@gmail.com  ", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Luciana Coelho Mendonça", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "lucianamendonca@ufs.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Ludmilson Abritta Mendes", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "ludmilsonmendes@yahoo.com.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Marcelo Augusto Costa Maciel", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "mamaciel081169@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Marco Antonio Brarsiel Sampaio", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "marcobrasiel@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Michelline Nei Bomfim de Santana", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "michellinenei@yahoo.com.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Nilma Fontes de araujo Andrade", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "nilma@ufs.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Rejane Martins Fernandes Canha", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "Rejane_canha@yahoo.com.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Sandra Carla Lima Dorea", 4, "DEPARTAMENTO DE ENGENHARIA CIVIL - UFS (DEC/UFS)", "doreasandra@gmail.com", senha(), "");
//        
//        // DEPARTAMENTO DE ENGENHARIA DE PRODUÇÃO - UFS (DEPRO/UFS)
//        colaboradorRules.addColaborador(1, 0, "Luciano Fernandes Monteiro", 5, "DEPARTAMENTO DE ENGENHARIA DE PRODUÇÃO - UFS (DEPRO/UFS)", "lucianofm2007@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Veruschka Vieira Franca", 5, "DEPARTAMENTO DE ENGENHARIA DE PRODUÇÃO - UFS (DEPRO/UFS)", "veruschkafranca@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Celso Satoshi Sakuraba", 5, "DEPARTAMENTO DE ENGENHARIA DE PRODUÇÃO - UFS (DEPRO/UFS)", "celsosakuraba@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Emerson Cleister Lima Muniz", 5, "DEPARTAMENTO DE ENGENHARIA DE PRODUÇÃO - UFS (DEPRO/UFS)", "eng.prod.emerson@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Cleiton Rodrigues de Vasconcelos", 5, "DEPARTAMENTO DE ENGENHARIA DE PRODUÇÃO - UFS (DEPRO/UFS)", "cleitongv@yahoo.com.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Reynaldo Chile Palomino", 5, "DEPARTAMENTO DE ENGENHARIA DE PRODUÇÃO - UFS (DEPRO/UFS)", "reychile@hotmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Pedro Felipe de Abreu", 5, "DEPARTAMENTO DE ENGENHARIA DE PRODUÇÃO - UFS (DEPRO/UFS)", "deabreu.pedro@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Richard Andres Estombelo", 5, "DEPARTAMENTO DE ENGENHARIA DE PRODUÇÃO - UFS (DEPRO/UFS)", "restomb@hotmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Isabelly Pereira da Silva", 5, "DEPARTAMENTO DE ENGENHARIA DE PRODUÇÃO - UFS (DEPRO/UFS)", "isabelly@ufs.br", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Simone de Cassia Silva", 5, "DEPARTAMENTO DE ENGENHARIA DE PRODUÇÃO - UFS (DEPRO/UFS)", "scassia@gmail.com", senha(), "");
//        colaboradorRules.addColaborador(1, 0, "Daniel Pereira da silva", 5, "DEPARTAMENTO DE ENGENHARIA DE PRODUÇÃO - UFS (DEPRO/UFS)", "silvadp@hotmail.com", senha(), "");
//        
//        // DEPARTAMENTO DE ENGENHARIA ELÉTRICA - UFS (DEL/UFS)
//        colaboradorRules.addColaborador(1, 0, "", 6, "DEPARTAMENTO DE ENGENHARIA ELÉTRICA - UFS (DEL/UFS)", "", senha(), "");
    }
    
    public static String senha() {
        
        String[] carct = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String senha = "";

        for (int x = 0; x < 6; x++) {
            
            int j = (int) (Math.random() * carct.length);
            senha += carct[j];
        }
        
        return senha;
    }
}