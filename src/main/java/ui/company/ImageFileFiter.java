
package ui.company;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Bhuwan Prasad Upadhyay
 */
class ImageFileFiter extends FileFilter {
    
    @Override
    public boolean accept(File f) {
        return f.isDirectory() || f.getAbsolutePath().endsWith(".png") || f.getAbsolutePath().endsWith(".jpeg") || f.getAbsolutePath().endsWith(".jpg");
    }

    @Override
    public String getDescription() {
        return "Image documents Only(*.png,*.jpeg,*.jpg)";
    }
    
}
