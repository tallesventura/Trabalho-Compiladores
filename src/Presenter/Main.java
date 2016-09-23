/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import java.io.File;

/**
 *
 * @author tallesventura
 */
public class Main {
    
    public static void gerarLexer( String path){
        File f = new File(path);
        jflex.Main.generate(f);
    }
    
    public static void main(String[] args){
        MainWindowPresenter mainWindow = new MainWindowPresenter();
        
        String path_lexer = "src/analisador_lexico/Lexer.flex";
        gerarLexer(path_lexer);
    }
}
