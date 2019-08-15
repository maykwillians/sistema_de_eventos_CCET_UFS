/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author mayk-
 */
public class Colaborador extends Usuario {

    private int tipoColaborador; // 0 - Professor, 1 - Aluno, 2 - Secretaria
    private int dpt;
    private String nomeDpt;

    public Colaborador() {

    }

    public Colaborador(int tipoColaborador, int dpt, String nomeDpt) {

        this.tipoColaborador = tipoColaborador;
        this.dpt = dpt;
        this.nomeDpt = nomeDpt;
    }

    public int getTipoColaborador() {
        return tipoColaborador;
    }

    public void setTipoColaborador(int tipoColaborador) {
        this.tipoColaborador = tipoColaborador;
    }

    public int getDpt() {
        return dpt;
    }

    public void setDpt(int dpt) {
        this.dpt = dpt;
    }

    public String getNomeDpt() {
        return nomeDpt;
    }

    public void setNomeDpt(String nomeDpt) {
        this.nomeDpt = nomeDpt;
    }
}