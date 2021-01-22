package icu.jogeen.fakerplugin.ui;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiDocumentManager;
import icu.jogeen.fakerplugin.service.FakerService;
import icu.jogeen.fakerplugin.utils.PsiDocumentUtils;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class FakerDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JList jlField;
    private JComboBox cbTopic;
    private FakerService fakerService;
    private AnActionEvent e;

    public FakerDialog(FakerService fakerService, AnActionEvent e) {
        this.e = e;
        this.fakerService = fakerService;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        cbTopic.setModel(new DefaultComboBoxModel(fakerService.getTopics().toArray()));
        setLocation(600, 200);//距离屏幕左上角的其实位置
        setSize(200, 300);
        setTitle("");
        init();
    }

    public void init() {
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        cbTopic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSelect();
            }
        });
    }

    private void onOK() {
        int topicIndex = cbTopic.getSelectedIndex();
        int filedIndex = jlField.getSelectedIndex();
        Object value = fakerService.invoke(topicIndex, filedIndex);
        Project project = e.getProject();
        PsiDocumentManager psiDocumentManager = PsiDocumentManager
                .getInstance(project);
        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        Document document = editor.getDocument();
        SelectionModel selectionModel = editor.getSelectionModel();
        WriteCommandAction.runWriteCommandAction(project, new Runnable() {
            @Override
            public void run() {
                //document.insertString(selectionModel.getSelectionStart(), value + "");
                document.replaceString(selectionModel.getSelectionStart(),selectionModel.getSelectionEnd(),"\""+value+"\"");
                PsiDocumentUtils.commitAndSaveDocument(psiDocumentManager, document);

            }
        });
        this.setFocusable(false);
        //dispose();
        //String selectedText = selectionModel.getSelectedText();

    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    private void onSelect() {
        int selectedIndex = cbTopic.getSelectedIndex();
        List<String> fields = fakerService.getFields(selectedIndex);
        DefaultListModel listModel = new DefaultListModel();
        jlField.setModel(listModel);
        fields.stream().forEach(temp -> listModel.addElement(temp));
    }
}
