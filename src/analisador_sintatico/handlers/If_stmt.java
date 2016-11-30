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
public class If_stmt extends AbstractHandler {

    public If_stmt(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.IF);
        terminais.add(Token.DOIS_PONTOS);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.IF) {//IF
                removeToken();
                if (new Expr(tokens).handle()) {
                    if (nextToken()) {
                        if (currentToken == Token.DOIS_PONTOS) {//DOIS_PONTOS
                            removeToken();
                            if (new Suite(tokens).handle()) {
                                if (new Elif_stmt(tokens).handle()) {
                                    return new Else_stmt(tokens).handle();
                                }else{
                                    return false;
                                }
                            }else{
                                return false;
                            }
                        } else{
                            AbstractHandler.errorCode = 49;
                            return false;
                        }
                    } else {
                        AbstractHandler.errorCode = 49;
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                AbstractHandler.errorCode = 62;
                return false;
            }
        } else {
            AbstractHandler.errorCode = 61;
            return false;
        }
    }

}
