/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import analisador_lexico.Token;

/**
 *
 * @author tallesventura
 */
public class TokenModel {
    
    private int ID;
    private int linha;
    private Token nome;
    private String lexema;

    public TokenModel(int ID, int linha, Token nome, String lexema) {
        this.ID = ID;
        this.linha = linha;
        this.nome = nome;
        this.lexema = lexema;
    }
    

    public int getID() {
        return ID;
    }

    public int getLinha() {
        return linha;
    }

    public Token getNome() {
        return nome;
    }

    public String getLexema() {
        return lexema;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public void setNome(Token nome) {
        this.nome = nome;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }
    
    
}
