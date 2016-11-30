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
public class Simple_stmt extends AbstractHandler {

    public Simple_stmt(ArrayList<TokenModel> tokens) {
        super(tokens);
    }

    @Override
    public boolean handle() {

        if (nextToken()) {
            if (new Small_stmt(tokens).handle()) {
                if (new Small_stmt2(tokens).handle()) {
                    if (nextToken()) {
                        if (currentToken == Token.NOVA_LINHA) {
                            removeToken();
                        } else {
                            AbstractHandler.errorCode = 4;
                            return false;
                        }
                    } else {
                        AbstractHandler.errorCode = 5;
                        return false;
                    }
                }else{
                    return false;
                }
            }else{
                return false;
            }
        } else {
            AbstractHandler.errorCode = 25;
            return false;
        }
        return true;
    }

}
