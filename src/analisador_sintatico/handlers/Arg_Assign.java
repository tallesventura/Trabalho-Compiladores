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
public class Arg_Assign extends AbstractHandler {

    public Arg_Assign(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.OP_ATRIBUICAO);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.OP_ATRIBUICAO) {//OP_ATRIBUICAO
                removeToken();
                if (nextToken()) {
                    return new Expr(tokens).handle();
                }
            } else {
                errorCode = 37;
                return false;
            }
        }
        return true;
    }
}
