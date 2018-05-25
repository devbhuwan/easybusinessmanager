/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */
package ui.reports;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.YearMonthDay;
import ui.main.MainFrame;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class ReportUtils {

    public ReportUtils() {
    }

    public Date getCompanyBeginnigDate(Connection conn, String companyCode) {
        Date temp = Calendar.getInstance().getTime();
        String sql = "select financialYearFrom from COMPANY_DETAIL where companyCode = ?";
        try {
            conn.setAutoCommit(false);
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, companyCode);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                temp = r.getDate("financialYearFrom");
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ReportUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public String getGroupName(MainFrame mainFrame, String accountNumber, String companyCode) {
        String groupName = null;
        String sql = "SELECT groupName FROM ACCOUNT_DETAIL where companyCode = ? AND accountNumber = ?";
        try {
            Connection conn = mainFrame.getConnection4();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, accountNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                groupName = rs.getString("groupName");
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return groupName;
    }

    public ArrayList<String> getAccountGroups(MainFrame mainFrame, String companyCode, String requiredGroup) {
        ArrayList<String> groups = new ArrayList<>();
        String sql = "SELECT groupName FROM ACCOUNT_GROUP_DETAIL where companyCode = ?";
        try {
            Connection conn = mainFrame.getConnection4();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String groupName = rs.getString("groupName");
                if (checkPredefinedGroupOrNot(groupName)) {
                    if (checkWithRequiredGroupOrNot(groupName, requiredGroup)) {
                        groups.add(groupName);
                    }
                } else {
                    String underGroup = getUnderGroup(mainFrame, companyCode, groupName);
                    while (true) {
                        try {
                            if (checkPredefinedGroupOrNot(underGroup)) {
                                if (checkWithRequiredGroupOrNot(underGroup, requiredGroup)) {
                                    groups.add(groupName);
                                    break;
                                }
                                break;
                            } else {
                                underGroup = getUnderGroup(mainFrame, companyCode, underGroup);
                            }
                        } catch (NullPointerException ex) {
                            break;
                        }
                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return groups;
    }

    public ArrayList<String> getAccountGroups(MainFrame mainFrame, String companyCode, ArrayList<String> forGroup) {
        ArrayList<String> groups = new ArrayList<>();
        String sql = "SELECT groupName FROM ACCOUNT_GROUP_DETAIL where companyCode = ?";
        try {
            Connection conn = mainFrame.getConnection4();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String groupName = rs.getString("groupName");
                if (checkPredefinedGroupOrNot(groupName)) {
                    if (forGroup.contains(groupName)) {
                        groups.add(groupName);
                    }
                } else {
                    String underGroup = getUnderGroup(mainFrame, companyCode, groupName);
                    while (true) {
                        try {
                            if (checkPredefinedGroupOrNot(underGroup)) {
                                if (forGroup.contains(underGroup)) {
                                    groups.add(groupName);
                                    break;
                                }
                                break;
                            } else {
                                underGroup = getUnderGroup(mainFrame, companyCode, underGroup);
                            }
                        } catch (NullPointerException ex) {
                            break;
                        }
                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return groups;
    }

    public boolean checkPredefinedGroupOrNot(String groupName) {
        if (groupName != null) {
            return groupName.equalsIgnoreCase("Advance Income")
                    || groupName.equalsIgnoreCase("Appreciation")
                    || groupName.equalsIgnoreCase("Bank Accounts")
                    || groupName.equalsIgnoreCase("Bank O/D Account")
                    || groupName.equalsIgnoreCase("Capital Account")
                    || groupName.equalsIgnoreCase("Cash in hand")
                    || groupName.equalsIgnoreCase("Current Assets")
                    || groupName.equalsIgnoreCase("Current Liabilities")
                    || groupName.equalsIgnoreCase("Depreciation")
                    || groupName.equalsIgnoreCase("Drawing")
                    || groupName.equalsIgnoreCase("Duties & Taxes")
                    || groupName.equalsIgnoreCase("Expenses(Direct)")
                    || groupName.equalsIgnoreCase("Expenses(Indirect)")
                    || groupName.equalsIgnoreCase("Fixed Assets")
                    || groupName.equalsIgnoreCase("Income(Direct)")
                    || groupName.equalsIgnoreCase("Income(Indirect)")
                    || groupName.equalsIgnoreCase("Interest on Capital")
                    || groupName.equalsIgnoreCase("Investments")
                    || groupName.equalsIgnoreCase("Loan")
                    || groupName.equalsIgnoreCase("Loans & Advances")
                    || groupName.equalsIgnoreCase("Purchase")
                    || groupName.equalsIgnoreCase("Provision for Doubtful Debts")
                    || groupName.equalsIgnoreCase("Provisions/Expenses Payable")
                    || groupName.equalsIgnoreCase("Outstanding Expenses")
                    || groupName.equalsIgnoreCase("Reserves & Surplus")
                    || groupName.equalsIgnoreCase("Revenue")
                    || groupName.equalsIgnoreCase("Sale")
                    || groupName.equalsIgnoreCase("Secured Loans")
                    || groupName.equalsIgnoreCase("Security & Deposits(Assets)")
                    || groupName.equalsIgnoreCase("Sundry Creditors")
                    || groupName.equalsIgnoreCase("Sundry Debtors")
                    || groupName.equalsIgnoreCase("Suspense Account")
                    || groupName.equalsIgnoreCase("Unsecured Loans");
        } else {
            return false;
        }
    }

    private boolean checkWithRequiredGroupOrNot(String groupName, String requiredGroup) {
        try {
            return groupName.equalsIgnoreCase(requiredGroup);
        } catch (NullPointerException ex) {
            return false;
        }

    }

    private String getUnderGroup(MainFrame mainFrame, String companyCode, String gN) {
        String groupName = null;
        String sql = "SELECT underGroup FROM ACCOUNT_GROUP_DETAIL where companyCode = ? AND groupName = ?";
        try {
            Connection conn = mainFrame.getConnection3();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, gN);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                groupName = rs.getString("underGroup");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return groupName;
    }

    public double getRateForUnit(String itemCode, String unitName, MainFrame mainFrame, String companyCode) {
        double rate = 1.0;
        String sql = "SELECT purchasePrice FROM ITEM_DETAIL where itemCode = ? AND companyCode = ?";
        String sqlU = "SELECT unitName FROM UNIT_DETAIL where unitType = ? AND companyCode = ?";
        ArrayList<String> primaryUnit = new ArrayList<>();
        try {
            Connection conn = mainFrame.getConnection2();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sqlU);
            ps.setString(1, "Single");
            ps.setString(2, companyCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                primaryUnit.add(rs.getString("unitName"));
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            Connection conn = mainFrame.getConnection2();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, itemCode);
            ps.setString(2, companyCode);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String purchasePrice = rs.getString("purchasePrice");
                if (primaryUnit.contains(unitName)) {
                    try {
                        rate = rate * Double.valueOf(purchasePrice);
                    } catch (NullPointerException | NumberFormatException ex) {
                    }
                } else {
                    String underUnit = getUnderUnit(unitName, mainFrame, companyCode);
                    rate = rate * getUnitConversionRate(unitName, mainFrame, companyCode);
                    while (true) {
                        try {
                            if (primaryUnit.contains(underUnit)) {
                                break;
                            } else {
                                underUnit = getUnderUnit(unitName, mainFrame, companyCode);
                                rate = rate * getUnitConversionRate(unitName, mainFrame, companyCode);
                            }
                        } catch (NullPointerException ex) {
                            break;
                        }

                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rate;
    }

    private String getUnderUnit(String unitName, MainFrame mainFrame, String companyCode) {
        String underUnit = null;
        String sql = "SELECT primaryUnit FROM UNIT_DETAIL where unitName = ? AND companyCode = ?";
        try {
            Connection conn = mainFrame.getConnection2();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, unitName);
            ps.setString(2, companyCode);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                underUnit = rs.getString("primaryUnit");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return underUnit;
    }

    private double getUnitConversionRate(String unitName, MainFrame mainFrame, String companyCode) {
        double rate = 1.0;
        String sql = "SELECT perUnit FROM UNIT DETAIL where unitName = ? AND companyCode = ?";
        try {
            Connection conn = mainFrame.getConnection2();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, unitName);
            ps.setString(2, companyCode);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                try {
                    rate = Double.valueOf(rs.getString("perUnit"));
                } catch (NullPointerException | NumberFormatException ex) {
                }

            }
        } catch (SQLException ex) {
        }
        return rate;

    }

    public String getAccountName(String accNo, String companyCode, MainFrame mainFrame) {
        String sql = "select accountName from ACCOUNT_DETAIL where companyCode = ? AND accountNumber = ?";
        String custName = null;
        try {
            Connection conn = mainFrame.getConnection4();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, accNo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                custName = rs.getString("accountName");
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ReportUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return custName;
    }

    public ArrayList<String> getAccountNumber(String companyCode, String primarG, MainFrame mainFrame) {
        ArrayList<String> accNos = new ArrayList<>();
        ArrayList<String> accGs = getAccountGroups(mainFrame, companyCode, primarG);
        String sql = "select accountNumber,groupName from ACCOUNT_DETAIL where companyCode = ?";
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String aNu = rs.getString("accountNumber");
                if (accGs.contains(rs.getString("groupName"))) {
                    accNos.add(aNu);
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ReportUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accNos;
    }

    public String getItemName(String iC, String companyCode, MainFrame mainFrame) {
        String iN = null;
        String sql = "Select itemName from ITEM_DETAIl where companyCode = ? AND itemCode = ?";
        try {
            Connection conn = mainFrame.getConnection4();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, iC);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                iN = rs.getString("itemName");
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return iN;
    }

    public ArrayList<String> getStoreName(String companyCode, MainFrame mainFrame) {
        String sql = "select storeName from STORE_DETAIL where companyCode = ? AND storeName is not null";
        ArrayList<String> storeName = new ArrayList<>();
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                storeName.add(rs.getString("storeName"));
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ReportUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return storeName;
    }

    public ArrayList<String> getAllItems(String companyCode, MainFrame mainFrame, ArrayList<String> selectedStore) {
        String sql = "select itemCode,storeName from ITEM_DETAIL where companyCode = ?";
        ArrayList<String> itemCode = new ArrayList<>();
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String ic = rs.getString("itemCode");
                if (selectedStore.contains(rs.getString("storeName"))) {
                    itemCode.add(ic);
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ReportUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemCode;
    }

    public ArrayList<String> getVoucherNumberList(String sqlV, MainFrame mainFrame, String companyCode) {
        ArrayList<String> vN = new ArrayList<>();
        try {
            Connection conn = mainFrame.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sqlV);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                vN.add(rs.getString("voucherNumber"));
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vN;
    }

    public String getUnitName(String ic, String companyCode, MainFrame mainFrame) {
        String iN = null;
        String sql = "Select unitName from ITEM_DETAIl where companyCode = ? AND itemCode = ?";
        try {
            Connection conn = mainFrame.getConnectionExtra();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, ic);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                iN = rs.getString("unitName");
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return iN;
    }

    public double getConvertedQuantity(String unitName, String qty, String companyCode, MainFrame mainFrame) {
        System.out.println(unitName);
        double rate = 1.0;
        String sql = "SELECT perUnit FROM UNIT_DETAIL where unitName = ? AND companyCode = ?";
        String sqlU = "SELECT unitName FROM UNIT_DETAIL where unitType = ? AND companyCode = ?";
        ArrayList<String> primaryUnit = new ArrayList<>();
        try {
            Connection conn = mainFrame.getConnection2();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sqlU);
            ps.setString(1, "Single");
            ps.setString(2, companyCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                primaryUnit.add(rs.getString("unitName"));
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            Connection conn = mainFrame.getConnection4();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, unitName);
            ps.setString(2, companyCode);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String perUnit = rs.getString("perUnit");
                String underUnit = getUnderUnit(unitName, mainFrame, companyCode);
                if (primaryUnit.contains(underUnit)) {
                    rate = rate * Double.valueOf(perUnit);
                } else {
                    rate = rate * Double.valueOf(perUnit);
                    underUnit = getUnderUnit(underUnit, mainFrame, companyCode);
                    while (true) {
                        try {
                            if (primaryUnit.contains(underUnit)) {
                                break;
                            } else {
                                underUnit = getUnderUnit(underUnit, mainFrame, companyCode);
                                rate = rate * getUnitConversionRate(underUnit, mainFrame, companyCode);
                            }
                        } catch (NullPointerException ex) {
                            break;
                        }
                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            return rate * Double.valueOf(qty);
        } catch (NullPointerException | NumberFormatException ex) {
            return 0.0;
        }

    }

    public double getConvertedRate(String unitName, String companyCode, MainFrame mainFrame) {
        double rate = 1.0;
        String sql = "SELECT perUnit FROM UNIT_DETAIL where unitName = ? AND companyCode = ?";
        String sqlU = "SELECT unitName FROM UNIT_DETAIL where unitType = ? AND companyCode = ?";
        ArrayList<String> primaryUnit = new ArrayList<>();
        try {
            Connection conn = mainFrame.getConnection2();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sqlU);
            ps.setString(1, "Single");
            ps.setString(2, companyCode);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                primaryUnit.add(rs.getString("unitName"));
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            Connection conn = mainFrame.getConnection4();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, unitName);
            ps.setString(2, companyCode);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String perUnit = rs.getString("perUnit");
                String underUnit = getUnderUnit(unitName, mainFrame, companyCode);
                if (primaryUnit.contains(underUnit)) {
                    rate = rate * Double.valueOf(perUnit);
                } else {
                    rate = rate * Double.valueOf(perUnit);
                    underUnit = getUnderUnit(underUnit, mainFrame, companyCode);
                    while (true) {
                        try {
                            if (primaryUnit.contains(underUnit)) {
                                break;
                            } else {
                                underUnit = getUnderUnit(underUnit, mainFrame, companyCode);
                                rate = rate * getUnitConversionRate(underUnit, mainFrame, companyCode);
                            }
                        } catch (NullPointerException ex) {
                            break;
                        }
                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        try {
            return rate;
        } catch (NullPointerException | NumberFormatException ex) {
            return 0.0;
        }

    }

    public boolean checkDateIsValid(Date date, Calendar cal, Calendar cal1) {
        YearMonthDay dateYMD = YearMonthDay.fromDateFields(date);
        YearMonthDay calYMD = YearMonthDay.fromCalendarFields(cal);
        YearMonthDay cal1YMD = YearMonthDay.fromCalendarFields(cal1);
        return (dateYMD.isAfter(calYMD) && dateYMD.isBefore(cal1YMD)) || dateYMD.equals(cal1YMD) || dateYMD.equals(calYMD);
    }

    public ArrayList<String> getItemList(MainFrame mainFrame, String companyCode) {
        ArrayList<String> iN = new ArrayList<>();
        String sql = "Select itemCode from ITEM_DETAIl where companyCode = ?";
        try {
            Connection conn = mainFrame.getConnection4();
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                iN.add(rs.getString("itemCode"));
            }
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return iN;
    }

}
