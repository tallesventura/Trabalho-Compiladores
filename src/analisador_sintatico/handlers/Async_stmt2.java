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
public class Async_stmt2 extends AbstractHandler{

    public Async_stmt2() {
        super();
    }

    @Override
    public boolean handle() {
        if(nextToken()){
            if(new Funcdef().handle()){
                //funcdef
            }else if(new With_stmt().handle()){
                //with
            }else
                return new For_stmt().handle();
        }else{
            //lista de tokens vazia
            return false;
        }
        return true;
        
    }
    
}
