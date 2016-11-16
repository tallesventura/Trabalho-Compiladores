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
public class Else_stmt extends AbstractHandler {

    public Else_stmt() {
        super();
        terminais.add(Token.ELSE);
        terminais.add(Token.DOIS_PONTOS);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (terminais.contains(currentToken)) {//ELSE
                removeToken();
                if (nextToken()) {
                    if (terminais.contains(currentToken)) {//DOIS_PONTOS
                        removeToken();
                        if (nextToken()) {
                            if (!(new Suite().handle())) {
                                //ouve algum erro no handler do Suite
                                return false;
                            }
                        } else {
                            //lista de tokens vazia
                            return false;
                        }
                    } else {
                        //token ":" não foi encontrado
                        return false;
                    }
                } else {
                    //lista de tokens vazia
                    return false;
                }
            } else {
                //token "else" não foi encontrado
                //Else_stmt permite vazio
            }
        }
        return true;
    }

}
