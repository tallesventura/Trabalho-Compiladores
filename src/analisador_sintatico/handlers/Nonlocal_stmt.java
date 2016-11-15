/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

import analisador_lexico.Token;
import static analisador_sintatico.handlers.AbstractHandler.currentToken;

/**
 *
 * @author talles
 */
public class Nonlocal_stmt extends AbstractHandler{

    public Nonlocal_stmt() {
        super();
        terminais.add(Token.NONLOCAL);
        terminais.add(Token.IDENTIFICADOR);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (terminais.contains(currentToken)) {
                removeToken();
                if (nextToken()) {
                    if (terminais.contains(currentToken)) {
                        removeToken();
                        if (nextToken()) {
                            if (!(new Arglist().handle())) {
                                //ouve algun erro no handler do nonlocal_stmt
                                return false;
                            }
                        } else {
                            //lista de tokens vazia
                            return false;
                        }
                    } else {
                        //token "NAME" não foi encontrado
                        return false;
                    }
                } else {
                    //lista de tokens vazia
                    return false;
                }
            } else {
                //token "nonlocal" não foi encontrado
                return false;
            }
        } else {
            //lista de tokens vazia
            return false;
        }
        return true;
    }
    
}
