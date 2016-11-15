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
public class Comp_expr extends AbstractHandler{

    public Comp_expr() {
        super();
    }
    
    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(new Operational_expr().handle()){
                if(nextToken()){
                    return new Relational_expr().handle();
                }else{
                    errorCode = 16;
                    return false;
                }
            }
        }else{
            errorCode = 15;
            return false;
        }
        
        return true;
    }
    
}
