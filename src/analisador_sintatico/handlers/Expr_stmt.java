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
public class Expr_stmt extends AbstractHandler {

    public Expr_stmt() {
        super();
    }
    
    

    @Override
    public boolean handle() {

        if (nextToken()) {
            if (currentToken == Token.IDENTIFICADOR) {
                removeToken();
                if (nextToken()) {
                    if (new Augassign().handle()) {
                        if (nextToken()) {
                            return new Expr().handle();
                        }else{
                            errorCode = 13;
                            return false;
                        }
                    }
                }else{
                    errorCode = 8;
                    return false;
                }
            } else {
                errorCode = 6;
            }
        } else {
            errorCode = 10;
            return false;
        }

        return true;
    }

}
