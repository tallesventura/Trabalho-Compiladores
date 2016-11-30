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

    public Elif_stmt(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.ELIF);
        terminais.add(Token.DOIS_PONTOS);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.ELIF) {
                removeToken();
                if (nextToken()) {
                    if (new Expr(tokens).handle()) {
                        if (nextToken()) {
                            if (currentToken == Token.DOIS_PONTOS) {
                                removeToken();
                                if (nextToken()) {
                                    if (new Suite(tokens).handle()) {
                                        return new Elif_stmt(tokens).handle();
                                    }else{
                                        return false;
                                    }
                                } else {
                                    AbstractHandler.errorCode = 25;
                                    return false;
                                }
                            } else {
                                AbstractHandler.errorCode = 49;
                                return false;
                            }
                        } else {
                            AbstractHandler.errorCode = 48;
                            return false;
                        }
                    }else{
                        return false;
                    }
                } else {
                    AbstractHandler.errorCode = 13;
                    return false;
                }
            }
        }
        return true;
    }
}
