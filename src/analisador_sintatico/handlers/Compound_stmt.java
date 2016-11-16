/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

/**
 *
 * @author talles
 */
// TODO: terminar
public class Compound_stmt extends AbstractHandler {

    public Compound_stmt() {
        super();
    }
    

    @Override
    public boolean handle() {
        if (nextToken()) {
            if (new If_stmt().handle()) {

            } else if (new While_stmt().handle()) {

            } else if (new With_stmt().handle()) {

            } else if (new Funcdef().handle()) {

            } else if (new Classdef().handle()) {

            } else if (new Decorated().handle()) {

            } else if (new Async_stmt().handle()) {

            } else {
                errorCode = 3;
                return false;
            }
        }
        return true;
    }
}
