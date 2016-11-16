package analisador_sintatico.handlers;

import analisador_lexico.Token;
import static analisador_sintatico.handlers.AbstractHandler.currentToken;

public class Argument_list extends AbstractHandler {

    public Argument_list() {
        super();
        terminais.add(Token.VIRGULA);
        terminais.add(Token.IDENTIFICADOR);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (terminais.contains(currentToken)) {
                removeToken();
                if (nextToken()) {
                    if (terminais.contains(currentToken)) {
                        if (nextToken()) {
                            if(!(new Argument_list().handle())){
                                //argument_list não foi encontrado
                                return false;
                            }
                        } else {
                            //lista de tokens vazia
                            return false;
                        }
                    } else {
                        //token "NAME" não foi encontrado
                        return false;
                    }
                } else {
                    //lista de tokens vazia
                    return false;
                }
            } else {
                //token "," não foi encontrado
                return false;
            }
        } else {
            //lista de tokens vazia
            //argument_list permite que não tenha nada
        }
        return true;
    }
}
