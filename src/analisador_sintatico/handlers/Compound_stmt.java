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
public class Compound_stmt extends AbstractHandler {

    public Compound_stmt(ArrayList<TokenModel> tokens) {
        super(tokens);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            switch(currentToken){
                case IF:
                    return new If_stmt(tokens).handle();
                case WHILE:
                    return new While_stmt(tokens).handle();
                case DEF:
                    return new Funcdef(tokens).handle();
                case CLASS:
                    return new Classdef(tokens).handle();
                case OP_ARROBA:
                    return new Decorated(tokens).handle();
                case ASYNC:
                    return new Async_stmt(tokens).handle();
                case FOR:
                    return new For_stmt(tokens).handle();
                default:
                    AbstractHandler.errorCode = 3;
                    return false;
            }
        }
        return true;
    }
}
