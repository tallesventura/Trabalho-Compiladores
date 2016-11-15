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
LineTerminator = \r | \r\n
WhiteSpace = {LineTerminator} | [ \f]

%%

{Comment} {/*Ignore*/}
\t {id+=1; return Token.INDENT;}
\n { return Token.NOVA_LINHA; }
{WhiteSpace} {/*Ignore*/}
(\".*\") | (\'.*\') { id+=1; return Token.STRING; }
({Num1}|{Num2}|{Num3}) { id+=1; return Token.NUMERO; }

(_|{Letra})({Letra}|{N}|_)* { id+=1; return Token.IDENTIFICADOR; }


/* Operadores aritméticos */
"+" { id+=1; return Token.OP_ADICAO; }
"-" { id+=1; return Token.OP_SUBTRACAO; }
"*" { id+=1; return Token.OP_MULTIPLICACAO; }
"/" { id+=1; return Token.OP_DIVISAO; }
"//" { id+=1; return Token.OP_DIVISAO_INTEIRA; }
"**" { id+=1; return Token.OP_EXPONENCIACAO; }
"%" { id+=1; return Token.OP_RESTO; }
"~" { id+=1; return Token.OP_TIL; }

/* Operadores de atribuição */
"=" { id+=1; return Token.ATRIBUICAO; }
"**=" { id+=1; return Token.OP_EXPONENCIACAO_IGUAL; }
"//=" { id+=1; return Token.OP_DIVISAO_INTEIRA_IGUAL; }
"+=" { id+=1; return Token.OP_MAIS_IGUAL; }
"-=" { id+=1; return Token.OP_MENOS_IGUAL; }
"*=" { id+=1; return Token.OP_VEZES_IGUAL; }
"/=" { id+=1; return Token.OP_DIVIDIDO_IGUAL; }
"%=" { id+=1; return Token.OP_RESTO_IGUAL; }
"@=" { id+=1; return Token.OP_ARROBA_IGUAL; }
"^=" { id+=1; return Token.OP_CIRCUNFLEXO_IGUAL; }
"<<=" { id+=1; return Token.OP_LEFT_SHIFT_IGUAL; }
">>=" { id+=1; return Token.OP_RIGHT_SHIFT_IGUAL; }

/* Operadores de comparação */
">" { id+=1; return Token.OP_MAIOR; }
"<" { id+=1; return Token.OP_MENOR; }
">=" { id+=1; return Token.OP_MAIOR_IGUAL; }
"<=" { id+=1; return Token.OP_MENOR_IGUAL; }
"==" { id+=1; return Token.OP_IGUALDADE; }
"!=" { id+=1; return Token.OP_DIFERENTE; }
"<>" { id+=1; return Token.OP_DIFERENTE; }

/* Operadores lógicos */
"and" { id+=1; return Token.AND; }
"or" { id+=1; return Token.OR; }
"not" { id+=1; return Token.NOT; }

/* Operadores bit a bit */
">>" { id+=1; return Token.RIGHT_SHIFT; }
"<<" { id+=1; return Token.LEFT_SHIFT; }

/* Palavras reservadas */
"and" { id+=1; return Token.AND; }
"as" { id+=1; return Token.AS; }
"break" { id+=1; return Token.BREAK; }
"class" { id+=1; return Token.CLASS; }
"continue" { id+=1; return Token.CONTINUE; }
"def" { id+=1; return Token.DEF; }
"del" { id+=1; return Token.DELETE; }
"elif" { id+=1; return Token.ELIF; }
"else" { id+=1; return Token.ELSE; }
"except" { id+=1; return Token.EXCEPT; }
"False" { id+=1; return Token.FALSE; }
"for" { id+=1; return Token.FOR; }
"from" { id+=1; return Token.FROM; }
"global" { id+=1; return Token.GLOBAL; }
"if" { id+=1; return Token.IF; }
"import" { id+=1; return Token.IMPORT; }
"in" { id+=1; return Token.IN; }
"is" { id+=1; return Token.IS; }
"None" { id+=1; return Token.NONE; }
"nonlocal" { id+=1; return Token.NONLOCAL; }
"print" { id+=1; return Token.PRINT; }
"pass" { id+=1; return Token.PASS; }
"range" { id+=1; return Token.RANGE; }
"return" { id+=1; return Token.RETURN; }
"raise" { id+=1; return Token.RAISE; }
"True" { id+=1; return Token.TRUE; }
"try" { id+=1; return Token.TRY; }
"while" { id+=1; return Token.WHILE; }
"yield" { id+=1; return Token.YIELD; }

/* Pontuacao */
":" { id+=1; return Token.DOIS_PONTOS; }
"(" { id+=1; return Token.ABRE_PARENTESES; }
")" { id+=1; return Token.FECHA_PARENTESES; }
"[" { id+=1; return Token.ABRE_COLCHETES; }
"]" { id+=1; return Token.FECHA_COLCHETES; }
"{" { id+=1; return Token.ABRE_CHAVES; }
"}" { id+=1; return Token.FECHA_CHAVES; }
"," { id+=1; return Token.VIRGULA; }
"'" { id+=1; return Token.ASPAS_SIMPLES; }
"\"" { id+=1; return Token.ASPAS_DUPLAS; }
"." { id+=1; return Token.PONTO; }
";" { id+=1; return Token.PONTO_VIRGULA; }

. { id+= 1; return Token.ERROR; }