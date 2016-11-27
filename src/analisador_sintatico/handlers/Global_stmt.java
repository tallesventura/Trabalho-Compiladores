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
 * @author talles
 */
public class Global_stmt extends AbstractHandler {

    public Global_stmt(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.GLOBAL);
        terminais.add(Token.IDENTIFICADOR);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.GLOBAL) {
                removeToken();
                if (nextToken()) {
                    if (currentToken == Token.IDENTIFICADOR) {
                        removeToken();
                        return new Arglist(tokens).handle();
                    } else {
                        errorCode = 6;
                        return false;
                    }
                } else {
                    errorCode = 10;
                    return false;
                }
            } else {
                errorCode = 73;
                return false;
            }
        } else {
            errorCode = 72;
            return false;
        }
    }

}
