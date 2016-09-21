/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_lexico;

/**
 *
 * @author tallesventura
 */
public enum Token {
    ABRE_PARENTESES, ASPAS_DUPLAS, ASPAS_SIMPLES, ATRIBUICAO, BREAK, CONTINUE,
    DEDENT, DEF, DOIS_PONTOS, ELIF, ELSE, FECHA_PARENTESES, FOR, WHILE, INDENT,
    IDENTIFICADOR, IF, IN, NONE, NOVA_LINHA, NUMERO, OP_ARITIMETICO, OP_LOGICO,
    OP_RELACIONAL, RANGE, RETURN, STRING, VIRGULA
}
