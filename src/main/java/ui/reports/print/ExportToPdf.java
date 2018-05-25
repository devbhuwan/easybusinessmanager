/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports.print;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import ui.company.CompanyDBUtils;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class ExportToPdf {

    public void pdfExport(String reportName, JasperPrint jasperPrint, String companyCode) {

        String envDirectory = System.getenv("ProgramFiles");
        Path path = FileSystems.getDefault().getPath(envDirectory + "/Business Manager/reports/" + companyCode + "/");
        Path pathForReport = FileSystems.getDefault().getPath(envDirectory + "/Business Manager/reports/" + companyCode + "/", reportName + ".pdf");
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException ex) {
                Logger.getLogger(CompanyDBUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                Files.deleteIfExists(pathForReport);
            } catch (IOException ex) {
                Logger.getLogger(CompanyDBUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            JRPdfExporter pdfExporter = new JRPdfExporter();
            pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT,
                    jasperPrint);
            pdfExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
                    path + "/" + reportName + ".pdf");
            System.out.println("Exporting report...");
            pdfExporter.exportReport();
            System.out.println("Done!");
            openPdf(pathForReport);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    private void openPdf(Path path) {
        try {
            if (Files.exists(path)) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler " + path.toAbsolutePath());
                p.waitFor();

            } else {
                System.out.println("File is not exists");

            }
            System.out.println("Done");

        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
