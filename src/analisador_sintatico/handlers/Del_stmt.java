
package analisador_sintatico.handlers;

import analisador_lexico.Token;

public class Del_stmt extends AbstractHandler{

    public Del_stmt() {
        super();
        terminais.add(Token.DELETE);
        terminais.add(Token.IDENTIFICADOR);
    }
    
    @Override
    public boolean handle() {
        if(nextToken()){
            if(terminais.contains(currentToken)){
                removeToken();
                if(nextToken()){
                    if(terminais.contains(currentToken)){
                        removeToken();
                    }else{
                        //token "NAME" não foi encontrado
                        return false;
                    }
                }else{
                    //lista de tokens vazia
                    return false;
                }
            }else{
                //token "del" não foi encontrado
                return false;
            }
        }else{
            //lista de tokens vazia
            return false;
        }
        return true;
    }
}
