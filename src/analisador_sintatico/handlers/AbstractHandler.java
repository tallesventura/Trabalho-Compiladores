/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

import Model.TokenModel;
import analisador_lexico.Token;
import java.util.ArrayList;

/**
 *
 * @author talles
 */
public abstract class AbstractHandler implements IHandler{
    
    protected ArrayList<TokenModel> tokens;
    protected ArrayList<Integer> terminais;
    protected static Token currentToken;
    protected int errorCode = 0;

    public AbstractHandler(ArrayList<TokenModel> tokenList) {
        this.terminais = new ArrayList();
        this.tokens = tokenList;
    }
    
    public AbstractHandler(){
        this.terminais = new ArrayList();
    }
    
    public boolean nextToken(){
        if(tokens.size() > 0){
            this.currentToken = tokens.get(0).getNome();
            return true;
        }else{
            currentToken = null;
            return false;
        }
    }
    
    public boolean removeToken(){
        if(tokens.size() > 0 ){
            tokens.remove(0);
            return true;
        }else{
            return false;
        }      
    }
    
    public int getNumTokens(){
        return tokens.size();
    }
    
    
    
}
