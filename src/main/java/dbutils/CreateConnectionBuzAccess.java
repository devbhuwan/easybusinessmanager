package dbutils;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Bhuwan Upadhyay
 * @version 1.0.0
 */
public class CreateConnectionBuzAccess {

    String username = null;
    String password = null;
    String jdbcUrl = null;
    Connection conn = null;
    private String dbDir;

    public Connection getConnection() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        String envDirectory = System.getenv("ProgramFiles");
        System.out.println(envDirectory);
        Path path = FileSystems.getDefault().getPath(envDirectory + "/Business Manager/db_log/", "buzcompdetail.accdb");
        if (Files.exists(path)) {
            dbDir = path.toAbsolutePath().toString();
            this.jdbcUrl = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + dbDir + ";PWD=18190430!buzmgr#1.0;";
            try {
                conn = DriverManager.getConnection(jdbcUrl);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            System.out.println("jjj");
        }
        if(conn == null) {
            System.out.println("null");
        }
        return conn;
    }

}
