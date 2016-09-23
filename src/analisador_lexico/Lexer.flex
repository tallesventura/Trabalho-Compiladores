package analisador_lexico;

import analisador_lexico.Token;
%%

%class Lexer
%line
%column
%type Token

%{ 
private static int id = 0;

public int getId(){
    return id;
}
%}

Num = [0-9]
Letra = [a-zA-Z]
Comment = "#".*
LineTerminator = \r | \n | \r\n
WhiteSpace = {LineTerminator} | [ \f]

%%

{Comment} {/*Ignore*/}
{WhiteSpace} {/*Ignore*/}
(\".*\") { id+=1; return Token.STRING;}

(_|{Letra})({Letra}|{Num}|_)* { id+=1; return Token.IDENTIFICADOR; }

/* Operadores */
"+" { id+=1; return Token.OP_ADICAO; }
"-" { id+=1; return Token.OP_SUBTRACAO; }
"*" { id+=1; return Token.OP_MULTIPLICACAO; }
"/" { id+=1; return Token.OP_DIVISAO; }
"+=" { id+=1; return Token.OP_MAIS_IGUAL; }
"-=" { id+=1; return Token.OP_MENOS_IGUAL; }
"*=" { id+=1; return Token.OP_VEZES_IGUAL; }
"/=" { id+=1; return Token.OP_DIVIDIDO_IGUAL; }
"=" { id+=1; return Token.ATRIBUICAO; }
"%" { id+=1; return Token.OP_RESTO; }

/* Pontuacao */
":" { id+=1; return Token.DOIS_PONTOS; }


. { return Token.ERROR; }