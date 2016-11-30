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
public class Comp_expr extends AbstractHandler {

    public Comp_expr(ArrayList<TokenModel> tokens) {
        super(tokens);
    }

    @Override
    public boolean handle() {

        if (nextToken()) {
            if (new Operational_expr(tokens).handle()) {
                return new Relational_expr(tokens).handle();
            } else {
                return false;
            }
        } else {
            AbstractHandler.errorCode = 15;
            return false;
        }
    }

}
