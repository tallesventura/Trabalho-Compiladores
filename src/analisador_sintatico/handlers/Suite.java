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
public class Suite extends AbstractHandler {

    public Suite(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.NOVA_LINHA);
        terminais.add(Token.ABRE_CHAVES);
        terminais.add(Token.FECHA_CHAVES);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (new Simple_stmt(tokens).handle()) {
                return true;
            } else if (nextToken()) {
                if (currentToken == Token.ABRE_CHAVES) {//ABRE_CHAVES
                    removeToken();
                    if (nextToken()) {
                        if (currentToken == Token.NOVA_LINHA) {
                            removeToken();
                            if (new Stmt(tokens).handle()) {
                                if (new Stmt2(tokens).handle()) {
                                    if (nextToken()) {
                                        if (currentToken == Token.FECHA_CHAVES) {
                                            removeToken();
                                        } else {
                                            AbstractHandler.errorCode = 80;
                                            return false;
                                        }
                                    } else {
                                        AbstractHandler.errorCode = 79;
                                        return false;
                                    }
                                } else {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        }else{
                            errorCode = 4;
                            return false;   
                        }
                    } else {
                        errorCode = 5;
                        return false;
                    }
                } else {
                    AbstractHandler.errorCode = 78;
                    return false;
                }
            } else {
                AbstractHandler.errorCode = 3;
                return false;
            }
        } else {
            AbstractHandler.errorCode = 25;
            return false;
        }
        return true;
    }

}
