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
                if (nextToken()) {
                    if (new Dotted_name(tokens).handle()) {
                        if (nextToken()) {
                            if (!(new Import_as_name(tokens).handle())) {
                                //ouve algum erro no handler do import_as_name
                                return false;
                                //return new Import_as_name(tokens).handle();
                            }
                        } else {
                            //lista de tokens vazia
                            return false;
                        }
                    }
                } else {
                    //lista de tokens vazia
                    return false;
                }
            } else {
                //O token import não foi encontrado
                return false;
            }
        } else {
            //lista de tokens vazia
            return false;
        }
        return true;
    }
}
