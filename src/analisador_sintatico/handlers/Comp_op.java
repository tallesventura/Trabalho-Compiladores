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
public class Comp_op extends AbstractHandler{

    public Comp_op() {
        super();
        terminais.add(Token.OP_MENOR);
        terminais.add(Token.OP_MAIOR);
        terminais.add(Token.OP_IGUALDADE);
        terminais.add(Token.OP_MAIOR_IGUAL);
        terminais.add(Token.OP_MENOR_IGUAL);
        terminais.add(Token.OP_DIFERENTE);
        terminais.add(Token.IN);
    }
    
    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(terminais.contains(currentToken)){
                removeToken();
            }else if(currentToken == Token.NOT){
                removeToken();
                if(nextToken()){
                    if(currentToken == Token.IN){
                        removeToken();
                    }else{
                        errorCode = 22;
                        return false;
                    }
                }else{
                    errorCode = 21;
                    return false;
                }
            }else if(currentToken == Token.IS){
                removeToken();
                return new Is_not().handle();
            }else{
                errorCode = 30;
                return false;
            }
        }else{
            errorCode = 20;
            return false;
        }
                
        return true;
    }   
}
