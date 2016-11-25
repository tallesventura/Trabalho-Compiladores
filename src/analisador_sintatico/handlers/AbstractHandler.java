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
    
    protected static ArrayList<TokenModel> tokens;
    protected ArrayList<Token> terminais;
    protected static Token currentToken;
    protected int errorCode = 0;

    public AbstractHandler(ArrayList<TokenModel> tokens) {
        this.terminais = new ArrayList();
        this.tokens = tokens;
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
    
    public String getCurrentLexema(){
        String lexema = "";
        if(tokens.size() > 0){
            lexema = tokens.get(0).getLexema();
        }
        return lexema;
    }
    
    public int getCurrentLine(){
        int line = -1;
        if(tokens.size() > 0){
            line = tokens.get(0).getLinha();
        }
        return line;
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

    public int getErrorCode() {
        return errorCode;
    }
   
    
}
