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
public class Small_stmt extends AbstractHandler{

    public Small_stmt() {
        super();
    }
    

    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(new Expr_stmt().handle()){
                
            }else if(new Del_stmt().handle()){
                
            }else if(new Pass().handle()){
                
            }else if(new Flow_stmt().handle()){
                
            }else if(new Import_stmt().handle()){
                
            }else if(new Global_stmt().handle()){
                
            }else if(new Nonlocal_stmt().handle()){
                
            }else{
                errorCode = 3;
                return false;
            }
        }
        
        return true;
    }
    
}