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
public class Small_stmt extends AbstractHandler{

    public Small_stmt(ArrayList<TokenModel> tokens) {
        super(tokens);
    }
    

    @Override
    public boolean handle() {
        // break, continue, return yield
        /*
        if(nextToken()){
            if(currentToken == Token.IDENTIFICADOR){
                return new Expr_stmt(tokens).handle();
            }else if(currentToken == Token.DELETE){
                return new Del_stmt(tokens).handle();
            }else if(currentToken == Token.PASS){
                return new Pass(tokens).handle();
            }else if(currentToken == Token.BREAK || currentToken == Token.CONTINUE ||
                    currentToken == Token.RETURN || currentToken == Token.YIELD){
                return new Flow_stmt(tokens).handle();
            }else if(currentToken == Token.IMPORT){
                return new Import_stmt(tokens).handle();
            }else if(currentToken == Token.GLOBAL){
                return new Global_stmt(tokens).handle();
            }else if(currentToken == Token.NONLOCAL){
                return new Nonlocal_stmt(tokens).handle();
            }
            
            else{
                errorCode = 3;
                return false;
            }
            */
            
            switch(currentToken){
                case IDENTIFICADOR:
                    return new Expr_stmt(tokens).handle();
                case DELETE:
                    return new Del_stmt(tokens).handle();
                case PASS:
                    return new Pass(tokens).handle();
                case BREAK:
                    return new Flow_stmt(tokens).handle();
                case CONTINUE:
                    return new Flow_stmt(tokens).handle();
                case RETURN:
                    return new Flow_stmt(tokens).handle();
                case YIELD:
                    return new Flow_stmt(tokens).handle();
                case IMPORT:
                    return new Import_stmt(tokens).handle();
                case GLOBAL:
                    return new Global_stmt(tokens).handle();
                case NONLOCAL:
                    return new Nonlocal_stmt(tokens).handle();
                default:
                    AbstractHandler.errorCode = 3;
                    return false;
            }
    }
    
}
