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
public class Decorator extends AbstractHandler {

    public Decorator(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.OP_ARROBA);
        terminais.add(Token.NOVA_LINHA);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.OP_ARROBA) {//@
                removeToken();
                if (new Dotted_name(tokens).handle()) {
                    if (nextToken()) {
                        if (currentToken == Token.NOVA_LINHA) {//NOVA_LINHA
                            removeToken();
                            if (nextToken()) {
                                if (!(new Decorator(tokens).handle())) {
                                    //ouve algum erro no handler do Dotted_name
                                    return false;
                                    //return new Decorator(tokens).handle();
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
