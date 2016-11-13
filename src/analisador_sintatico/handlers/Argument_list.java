package analisador_sintatico.handlers;

import analisador_lexico.Token;
import static analisador_sintatico.handlers.AbstractHandler.currentToken;

public class Argument_list extends AbstractHandler {

    public Argument_list() {
        super();
    }

    @Override
    public boolean handle() {

        if (nextToken()) {
            if (currentToken == Token.VIRGULA) {
                removeToken();
                if (nextToken()) {
                    if (currentToken == Token.IDENTIFICADOR) {
                        if (nextToken()) {
                            if(new Argument_list().handle()){
                                //
                            }else{
                                //argument_list não foi encontrado
                            }
                            
                        } else {
                            //lista de tokens vazia
                            errorCode = 6;
                            return false;
                        }

                    } else {
                        //token "NAME" - > IDENTIFICADOR não foi encontrado
                    }
                } else {
                    //lista de tokens vazia
                    errorCode = 6;
                    return false;
                }

            } else {
                //token "," - > VIRGULA não foi encontrado
            }

        } else {
            //argument_list permite que não tenha nada
        }

        return true;
    }

}
