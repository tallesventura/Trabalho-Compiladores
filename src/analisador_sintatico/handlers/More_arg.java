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
public class More_arg extends AbstractHandler {

    public More_arg(ArrayList<TokenModel> tokenList) {
        super(tokenList);
        terminais.add(Token.VIRGULA);
        terminais.add(Token.IDENTIFICADOR);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.VIRGULA) {//VIRGULA
                removeToken();
                if (nextToken()) {
                    if (currentToken == Token.IDENTIFICADOR) {//IDENTIFICADOR
                        removeToken();
                        if (nextToken()) {
                            if (new Arg_Assign(tokens).handle()) {
                                if (nextToken()) {
                                    if (!(new More_arg(tokens).handle())) {
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
