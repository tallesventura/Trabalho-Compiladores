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
 * @author talles
 */
public class Single_input extends AbstractHandler {

    public Single_input(ArrayList<TokenModel> tokens) {
        super(tokens);
        this.terminais = new ArrayList();
    }

    @Override
    public boolean handle() {

        if (nextToken()) {
            if (currentToken == Token.NOVA_LINHA) {
                removeToken();
                new Single_input(tokens).handle();
            }else if(new Simple_stmt(tokens).handle()){
                    new Single_input(tokens).handle();
            }else if(new Compound_stmt(tokens).handle()){
                    if(nextToken()){
                        if(currentToken == Token.NOVA_LINHA){
                            tokens.remove(0);
                            new Single_input(tokens).handle();
                        }else{
                            errorCode = 4;
                            return false;
                        }
                    }else{
                        errorCode = 5;
                        return false;
                    }
            }else{
                errorCode = 3;
                return false;
            }
        }
        return true;
    }

}
