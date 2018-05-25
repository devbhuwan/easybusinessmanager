package ui.company;

import dbutils.CreateConnectionAccess;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ui.main.MainFrame;

/**
 *
 * @author Bhuwan
 */
public class CompanyDBUtils {

    private final Connection buzCompConn;
    private PreparedStatement ps;
    private ResultSet rs;
    private final MainFrame mainFrame;
    private Connection conn;
    private final String defaultGroupName[] = {
        "Advance Income",
        "Appreciation",
        "Bank Accounts",
        "Bank O/D Account",
        "Capital Account",
        "Cash in hand",
        "Current Assets",
        "Current Liabilities",
        "Depreciation",
        "Drawing",
        "Duties & Taxes",
        "Expenses(Direct)",
        "Expenses(Indirect)",
        "Fixed Assets",
        "Income(Direct)",
        "Income(Indirect)",
        "Interest on Capital",
        "Investments",
        "Loan",
        "Loans & Advances",
        "Purchase",
        "Provision for Doubtful Debts",
        "Provisions/Expenses Payable",
        "Outstanding Expenses",
        "Reserves & Surplus",
        "Revenue",
        "Sale",
        "Secured Loans",
        "Security & Deposits(Assets)",
        "Sundry Creditors",
        "Sundry Debtors",
        "Suspense Account",
        "Unsecured Loans"
    };

    private final String primaryNature[] = {
        null,
        null,
        null,
        null,
        "Y",
        null,
        "Y",
        "Y",
        null,
        "Y",
        null,
        null,
        null,
        "Y",
        null,
        null,
        null,
        "Y",
        "Y",
        null,
        null,
        null,
        null,
        null,
        null,
        "Y",
        null,
        null,
        null,
        null,
        null,
        "Y",
        null
    };

    private final String underGroup[] = {
        "Current Liabilities",
        "Income(Indirect)",
        "Current Assets",
        "Loan",
        null,
        "Current Assets",
        null,
        null,
        "Expenses(Indirect)",
        null,
        "Expenses(Direct)",
        "Revenue",
        "Revenue",
        null,
        "Revenue",
        "Revenue",
        null,
        null,
        null,
        "Current Assets",
        "Revenue",
        "Expenses(Indirect)",
        "Current Liabilities",
        "Current Liabilities",
        "Capital Account",
        null,
        "Revenue",
        "Loan",
        "Current Assets",
        "Current Liabilities",
        "Current Assets",
        null,
        "Loan"
    };

    public CompanyDBUtils(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.buzCompConn = mainFrame.getConnection5();

    }

