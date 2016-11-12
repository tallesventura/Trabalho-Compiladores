/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

import analisador_lexico.Token;

/**
 *
 * @author talles
 */
public class Augassign extends AbstractHandler{

    public Augassign() {
        super();
        terminais.add(Token.OP_ATRIBUICAO);
        terminais.add(Token.OP_MAIS_IGUAL);
        terminais.add(Token.OP_MENOS_IGUAL);
        terminais.add(Token.OP_VEZES_IGUAL);
        terminais.add(Token.OP_ARROBA_IGUAL);
        terminais.add(Token.OP_DIVIDIDO_IGUAL);
        terminais.add(Token.OP_RESTO_IGUAL);
        terminais.add(Token.OP_AND_IGUAL);
        terminais.add(Token.OP_OR_IGUAL);
        terminais.add(Token.OP_CIRCUNFLEXO_IGUAL);
        terminais.add(Token.OP_LEFT_SHIFT_IGUAL);
        terminais.add(Token.OP_RIGHT_SHIFT_IGUAL);
        terminais.add(Token.OP_EXPONENCIACAO_IGUAL);
        terminais.add(Token.OP_DIVISAO_INTEIRA_IGUAL);        
    }
    

    @Override
    public boolean handle() {
        
        if(nextToken()){
            if(!terminais.contains(currentToken)){
                errorCode = 12;
                return false;
            }
        }else{
            errorCode = 11;
            return false;
        }
        return true;
    }
   
}
