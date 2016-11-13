package analisador_sintatico.handlers;

import analisador_lexico.Token;

public class Pass extends AbstractHandler{
    public Pass() {
        super();
    }
    
    @Override
    public boolean handle() {
        if(nextToken()){
            if(currentToken == Token.PASS){
                removeToken();
            }else{
                //token "pass" - > PASS não foi encontrado
                errorCode = 9;
                return false;
            }        
        }else{
            //lista de tokens vazia
            errorCode = 9;
            return false;
        }    
        return true;
    }
}
