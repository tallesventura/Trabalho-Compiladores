/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_lexico;

import Model.ErrorModel;
import Model.TokenModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tallesventura
 */
public class AnalisadorLexico {
    
    private static File sourceCode;
    private static AnalisadorLexico instance = null;
    private Lexer lexer;
    private ArrayList<ErrorModel> errorList;
    
    private AnalisadorLexico(File sourceCode) throws FileNotFoundException{
        this.sourceCode = sourceCode;
        Reader reader = new BufferedReader(new FileReader(sourceCode));
        this.lexer = new Lexer(reader);
        errorList = new ArrayList();
    }
   
    public File getSourceCode() {
        return sourceCode;
    }

    public static AnalisadorLexico getInstance(File sourceCode) throws FileNotFoundException {
        if(AnalisadorLexico.instance == null){
            AnalisadorLexico.instance = new AnalisadorLexico(sourceCode);
        }
        AnalisadorLexico.sourceCode = sourceCode;
        
        return instance;
    }
    
    private void montaListaErros(ArrayList<TokenModel> tokenList){
        
        for(TokenModel tm : tokenList){
            if (tm.getNome().equals(Token.ERROR)) {
                ErrorModel e = new ErrorModel(1,tm.getLexema(),tm.getLinha());
                errorList.add(e);
            }else if(tm.getNome() == Token.IDENTIFICADOR && tm.getLexema().length() > 79) {
                ErrorModel e = new ErrorModel(2,tm.getLexema(),tm.getLinha());
                errorList.add(e);
            }
        }
    }
    
    public ArrayList<TokenModel> runAnalysis() throws IOException{
        
        Reader reader = new BufferedReader(new FileReader(sourceCode));
        this.lexer = new Lexer(reader);
        
        ArrayList<TokenModel> tokenList = new ArrayList();
        while(true){
            
            Token token = lexer.yylex();
            
            if(token == null){
                break;
            }
            
            TokenModel tokenModel = new TokenModel(lexer.getId(),lexer.getLine(),token,lexer.yytext());
            tokenList.add(tokenModel);           
        }
        
        montaListaErros(tokenList);
        
        return tokenList;
    }

    public ArrayList<ErrorModel> getErrorList() {
        return errorList;
    }
   
}
