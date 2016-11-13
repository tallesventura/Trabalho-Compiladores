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
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.YIELD) {
                removeToken();
                if (nextToken()) {
                    if(new Parameters_opt().handle()){
                        //função parametrs_opt
                        
                    }else{
                        //parameters_opt não encontrado
                  
                    }
                } else {
                    //lista de tokens vazia
                    errorCode = 6;
                    return false;

                }

            } else {
                //Yield permite que não tenha nada

            }
        } else {
            //lista de tokens vazia
            errorCode = 6;
            return false;
        }

        return true;
    }

}