    public boolean saveCompanyInformation(CompanyDetail cDetail, ContactPersonDetail cpDetail, SecurityDetail sDetail) {
        boolean check = false;
        String companyCode = getCompanyCode();
        String query = "insert into COMPANY_INFO values (?,?,?)";
        String envDirectory = System.getenv("ProgramFiles");
        Path path = FileSystems.getDefault().getPath(envDirectory + "/Business Manager/db_log/" + companyCode + "/");
        Path pathForCompanyDB = FileSystems.getDefault().getPath(envDirectory + "/Business Manager/db_log/" + companyCode + "/", "buzmgrdb.accdb");
        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
            } catch (IOException ex) {
                Logger.getLogger(CompanyDBUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                Files.deleteIfExists(pathForCompanyDB);
            } catch (IOException ex) {
                Logger.getLogger(CompanyDBUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Path copy_from = Paths.get(envDirectory + "/Business Manager/db_log/", "buzmgrdb.accdb");
        Path copy_to = Paths.get(envDirectory + "/Business Manager/db_log/" + companyCode + "/", copy_from.getFileName().toString());
        try {
            Files.copy(copy_from, copy_to, REPLACE_EXISTING, COPY_ATTRIBUTES, NOFOLLOW_LINKS);
        } catch (IOException e) {
            System.err.println(e);
        }
        if (Files.exists(copy_to)) {
            try {
                buzCompConn.setAutoCommit(false);
                ps = buzCompConn.prepareStatement(query);
                ps.setString(1, companyCode);
                ps.setString(2, cDetail.getCName());
                ps.setString(3, copy_to.toAbsolutePath().toString());
                ps.executeUpdate();
                buzCompConn.commit();
                check = true;
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            if (check) {
                String sql = "insert into COMPANY_DETAIL values (?, ?, ? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?)";
                try {
                    conn = new CreateConnectionAccess().getConnection(copy_to.toAbsolutePath().toString());
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, companyCode);
                    ps.setString(2, cDetail.getCName());
                    ps.setString(3, cDetail.getAddress());
                    ps.setString(4, cDetail.getPhoneNumber());
                    ps.setString(5, cDetail.getFaxNumber());
                    ps.setString(6, cDetail.getEmail());
                    ps.setString(7, cDetail.getWebsite());
                    ps.setTimestamp(8, cDetail.getFinancialDate());
                    ps.setTimestamp(9, cDetail.getBookBeginDate());
                    ps.setString(10, cDetail.getBusinessType());
                    ps.setBinaryStream(11, cDetail.getLogoFileStream(), cDetail.getLength());
                    ps.setString(12, cpDetail.getCName());
                    ps.setString(13, cpDetail.getAddress());
                    ps.setString(14, cpDetail.getPhoneNumber());
                    ps.setString(15, cpDetail.getFaxNumber());
                    ps.setString(16, cpDetail.getEmail());
                    ps.setString(17, cpDetail.getWebsite());
                    ps.setString(18, cpDetail.getRole());
                    ps.setBinaryStream(19, cpDetail.getCPPhotoStream(), cpDetail.getLength());
                    ps.setString(20, sDetail.getUserCode());
                    ps.setString(21, sDetail.getPasswords());
                    ps.executeUpdate();
                    check = true;
                } catch (SQLException ex) {
                    check = false;
                    ex.printStackTrace();
                }

            }
            if (check) {
                String sql = "insert into ACCOUNT_GROUP_DETAIL values(?,?,?,?,?)";
                for (int i = 0; i < 33; i++) {
                    try {
                        conn.setAutoCommit(false);
                        ps = conn.prepareStatement(sql);
                        ps.setString(1, getGroupName(i));
                        ps.setString(2, getPrimaryNature(i));
                        ps.setString(3, getUnderGroup(i));
                        ps.setString(4, null);
                        ps.setString(5, companyCode);
                        ps.executeUpdate();
                        conn.commit();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        return check;
    }

    private String getCompanyCode() {
        ArrayList<String> companyCodes = new ArrayList<>();
        String code;
        String sql = "select companyCode from COMPANY_INFO";
        int count = 1;
        try {
            buzCompConn.setAutoCommit(false);
            ps = buzCompConn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                companyCodes.add(rs.getString("companyCode"));
                count++;
            }
            buzCompConn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        while(true) {
            if (count < 10) {
                code = "Comp000" + count;
            } else if (count < 100) {
                code = "Comp00" + count;
            } else if (count < 1000) {
                code = "Comp0" + count;
            } else {
                code = "Comp" + count;
            }
            if(!companyCodes.contains(code)) {
               break;
            } else {
                count++;
            }
        }
        return code;
    }

    private String getGroupName(int i) {
        return defaultGroupName[i];
    }

    private String getPrimaryNature(int i) {
        return primaryNature[i];
    }

    private String getUnderGroup(int i) {
        return underGroup[i];
    }

    boolean updateCompanyInformation(CompanyDetail cDetail, ContactPersonDetail cpDetail, SecurityDetail sDetail, String companyCode, Connection con) {
        boolean status = false;
        String sql = "UPDATE COMPANY_DETAIL SET companyName = ?, companyAddress = ?, companyPhNo = ? , companyFaxNo = ?,companyEmail = ?, companyWebsite = ?, financialYearFrom = ?, booksBeginDate = ?, businessType = ?, companyLogo = ?, cpName = ?,cpAddress = ?,cpPhoneNo = ?, cpFaxNo = ?, cpEmail = ?,cpWebsite = ?, cpRole = ?, cpPhoto = ?, userCode = ? ,password = ? where companyCode = ?";
        try {
            con.setAutoCommit(false);
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, cDetail.getCName());
            p.setString(2, cDetail.getAddress());
            p.setString(3, cDetail.getPhoneNumber());
            p.setString(4, cDetail.getFaxNumber());
            p.setString(5, cDetail.getEmail());
            p.setString(6, cDetail.getWebsite());
            p.setTimestamp(7, cDetail.getFinancialDate());
            p.setTimestamp(8, cDetail.getBookBeginDate());
            p.setString(9, cDetail.getBusinessType());
            p.setBinaryStream(10, cDetail.getLogoFileStream(), cDetail.getLength());
            p.setString(11, cpDetail.getCName());
            p.setString(12, cpDetail.getAddress());
            p.setString(13, cpDetail.getPhoneNumber());
            p.setString(14, cpDetail.getFaxNumber());
            p.setString(15, cpDetail.getEmail());
            p.setString(16, cpDetail.getWebsite());
            p.setString(17, cpDetail.getRole());
            p.setBinaryStream(18, cpDetail.getCPPhotoStream(), cpDetail.getLength());
            p.setString(19, sDetail.getUserCode());
            p.setString(20, sDetail.getPasswords());
            p.setString(21, companyCode);
            p.executeUpdate();
            con.commit();
            status = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return status;
    }

}
