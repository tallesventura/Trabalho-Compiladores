package analisador_sintatico.handlers;

import analisador_lexico.Token;

public class Pass extends AbstractHandler{
    public Pass() {
        super();
        terminais.add(Token.PASS);
    }
    
    @Override
    public boolean handle() {
        if(nextToken()){
            if(terminais.contains(currentToken)){
                removeToken();
            }else{
                //token "pass" não foi encontrado
                return false;
            }        
        }else{
            //lista de tokens vazia
            return false;
        }    
        return true;
    }
}
