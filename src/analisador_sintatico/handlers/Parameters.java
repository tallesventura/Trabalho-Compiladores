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
public class Parameters extends AbstractHandler {

    public Parameters() {
        super();
        terminais.add(Token.ABRE_PARENTESES);
        terminais.add(Token.FECHA_PARENTESES);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (terminais.contains(currentToken)) {//ABRA_PARENTESES
                removeToken();
                if (nextToken()) {
                    if (new Typedargslist().handle()) {
                        if(nextToken()){
                            if(terminais.contains(currentToken)){//FECHA_PARENTESES
                                removeToken();
                            }else{
                                //token ")" não foi encontrado
                                return false;
                            }
                        }else{
                            //lista de tokens vazia
                            return false;
                        }
                    } else {
                        //ouve algum erro no handler do Typedargslist
                        return false;
                    }
                } else {
                    //lista de tokens vazia
                    return false;
                }
            } else {
                //token "(" não foi encontrado
            }
        } else {
            //lista de tokens vazia
            return false;
        }
        return true;
    }

}
