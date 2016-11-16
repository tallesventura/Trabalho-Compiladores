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
public class Dotted_name2 extends AbstractHandler {

    public Dotted_name2() {
        super();
        terminais.add(Token.PONTO);
        terminais.add(Token.IDENTIFICADOR);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (terminais.contains(currentToken)) {
                removeToken();
                if (nextToken()) {
                    if (terminais.contains(currentToken)) {
                        removeToken();
                        if (!(new Dotted_name2().handle())) {
                            //ouve algum erro no handler do dotted_name2
                            return false;
                        }
                    } else {
                        //identificador não encontrado
                        return false;
                    }
                } else {
                    //lista de tokens vazia
                    return false;
                }
            } else {
                //dotted_name permite que não tenha nada
            }
        } else {
            //lista de tokens vazia
            return false;
        }
        return true;
    }

}
