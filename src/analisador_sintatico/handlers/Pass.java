package analisador_sintatico.handlers;

import Model.TokenModel;
import analisador_lexico.Token;
import java.util.ArrayList;

public class Pass extends AbstractHandler{
    public Pass(ArrayList<TokenModel> tokens) {
        super(tokens);
        terminais.add(Token.PASS);
    }
    
    @Override
    public boolean handle() {
        if(nextToken()){
            if(terminais.contains(currentToken)){
                removeToken();
            }else{
                AbstractHandler.errorCode = 39;
                return false;
            }        
        }else{
            AbstractHandler.errorCode = 40;
            return false;
        }    
        return true;
    }
}
