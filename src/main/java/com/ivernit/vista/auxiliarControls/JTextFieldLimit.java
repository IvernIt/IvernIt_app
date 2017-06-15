package com.ivernit.vista.auxiliarControls;

import static com.google.common.collect.Iterables.limit;
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
 * Crea un JTextField que está limitado tanto por la cantidad de caracteres que
 * se pueden introducir, como por los caracteres que se pueden introducir. Los
 * caracteres validos son todos aquellos que cumplan la expersion almacenada en
 * VALID_STRING_REGEX
 *
 * @author Pablo
 */
public class JTextFieldLimit extends JTextField {

    private int limit = 20;
    private final String VALID_STRING_REGEX = "[0-9a-zA-Z @.]*";

    public JTextFieldLimit() {
        super();
    }

    /**
     * Usar este constructor en caso de necesitar un campo con más largo
     * @param limit 
     */
    public JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }

    @Override
    protected Document createDefaultModel() {
        return new LimitDocument();
    }

    /**
     * Se ha de crear una clase que permita escuchar las acciones antes de que
     * se lleguen a visualizar
     */
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
                            Strings.MSG_CARACTERES_INVALIDOS + ": " + str,
                            Strings.ERROR,
                            JOptionPane.PLAIN_MESSAGE,
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

}
