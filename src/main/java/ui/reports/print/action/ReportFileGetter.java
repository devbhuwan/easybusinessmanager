/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */

package ui.reports.print.action;

import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 *
 * @author Vimal
 */
public class ReportFileGetter {


    String getFilePath(String file) {
        String envDirectory = System.getenv("ProgramFiles");
        Path path = FileSystems.getDefault().getPath(envDirectory + "/Business Manager/reports/", file);
        return path.toString();
    }
    
}
