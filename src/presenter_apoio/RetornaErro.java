/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter_apoio;

import Model.TokenModel;

/**
 *
 * @author otavi
 */
public class RetornaErro {
    
    // Aqui ele retorna um erro em formato de string de acordo com
    // o seu identificador, ele tambem recebe um token caso ele
    // precise pegar alguma informação, por exemplo, este primeiro
    // "case" retorna a mensagem de erro "Operador inválido + nome do token".
    
    // A medida que novos erros forem aparecendo, a gente seta um novo "case" pra ele.
    
    
    public static String getError(int id, TokenModel token){
        switch(id){
            case 1:
                return "Operador inválido < " + token.getLexema() + " >";
            case 2:
                return "Ultrapassou o tamanho máximo permitido para um identificador.";
            case 3:
                return "Token <" + token.getLexema() +  "> não esperado.";
            case 4:
                return "Token <NOVA_LINHA> esperado, mas foi encontrado <" + token.getLexema() + ">.";
            case 5:
                return "Token <" + token.getLexema() + "> esperado, mas nenhum token foi encontrado.";
            default:
                return "";
        }
    }
}
