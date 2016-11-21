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
 * @author yrmao
 */
public class Async_stmt2 extends AbstractHandler{

    public Async_stmt2(ArrayList<TokenModel> tokenList) {
        super(tokenList);
    }

    @Override
    public boolean handle() {
        if(nextToken()){
            if(new Funcdef(tokens).handle()){
                //funcdef
            }else
                return new For_stmt(tokens).handle();
        }else{
            //lista de tokens vazia
            return false;
        }
        return true;
        
    }
    
}
