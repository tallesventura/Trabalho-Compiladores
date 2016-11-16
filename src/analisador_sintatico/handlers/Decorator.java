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
public class Decorator extends AbstractHandler {

    public Decorator() {
        super();
        terminais.add(Token.OP_ARROBA);
        terminais.add(Token.NOVA_LINHA);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (terminais.contains(currentToken)) {//@
                removeToken();
                if (new Dotted_name().handle()) {
                    if (nextToken()) {
                        if (terminais.contains(currentToken)) {//NOVA_LINHA
                            removeToken();
                            if (nextToken()) {
                                if (!(new Decorator().handle())) {
                                    //ouve algum erro no handler do Dotted_name
                                    return false;
                                }
                            } else {
                                //lista de tokens vazia
                                return false;
                            }
                        } else {
                            //token "NOVA_LINHA" não foi encontrado
                            return false;
                        }
                    } else {
                        //lista de tokens vazia
                        return false;
                    }
                } else {
                    //ouve algum erro no handler do Dotted_name
                    return false;
                }
            } else {
                //token "@" não foi encontrado
                return false;
            }
        } else {
            //list de tokens vazia
            return false;
        }
        return true;
    }

}
