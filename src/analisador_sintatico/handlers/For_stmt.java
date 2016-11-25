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
public class For_stmt extends AbstractHandler {

    public For_stmt(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.FOR);
        terminais.add(Token.IDENTIFICADOR);
        terminais.add(Token.IN);
        terminais.add(Token.DOIS_PONTOS);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.FOR) {
                removeToken();
                if (nextToken()) {
                    if (currentToken == Token.IDENTIFICADOR) {
                        removeToken();
                        if (nextToken()) {
                            if (currentToken == Token.IN) {
                                removeToken();
                                if (new Expr(tokens).handle()) {
                                    if (nextToken()) {
                                        if(currentToken == Token.DOIS_PONTOS){
                                            removeToken();
                                            if(new Suite(tokens).handle()){
                                                return new Else_stmt(tokens).handle();
                                            }
                                        }else{
                                            errorCode = 49;
                                            return false;
                                        }
                                    } else {
                                        errorCode = 56;
                                        return false;
                                    }
                                }
                            } else {
                                errorCode = 58;
                                return false;
                            }
                        } else {
                            errorCode = 56;
                            return false;
                        }
                    } else {
                        errorCode = 6;
                        return false;
                    }
                } else {
                    errorCode = 56;
                    return false;
                }
            } else {
                errorCode = 57;
                return false;
            }

        } else {
            errorCode = 56;
            return false;
        }
        return true;
    }

}
