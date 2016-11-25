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
public class Async_stmt2 extends AbstractHandler {

    public Async_stmt2(ArrayList<TokenModel> tokens) {
        super(tokens);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.DEF) {
                return new Funcdef(tokens).handle();
            } else if(currentToken == Token.FOR){
                return new For_stmt(tokens).handle();
            }
        }
        return true;
    }

}
