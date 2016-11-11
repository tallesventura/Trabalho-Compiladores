/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico;

import Model.TokenModel;
import analisador_sintatico.handlers.Single_input;
import java.util.ArrayList;

/**
 *
 * @author talles
 */
public class AnalisadorSintatico{
    
    private ArrayList<TokenModel> tokens;
    private Single_input handler;

    public AnalisadorSintatico(ArrayList<TokenModel> tokens) {
        this.tokens = tokens;
        this.handler = new Single_input(tokens);
    }
    
    
    
}
