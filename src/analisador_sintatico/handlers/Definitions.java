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
 * @author yrmao
 */
public class Definitions extends AbstractHandler {

    public Definitions(ArrayList<TokenModel> tokens) {
        super(tokens);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (new Funcdef(tokens).handle()) {
                return true;
            } else if (!new Async_stmt(tokens).handle()) {
                return new Classdef(tokens).handle(); 
            }
        } else {
            //lista de tokens vazia
            return false;
        }
        return true;
    }

}
