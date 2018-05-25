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
import ui.reports.print.model.RegRetModel;

/**
 *
 * @author Vimal
 */
public class RegRetPrint {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final JTable reportTable;
    private HashMap param;
    private ArrayList<RegRetModel> arrayList;
    private final String reportTitle;

    /**
     *
     * @param mainFrame
     * @param companyCode
     * @param reportTable
     * @param reportTitle

     */
    public RegRetPrint(MainFrame mainFrame, String companyCode, JTable reportTable, String reportTitle) {
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        this.reportTable = reportTable;
        this.reportTitle = reportTitle;
    }

    public boolean print() {
        boolean status = false;
        try {
            JasperReport jr = JasperCompileManager.compileReport(getClass().getResource("RegRetVoucherTemplate.jrxml").getPath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(arrayList);
            JasperPrint print = JasperFillManager.fillReport(jr, param, dataSource);
            new ExportToPdf().pdfExport(reportTitle, print, companyCode);
            status = true;
        } catch (JRException ex) {
            Logger.getLogger(RegRetPrint.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public void prepareModel() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < reportTable.getRowCount(); i++) {
            arrayList.add(new RegRetModel(reportTable.getValueAt(i, 0), reportTable.getValueAt(i, 1),
                    reportTable.getValueAt(i, 2), reportTable.getValueAt(i, 4),
                    reportTable.getValueAt(i, 5), reportTable.getValueAt(i, 6), reportTable.getValueAt(i, 7),reportTable.getValueAt(i, 8),reportTable.getValueAt(i, 10),reportTable.getValueAt(i, 12),reportTable.getValueAt(i, 13)));
        }

    }

    public void prepareParams(Object rN,Object vN,Calendar cal,Object notes, Object cN, Object cA,Object cAcc, Object bA,Object bAcc,Object debit,Object credit, Object totA,Object posOtherB,Object negOtherB, Object gt) {
        param = new HashMap();
        ArrayList<String> companyDetail = new PrintUtils().getCompanyName(companyCode, mainFrame);
        param.put("companyName", companyDetail.get(0));
        param.put("panOrVatNo", companyDetail.get(1));
        param.put("companyAddressPhone", companyDetail.get(2));
        param.put("reportName", rN);
        param.put("voucherNumber", vN);
        param.put("date", YearMonthDay.fromCalendarFields(cal));
        param.put("notes", notes);
        ArrayList<String> accDetail = new PrintUtils().getAccountDetail(companyCode, mainFrame, (String) cN);
        param.put("customerName", accDetail.get(0));
        param.put("customerAddressPhone", accDetail.get(1));
        param.put("cashAmount", (cA != null) ? ("Amt. " + cA) : null);
        param.put("cashAccount", (cAcc != null) ? ("Acc. " + cAcc) : null);
        param.put("bankAmount", (bA != null) ? ("Amt. " + bA) : null);
        param.put("bankAccount", (bAcc != null) ? ("Acc. " + bAcc) : null);
        param.put("debit", debit);
        param.put("credit", credit);
        param.put("totalAmount", totA);
        param.put("posOtherBS", posOtherB);
        param.put("negOtherBS", negOtherB);
        param.put("grandTotal", gt);
    }

}
