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
public class Stmt2 extends AbstractHandler {

    public Stmt2() {
        super();
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (!(new Stmt().handle())) {
                //ouve algum erro no handler do Stmt
                return false;
            }
        }
        return true;
    }
}
