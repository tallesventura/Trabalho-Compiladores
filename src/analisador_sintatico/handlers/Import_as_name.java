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
public class Import_as_name extends AbstractHandler {

    public Import_as_name(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.contains(Token.AS);
        terminais.contains(Token.IDENTIFICADOR);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.AS) {
                removeToken();
                if (nextToken()) {
                    if (currentToken == Token.IDENTIFICADOR) {
                        removeToken();
                    } else {
                        //token "NAME" não foi encontrado
                        return false;
                    }
                } else {
                    //lista de tokens vazia
                    return false;
                }
            }
        } else {
            //lista de tokens vazia
            return false;
        }
        return true;
    }

}
