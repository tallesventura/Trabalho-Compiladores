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
public class Yield_stmt extends AbstractHandler {

    public Yield_stmt(ArrayList<TokenModel> tokenList) {
        super(tokenList);
        terminais.add(Token.YIELD);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.YIELD) {
                removeToken();
                if (nextToken()) {
                    if((new Parameters_opt(tokens).handle())){
                        errorCode = 44 ;
                        return false;
                    }
                } else {
                    errorCode = 45 ;
                }
            } else {
                errorCode = 9;
                return false;
            }
        } else {
            //lista de tokens vazia
            return false;
        }
        return true;
    }
}

