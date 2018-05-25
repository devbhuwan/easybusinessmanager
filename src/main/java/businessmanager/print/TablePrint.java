package businessmanager.print;

import java.awt.print.PrinterException;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class TablePrint {

    private final JTable table;
    private final String headerFormat;
    private final String footerFormat;

    /**
     * Constructs an instance of the demo.
     *
     * @param table
     * @param name
     * @param headerFormat
     * @param footerFormat
     */
    public TablePrint(JTable table, String name, String headerFormat, String footerFormat) {
        this.table = table;
        this.headerFormat = headerFormat;
        this.footerFormat = footerFormat;

    }

    /**
     * Print the grades table.
     */
    public void printTable() {
        MessageFormat header = new MessageFormat(headerFormat);
        MessageFormat footer = new MessageFormat(footerFormat);

        try {
            /* print the table */
            boolean complete = table.print(JTable.PrintMode.FIT_WIDTH, header, footer,
                    true, null,
                    true, null);

            /* if printing completes */
            if (complete) {
                /* show a success message */
                JOptionPane.showMessageDialog(null,
                        "Printing Complete",
                        "Printing Result",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                /* show a message indicating that printing was cancelled */
                JOptionPane.showMessageDialog(null,
                        "Printing Cancelled",
                        "Printing Result",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (PrinterException pe) {
            /* Printing failed, report to the user */
            JOptionPane.showMessageDialog(null,
                    "Printing Failed: " + pe.getMessage(),
                    "Printing Result",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
