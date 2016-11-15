/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

import analisador_lexico.Token;

/**
 *
 * @author talles
 */
public class Simple_stmt extends AbstractHandler {

    public Simple_stmt() {
        super();
    }

    @Override
    public boolean handle() {

        if (nextToken()) {
            if (new Small_stmt().handle()) {
                if (nextToken()) {
                    if (new Small_stmt2().handle()) {
                        if (nextToken()) {
                            if (currentToken == Token.NOVA_LINHA) {
                                removeToken();
                            } else {
                                errorCode = 4;
                                return false;
                            }
                        } else {
                            errorCode = 5;
                            return false;
                        }
                    }
                } else {
                    errorCode = 8;
                    return false;
                }
            }
        }
        return true;
    }

}
