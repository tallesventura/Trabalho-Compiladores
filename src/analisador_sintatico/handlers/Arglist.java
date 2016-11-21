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
public class Arglist extends AbstractHandler {

    public Arglist(ArrayList<TokenModel> tokenList) {
        super(tokenList);
        terminais.add(Token.IDENTIFICADOR);
    }

    @Override
    public boolean handle() {

        if (nextToken()) {
            if (currentToken == Token.IDENTIFICADOR) {
                removeToken();
                if (nextToken()) {
                    if (!(new Argument_list(tokens).handle())) {//return new Argument_list().handle(); //por que não é permitido
                        errorCode = 33;
                        return false;
                    }
                } else {
                    errorCode = 33;
                    return false;
                }
            } else {
                errorCode = 6;
                return false;
            }
        } else {
            errorCode = 10;
            return false;
        }
        return true;
    }
}
