
package businessmanager;

import java.util.logging.Level;
import java.util.logging.Logger;
import ui.welcome.splash.SplashScreen;

/**
 * 
 * @author Bhuwan Upadhyay
 */
public class BusinessManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            new SplashScreen().setSplash();
        } catch (InterruptedException ex) {
            Logger.getLogger(BusinessManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
