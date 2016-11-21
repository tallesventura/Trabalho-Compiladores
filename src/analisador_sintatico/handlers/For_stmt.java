/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_sintatico.handlers;

import Model.TokenModel;
import java.util.ArrayList;

/**
 *
 * @author yrmao
 */
public class For_stmt extends AbstractHandler{

    public For_stmt(ArrayList<TokenModel> tokenList) {
        super(tokenList);
    }

    @Override
    public boolean handle() {
        return true;
    }

    
}
