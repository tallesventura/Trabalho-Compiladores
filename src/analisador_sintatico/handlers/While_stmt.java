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
public class While_stmt extends AbstractHandler {

    public While_stmt() {
        super();
        terminais.add(Token.WHILE);
        terminais.add(Token.DOIS_PONTOS);

    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (terminais.contains(currentToken)) {//WHILE
                removeToken();
                if (nextToken()) {
                    if (new Expr().handle()) {
                        if (nextToken()) {
                            if (terminais.contains(currentToken)) {//DOIS_PONTOS
                                removeToken();
                                if (new Suite().handle()) {
                                    if (nextToken()) {
                                        if (!(new Else_stmt().handle())) {
                                            //ouve algum erro no handler do Else_stmt
                                            return false;
                                        }
                                    } else {
                                        //lista de Tokens vazia
                                        return false;
                                    }
                                } else {
                                    //ouve algum erro no handler do Suite
                                    return false;
                                }
                            } else {
                                //Token ":" não foi encontrado
                                return false;
                            }
                        } else {
                            //lista de Tokens vazia
                            return false;

                        }
                    } else {
                        //ouve algum erro no handler do Expr
                        return false;
                    }
                } else {
                    //lista de Tokens vazia
                    return false;
                }
            } else {
                //token "while" não foi encontrado
                return false;
            }
        } else {
            //lista de Tokens vazia
            return false;
        }
        return true;
    }
}
