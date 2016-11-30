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
public class Dotted_name extends AbstractHandler {

    public Dotted_name(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.IDENTIFICADOR);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.IDENTIFICADOR) {
                removeToken();
                return new Dotted_name2(tokens).handle();
            } else {
                AbstractHandler.errorCode = 6;
                return false;
            }
        } else {
            AbstractHandler.errorCode = 10;
            return false;
        }
    }
}
