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
public class Stmt extends AbstractHandler {

    public Stmt() {
        super();
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (new Simple_stmt().handle())  {
                //simple
            } else if (new Compound_stmt().handle()) {
                //compound
            } else {
                //ouve algum erro no handler do Simple/Compound
                return false;
            }
        } else {
            //lista de Tokens vazia
            return false;
        }
        return true;
    }
}
