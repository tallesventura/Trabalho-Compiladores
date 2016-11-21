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

public class Arith_expr extends AbstractHandler{

    public Arith_expr(ArrayList<TokenModel> tokenList) {
        super(tokenList);
    }

    
    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(new Arith_op(tokens).handle()){
                if(nextToken()){
                    if(new Term(tokens).handle()){
                        if(nextToken()){
                            return new Arith_expr(tokens).handle();
                        }else{
                            errorCode = 17;
                            return false;
                        }
                    }
                }else{
                    errorCode = 8;
                    return false;
                }
            }     
        }else{
            errorCode = 18;
            return false;
        }    
        return true;
    }   
}
