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
public class Arith_expr extends AbstractHandler {

    public Arith_expr(ArrayList<TokenModel> tokens) {
        super(tokens);
    }

    @Override
    public boolean handle() {

        if (nextToken()) {
            if (new Arith_op(tokens).handle()) {
                if (new Term(tokens).handle()) {
                    return new Arith_expr(tokens).handle();
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
