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
 * @author yrmao
 */
public class Async_funcdef extends AbstractHandler{

    public Async_funcdef(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.ASYNC);
    }

    @Override
    public boolean handle() {
        if(nextToken()){
            if(currentToken == Token.ASYNC){
                removeToken();
                if(nextToken()){
                    return new Funcdef(tokens).handle();
                }else{
                    AbstractHandler.errorCode = 59;
                    return false;
                }
            }else{
                AbstractHandler.errorCode = 47;
                return false;
            }
        }else{
            AbstractHandler.errorCode = 46;
            return false;
        }
    }  
}
