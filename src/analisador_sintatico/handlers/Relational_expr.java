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

public class Relational_expr extends AbstractHandler{

    public Relational_expr() {
        super();
    }
    

    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(new Comp_op().handle()){
                if(new Operational_expr().handle()){
                    return new Relational_expr().handle();
                }
            }
        }
        
        return true;
    }  
}
