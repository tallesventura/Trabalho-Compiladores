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

// TODO: terminar
public class Expr2 extends AbstractHandler{

    public Expr2() {
        super();
    }
    

    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(new Rel_op().handle()){
                if(new Comp_expr().handle()){
                    return new Expr2().handle();
                }
            }
        }
        
        return true;
    }   
}
