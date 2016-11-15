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
public class Import_as_name extends AbstractHandler {

    public Import_as_name() {
        super();
        terminais.contains(Token.AS);
        terminais.contains(Token.IDENTIFICADOR);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (terminais.contains(currentToken)) {
                removeToken();
                if (nextToken()) {
                    if (terminais.contains(currentToken)) {
                        removeToken();
                    } else {
                        //token "NAME" não foi encontrado
                        return false;
                    }
                } else {
                    //lista de tokens vazia
                    return false;
                }
            } else {
                //token "as" não foi encontrado
                //Import_as_name permite que não seja esperado nada
            }
        } else {
            //lista de tokens vazia
            return false;
        }
        return true;
    }

}
