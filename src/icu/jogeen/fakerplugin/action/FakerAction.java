package icu.jogeen.fakerplugin.action;

import com.intellij.codeInsight.intention.PsiElementBaseIntentionAction;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import icu.jogeen.fakerplugin.common.CommonConstants;
import icu.jogeen.fakerplugin.service.FakerService;
import icu.jogeen.fakerplugin.service.FakerServiceFactory;
import icu.jogeen.fakerplugin.utils.PsiDocumentUtils;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

public class FakerAction extends PsiElementBaseIntentionAction {


    private static Map<String, String> keyMap = new HashMap<String, String>() {
        {
            put("city", "java.math.BigDecimal");
            put("java.util.Date", "java.util.Date");
            put("java.time.LocalDateTime", "java.time.LocalDateTime");
            put("java.time.LocalDate", "java.time.LocalDate");
        }
    };
    private String key;
    private Integer count;


    @Override
    public void invoke(@NotNull Project project, Editor editor, @NotNull PsiElement psiElement) throws IncorrectOperationException {
        FakerService fakerService = FakerServiceFactory.getFakerService(Locale.ENGLISH);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            String invoke = fakerService.invoke(1, 1);
            if (i != 0) {
                sb.append(",");
            }
            sb.append("\"").append(invoke).append("\"");
        }

        PsiDocumentManager psiDocumentManager = PsiDocumentManager
                .getInstance(project);
        Document document = editor.getDocument();
        WriteCommandAction.runWriteCommandAction(project, new Runnable() {
            @Override
            public void run() {
                document.insertString(psiElement.getTextOffset() + psiElement.getText().length(),
                        sb.toString());
                PsiDocumentUtils.commitAndSaveDocument(psiDocumentManager, document);
            }
        });
    }

    @Override
    public boolean isAvailable(@NotNull Project project, Editor editor, @NotNull PsiElement psiElement) {


        PsiElement psiParent = PsiTreeUtil.getParentOfType(psiElement,
                PsiLocalVariable.class, PsiMethod.class);
        if (psiParent == null) {
            return false;
        }
        if (psiParent instanceof PsiLocalVariable) {
            PsiLocalVariable psiLocal = (PsiLocalVariable) psiParent;
            if (!(psiLocal.getParent() instanceof PsiDeclarationStatement)) {
                return false;
            }

            String text =  psiLocal.getName();
            String countStr = text.replaceAll(".*[^\\d](?=(\\d+))", "");
            if (countStr == null || countStr.isEmpty()) {
                count = 1;
            } else {
                count = Integer.parseInt(countStr);
            }
            key = text.replace(countStr, "");
            if (keyMap.containsKey(key)) {
                return true;
            }
            return false;
        }
        return false;

    }

    @Nls
    @NotNull
    @Override
    public String getFamilyName() {
        return CommonConstants.GENERATE_RANDOM_DATA;
    }

    @NotNull
    @Override
    public String getText() {
        return CommonConstants.GENERATE_RANDOM_DATA;
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }
}
