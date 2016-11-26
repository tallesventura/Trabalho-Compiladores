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
public class Simple_stmt3 extends AbstractHandler{

    public Simple_stmt3(ArrayList<TokenModel> tokens) {
        super(tokens);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (new Small_stmt(tokens).handle()) {
                return new Small_stmt2(tokens).handle();
            }
        }
        return true;
    }
}
