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
public class Expr extends AbstractHandler{

    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(new Comp_expr().handle()){
                if(nextToken()){
                    return new Expr2().handle();
                }else{
                    errorCode = 8;
                    return false;
                }
            }
        }else{
            errorCode = 14;
            return false;
        }
        
        return true;
    }
    
}
