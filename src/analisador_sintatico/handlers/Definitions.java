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
public class Definitions extends AbstractHandler {

    public Definitions() {
        super();
    }

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (new Funcdef().handle()) {
                //Funcdef
            } else if (new Async_stmt().handle()) {
                //Async_funcdef
            } else {
                return new Classdef().handle(); 
                //ouve algum erro no handler do Funcdef/Async_fundef/Classdef
            }
        } else {
            //lista de tokens vazia
            return false;
        }
        return true;
    }

}
