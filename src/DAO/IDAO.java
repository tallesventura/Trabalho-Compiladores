/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.File;

/**
 *
 * @author otavi
 */
public interface IDAO {
    public void salvaArquivo(String conteudo);
    public File getFile();
}
