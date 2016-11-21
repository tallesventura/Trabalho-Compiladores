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

    public Flow_stmt(ArrayList<TokenModel> tokenList) {
        super(tokenList);
        terminais.add(Token.BREAK);
        terminais.add(Token.CONTINUE);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (terminais.contains(currentToken)) {
                removeToken();
            } else if (new Return_stmt(tokens).handle()) {
                //função Return
            } else if(new Yield_stmt(tokens).handle()){
                //função Yield
            }else{
                errorCode = 41;
                return false;
            }
        }else {
            errorCode = 42;
            return false;
        }
        return true;
    }
}
