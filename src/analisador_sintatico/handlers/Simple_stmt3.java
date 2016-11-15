/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

/**
 *
 * @author yrmao
 */
public class Simple_stmt3 extends AbstractHandler {

    public Simple_stmt3() {
        super();
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (new Small_stmt().handle()) {
                if (nextToken()) {
                    if(new Small_stmt2().handle()){
                        
                    }else{
                        //small_stmt não encontrado
                    }
                    
                } else {
                    //lista de tokens vazia
                    errorCode = 6;
                    return false;
                }
            } else {
                //small_stmt3 não encontrado
                //small_stmt3 permite valor vazio
            }

        } else {
            //lista de tokens vazia
            errorCode = 6;
            return false;
        }
        return true;
    }

}
