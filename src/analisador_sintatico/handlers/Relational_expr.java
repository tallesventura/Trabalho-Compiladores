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

public class Relational_expr extends AbstractHandler{

    public Relational_expr(ArrayList<TokenModel> tokens) {
        super(tokens);
    }
    

    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(new Comp_op(tokens).handle()){
                if(new Operational_expr(tokens).handle()){
                    return new Relational_expr(tokens).handle();
                }
            }
        }
        
        return true;
    }  
}
