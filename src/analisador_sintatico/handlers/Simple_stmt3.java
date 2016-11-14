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
public class Simple_stmt3 extends AbstractHandler{

    public Simple_stmt3() {
        super();
    }
    

    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(new Small_stmt().handle()){
                return new Small_stmt2().handle();
            }
        }
        
        return true;
    }
    
}
