
package businessmanager.backuprecovery;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Tej Bist
 */
class PathFileFiter extends FileFilter {

    @Override
    public boolean accept(File f) {
        return f.isDirectory();
    }

    @Override
    public String getDescription() {
        return "Select Path For Backup";
    }
    
}
