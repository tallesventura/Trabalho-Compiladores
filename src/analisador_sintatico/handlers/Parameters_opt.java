/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

import analisador_lexico.Token;

/**
 *
 * @author yrmao
 */
public class Parameters_opt extends AbstractHandler {

    public Parameters_opt() {
        super();
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.ABRE_PARENTESES) {
                removeToken();
                if (nextToken()) {
                    if (new Arglist().handle()) {//função argslist
                        if (nextToken()) {
                            if(currentToken == Token.FECHA_PARENTESES){
                                removeToken();                             
                            }else{
                                //token ")" - > FECHA_PARENTESES não foi encontrado
                            }
                            
                        } else {
                            //lista de tokens vazia
                            errorCode = 6;
                            return false;
                        }

                    } else {
                        //função argslist não foi encontrada
                    }
                } else {
                    //lista de tokens vazia
                    errorCode = 6;
                    return false;
                }

            } else {
                //token "(" - > ABRE_PARENTESES não foi encontrado

                //parameters_opt permite que não tenha nada
            }

        } else {
            //lista de tokens vazia
            errorCode = 6;
            return false;
        }

        return true;
    }

}
