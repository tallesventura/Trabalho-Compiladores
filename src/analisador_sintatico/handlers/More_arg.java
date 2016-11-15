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
public class More_arg extends AbstractHandler {

    public More_arg() {
        super();
        terminais.add(Token.VIRGULA);
        terminais.add(Token.IDENTIFICADOR);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (terminais.contains(currentToken)) {//VIRGULA
                removeToken();
                if (nextToken()) {
                    if (terminais.contains(currentToken)) {//IDENTIFICADOR
                        removeToken();
                        if (nextToken()) {
                            if (new Arg_Assign().handle()) {
                                if (nextToken()) {
                                    if (!(new More_arg().handle())) {
                                        //ouve algum erro no handler do More_arg
                                        return false;
                                    }
                                } else {
                                    //lista de tokens vazia
                                    return false;
                                }
                            } else {
                                //ouve algum erro no handler do Arg_Assign
                                return false;
                            }
                        } else {
                            //lista de tokens vazia
                            return false;
                        }
                    } else {
                        //token "NAME" não foi encontrado
                    }

                } else {
                    //lista de token vazia
                    return false;
                }
            }
        }
        return true;
    }

}
