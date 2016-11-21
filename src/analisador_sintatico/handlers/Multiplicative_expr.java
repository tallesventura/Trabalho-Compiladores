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

public class Multiplicative_expr extends AbstractHandler{

    public Multiplicative_expr(ArrayList<TokenModel> tokenList) {
        super(tokenList);
    }
    

    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(new Multiplicative_op(tokens).handle()){
                if(new Unary_expr(tokens).handle()){
                    return new Multiplicative_expr(tokens).handle();
                }
            }
        }
        
        return true;
    }
    
}
