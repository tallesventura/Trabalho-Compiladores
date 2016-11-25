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
public class More_arg extends AbstractHandler {

    public More_arg(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.VIRGULA);
        terminais.add(Token.IDENTIFICADOR);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.VIRGULA) {//VIRGULA
                removeToken();
                if (nextToken()) {
                    if (currentToken == Token.IDENTIFICADOR) {//IDENTIFICADOR
                        removeToken();
                        if (new Arg_Assign(tokens).handle()) {
                            return new More_arg(tokens).handle();
                        }
                    } else {
                        errorCode = 6;
                        return false;
                    }
                } else {
                    errorCode = 10;
                    return false;
                }
            }
        }
        return true;
    }

}
