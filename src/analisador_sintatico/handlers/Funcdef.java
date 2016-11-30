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
public class Funcdef extends AbstractHandler {

    public Funcdef(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.DEF);
        terminais.add(Token.IDENTIFICADOR);
        terminais.add(Token.DOIS_PONTOS);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.DEF) {//DEF
                removeToken();
                if (nextToken()) {
                    if (currentToken == Token.IDENTIFICADOR) {//NAME
                        removeToken();
                        if (new Parameters(tokens).handle()) {
                            if (nextToken()) {
                                if (currentToken == Token.DOIS_PONTOS) {//DOID_PONTOS
                                    removeToken();
                                    return new Suite(tokens).handle(); 
                                } else {
                                    AbstractHandler.errorCode = 49;
                                    return false;
                                }
                            } else {
                                AbstractHandler.errorCode = 48;
                                return false;
                            }
                        }
                    } else {
                        AbstractHandler.errorCode = 6;
                        return false;
                    }
                } else {
                    AbstractHandler.errorCode = 10;
                    return false;
                }
            } else {
                AbstractHandler.errorCode = 60;
                return false;
            }
        } else {
            AbstractHandler.errorCode = 59;
            return false;
        }
        return true;
    }

}
