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
 * @author talles
 */
public class Import_stmt extends AbstractHandler {

    public Import_stmt(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.IMPORT);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.IMPORT) {
                removeToken();
                if (new Dotted_name(tokens).handle()) {
                    return new Import_as_name(tokens).handle();
                }
            } else {
                //O token import não foi encontrado
                return false;
            }
        } else {
            errorCode = 62;
            return false;
        }
        return true;
    }
}
