package analisador_sintatico.handlers;

import analisador_lexico.Token;
import static analisador_sintatico.handlers.AbstractHandler.currentToken;

/**
 *
 * @author talles
 */
public class Flow_stmt extends AbstractHandler {

    public Flow_stmt() {
        super();
        terminais.add(Token.BREAK);
        terminais.add(Token.CONTINUE);
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (terminais.contains(currentToken)) {
                removeToken();
            } else if (new Return_stmt().handle()) {
                //função Return
            } else 
                return new Yield_stmt().handle();
        }else {
            //lista de tokens vazia
            return false;
        }
        return true;
    }
}
