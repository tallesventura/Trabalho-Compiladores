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
public class Rel_op extends AbstractHandler{

    public Rel_op() {
        super();
        terminais.add(Token.AND);
        terminais.add(Token.OR);
    }

    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(terminais.contains(currentToken)){
                removeToken();
            }else{
                errorCode = 24;
                return false;
            }
        }else{
            errorCode = 23;
            return false;
        }
        
        return true;
    }
    
}
