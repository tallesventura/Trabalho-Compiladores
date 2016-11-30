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
 * @author talles
 */
public class Rel_op extends AbstractHandler{

    public Rel_op(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.AND);
        terminais.add(Token.OR);
    }

    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(terminais.contains(currentToken)){
                removeToken();
            }else{
                AbstractHandler.errorCode = 24;
                return false;
            }
        }else{
            AbstractHandler.errorCode = 23;
            return false;
        }
        
        return true;
    }
    
}
