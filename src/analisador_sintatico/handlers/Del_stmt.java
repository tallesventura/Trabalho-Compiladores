
package analisador_sintatico.handlers;

import analisador_lexico.Token;

public class Del_stmt extends AbstractHandler{

    public Del_stmt() {
        super();
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
                        //token "NAME" - > IDENTIFICADOR não foi encontrado
                        errorCode = 6;
                        return false;
                    }
                }else{
                    //lista de tokens vazia
                    errorCode = 6;
                    return false;
                }
            }else{
                //token "del" - > DELETE não foi encontrado
                errorCode = 7;
                return false;
            }
        }else{
            //lista de tokens vazia
            errorCode = 6;
            return false;
        }
        
        return true;
    }
    
}
