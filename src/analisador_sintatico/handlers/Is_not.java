/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

import analisador_lexico.Token;

/**
 *
 * @author talles
 */
public class Is_not extends AbstractHandler{

    public Is_not() {
        super();
    }

    
    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(currentToken == Token.NOT){
                removeToken();
            }     
        }
        
        return true;
    }
    
}
