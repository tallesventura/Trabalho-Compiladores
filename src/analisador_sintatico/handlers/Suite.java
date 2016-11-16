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
public class Suite extends AbstractHandler {

    public Suite() {
        super();
        terminais.add(Token.NOVA_LINHA);
        terminais.add(Token.INDENT);
        terminais.add(Token.DEDENT);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (new Simple_stmt().handle()) {
                //nada
            } else if (terminais.contains(currentToken)) {//NEWLINE
                removeToken();
                if (nextToken()) {
                    if (terminais.contains(currentToken)) {//INDENT
                        removeToken();
                        if (nextToken()) {
                            if (new Stmt().handle()) {
                                if (nextToken()) {
                                    if (new Stmt2().handle()) {
                                        if (terminais.contains(currentToken)) {//DEDENT
                                            removeToken();
                                        }else{
                                            // token DEDENT não foi encontrado
                                            return false;
                                        }
                                    } else {
                                        //ouve algum erro no handler do Stmt2
                                        return false;
                                    }
                                } else {
                                    //lista de Tokens vazia
                                    return false;
                                }
                            } else {
                                //ouve algum erro no handler do Stmt
                                return false;
                            }
                        } else {
                            //lista de Tokens vazia
                            return false;
                        }
                    } else {
                        // token INDENT não foi encontrado
                        return false;
                    }

                } else {
                    //lista de Tokens vazia
                    return false;
                }
            } else {
                //ouve algum erro no handler do Elif_stmt ou não foi encontrado New Line
                return false;
            }
        } else {
            //lista de Tokens vazia
            return false;
        }
        return true;
    }

}
