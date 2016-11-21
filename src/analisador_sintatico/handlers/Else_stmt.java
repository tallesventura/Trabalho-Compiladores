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
public class Else_stmt extends AbstractHandler {

    public Else_stmt(ArrayList<TokenModel> tokenList) {
        super(tokenList);
        terminais.add(Token.ELSE);
        terminais.add(Token.DOIS_PONTOS);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.ELSE) {//ELSE
                removeToken();
                if (nextToken()) {
                    if (currentToken == Token.DOIS_PONTOS) {//DOIS_PONTOS
                        removeToken();
                        if (nextToken()) {
                            if (!(new Suite(tokens).handle())) {
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
