/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

import analisador_lexico.Token;
import static analisador_sintatico.handlers.AbstractHandler.currentToken;

/**
 *
 * @author yrmao
 */
public class Return_stmt extends AbstractHandler {

    public Return_stmt() {
        super();
        terminais.add(Token.RETURN);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (terminais.contains(currentToken)) {
                removeToken();
                if (nextToken()) {
                    if(!(new Parameters_opt().handle())){
                        //ouve algun erro no handler do parameters_opt
                        return false;
                    }
                } else {
                    //lista de tokens vazia
                    //return_stmt permite que não tenha nada
                }
            } else {
                //esperado um tokem return
                return false;
            }
        } else {
            //lista de tokens vazia
            return false;
        }
        return true;
    }
}
