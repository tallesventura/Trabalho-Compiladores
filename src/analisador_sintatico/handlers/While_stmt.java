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

    public While_stmt(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.WHILE);
        terminais.add(Token.DOIS_PONTOS);

    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.WHILE) {//WHILE
                removeToken();
                if (new Expr(tokens).handle()) {
                    if (nextToken()) {
                        if (currentToken == Token.DOIS_PONTOS) {//DOIS_PONTOS
                            removeToken();
                            if (new Suite(tokens).handle()) {
                                return new Else_stmt(tokens).handle();
                            } else {
                                return false;
                            }
                        } else {
                            errorCode = 49;
                            return false;
                        }
                    } else {
                        errorCode = 48;
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                errorCode = 75;
                return false;
            }
        } else {
            errorCode = 74;
            return false;
        }
    }
}
