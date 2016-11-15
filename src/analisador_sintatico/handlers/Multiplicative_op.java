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

public class Multiplicative_op extends AbstractHandler{

    public Multiplicative_op() {
        super();
        terminais.add(Token.OP_DIVISAO);
        terminais.add(Token.OP_MULTIPLICACAO);
        terminais.add(Token.OP_RESTO);
        terminais.add(Token.OP_DIVISAO_INTEIRA);
        terminais.add(Token.OP_ARROBA);
    }
    
    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(terminais.contains(currentToken)){
                removeToken();
            }else{
                errorCode = 29;
                return false;
            }
        }else{
            errorCode = 28;
            return false;
        }
        
        return true;
    }
}
