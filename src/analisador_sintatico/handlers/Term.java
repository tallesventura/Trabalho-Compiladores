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

public class Term extends AbstractHandler{

    public Term(ArrayList<TokenModel> tokens) {
        super(tokens);
    }
    
    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(new Unary_expr(tokens).handle()){
                return new Multiplicative_expr(tokens).handle();
            }else{
                return false;
            }
        }else{
            AbstractHandler.errorCode = 26;
            return false;
        }
    }  
}
