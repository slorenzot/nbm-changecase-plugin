/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osm.netbeans.plugin.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JEditorPane;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.cookies.EditorCookie;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Source",
        id = "com.osm.netbeans.plugin.actions.ChangeTextLowerCaseAction"
)
@ActionRegistration(
        displayName = "#CTL_ChangeTextLowerCaseAction"
)
@ActionReference(path = "Editors/text/x-java/Popup", position = 4150, separatorBefore = 2495, separatorAfter = 4151)
@Messages("CTL_ChangeTextLowerCaseAction=Change Text to Lowercase")
public final class ChangeTextLowerCaseAction implements ActionListener {

    private final List<EditorCookie> context;

    public ChangeTextLowerCaseAction(List<EditorCookie> context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        
        for (EditorCookie editorCookie : context) {
            // TODO use editorCookie
            for (JEditorPane editingFile : editorCookie.getOpenedPanes()) {
                if (editingFile.getSelectedText() == null) {
                    NotifyDescriptor d =
                        new NotifyDescriptor.Message("No selected text!", NotifyDescriptor.INFORMATION_MESSAGE);
                    DialogDisplayer.getDefault().notify(d);
                } else {
                    editingFile.replaceSelection(editingFile.getSelectedText().toLowerCase());
                }
            }
        }
    }
}
