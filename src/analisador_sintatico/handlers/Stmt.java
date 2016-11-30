/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

import Model.TokenModel;
import analisador_lexico.Token;
import static analisador_sintatico.handlers.AbstractHandler.currentToken;
import java.util.ArrayList;

/**
 *
 * @author yrmao
 */
public class Stmt extends AbstractHandler {

    public Stmt(ArrayList<TokenModel> tokens) {
        super(tokens);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            /*
            if (currentToken == Token.IDENTIFICADOR || currentToken == Token.DELETE || 
                    currentToken == Token.PASS || currentToken == Token.BREAK || 
                    currentToken == Token.CONTINUE || currentToken == Token.RETURN || 
                    currentToken == Token.YIELD || currentToken == Token.IMPORT || 
                    currentToken == Token.GLOBAL || currentToken == Token.NONLOCAL)  {
                //simple
                return new Simple_stmt(tokens).handle();
            } else if (currentToken == Token.IF || currentToken == Token.WHILE || 
                    currentToken == Token.DEF || currentToken == Token.CLASS || 
                    currentToken == Token.OP_ARROBA || currentToken == Token.ASYNC) {
                //compound
                return new Compound_stmt(tokens).handle();
            } else {
                errorCode = 3;
                return false;
            }
            */
            int flag = switchHelper();
            switch(flag){
                case 1:
                    return new Simple_stmt(tokens).handle();
                case 2:
                    return new Compound_stmt(tokens).handle();
                default:
                    errorCode = 3;
                    return false;
            }
        } else {
            errorCode = 25;
            return false;
        }
    }
    
    private int switchHelper(){
        
        if(currentToken == Token.IDENTIFICADOR || currentToken == Token.DELETE || 
                    currentToken == Token.PASS || currentToken == Token.BREAK || 
                    currentToken == Token.CONTINUE || currentToken == Token.RETURN || 
                    currentToken == Token.YIELD || currentToken == Token.IMPORT || 
                    currentToken == Token.GLOBAL || currentToken == Token.NONLOCAL){
            return 1;
        }else if(currentToken == Token.IF || currentToken == Token.WHILE || 
                    currentToken == Token.DEF || currentToken == Token.CLASS || 
                    currentToken == Token.OP_ARROBA || currentToken == Token.ASYNC){
            return 2;
        }else{
            return -1;
        }
        
    }
}
