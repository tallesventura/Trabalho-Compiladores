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

    public Global_stmt(ArrayList<TokenModel> tokenList) {
        super(tokenList);
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
                        if (nextToken()) {
                            if (!(new Arglist(tokens).handle())) {
                                //ouve algun erro no handler do arglist
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
                    //lista de tokens vazia
                    return false;
                }
            } else {
                //token "global" não foi encontrado
                return false;
            }
        } else {
            //lista de tokens vazia
            return false;
        }

        return true;
    }

}
