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
public class Dotted_name2 extends AbstractHandler {

    public Dotted_name2(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.PONTO);
        terminais.add(Token.IDENTIFICADOR);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.PONTO) {
                removeToken();
                if (nextToken()) {
                    if (currentToken == Token.IDENTIFICADOR) {
                        removeToken();
                        if (!(new Dotted_name2(tokens).handle())) {
                            //ouve algum erro no handler do dotted_name2
                            return false;
                            //return new Dotted_name2(tokens).handle();
                        }
                    } else {
                        //identificador não encontrado
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
