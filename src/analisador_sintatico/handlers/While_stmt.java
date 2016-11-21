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
public class While_stmt extends AbstractHandler {

    public While_stmt(ArrayList<TokenModel> tokenList) {
        super(tokenList);
        terminais.add(Token.WHILE);
        terminais.add(Token.DOIS_PONTOS);

    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.WHILE) {//WHILE
                removeToken();
                if (nextToken()) {
                    if (new Expr().handle()) {
                        if (nextToken()) {
                            if (currentToken == Token.DOIS_PONTOS) {//DOIS_PONTOS
                                removeToken();
                                if (new Suite(tokens).handle()) {
                                    if (nextToken()) {
                                        if (!(new Else_stmt(tokens).handle())) {
                                            //ouve algum erro no handler do Else_stmt
                                            return false;
                                        }
                                    } else {
                                        //lista de Tokens vazia
                                        return false;
                                    }
                                } else {
                                    //ouve algum erro no handler do Suite
                                    return false;
                                }
                            } else {
                                //Token ":" não foi encontrado
                                return false;
                            }
                        } else {
                            //lista de Tokens vazia
                            return false;

                        }
                    } else {
                        //ouve algum erro no handler do Expr
                        return false;
                    }
                } else {
                    //lista de Tokens vazia
                    return false;
                }
            } else {
                //token "while" não foi encontrado
                return false;
            }
        } else {
            //lista de Tokens vazia
            return false;
        }
        return true;
    }
}
