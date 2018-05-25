
package ui.images;

import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author Bhuwan
 */
public class ImageGet {

    public ImageIcon getActiveButtonIcon() {
        return new ImageIcon(getClass().getResource("activeButtonBackround.PNG"));
    }

    public ImageIcon getActiveSubButtonIcon() {
        return new ImageIcon(getClass().getResource("activeSubButtonBackround.png"));
    }

    public ImageIcon getHoverMainButtonIcon() {
        return new ImageIcon(getClass().getResource("hover.png"));
    }

    public ImageIcon getActiveMainButtonIcon() {
        return new ImageIcon(getClass().getResource("active.png"));
    }

    public ImageIcon getDefaultCompanyLogo() {
        return new ImageIcon(getClass().getResource("companyLogo.png"));
    }

    public ImageIcon getDefaultUserPhoto() {
        return new ImageIcon(getClass().getResource("user.png"));
    }

    public ImageIcon resizeimage(ImageIcon image) {
        return image;
    }

    public ImageIcon getAcceptIcon() {
        return new ImageIcon(getClass().getResource("accept.png"));
    }

    public ImageIcon getRejectIcon() {
        return new ImageIcon(getClass().getResource("reject.png"));
    }

    public ImageIcon getAlertIcon() {
        return new ImageIcon(getClass().getResource("alert.png"));
    }
    
    public ImageIcon getBuzLogo() {
        return new ImageIcon(getClass().getResource("logo.png"));
    }

    public File getDefaultUserPhotoFile() {
        return new File(getClass().getResource("user.png").getPath());
    }

    public File getDefaultCompanyLogoFile() {
        return new File(getClass().getResource("companyLogo.png").getPath());
    }

    public ImageIcon getLoader() {
        return new ImageIcon(getClass().getResource("loader.png"));
    }
    
}
