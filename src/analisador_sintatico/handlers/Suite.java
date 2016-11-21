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
public class Suite extends AbstractHandler {

    public Suite(ArrayList<TokenModel> tokenList) {
        super(tokenList);
        terminais.add(Token.NOVA_LINHA);
        terminais.add(Token.INDENT);
        terminais.add(Token.DEDENT);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (new Simple_stmt(tokens).handle()) {
                //nada
            } else if (currentToken == Token.NOVA_LINHA) {//NEWLINE
                removeToken();
                if (nextToken()) {
                    if (currentToken == Token.INDENT) {//INDENT
                        removeToken();
                        if (nextToken()) {
                            if (new Stmt(tokens).handle()) {
                                if (nextToken()) {
                                    if (new Stmt2(tokens).handle()) {
                                        if (nextToken()) {
                                            if (currentToken == Token.DEDENT) {
                                                removeToken();
                                            } else {
                                                errorCode = 102; //token DEDENT não foi encontrado
                                                return false;
                                            }
                                        } else {
                                            errorCode = 101;
                                            return false;
                                        }
                                    } else {
                                        errorCode = 104;//ouve algum erro no handler do Stmt2
                                        return false;
                                    }
                                } else {
                                    errorCode = 104;
                                    return false;
                                }
                            } else {
                                errorCode = 104;//ouve algum erro no handler do Stmt
                                return false;
                            }
                        } else {
                            errorCode = 104;
                            return false;
                        }
                    } else {
                        errorCode = 102;
                        return false;
                    }

                } else {
                    errorCode = 103;
                    return false;
                }
            } else {
                errorCode = 104;
                return false;
            }
        } else {
            //lista de Tokens vazia
            return false;
        }
        return true;
    }

}
