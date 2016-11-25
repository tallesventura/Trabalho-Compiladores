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
// TODO: terminar
public class Small_stmt2 extends AbstractHandler {

    public Small_stmt2(ArrayList<TokenModel> tokens) {
        super(tokens);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.PONTO_VIRGULA) {
                removeToken();

                return new Simple_stmt3(tokens).handle();        
            }
        }
        return true;
    }
}
