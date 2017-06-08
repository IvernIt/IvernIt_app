/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivernit.vista.auxiliarControls;

import com.ivernit.utils.Strings;
import com.ivernit.vista.mainFrame.MainFrame;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Pablo
 */
public class JTextFieldLimit extends JTextField {

    private final int limit;
    private final String VALID_STRING_REGEX = "[0-9a-zA-Z ]*";

    public JTextFieldLimit() {
        super();
        this.limit = 20;
    }

    @Override
    protected Document createDefaultModel() {
        return new LimitDocument();
    }

    private class LimitDocument extends PlainDocument {

        @Override
        public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {

            if (str != null) {

                if (Pattern.matches(VALID_STRING_REGEX, str)) {

                    if ((getLength() + str.length()) <= limit) {
                        super.insertString(offset, str, attr);
                    }
                } else {
                    JOptionPane.showConfirmDialog(MainFrame.get(),
                            Strings.MSG_CARACTERES_INVALIDOS +": " + str,
                            Strings.ERROR,
                            JOptionPane.PLAIN_MESSAGE,
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

}
