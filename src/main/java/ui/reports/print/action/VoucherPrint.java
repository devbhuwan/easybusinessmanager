/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.print.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.joda.time.YearMonthDay;
import ui.main.MainFrame;
import ui.reports.print.ExportToPdf;
import ui.reports.print.PrintUtils;
import ui.reports.print.model.VoucherModel;

/**
 *
 * @author Vimal
 */
public class VoucherPrint {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final JTable reportTable;
    private HashMap param;
    private ArrayList<VoucherModel> arrayList;
    private final String reportTitle;

    /**
     *
     * @param mainFrame
     * @param companyCode
     * @param reportTable
     * @param reportTitle

     */
    public VoucherPrint(MainFrame mainFrame, String companyCode, JTable reportTable, String reportTitle) {
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        this.reportTable = reportTable;
        this.reportTitle = reportTitle;
    }

    public boolean print() {
        boolean status = false;
        try {
            JasperReport jr = JasperCompileManager.compileReport(new ReportFileGetter().getFilePath("VouchersTemplate.jrxml"));
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(arrayList);
            JasperPrint print = JasperFillManager.fillReport(jr, param, dataSource);
            new ExportToPdf().pdfExport(reportTitle, print, companyCode);
            status = true;
        } catch (JRException ex) {
            Logger.getLogger(VoucherPrint.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public void prepareModel() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < reportTable.getRowCount(); i++) {
            arrayList.add(new VoucherModel(reportTable.getValueAt(i, 0), reportTable.getValueAt(i, 1),
                    reportTable.getValueAt(i, 2), reportTable.getValueAt(i, 3),
                    reportTable.getValueAt(i, 4), reportTable.getValueAt(i, 5), reportTable.getValueAt(i, 6)));
        }

    }

    public void prepareParams(Object rN,Object vN,Calendar cal,Object notes,Object debit,Object credit) {
        param = new HashMap();
        ArrayList<String> companyDetail = new PrintUtils().getCompanyName(companyCode, mainFrame);
        param.put("companyName", companyDetail.get(0));
        param.put("panOrVatNo", companyDetail.get(1));
        param.put("companyAddressPhone", companyDetail.get(2));
        param.put("reportName", rN);
        param.put("voucherNumber", vN);
        param.put("date", YearMonthDay.fromCalendarFields(cal));
        param.put("notes", notes);
        param.put("debit", debit);
        param.put("credit", credit);
    }

}
