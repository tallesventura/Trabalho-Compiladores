package analisador_lexico;

import analisador_lexico.Token;
%%

%class Lexer
%line
%column
%type Token

%{
private int id = 0;

public int getId(){
    return id;
}

public int getLine(){
    return yyline;
}
%}

N = [0-9]
Num1 =  {N}+ \. {N}*
Num2 = \. {N}+
Num3 =  {N}+
Letra = [a-zA-Z]
Comment = "#".*
LineTerminator = \r | \n | \r\n
WhiteSpace = {LineTerminator} | [ \f]

%%

{Comment} {/*Ignore*/}
\n\t {id+=1; return Token.INDENT;}
{WhiteSpace} {/*Ignore*/}
(\".*\") | (\'.*\') { id+=1; return Token.STRING; }
({Num1}|{Num2}|{Num3}) { id+=1; return Token.NUMERO; }

(_|{Letra})({Letra}|{N}|_)* { id+=1; return Token.IDENTIFICADOR; }


/* Operadores */
"+" { id+=1; return Token.OP_ADICAO; }
"-" { id+=1; return Token.OP_SUBTRACAO; }
"**=" { id+=1; return Token.OP_EXPONENCIACAO_IGUAL; }
"**" { id+=1; return Token.OP_EXPONENCIACAO; }
"*" { id+=1; return Token.OP_MULTIPLICACAO; }
"//=" { id+=1; return Token.OP_DIVISAO_INTEIRA_IGUAL; }
"//" { id+=1; return Token.OP_DIVISAO_INTEIRA; }
"/" { id+=1; return Token.OP_DIVISAO; }
"+=" { id+=1; return Token.OP_MAIS_IGUAL; }
"-=" { id+=1; return Token.OP_MENOS_IGUAL; }
"*=" { id+=1; return Token.OP_VEZES_IGUAL; }
"/=" { id+=1; return Token.OP_DIVIDIDO_IGUAL; }
"==" { id+=1; return Token.OP_IGUALDADE; }
"=" { id+=1; return Token.ATRIBUICAO; }
"%=" { id+=1; return Token.OP_RESTO_IGUAL; }
"%" { id+=1; return Token.OP_RESTO; }

/* Pontuacao */
":" { id+=1; return Token.DOIS_PONTOS; }


. { id+= 1; return Token.ERROR; }