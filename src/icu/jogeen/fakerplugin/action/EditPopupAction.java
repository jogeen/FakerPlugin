package icu.jogeen.fakerplugin.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import icu.jogeen.fakerplugin.config.FakerLanguageConfigFactory;
import icu.jogeen.fakerplugin.ui.FakerDialog;

/**
 * @Author jogeen
 * @Date 11:16 2021/1/19
 * @Version v1.0
 * @Description
 */
public class EditPopupAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        FakerLanguageConfigFactory.createFakerLanguageConfig();
        FakerDialog fakerDialog = new FakerDialog();
        fakerDialog.setVisible(true);
    }
}
