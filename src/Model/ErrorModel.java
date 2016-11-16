/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author talles
 */
public class ErrorModel {
    private int codigo;
    private String lexema;
    private int linha;

    public ErrorModel(int codigo, String lexema, int linha) {
        this.codigo = codigo;
        this.lexema = lexema;
        this.linha = linha;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getLexema() {
        return lexema;
    }

    public int getLinha() {
        return linha;
    }
    
}
