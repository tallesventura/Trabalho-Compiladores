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

public class Unary_expr extends AbstractHandler{
    public Unary_expr(ArrayList<TokenModel> tokens) {
        super(tokens);
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
                        AbstractHandler.errorCode = 6;
                    }
                }else{
                    AbstractHandler.errorCode = 10;
                    return false;
                }
            }else if(currentToken == Token.IDENTIFICADOR){
                removeToken();
            }else{
                AbstractHandler.errorCode = 27;
                return false;
            }
        }else{
            AbstractHandler.errorCode = 26;
            return false;
        }
        
        return true;
    }    
}
