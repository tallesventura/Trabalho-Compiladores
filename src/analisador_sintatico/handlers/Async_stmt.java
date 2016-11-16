/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

import analisador_lexico.Token;

/**
 *
 * @author yrmao
 */
public class Async_stmt extends AbstractHandler {

    public Async_stmt() {
        super();
        terminais.add(Token.ASYNC);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (terminais.contains(currentToken)) {//ASYNC
                removeToken();
                if (nextToken()) {
                    if (!(new Async_stmt2().handle())) {
                        //ouve algum erro no handler do Async_stmt2
                        return false;
                    }
                } else {
                    //lista de Tokens vazia
                    return false;
                }
            } else {
                //token "async" não foi encontrado
                return false;
            }
        } else {
            //lista de tokens vazia
            return false;
        }
        return true;
    }
}
