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
                        removeToken();
                        if (nextToken()) {
                            if(!(new Argument_list(tokens).handle())){
                                AbstractHandler.errorCode = 33;
                                return false;
                            }
                        } else {
                            AbstractHandler.errorCode = 34;
                            return false;
                        }
                    } else {
                        AbstractHandler.errorCode = 6;
                        return false;
                    }
                } else {
                    AbstractHandler.errorCode = 10;
                    return false;
                }
            }
        }
        return true;
    }
}
