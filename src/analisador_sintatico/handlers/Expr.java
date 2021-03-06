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
public class Expr extends AbstractHandler {

    public Expr(ArrayList<TokenModel> tokens) {
        super(tokens);
    }

    @Override
    public boolean handle() {

        if (nextToken()) {
            if (new Comp_expr(tokens).handle()) {
                return new Expr2(tokens).handle();
            }else{
                return false;
            }
        } else {
            AbstractHandler.errorCode = 14;
            return false;
        }
    }

}
