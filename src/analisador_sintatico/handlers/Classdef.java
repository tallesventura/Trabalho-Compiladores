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
public class Classdef extends AbstractHandler {

    public Classdef(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.CLASS);
        terminais.add(Token.IDENTIFICADOR);
        terminais.add(Token.DOIS_PONTOS);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.CLASS) {//CLASS
                removeToken();
                if (nextToken()) {
                    if (currentToken == Token.IDENTIFICADOR) {//NAME
                        removeToken();
                        if (nextToken()) {
                            if (new Parameters_opt(tokens).handle()) {
                                if (nextToken()) {
                                    if (currentToken == Token.DOIS_PONTOS) {//DOID_PONTOS
                                        removeToken();
                                        if (nextToken()) {
                                            return new Suite(tokens).handle();
                                        }
                                    } else {
                                        errorCode = 49;
                                        return false;
                                    }
                                } else {
                                    errorCode = 48;
                                    return false;
                                }
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
                //token "class" não foi encontrado
                return false;
            }
        } else {
            //liste de tokens vazia
            return false;
        }

        return true;
    }

}
