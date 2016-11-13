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
public class Arglist extends AbstractHandler{

    public Arglist() {
        super();
    }

    @Override
    public boolean handle() {
        
        if (nextToken()) {
            if (currentToken == Token.IDENTIFICADOR) {
                removeToken();
                if (nextToken()) {
                    if (new Argument_list().handle()) {//função argument_list
                        //função
                    } else {
                        //função argument_list não foi encontrada
                    }
                } else {
                    //lista de tokens vazia
                    errorCode = 6;
                    return false;
                }

            } else {
                //token "NAME" - > IDENTIFICADOR não foi encontrado
            }

        } else {
            //parameters_opt permite que não tenha nada
        }
       
        return true;
        
    }
    
}
