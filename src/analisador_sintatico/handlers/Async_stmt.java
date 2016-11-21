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
 * @author yrmao
 */
public class Async_stmt extends AbstractHandler {

    public Async_stmt(ArrayList<TokenModel> tokenList) {
        super(tokenList);
        terminais.add(Token.ASYNC);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.ASYNC) {//ASYNC
                removeToken();
                if (nextToken()) {
                    if (!(new Async_stmt2(tokens).handle())) {
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
