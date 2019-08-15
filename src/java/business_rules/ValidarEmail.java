/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_rules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author mayk-
 */
public class ValidarEmail {

    public boolean validarEmail(String email) {

        if (email != null && email.length() > 0) {
            
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            
            if (!matcher.matches()) {
                
                return false;
            }
        }

        return true;
    }
}