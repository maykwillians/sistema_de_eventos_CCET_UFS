/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import business_rules.ADMRules;

/**
 *
 * @author Mayk Willians
 */
public class AddADM {

    public static void main(String[] args) {

        ADMRules admRules = new ADMRules();
        admRules.addADM(0, "Adm System", "cceteventosufs@gmail.com", "123123", "");
    }
}