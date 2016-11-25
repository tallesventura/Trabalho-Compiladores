package analisador_sintatico.handlers;

import Model.TokenModel;
import analisador_lexico.Token;
import static analisador_sintatico.handlers.AbstractHandler.currentToken;
import java.util.ArrayList;

public class Argument_list extends AbstractHandler {

    public Argument_list(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.VIRGULA);
        terminais.add(Token.IDENTIFICADOR);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (currentToken == Token.VIRGULA) {//VIRGULA
                removeToken();
                if (nextToken()) {
                    if (currentToken == Token.IDENTIFICADOR) {//NAME
                        if (nextToken()) {
                            if(!(new Argument_list(tokens).handle())){
                                errorCode = 33;
                                return false;
                            }
                        } else {
                            errorCode = 34;
                            return false;
                        }
                    } else {
                        errorCode = 6;
                        return false;
                    }
                } else {
                    errorCode = 10;
                    return false;
                }
            } else {
                //token "," não foi encontrado
                errorCode = 35;
                return false;
            }
        }
        return true;
    }
}
