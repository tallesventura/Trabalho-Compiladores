/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

import analisador_lexico.Token;

/**
 *
 * @author talles
 */
// TODO: terminar
public class Small_stmt2 extends AbstractHandler {

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.PONTO_VIRGULA) {
                if (nextToken()) {
                    if(true ){//simple_stmt
                        
                    }

                } else {
                    //lista de tokens vazia
                    errorCode = 6;
                    return false;
                }
            } else {
                //Small_stmt2 permite volor vazio
                //tokem ponto_virgula não encontrado
            }
        } else {
            //lista de tokens vazia
            errorCode = 6;
            return false;
        }
        return true;
    }

}
