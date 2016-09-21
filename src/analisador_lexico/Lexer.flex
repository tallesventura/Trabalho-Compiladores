package analisador_lexico

%%

%class Lexer
%line
%column

%{ 
private String lexema;
private int line;

public String getLexema(){
    return lexema;
}

%}