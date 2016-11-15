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
public class Parameters_opt extends AbstractHandler {

    public Parameters_opt() {
        super();
        terminais.add(Token.ABRE_PARENTESES);
        terminais.add(Token.FECHA_PARENTESES);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (terminais.contains(currentToken)) {
                removeToken();
                if (nextToken()) {
                    if (new Arglist().handle()) {
                        if (nextToken()) {
                            if(terminais.contains(currentToken)){
                                removeToken();                             
                            }else{
                                //token ")" não foi encontrado
                                return false;
                            }
                        } else {
                            //lista de tokens vazia
                            return false;
                        }
                    } else {
                        //ouve algun erro no handler do argslist
                        return false;
                    }
                } else {
                    //lista de tokens vazia
                    return false;
                }
            }else{
                //token "(" não foi encontrado
            }
        }
        return true;
    }

}
