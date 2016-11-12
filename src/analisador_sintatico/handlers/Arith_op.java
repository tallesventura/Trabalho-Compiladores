/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

import analisador_lexico.Token;

/**
 *
 * @author tallesventura
 */
public class Arith_op extends AbstractHandler{

    public Arith_op() {
        super();
        terminais.add(Token.OP_ADICAO);
        terminais.add(Token.OP_SUBTRACAO);
        terminais.add(Token.OP_TIL);
    }

    @Override
    public boolean handle() {
        if(nextToken()){
            if(terminais.contains(currentToken)){
                removeToken();
            }else{
                errorCode = 19;
                return false;
            }
        }else{
            errorCode = 18;
            return false;             
        }
        return true;
    }
    
    
}