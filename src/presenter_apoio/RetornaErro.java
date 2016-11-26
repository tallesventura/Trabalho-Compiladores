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
            case 33: 
                return "Houve algum erro na lista de argumentos";
            case 34: 
                return "Lista de argumentos vazia";
            case 35: 
                return "Esperado o token <,>, mas foi encontrado <" + error.getLexema() + ">.";
            case 36: 
                return "Esperado o token <,>, mas nenhum token foi encontrado";
            case 37: 
                return "Esperado operador de atribuição , mas nenhum token foi encontrado";
            case 38: 
                return "terminal <del> esperado, mas nenhum token foi encontrado";
            case 39: 
                return "terminal <pass> esperado, mas foi encontrado <" + error.getLexema() + ">." ;
            case 40: 
                return "terminal <pass> esperado, mas nenhum token foi encontrado" ;
            case 41: 
                return "Esperado expressão de controle de fluxo, mas foi encontrado <" + error.getLexema() + ">.";
            case 42: 
                return "Esperado expressão de controle de fluxo, mas nenhum token foi encontrado" ;
            case 43: 
                return "Terminal <return> esperado, mas nenhum token foi encontrado" ;
            case 44: 
                return "Esperado parâmetros, mas foi encontrado <" + error.getLexema() + ">."  ;
            case 45: 
                return "Terminal <yield> esperado, mas nenhum token foi encontrado" ;
            case 46: 
                return "Terminal <async> esperado, mas nenhum token foi encontrado" ;
            case 47: 
                return "Terminal <async> esperado, mas foi encontrado <" + error.getLexema() + ">."  ;
            case 48: 
                return "Terminal <:> esperado, mas nenhum token foi encontrado" ;
            case 49: 
                return "Terminal <:> esperado, mas foi encontrado <" + error.getLexema() + ">."  ;
            case 50: 
                return "Terminal <class> esperado, mas nenhum token foi encontrado" ;
            case 51: 
                return "Terminal <class> esperado, mas foi encontrado <" + error.getLexema() + ">."  ;
            case 52: 
                return "Terminal <@> esperado, mas nenhum token foi encontrado" ;
            case 53: 
                return "Terminal <@> esperado, mas foi encontrado <" + error.getLexema() + ">."  ;
            case 54: 
                return "Terminal <.> esperado, mas nenhum token foi encontrado" ;
            case 55: 
                return "Terminal <.> esperado, mas foi encontrado <" + error.getLexema() + ">."  ;
            case 56: 
                return "expressão condicional incompleta";
            case 57: 
                return "Terminal <for> esperado, mas foi encontrado <" + error.getLexema() + ">."  ;
            case 58: 
                return "Terminal <in> esperado, mas foi encontrado <" + error.getLexema() + ">."  ;
            case 59: 
                return "Terminal <def> esperado, mas nenhum token foi encontrado" ;
            case 60: 
                return "Terminal <def> esperado, mas foi encontrado <" + error.getLexema() + ">."  ;
            case 61: 
                return "Terminal <if> esperado, mas nenhum token foi encontrado" ;
            case 62: 
                return "Terminal <if> esperado, mas foi encontrado <" + error.getLexema() + ">."  ;
            case 63: 
                return "Terminal <import> esperado, mas nenhum token foi encontrado" ;
            case 64: 
                return "Terminal <import> esperado, mas foi encontrado <" + error.getLexema() + ">."  ;
            case 65: 
                return "Terminal <nonlocal> esperado, mas nenhum token foi encontrado" ;
            case 66:
                return "Terminal <nonlocal> esperado, mas foi encontrado <" + error.getLexema() + ">."  ;
            case 67: 
                return "Terminal <)> esperado, mas nenhum token foi encontrado";
            case 68: 
                return "Terminal <)> esperado, mas foi encontrado <" + error.getLexema() + ">.";
            case 69: 
                return "Esperado expressão operacional, mas foi encontrado <" + error.getLexema() + ">.";
            case 70: 
                return "Esperado definição de função ou de classe, mas nenhum token foi encontrado";
            case 71: 
                return "Esperado o token < = >, mas nenhum token foi encontrado";
            case 72: 
                return "Esperado o token <global>, mas nenhum token foi encontrado";
            case 73: 
                return "Esperado o token <global>, mas foi encontrado <" + error.getLexema() + ">.";
            case 74:
                return "Esperado o token <while>, mas nenhum token foi encontrado";
            case 75: 
                return "Esperado o token <while>, mas foi encontrado <" + error.getLexema() + ">.";
            case 76: 
                return "Terminal <for> esperado, mas nenhum token foi encontrado";
            case 77: 
                return "Esperado o token <{>, mas nenhum token foi encontrado";
            case 78: 
                return "Esperado o token <{>, mas foi encontrado <" + error.getLexema() + ">.";
            case 79: 
                return "Esperado o token <}>, mas nenhum token foi encontrado";
            case 80: 
                return "Esperado o token <}>, mas foi encontrado <" + error.getLexema() + ">.";
            default:
                return "";
        }
    }
}
