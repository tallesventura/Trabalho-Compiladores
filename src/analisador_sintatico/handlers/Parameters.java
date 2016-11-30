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
public class Parameters extends AbstractHandler {

    public Parameters(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.ABRE_PARENTESES);
        terminais.add(Token.FECHA_PARENTESES);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.ABRE_PARENTESES) {//ABRA_PARENTESES
                removeToken();
                if (new Typedargslist(tokens).handle()) {
                    if (nextToken()) {
                        if (currentToken == Token.FECHA_PARENTESES) {//FECHA_PARENTESES
                            removeToken();
                        } else {
                            AbstractHandler.errorCode = 68;
                            return false;
                        }
                    } else {
                        AbstractHandler.errorCode = 67;
                        return false;
                    }
                }else{
                    return false;
                }
            } else {
                AbstractHandler.errorCode = 31;
                return false;
            }
        } else {
            AbstractHandler.errorCode = 32;
            return false;
        }
        return true;
    }

}
