/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author otavi
 */
public class DAOTxt implements IDAO {

    private final File arquivo;

    public DAOTxt(String diretorio) throws Exception {
        this.arquivo = new File(diretorio);
        if(!arquivo.exists())
            arquivo.createNewFile();
    }
    
    @Override
    public void salvaArquivo(String conteudo) {
        try{
        FileWriter w = new FileWriter(arquivo, false);
        BufferedWriter bf = new BufferedWriter(w);
        bf.write(conteudo);
        bf.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao salvar aquivo!!");
        }
    }
    
    public File getFile(){
        return arquivo;
    }

}
