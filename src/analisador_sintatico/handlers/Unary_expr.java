/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

import analisador_lexico.Token;

/**
 *
 * @author talles
 */

public class Unary_expr extends AbstractHandler{

    public Unary_expr() {
        super();
    }

    
    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(currentToken == Token.OP_ADICAO || currentToken == Token.OP_SUBTRACAO){
                removeToken();
                if(nextToken()){
                    if(currentToken == Token.IDENTIFICADOR){
                        removeToken();
                    }else{
                        errorCode = 6;
                    }
                }else{
                    errorCode = 10;
                    return false;
                }
            }else if(currentToken == Token.IDENTIFICADOR){
                removeToken();
            }else{
                errorCode = 27;
                return false;
            }
        }else{
            errorCode = 26;
            return false;
        }
        
        return true;
    }    
}