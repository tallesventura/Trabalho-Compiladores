/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

import Model.TokenModel;
import java.util.ArrayList;

/**
 *
 * @author talles
 */
public class Return2 extends AbstractHandler{

    public Return2(ArrayList<TokenModel> tokens) {
        super(tokens);
    }

    @Override
    public boolean handle() {
    
        if(nextToken()){
            switch(currentToken){
                case ABRE_PARENTESES:
                    return new Parameters_opt(tokens).handle();
                case IDENTIFICADOR:
                    return new Arglist(tokens).handle();
                default:
                  errorCode = 81;
                  return false;  
            }
        }else{
            errorCode = 81;
            return false;
        }
    }
    
}
