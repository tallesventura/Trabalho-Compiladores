/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

import Model.TokenModel;
import analisador_lexico.Token;
import java.util.ArrayList;

/**
 *
 * @author tallesventura
 */
public class Comp_op extends AbstractHandler{

    public Comp_op(ArrayList<TokenModel> tokens) {
        super(tokens);
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
                        AbstractHandler.errorCode = 22;
                        return false;
                    }
                }else{
                    AbstractHandler.errorCode = 21;
                    return false;
                }
            }else if(currentToken == Token.IS){
                removeToken();
                return new Is_not(tokens).handle();
            }else{
                AbstractHandler.errorCode = 30;
                return false;
            }
        }else{
            AbstractHandler.errorCode = 20;
            return false;
        }
                
        return true;
    }   
}
