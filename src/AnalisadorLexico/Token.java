/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalisadorLexico;

/**
 *
 * @author tallesventura
 */
public enum Token {
    IDENTIFICADOR, OP_LOGICO, OP_ARITIMETICO, OP_RELACIONAL, DOIS_PONTOS, 
    VIRGULA, IDENTACAO, NUMERO, IF, ELSE, ELIF, IN, DEF, BREAK, CONTINUE, 
    RETURN, FOR, WHILE, STRING, ATRIBUICAO, ABRE_PARENTESES, FECHA_PARENTESES,
    NONE, ASPAS_SIMPLES, ASPAS_DUPLAS
}
