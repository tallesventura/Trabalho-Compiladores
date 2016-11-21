package analisador_sintatico.handlers;

import Model.TokenModel;
import analisador_lexico.Token;
import java.util.ArrayList;

public class Pass extends AbstractHandler{
    public Pass(ArrayList<TokenModel> tokenList) {
        super(tokenList);
        terminais.add(Token.PASS);
    }
    
    @Override
    public boolean handle() {
        if(nextToken()){
            if(terminais.contains(currentToken)){
                removeToken();
            }else{
                errorCode = 39;
                return false;
            }        
        }else{
            errorCode = 40;
            return false;
        }    
        return true;
    }
}
