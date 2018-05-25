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
import ui.reports.print.model.ProductionReportModel;

/**
 *
 * @author Vimal
 */
public class ProductionReportPrint {

    private final MainFrame mainFrame;
    private final String companyCode;
    private final JTable reportTable;
    private final String notes;
    private HashMap param;
    private ArrayList<ProductionReportModel> arrayList;
    private final Calendar cal;
    private final Calendar cal1;
    private final String reportTitle;
    private final String transactionName;

    /**
     *
     * @param mainFrame
     * @param companyCode
     * @param reportTable
     * @param notes
     * @param cal
     * @param cal1
     * @param transactionName
     * @param reportTitle
     */
    public ProductionReportPrint(MainFrame mainFrame, String companyCode, JTable reportTable, String notes, Calendar cal, Calendar cal1, String reportTitle,String transactionName) {
        this.mainFrame = mainFrame;
        this.companyCode = companyCode;
        this.reportTable = reportTable;
        this.notes = notes;
        this.cal = cal;
        this.cal1 = cal1;
        this.reportTitle = reportTitle;
        this.transactionName = transactionName;
    }

    public void prepare() {
        prepareModel();
        prepareParams();
    }

    public boolean print() {
        boolean status = false;
        try {
            JasperReport jr = JasperCompileManager.compileReport(new ReportFileGetter().getFilePath("ProductionReportTemplate.jrxml"));
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(arrayList);
            JasperPrint print = JasperFillManager.fillReport(jr, param, dataSource);
            new ExportToPdf().pdfExport(reportTitle, print, companyCode);
            status = true;
        } catch (JRException ex) {
            Logger.getLogger(ProductionReportPrint.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    private void prepareModel() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < reportTable.getRowCount(); i++) {
            arrayList.add(new ProductionReportModel(reportTable.getValueAt(i, 0), reportTable.getValueAt(i, 1),
                    reportTable.getValueAt(i, 2), reportTable.getValueAt(i, 3),
                    reportTable.getValueAt(i, 4), reportTable.getValueAt(i, 5), reportTable.getValueAt(i, 6),reportTable.getValueAt(i, 7),reportTable.getValueAt(i, 8),reportTable.getValueAt(i, 9)));
        }

    }

    private void prepareParams() {
        param = new HashMap();
        ArrayList<String> companyDetail = new PrintUtils().getCompanyName(companyCode, mainFrame);
        param.put("companyName", companyDetail.get(0));
        param.put("panOrVatNo", companyDetail.get(1));
        param.put("companyAddressPhone", companyDetail.get(2));
        param.put("reportName", transactionName);
        param.put("dateFrom", YearMonthDay.fromCalendarFields(cal));
        param.put("dateTo", YearMonthDay.fromCalendarFields(cal1));
        param.put("notes", notes);
    }

}
