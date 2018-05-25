
package businessmanager.backuprecovery;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Tej Bist
 */
class FileFiter extends FileFilter {

    @Override
    public boolean accept(File f) {
        return f.isDirectory() || f.getAbsolutePath().endsWith(".accdb");
    }

    @Override
    public String getDescription() {
        return "Only MS Acess Database File";
    }
}
