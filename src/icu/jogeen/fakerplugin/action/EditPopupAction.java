package icu.jogeen.fakerplugin.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import icu.jogeen.fakerplugin.service.FakerService;
import icu.jogeen.fakerplugin.service.FakerServiceFactory;
import icu.jogeen.fakerplugin.ui.FakerDialog;

import java.util.Locale;

/**
 * @Author jogeen
 * @Date 11:16 2021/1/19
 * @Version v1.0
 * @Description
 */
public class EditPopupAction extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        FakerService fakerService = FakerServiceFactory.getFakerService(Locale.ENGLISH);
        FakerDialog fakerDialog = new FakerDialog(fakerService,e);
        fakerDialog.setVisible(true);
    }
}
