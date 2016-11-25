/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

import Model.TokenModel;
import analisador_lexico.Token;
import static analisador_sintatico.handlers.AbstractHandler.currentToken;
import java.util.ArrayList;

/**
 *
 * @author yrmao
 */
public class Return_stmt extends AbstractHandler {

    public Return_stmt(ArrayList<TokenModel> tokenList) {
        super(tokenList);
        terminais.add(Token.RETURN);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.RETURN) {
                removeToken();
                if (nextToken()) {
                    if(!(new Parameters_opt(tokens).handle())){
                        errorCode = 44 ;
                        return false;
                        //return new Parameters_opt(tokens).handle();
                    }
                } else {
                    errorCode = 45;
                    return false;
                }
            }
        } else {
            errorCode = 43;
            return false;
        }
        return true;
    }
}
