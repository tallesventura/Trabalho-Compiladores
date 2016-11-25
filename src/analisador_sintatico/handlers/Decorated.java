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
public class Decorated extends AbstractHandler {

    public Decorated(ArrayList<TokenModel> tokens) {
        super(tokens);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (new Decorator(tokens).handle()) {
                if (nextToken()) {
                    if (!(new Definitions(tokens).handle())) {
                        //ouve algum erro no handler do Definicions
                        return false;
                        //return new Definitions(tokens).handle();
                    }
                } else {
                    //lista de tokens vazia
                    return false;
                }
            }
        } else {
            //lista de tkens vazia
            return false;
        }
        return true;
    }

}
