/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Presenter;

import DAO.DAOTxt;
import DAO.IDAO;
import Model.TokenModel;
import View.MainWindowView;
import analisador_lexico.AnalisadorLexico;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 *
 * @author tallesventura
 */
public class MainWindowPresenter {
    
    private MainWindowView viewMainWindow;
    private RSyntaxTextArea editor;
    private List<TokenModel> tokenList;
    private DefaultTableModel tblModelTokens;
    private String filePath;
    private String rootPath = "saved_files/arquivo1.txt";
    private File codeFile = null;
    
    public MainWindowPresenter() {
        
        viewMainWindow = new MainWindowView();
        editor = new RSyntaxTextArea();
        tokenList = new ArrayList();
        codeFile = new File(rootPath);
        
        initEditor();
        initTabelaToken();
        
        viewMainWindow.getMenuItemAbrir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lerArquivo();
            }
        });
        
        viewMainWindow.getBtnAbrir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lerArquivo();
            }
        });
        
        viewMainWindow.getBtnRefazer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    undo();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(viewMainWindow, ex.getMessage());
                }
            }
        });
        
        viewMainWindow.getBtnDesfazer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    undo();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(viewMainWindow, ex.getMessage());
                }
            }
        });
        
        viewMainWindow.getBtnAvancar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    redo();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(viewMainWindow, ex.getMessage());
                }
            }
        });
        
        viewMainWindow.getBtnVoltar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    redo();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(viewMainWindow, ex.getMessage());
                }
            }
        });
        
        viewMainWindow.getMenuItemSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarArquivo();
                /*
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnVal = fileChooser.showSaveDialog(viewMainWindow);
                if(returnVal == JFileChooser.APPROVE_OPTION){
                try {
                codeFile = fileChooser.getCurrentDirectory();
                //codeFile = fileChooser.getSelectedFile();
                //codeFile.createNewFile();
                saveCode(codeFile);
                } catch (IOException ex) {
                JOptionPane.showMessageDialog(viewMainWindow, ex);
                }
                }*/
            }
        });
        
        viewMainWindow.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarArquivo();
               
            }
        });
        
        viewMainWindow.getMenuItemAnaliseLex().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (codeFile == null) {
                    JOptionPane.showMessageDialog(viewMainWindow, "Salve o arquivo primeiro!");
                } else {
                    try {
                        runLexicalAnalysis();
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(viewMainWindow, ex);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(viewMainWindow, ex);
                    }
                }
            }
        });
        
        editor.addKeyListener(new KeyAdapter() {
            
            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if(keyCode == KeyEvent.VK_ENTER ||
                        keyCode == KeyEvent.VK_TAB){
                    try {
                        updateSourceCode();
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(viewMainWindow, ex);
                    }
                }            
            }
       
        });
           
        viewMainWindow.setLocationRelativeTo(viewMainWindow);
        viewMainWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);
        viewMainWindow.setVisible(true);
    }
    
    public final void initEditor() {
        JPanel cp = new JPanel(new BorderLayout());
        
        editor.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON);
        editor.setCodeFoldingEnabled(true);
        editor.setHighlightCurrentLine(true);
        editor.setLineWrap(true);
        editor.setAutoIndentEnabled(false);
        editor.setHighlightCurrentLine(true);
        RTextScrollPane sp = new RTextScrollPane(editor);
        sp.setFoldIndicatorEnabled(true);
        sp.setVisible(true);
        cp.add(sp);
        
        viewMainWindow.getjScrollPaneCodigo().setColumnHeaderView(cp);       
    }
    
    public final void initTabelaToken() {
        String[] columnNames = {"ID", "Linha", "Token", "Lexema"};
        tblModelTokens = new DefaultTableModel(columnNames, 0);
        viewMainWindow.getTblTokens().setModel(tblModelTokens);
    }
    
    public void saveCode(File f) throws IOException {
        
        String srcCode = editor.getText();
        FileWriter w = new FileWriter(f);
        BufferedWriter bf = new BufferedWriter(w);
        bf.write(srcCode);
        bf.flush();
        bf.close();
    }
    
    public void runLexicalAnalysis() throws FileNotFoundException, IOException {
        
        AnalisadorLexico al = AnalisadorLexico.getInstance(codeFile);
        this.tokenList.clear();
        this.tokenList = al.runAnalysis();
        for (TokenModel t : tokenList) {
            System.out.println(t.getNome());
        }
        updateTokenTable(tokenList);
    }
    
    public void updateTokenTable(List<TokenModel> tokens) {
        tblModelTokens.setNumRows(0);
        for (TokenModel t : tokens) {
            Object o[] = {t.getID(), t.getLinha(), t.getNome(), t.getLexema()};
            tblModelTokens.addRow(o);
        }
    }
    
    public void salvarArquivo() {
        try {
            String filename = File.separator;
            JFileChooser fc = new JFileChooser(new File(filename));
            fc.showSaveDialog(viewMainWindow);
            IDAO dao = new DAOTxt(fc.getSelectedFile().getAbsolutePath() + ".txt");
            dao.salvaArquivo(editor.getText());
            JOptionPane.showMessageDialog(null, "Arquivo Salvo!");
            codeFile = dao.getFile();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo MainPresenter");
        }
    }
    
    public void lerArquivo() {
        JFileChooser abrir = new JFileChooser();
        int retorno = abrir.showOpenDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION) {
            String caminho = abrir.getSelectedFile().getAbsolutePath();
            String codigo = "";
            codeFile = new File(caminho);
            try {
                Scanner scan = new Scanner(codeFile);
                while(scan.hasNextLine()) {
                    codigo = codigo + scan.nextLine() + "\n";
                }
                editor.setText(codigo);
                JOptionPane.showMessageDialog(null, "Importação concluida!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao carregar arquivo!");
            }
        }
    }
    
    public void undo() throws Exception{
        if(editor.canUndo()){
            editor.undoLastAction();
        }else{
            throw new Exception("Não é possível desfazer a última ação");
        }
    }
    
    public void redo() throws Exception{
        if(editor.canRedo()){
            editor.redoLastAction();
        }else{
            throw new Exception("Não é possível refazer a última ação");
        }
    }
    
    public void updateSourceCode() throws IOException{
        codeFile = new File(rootPath);
        saveCode(codeFile);
        runLexicalAnalysis();
    }
}
