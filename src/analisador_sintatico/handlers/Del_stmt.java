
package analisador_sintatico.handlers;

import Model.TokenModel;
import analisador_lexico.Token;
import java.util.ArrayList;

public class Del_stmt extends AbstractHandler{

    public Del_stmt(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.DELETE);
        terminais.add(Token.IDENTIFICADOR);
    }
    
    @Override
    public boolean handle() {
        if(nextToken()){
            if(currentToken == Token.DELETE){
                removeToken();
                if(nextToken()){
                    if(currentToken == Token.IDENTIFICADOR){
                        removeToken();
                    }else{
                        AbstractHandler.errorCode = 6;
                        return false;
                    }
                }else{
                    AbstractHandler.errorCode = 10;
                    return false;
                }
            }else{
                AbstractHandler.errorCode = 7;
                return false;
            }
        }else{
            AbstractHandler.errorCode = 38;
            return false;
        }
        return true;
    }
}
