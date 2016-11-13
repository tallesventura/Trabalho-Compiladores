package analisador_sintatico.handlers;

import analisador_lexico.Token;
import static analisador_sintatico.handlers.AbstractHandler.currentToken;

public class Flow_stmt extends AbstractHandler{

    @Override
    public boolean handle() {
        if(nextToken()){
                       
            if(currentToken == Token.BREAK){
                removeToken();
            
            }else if(currentToken == Token.CONTINUE){
                //token "continue" -> CONTINUE não foi encontrado
                errorCode = 7;
                return false;
            }else if(new Return_stmt().handle()){
                //função return
                
            }else if(new Yield_stmt().handle()){//yield_stmt
                //função yield
            }else{
                
            }
            
        }else{
            //lista de tokens vazia
            errorCode = 6;
            return false;
        }
        
        return true;
    }
    
}
