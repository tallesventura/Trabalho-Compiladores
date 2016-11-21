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
public class Elif_stmt extends AbstractHandler {

    public Elif_stmt(ArrayList<TokenModel> tokenList) {
        super(tokenList);
        terminais.add(Token.ELIF);
        terminais.add(Token.DOIS_PONTOS);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.ELIF) {
                removeToken();
                if (nextToken()) {
                    if (new Expr().handle()) {
                        if (nextToken()) {
                            if (currentToken == Token.DOIS_PONTOS) {
                                removeToken();
                                if (nextToken()) {
                                    if (new Suite(tokens).handle()) {
                                        if (nextToken()) {
                                            if (!(new Elif_stmt(tokens).handle())) {
                                                //ouve algum erro no handler do Suite
                                                return false;
                                            }
                                        } else {
                                            //lista de tokens vazia
                                            return false;
                                        }
                                    } else {
                                        //ouve algum erro no handler do Suite
                                        return false;
                                    }
                                } else {
                                    //lista de tokens vazia
                                    return false;
                                }
                            } else {
                                //Token ":" não foi encontrado
                                return false;
                            }
                        } else {
                            //lista de tokens vazia
                            return false;
                        }
                    } else {
                        //ouve algum erro no handler do Elif_stmt
                        return false;
                    }
                } else {
                    //lista de tokens vazia
                    return false;
                }
            } else {
                //token "elif" não foi encontrado
            }
        }
        return true;
    }
}
