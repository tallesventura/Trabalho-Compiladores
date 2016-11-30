package analisador_sintatico.handlers;

import Model.TokenModel;
import analisador_lexico.Token;
import static analisador_sintatico.handlers.AbstractHandler.currentToken;
import java.util.ArrayList;

/**
 *
 * @author talles
 */
public class Flow_stmt extends AbstractHandler {

    public Flow_stmt(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.BREAK);
        terminais.add(Token.CONTINUE);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            /*
            if (terminais.contains(currentToken)) {
                removeToken();
            } else if (currentToken == Token.RETURN) {
                return new Return_stmt(tokens).handle();
            } else if(currentToken == Token.YIELD){
                return new Yield_stmt(tokens).handle();
            }else{
                errorCode = 41;
                return false;
            }
        }else {
            errorCode = 42;
            return false;
        }
        */
            switch(currentToken){
                case BREAK:
                    removeToken();
                    return true;
                case CONTINUE:
                    removeToken();
                    return true;
                case RETURN:
                    return new Return_stmt(tokens).handle();
                case YIELD:
                    return new Yield_stmt(tokens).handle();
                default:
                    errorCode = 42;
                    return false;

            }
        }else{
            errorCode = 25;
            return false;
        }
        
        //return true;
    }
}
