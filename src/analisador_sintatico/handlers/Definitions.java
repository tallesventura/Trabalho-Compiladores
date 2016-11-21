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

    public Definitions(ArrayList<TokenModel> tokenList) {
        super(tokenList);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (new Funcdef(tokens).handle()) {
                //Funcdef
            } else if (new Async_stmt(tokens).handle()) {
                //Async_funcdef
            } else {
                return new Classdef(tokens).handle(); 
                //ouve algum erro no handler do Funcdef/Async_fundef/Classdef
            }
        } else {
            //lista de tokens vazia
            return false;
        }
        return true;
    }

}
