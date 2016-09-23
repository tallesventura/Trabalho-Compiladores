package analisador_lexico

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

%%

