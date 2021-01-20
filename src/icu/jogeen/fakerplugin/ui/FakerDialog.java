package icu.jogeen.fakerplugin.ui;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import icu.jogeen.fakerplugin.service.FakerService;

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
        this.fakerService = fakerService;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        cbTopic.setModel(new DefaultComboBoxModel(fakerService.getTopics().toArray()));

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

        Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
        Document document = editor.getDocument();
        SelectionModel selectionModel = editor.getSelectionModel();
        document.insertString(selectionModel.getSelectionStart(),value+"");
        //String selectedText = selectionModel.getSelectedText();
        dispose();
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
