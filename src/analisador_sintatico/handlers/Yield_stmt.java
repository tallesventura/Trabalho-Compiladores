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

    public Yield_stmt(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.YIELD);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.YIELD) {
                removeToken();
                if (nextToken()) {
                    return new Parameters_opt(tokens).handle();
                } else {
                    errorCode = 25;
                    return false;
                }
            }
        }
        return true;
    }
}

