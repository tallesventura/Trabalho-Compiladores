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
public class Arg_Assign extends AbstractHandler {

    public Arg_Assign() {
        super(tokens);
        terminais.add(Token.OP_ATRIBUICAO);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (terminais.contains(currentToken)) {//OP_ATRIBUICAO
                removeToken();
                if (nextToken()) {
                    if (!(new Expr().handle())) {
                        //ouve algum erro no handler do Expr
                        return false;
                    }
                }else{
                    //lista de tokens vazia
                    return false;
                }
            }
        } else {
            //lista de tokens vazia
            //permite returnar nada
        }
        return true;
    }

}
