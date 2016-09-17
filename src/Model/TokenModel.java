/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author tallesventura
 */
public class TokenModel {
    
    int id;
    String simbolo;
    String nome;
    int linha;

    public TokenModel(int id, String simbolo, String nome, int linha) {
        this.id = id;
        this.simbolo = simbolo;
        this.nome = nome;
        this.linha = linha;
    }

    public int getId() {
        return id;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getNome() {
        return nome;
    }

    public int getLinha() {
        return linha;
    }


    
    
}

