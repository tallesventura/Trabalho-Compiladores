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
public class Typedargslist extends AbstractHandler {

    public Typedargslist(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.IDENTIFICADOR);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.IDENTIFICADOR) {//NAME
                removeToken();
                if (nextToken()) {
                    if (new Arg_Assign(tokens).handle()) {
                        if (nextToken()) {
                            if (!(new More_arg(tokens).handle())) {
                                //ouve algum erro no handler do More_arg
                                return false;
                                //return new More_arg(tokens).handle();
                            }
                        } else {
                            //lista de tokens vazia
                            return false;
                        }
                    }
                }else{
                    //lista de tokens vazia
                    return false;
                }
            } else {
                //token "NAME" não foi encontrado
                return false;
            }
        } else {
            //lista de tokens vazia
            return false;
        }
        return true;
    }

}
