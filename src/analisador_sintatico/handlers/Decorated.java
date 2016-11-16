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
public class Decorated extends AbstractHandler {

    public Decorated() {
        super();
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (new Decorator().handle()) {
                if (nextToken()) {
                    if (!(new Definitions().handle())) {
                        //ouve algum erro no handler do Definicions
                        return false;
                    }
                } else {
                    //lista de tokens vazia
                    return false;
                }
            } else {
                //ouve algum erro no handler do Decorator
                return false;
            }
        } else {
            //lista de tkens vazia
            return false;
        }
        return true;
    }

}
