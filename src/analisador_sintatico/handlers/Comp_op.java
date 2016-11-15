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
        terminais.add(Token.NOT);
        terminais.add(Token.IS);
    }
    
    // TODO: ver se "is" está ambíguo
    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(terminais.contains(currentToken)){
                removeToken();
                if(currentToken == Token.NOT){
                    if(nextToken()){
                        if(currentToken != Token.IN){
                            errorCode = 22;
                            return false;
                        }else{
                            removeToken();
                        }
                    }else{
                        errorCode = 21;
                        return false;
                    }
                }else if(currentToken == Token.IS){
                    if(nextToken()){
                        if(currentToken == Token.NOT){
                            removeToken();
                        }
                    }
                }
            }
        }else{
            errorCode = 20;
            return false;
        }
                
        return true;
    }   
}
