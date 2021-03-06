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
public class Expr_stmt extends AbstractHandler {

    public Expr_stmt(ArrayList<TokenModel> tokens) {
        super(tokens);
    }

    @Override
    public boolean handle() {

        if (nextToken()) {
            if (currentToken == Token.IDENTIFICADOR) {
                removeToken();
                if (new Augassign(tokens).handle()) {
                    return new Expr(tokens).handle();
                } else {
                    return false;
                }
            } else {
                AbstractHandler.errorCode = 6;
                return false;
            }
        } else {
            AbstractHandler.errorCode = 10;
            return false;
        }
    }

}
