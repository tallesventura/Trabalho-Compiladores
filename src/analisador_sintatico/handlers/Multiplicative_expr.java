/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

/**
 *
 * @author talles
 */

public class Multiplicative_expr extends AbstractHandler{

    public Multiplicative_expr() {
        super();
    }
    

    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(new Multiplicative_op().handle()){
                if(new Unary_expr().handle()){
                    return new Multiplicative_expr().handle();
                }
            }
        }
        
        return true;
    }
    
}
