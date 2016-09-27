/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisador_lexico;

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
    
    private File sourceCode;
    private List<TokenModel> tokenList = new ArrayList();
    private static AnalisadorLexico instance = null;
    private Lexer lexer;
    
    private AnalisadorLexico(File sourceCode) throws FileNotFoundException{
        this.sourceCode = sourceCode;
        Reader reader = new BufferedReader(new FileReader(sourceCode));
        this.lexer = new Lexer(reader);
    }
   
    public File getSourceCode() {
        return sourceCode;
    }

    public List<TokenModel> getTokenList() {
        return tokenList;
    }

    public static AnalisadorLexico getInstance(File sourceCode) throws FileNotFoundException {
        if(AnalisadorLexico.instance == null){
            AnalisadorLexico.instance = new AnalisadorLexico(sourceCode);
        }
        return instance;
    }
    
    public void runAnalysis() throws IOException{
        
        while(true){
            
            Token token = lexer.yylex();
            
            if(token == null){
                break;
            }
            
            TokenModel tokenModel = new TokenModel(lexer.getId(),lexer.getLine(),token,lexer.yytext());
            tokenList.add(tokenModel);
        }
    }
    
}
