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
 * @author talles
 */
public class Single_input extends AbstractHandler {

    public Single_input(ArrayList<TokenModel> tokens) {
        super(tokens);
        this.terminais = new ArrayList();
    }

    @Override
    public boolean handle() {

        if (nextToken()) {
            if (currentToken == Token.NOVA_LINHA) {
                removeToken();
                new Single_input(tokens).handle();
            } else if (currentToken == Token.IDENTIFICADOR || currentToken == Token.DELETE
                    || currentToken == Token.PASS || currentToken == Token.BREAK
                    || currentToken == Token.CONTINUE
                    || currentToken == Token.RETURN || currentToken == Token.YIELD
                    || currentToken == Token.IMPORT || currentToken == Token.GLOBAL
                    || currentToken == Token.NONLOCAL) {
                if (new Simple_stmt(tokens).handle()) {
                    return new Single_input(tokens).handle();
                } else {
                    return false;
                }
            } else if (currentToken == Token.IF || currentToken == Token.WHILE
                    || currentToken == Token.FOR || currentToken == Token.DEF 
                    || currentToken == Token.CLASS || currentToken == Token.OP_ARROBA 
                    || currentToken == Token.ASYNC) {
                if (new Compound_stmt(tokens).handle()) {
                    if (currentToken == Token.NOVA_LINHA) {
                        removeToken();
                        new Single_input(tokens).handle();
                    } else {
                        AbstractHandler.errorCode = 4;
                        return false;
                    }
                }else{
                    return false;
                }
            } else {
                AbstractHandler.errorCode = 3;
                return false;
            }
        }
        return true;
    }

}
