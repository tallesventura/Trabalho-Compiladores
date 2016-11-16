/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico;

import Model.ErrorModel;
import Model.TokenModel;
import analisador_lexico.Token;
import analisador_sintatico.handlers.Single_input;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author talles
 */
public class AnalisadorSintatico{
    
    private ArrayList<TokenModel> tokens;
    private Single_input handler;
    private ArrayList<Token> tokensRecomeco;
    private ArrayList<ErrorModel> errorList;
    
    public AnalisadorSintatico(ArrayList<TokenModel> tokens) {
        this.tokens = tokens;
        this.handler = new Single_input(tokens);
        this.errorList = new ArrayList();
        
        this.tokensRecomeco = new ArrayList();
        tokensRecomeco.add(Token.IF);
        tokensRecomeco.add(Token.WHILE);
        tokensRecomeco.add(Token.FOR);
        tokensRecomeco.add(Token.DEF);
        tokensRecomeco.add(Token.CLASS);
        tokensRecomeco.add(Token.OP_ARROBA);
        tokensRecomeco.add(Token.ASYNC);
        tokensRecomeco.add(Token.IDENTIFICADOR);
        tokensRecomeco.add(Token.DELETE);
        tokensRecomeco.add(Token.PASS);
        tokensRecomeco.add(Token.BREAK);
        tokensRecomeco.add(Token.CONTINUE);
        tokensRecomeco.add(Token.RETURN);
        tokensRecomeco.add(Token.YIELD);
        tokensRecomeco.add(Token.IMPORT);
        tokensRecomeco.add(Token.GLOBAL);
        tokensRecomeco.add(Token.NONLOCAL);   
    }
    
    public ArrayList run(){
        
        Iterator<TokenModel> it = tokens.iterator();
        while(it.hasNext()){
            if(!handler.handle()){
                int errorCode = handler.getErrorCode();
                String lexema = handler.getCurrentLexema();
                int linha = handler.getCurrentLine();
                ErrorModel error = new ErrorModel(errorCode, lexema, linha);
                errorList.add(error);
                
                recuperaErro();
                this.handler = new Single_input(tokens);
            }
        }
        
        return errorList;
    }
    
    public void recuperaErro(){
        Iterator<TokenModel> it = tokens.iterator();
        while(it.hasNext()){
            TokenModel tm = it.next();
            if(!tokensRecomeco.contains(tm.getNome())){
                it.remove();
            }else{
                break;
            }
        }
    }
}
