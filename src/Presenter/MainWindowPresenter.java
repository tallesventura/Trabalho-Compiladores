/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenter;

import View.MainWindowView;
import java.awt.BorderLayout;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
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

    public MainWindowPresenter() {

        viewMainWindow = new MainWindowView();
        editor = new RSyntaxTextArea();
        
        
        initEditor();
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
        editor.setAutoIndentEnabled(true);
        editor.setHighlightCurrentLine(true);
        RTextScrollPane sp = new RTextScrollPane(editor);
        sp.setFoldIndicatorEnabled(true);
        sp.setVisible(true);
        cp.add(sp);
        
        viewMainWindow.getjScrollPaneCodigo().setColumnHeaderView(cp);
        
        
    }

}
