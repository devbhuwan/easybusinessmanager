package dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Bhuwan Upadhyay
 * @version 1.0.0
 */
public class CreateConnectionAccess {

    String username = null;
    String password = null;
    String jdbcUrl = null;
    Connection conn = null;

    public Connection getConnection(String dbDir) {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.jdbcUrl = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + dbDir + ";PWD=18190430!buzmgr#1.0;";
        try {
            conn = DriverManager.getConnection(jdbcUrl);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database is not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
    }

}
