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

    public Funcdef(ArrayList<TokenModel> tokenList) {
        super(tokenList);
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
                        if (nextToken()) {
                            if (new Parameters(tokens).handle()) {
                                if (nextToken()) {
                                    if (currentToken == Token.DOIS_PONTOS) {//DOID_PONTOS
                                        removeToken();
                                        if (nextToken()) {
                                            if (!(new Suite(tokens).handle())) {
                                                //ouve algum erro no handler do Suite
                                                return false;
                                            }
                                        } else {
                                            //lista de tokens vazia
                                            return false;
                                        }
                                    } else {
                                        //token ":" não foi encontrado
                                    }
                                } else {
                                    //lista de tokens vazia
                                    return false;
                                }
                            } else {
                                //ouve algum erro no handler do Parameters
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
                //token "def" não foi encontrado
                return false;
            }
        } else {
            //liste de tokens vazia
            return false;
        }

        return true;
    }

}
