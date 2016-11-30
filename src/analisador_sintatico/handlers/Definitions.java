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
public class Definitions extends AbstractHandler {

    public Definitions(ArrayList<TokenModel> tokens) {
        super(tokens);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            switch (currentToken) {
                case DEF:
                    return new Funcdef(tokens).handle();
                case ASYNC:
                    return new Async_stmt(tokens).handle();
                case CLASS:
                    return new Classdef(tokens).handle();
                default:
                    AbstractHandler.errorCode = 70;
                    return false;
            }
        }
        return true;
    }

}
