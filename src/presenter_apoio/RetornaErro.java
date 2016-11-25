/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter_apoio;

import Model.ErrorModel;
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
    
    
    public static String getError(ErrorModel error){
        switch(error.getCodigo()){
            case 1:
                return "Operador inválido < " + error.getLexema() + " >.";
            case 2:
                return "Ultrapassou o tamanho máximo permitido para um identificador.";
            case 3:
                return "Token <" + error.getLexema() +  "> não esperado.";
            case 4:
                return "Token <NOVA_LINHA> esperado, mas foi encontrado <" + error.getLexema() + ">.";
            case 5:
                return "Token <" + error.getLexema() + "> esperado, mas nenhum token foi encontrado.";
            case 6:
                return "Token <NOVA_LINHA> esperado, mas nenhum token foi encontrado.";
            case 7: 
                return "terminal “del” esperado, mas foi encontrado <" + error.getLexema() + ">.";
            case 8:
                return "Expressão incompleta.";
            case 9:
                return "terminal “pass” esperado, mas foi encontrado <" + error.getLexema() + ">.";
            case 10:
                return "Identificador esperado, mas nenhum token foi encontrado.";
            case 11:
                return "Esperado um operador de atribuição, mas nenhum token foi encontrado.";
            case 12:
                return "Esperado um operador de atribuição, mas foi encontrado <" + error.getLexema() + ">.";
            case 13:
                return "Esperado uma expressão, mas nenhum token foi encontrado.";
            case 14:
                return "Esperado expressão composta, mas nenhum token foi encontrado.";
            case 15:
                return "Esperado expressão operacional, mas nenhum token foi encontrado.";
            case 16:
                return "Esperado expressão relacional, mas nenhum token foi encontrado.";
            case 17:
                return "Esperado expressão aritmética, mas nenhum token foi encontrado.";
            case 18:
                return "Esperado operador aritmético, mas nenhum token foi encontrado.";
            case 19:
                return "Esperado operador aritmético, mas foi encontrado <" + error.getLexema() + ">.";
            case 20:
                return "Esperado operador relacional, mas nenhum token foi encontrado.";
            case 21:
                return "Esperado o operador <in>, mas nenhum token foi encontrado.";
            case 22:
                return "Esperado operador <in>, mas foi encontrado <" + error.getLexema() + ">."; 
            case 23:
                return "Esperado operador lógico, mas nenhum token foi encontrado.";
            case 24:
                return "Esperado operador lógico, mas foi encontrado <" + error.getLexema() + ">.";
            case 25:
                return "Instrução incompleta";
            case 26:
                return "Esperado expressão unária, mas nenhum token foi encontrado.";
            case 27:
                return "Esperado expressão unária, mas foi encontrado <" + error.getLexema() + ">.";
            case 28:
                return "Esperado operador multiplicativo, mas nenhum token foi encontrado";
            case 29:
                return "Esperado operador multiplicativo, mas foi encontrado <" + error.getLexema() + ">.";
            case 30:
                return "Esperado operador relacional, mas foi encontrado <" + error.getLexema() + ">.";
            case 31:
                return "Esperado o token <(>, mas foi encontrado <" + error.getLexema() + ">.";
            case 32:
                return "Esperado o token <(>, mas nenhum token foi encontrado";
            default:
                return "";
        }
    }
}
