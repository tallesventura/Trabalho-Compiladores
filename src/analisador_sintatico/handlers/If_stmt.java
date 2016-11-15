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
public class If_stmt extends AbstractHandler {

    public If_stmt() {
        super();
        terminais.add(Token.IF);
        terminais.add(Token.DOIS_PONTOS);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (terminais.contains(currentToken)) {//IF
                removeToken();
                if (nextToken()) {
                    if (new Expr().handle()) {
                        if (nextToken()) {
                            if (terminais.contains(currentToken)) {//DOIS_PONTOS
                                removeToken();
                                if (new Suite().handle()) {
                                    if (nextToken()) {
                                        if (new Elif_stmt().handle()) {
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
                                            //ouve algum erro no handler do Elif_stmt
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
                //token "if" não foi encontrado
                return false;
            }
        } else {
            //lista de Tokens vazia
            return false;
        }
        return true;
    }

}
