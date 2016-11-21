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
public class Parameters_opt extends AbstractHandler {

    public Parameters_opt(ArrayList<TokenModel> tokenList) {
        super(tokenList);
        terminais.add(Token.ABRE_PARENTESES);
        terminais.add(Token.FECHA_PARENTESES);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.ABRE_PARENTESES) {
                removeToken();
                if (nextToken()) {
                    if (new Arglist(tokens).handle()) {
                        if (nextToken()) {
                            if(currentToken == Token.FECHA_PARENTESES){
                                removeToken();                             
                            }else{
                                errorCode = 31;
                                return false;
                            }
                        } else {
                            errorCode = 32;
                            return false;
                        }
                    } else {
                        errorCode = 33;
                        return false;
                    }
                } else {
                    errorCode = 34;
                    return false;
                }
            }
        }
        return true;
    }
}
