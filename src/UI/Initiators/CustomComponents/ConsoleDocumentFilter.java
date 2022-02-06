package UI.Initiators.CustomComponents;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

public class ConsoleDocumentFilter extends DocumentFilter {
    private int offset = 0;
    private String DefaultString;
    private Document document;

    public void setDocument(Document document) {
        this.document = document;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setDefaultString(String defaultString) {
        DefaultString =defaultString;
    }

    /**
     * Invoked prior to removal of the specified region in the
     * specified Document. Subclasses that want to conditionally allow
     * removal should override this and only call supers implementation as
     * necessary, or call directly into the <code>FilterBypass</code> as
     * necessary.
     *
     * @param fb     FilterBypass that can be used to mutate Document
     * @param offset the offset from the beginning &gt;= 0
     * @param length the number of characters to remove &gt;= 0
     * @throws BadLocationException some portion of the removal range
     *                              was not a valid part of the document.  The location in the exception
     *                              is the first bad position encountered.
     */
    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        if (offset > this.offset) {
            super.remove(fb, offset, length);
            updateOffset();
        }

    }

    private void updateOffset() {
        try {
            this.offset = this.document.getText(0, document.getLength()).lastIndexOf(DefaultString) + DefaultString.length()-1;
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }


    /**
     * Invoked prior to insertion of text into the
     * specified Document. Subclasses that want to conditionally allow
     * insertion should override this and only call supers implementation as
     * necessary, or call directly into the FilterBypass.
     *
     * @param fb     FilterBypass that can be used to mutate Document
     * @param offset the offset into the document to insert the content &gt;= 0.
     *               All positions that track change at or after the given location
     *               will move.
     * @param string the string to insert
     * @param attr   the attributes to associate with the inserted
     *               content.  This may be null if there are no attributes.
     * @throws BadLocationException the given insert position is not a
     *                              valid position within the document
     */
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (offset > this.offset) {
            super.insertString(fb, this.offset + 1, string, attr);

        } else {
            super.insertString(fb, document.getLength(), DefaultString, attr);
        }

    }

    /**
     * Invoked prior to replacing a region of text in the
     * specified Document. Subclasses that want to conditionally allow
     * replace should override this and only call supers implementation as
     * necessary, or call directly into the FilterBypass.
     *
     * @param fb     FilterBypass that can be used to mutate Document
     * @param offset Location in Document
     * @param length Length of text to delete
     * @param text   Text to insert, null indicates no text to insert
     * @param attrs  AttributeSet indicating attributes of inserted text,
     *               null is legal.
     * @throws BadLocationException the given insert position is not a
     *                              valid position within the document
     */
    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (offset > this.offset) {
            super.replace(fb, offset, length, text, attrs);
        } else {
            super.insertString(fb, offset, DefaultString, attrs);
        }


    }
}
