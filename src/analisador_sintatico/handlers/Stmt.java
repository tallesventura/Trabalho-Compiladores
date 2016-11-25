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
public class Stmt extends AbstractHandler {

    public Stmt(ArrayList<TokenModel> tokens) {
        super(tokens);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (new Simple_stmt(tokens).handle())  {
                //simple
            } else if (new Compound_stmt(tokens).handle()) {
                //compound
            } else {
                //ouve algum erro no handler do Simple/Compound
                return false;
            }
        } else {
            //lista de Tokens vazia
            return false;
        }
        return true;
    }
}
