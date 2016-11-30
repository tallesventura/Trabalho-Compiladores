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
public class Else_stmt extends AbstractHandler {

    public Else_stmt(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.ELSE);
        terminais.add(Token.DOIS_PONTOS);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.ELSE) {//ELSE
                removeToken();
                if (nextToken()) {
                    if (currentToken == Token.DOIS_PONTOS) {//DOIS_PONTOS
                        removeToken();
                        return new Suite(tokens).handle();
                    }
                } else {
                    AbstractHandler.errorCode = 49;
                    return false;
                }
            }
        }
        
        return true;
    }  
}
