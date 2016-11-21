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

    public Async_funcdef(ArrayList<TokenModel> tokenList) {
        super(tokenList);
        terminais.add(Token.ASYNC);
    }

    @Override
    public boolean handle() {
        if(nextToken()){
            if(currentToken == Token.ASYNC){
                removeToken();
                if(nextToken()){
                    if(!(new Funcdef(tokens).handle())){
                        //ouve algum erro no handler do Funcdef
                        return false;
                    }
                }else{
                    //lista de tokens vazia
                    return false;
                }
            }else{
                //token "async" não foi encontrado
                return false;
            }
        }else{
            //lista de token vazia
            return false;
        }
        return true;
    }
    
}
