/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

import Model.TokenModel;
import java.util.ArrayList;

/**
 *
 * @author talles
 */
public class Compound_stmt extends AbstractHandler {

    public Compound_stmt(ArrayList<TokenModel> tokenList) {
        super(tokenList);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (new If_stmt(tokens).handle()) {

            } else if (new While_stmt(tokens).handle()) {

            } else if (new Funcdef(tokens).handle()) {

            } else if (new Classdef(tokens).handle()) {

            } else if (new Decorated(tokens).handle()) {

            } else if (new Async_stmt(tokens).handle()) {

            } else {
                errorCode = 3;
                return false;
            }
        }
        return true;
    }
}
