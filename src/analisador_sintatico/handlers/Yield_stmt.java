/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

import analisador_lexico.Token;
import static analisador_sintatico.handlers.AbstractHandler.currentToken;

/**
 *
 * @author yrmao
 */
public class Yield_stmt extends AbstractHandler {

    public Yield_stmt() {
        super();
        terminais.add(Token.YIELD);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (terminais.contains(currentToken)) {
                removeToken();
                if (nextToken()) {
                    if(new Parameters_opt().handle()){
                        //função parametrs_opt
                    }else{
                        //ouve algun erro no handler do parameters_opt
                        return false;
                    }
                } else {
                    //lista de tokens vazia
                }
            } else {
                //esperado um tokem yield
                return false;
            }
        } else {
            //lista de tokens vazia
            return false;
        }
        return true;
    }
}

