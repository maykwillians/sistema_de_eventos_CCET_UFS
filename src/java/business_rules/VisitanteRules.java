/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_rules;

import DAO.VisitanteDAO;
import Model.Visitante;
import java.util.List;

/**
 *
 * @author mayk-
 */
public class VisitanteRules {

    private final Visitante visitante = new Visitante();
    private final VisitanteDAO visitanteDAO = new VisitanteDAO();

    public boolean addVisitante(String nome, String email) {

        if (!verificaSeExistePeloEmail(email)) {
            
            this.visitante.setTipoUsuario(2); // Sempre será 2, porque 2 é o tipo de usuário visitante
            this.visitante.setNome(nome);
            this.visitante.setEmail(email);
            this.visitante.setObs(""); // por enquanto será vazio. Pode ser modificado em manutenções posteriores ;)
            
            this.visitanteDAO.addVisitante(this.visitante);
            
            return true;
        }
        return false;
    }
    
    public boolean verificaSeExistePeloEmail(String email) {
        
        return this.visitanteDAO.getOneForEmail(email) != null;
    }
    
    public boolean verificaSeExistePeloID(int id) {
        
        return this.visitanteDAO.getOneForID(id) != null;
    }
    
    public List<Visitante> listAll() {
        
        return this.visitanteDAO.listAll();
    }
}