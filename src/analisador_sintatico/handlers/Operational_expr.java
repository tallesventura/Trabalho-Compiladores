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
public class Operational_expr extends AbstractHandler{

    public Operational_expr() {
        super();
    }
    

    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(new Term().handle()){
                if(nextToken()){
                    return new Arith_expr().handle();
                }else{
                    errorCode = 17;
                    return false;
                }
            }
        }else{
            errorCode = 8;
            return false;
        }
        
        return true;
    }
    
}
