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
 * @author yrmao
 */
public class Arglist extends AbstractHandler{

    public Arglist() {
        super();
        terminais.add(Token.IDENTIFICADOR);
    }

    @Override
    public boolean handle() {
        
        if (nextToken()) {
            if (terminais.contains(currentToken)) {
                removeToken();
                if (nextToken()) {
//                    return new Argument_list().handle(); //por que não é permitido
                    if (!(new Argument_list().handle())) {
                        //ouve algun erro no handler do argument_list
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
            // lista de Tokens vazia
            return false;
        }
        return true;
    }
}
