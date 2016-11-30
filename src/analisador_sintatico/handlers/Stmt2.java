/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

import Model.TokenModel;
import analisador_lexico.Token;
import static analisador_sintatico.handlers.AbstractHandler.currentToken;
import java.util.ArrayList;

/**
 *
 * @author yrmao
 */
public class Stmt2 extends AbstractHandler {

    public Stmt2(ArrayList<TokenModel> tokens) {
        super(tokens);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.IDENTIFICADOR || currentToken == Token.DELETE
                    || currentToken == Token.PASS || currentToken == Token.BREAK
                    || currentToken == Token.CONTINUE || currentToken == Token.RETURN
                    || currentToken == Token.YIELD || currentToken == Token.IMPORT
                    || currentToken == Token.GLOBAL || currentToken == Token.NONLOCAL) {
                return new Stmt(tokens).handle();
            }
        }
        return true;
    }
}
