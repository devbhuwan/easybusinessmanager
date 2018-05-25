package ui.voucher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import ui.main.MainFrame;

/**
 *
 * @author Bhuwan Prasad Upadhyay
 */
public class FetchVoucherData {

    private PreparedStatement ps;
    private ResultSet rs;
    private MainFrame mainFrame;

    public String getAccountName(String accNo, String companyCode, Connection conn) {
        String sql = "select accountName from ACCOUNT_DETAIL where companyCode = ? AND accountNumber = ?";
        String custName = null;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, accNo);
            rs = ps.executeQuery();
            if (rs.next()) {
                custName = rs.getString("accountName");
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return custName;
    }

    public String getAccountNo(String selectedItem, String companyCode, Connection conn) {
        String sql = "select accountNumber from ACCOUNT_DETAIL where companyCode = ? AND accountName = ?";
        String custName = null;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, selectedItem);
            rs = ps.executeQuery();
            if (rs.next()) {
                custName = rs.getString("accountNumber");
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }

        return custName;
    }

    public String getNextSaleOrderVoucherNo(String companyCode, Connection conn) {
        String sql = "select voucherNumber from SALE_ORDER_DETAIL where companyCode = ?";
        int count = 0;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(++count);

    }

    public void fetchAccountNoPurchase(MainFrame mainFrame, JComboBox cb, String companyCode, Connection conn) {
        this.mainFrame = mainFrame;
        Object selectedNo = cb.getSelectedItem();
        cb.removeAllItems();
        String sql = "select accountNumber,groupName from ACCOUNT_DETAIL where companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                String accountNumber = rs.getString("accountNumber");
                String groupName = rs.getString("groupName");
                if (checkPredefinedGroupOrNot(groupName)) {
                    if (checkPurchaseAccountGroupNature(groupName)) {
                        cb.addItem(accountNumber);
                    }
                } else {
                    int count = 0;
                    String underGroup = getUnderGroupName(groupName, companyCode);
                    for (;;) {
                        count++;
                        if (checkPredefinedGroupOrNot(underGroup)) {
                            if (checkPurchaseAccountGroupNature(underGroup)) {
                                cb.addItem(accountNumber);
                                break;
                            }
                        } else {
                            underGroup = getUnderGroupName(underGroup, companyCode);
                        }
                        if (count > 20) {
                            break;
                        }
                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        cb.setSelectedItem(selectedNo);
    }

    public String getNextPurchaseOrderVoucherNo(String companyCode, Connection conn) {
        String sql = "select voucherNumber from PURCHASE_ORDER_DETAIL where companyCode = ?";
        int count = 0;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(++count);
    }

    public String getVendorName(Object selectedItem, String companyCode, Connection conn) {
        String sql = "select accountName from ACCOUNT_DETAIL where companyCode = ? AND accountNumber = ?";
        String venName = null;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, selectedItem.toString());
            rs = ps.executeQuery();
            if (rs.next()) {
                venName = rs.getString("accountName");
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return venName;
    }

    public String getNextSaleRegisterVoucherNo(String companyCode, Connection conn) {
        String sql = "select voucherNumber from SALE_REGISTER_DETAIL where companyCode = ?";
        int count = 0;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(++count);
    }

    public String getNextSaleReturnVoucherNo(String companyCode, Connection conn) {
        String sql = "select voucherNumber from SALE_RETURN_DETAIL where companyCode = ?";
        int count = 0;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(++count);
    }

    public String getNextPurchaseRegisterVoucherNo(String companyCode, Connection conn) {
        String sql = "select voucherNumber from PURCHASE_REGISTER_DETAIL where companyCode = ?";
        int count = 0;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(++count);
    }

    public String getNextPurchaseReturnVoucherNo(String companyCode, Connection conn) {
        String sql = "select voucherNumber from PURCHASE_RETURN_DETAIL where companyCode = ?";
        int count = 0;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(++count);
    }

    public String getNextPaymentVoucherNo(String companyCode, Connection conn) {
        String sql = "select voucherNumber from PAYMENT_VOUCHER_DETAIL where companyCode = ?";
        int count = 0;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(++count);
    }

    public String getNextReceiptVoucherNo(String companyCode, Connection conn) {
        String sql = "select voucherNumber from RECEIPT_VOUCHER_DETAIL where companyCode = ?";
        int count = 0;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(++count);
    }

    public String getNextJournalVoucherNo(String companyCode, Connection conn) {
        String sql = "select voucherNumber from JOURNAL_VOUCHER_DETAIL where companyCode = ?";
        int count = 0;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(++count);
    }

    public String getNextDebitNoteNo(String companyCode, Connection conn) {
        String sql = "select voucherNumber from DEBIT_NOTE_DETAIL where companyCode = ?";
        int count = 0;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(++count);
    }

    public String getNextCreditNoteNo(String companyCode, Connection conn) {
        String sql = "select voucherNumber from CREDIT_NOTE_DETAIL where companyCode = ?";
        int count = 0;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(++count);
    }

    public String getNextProductionVoucherVoucherNo(String companyCode, Connection conn) {
        String sql = "select voucherNumber from PRODUCTION_VOUCHER_DETAIL where companyCode = ?";
        int count = 0;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(++count);
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

    private String getUnderGroupName(String groupName, String companyCode) {
        String underGroupName = null;
        String query = "select underGroup from ACCOUNT_GROUP_DETAIL where groupName = ? AND companyCode = ?";
        Connection connn = mainFrame.getConnection2();
        try {
            connn.setAutoCommit(false);
            PreparedStatement ps1 = connn.prepareStatement(query);
            ps1.setString(1, groupName);
            ps1.setString(2, companyCode);
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next()) {
                underGroupName = rs1.getString("underGroup");
            }
            connn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return underGroupName;
    }

    private boolean checkSaleGroupNature(String groupName) {
        boolean status = false;
        if (groupName != null) {
            if (groupName.equalsIgnoreCase("Sundry Creditors") || groupName.equalsIgnoreCase("Sundry Debtors") || groupName.equalsIgnoreCase("Sale") || groupName.equalsIgnoreCase("Purchase")) {
                status = true;
            }
        }
        return status;
    }

    private boolean checkPurchaseAccountGroupNature(String groupName) {
        boolean status = false;
        if (groupName != null) {
            if (groupName.equalsIgnoreCase("Sundry Creditors") || groupName.equalsIgnoreCase("Sundry Debtors") || groupName.equalsIgnoreCase("Purchase") || groupName.equalsIgnoreCase("Sale")) {
                status = true;
            }
        }
        return status;
    }

    public String getItemName(String itemCode, String companyCode, Connection conn) {
        String query = "select itemName from ITEM_DETAIL where itemCode = ? AND companyCode = ?";
        String itemName = null;
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps1 = conn.prepareStatement(query);
            ps1.setString(1, itemCode);
            ps1.setString(2, companyCode);
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next()) {
                itemName = rs1.getString("itemName");
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return itemName;
    }

    public String getStoreName(String itemCode, String companyCode, Connection conn) {
        String query = "select storeName from ITEM_DETAIL where itemCode = ? AND companyCode = ?";
        String storeName = null;
        try {
            conn.setAutoCommit(false);
            PreparedStatement ps1 = conn.prepareStatement(query);
            ps1.setString(1, itemCode);
            ps1.setString(2, companyCode);
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next()) {
                storeName = rs1.getString("storeName");
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return storeName;
    }

    public void fetchCashAccNo(MainFrame mainFrame, JComboBox cb, String companyCode, Connection conn) {
        this.mainFrame = mainFrame;
        Object selectedNo = cb.getSelectedItem();
        cb.removeAllItems();
        String sql = "select accountNumber,groupName from ACCOUNT_DETAIL where companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                String accountNumber = rs.getString("accountNumber");
                String groupName = rs.getString("groupName");
                if (checkPredefinedGroupOrNot(groupName)) {
                    if (checkCashInGroupNature(groupName)) {
                        cb.addItem(accountNumber);
                    }
                } else {
                    int count = 0;
                    String underGroup = getUnderGroupName(groupName, companyCode);
                    for (;;) {
                        count++;
                        if (checkPredefinedGroupOrNot(underGroup)) {
                            if (checkCashInGroupNature(underGroup)) {
                                cb.addItem(accountNumber);
                                break;
                            }
                        } else {
                            underGroup = getUnderGroupName(underGroup, companyCode);
                        }
                        if (count > 20) {
                            break;
                        }
                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        cb.setSelectedItem(selectedNo);
    }

    private boolean checkCashInGroupNature(String groupName) {
        boolean status = false;
        if (groupName != null) {
            if (groupName.equalsIgnoreCase("Cash in hand")) {
                status = true;
            }
        }
        return status;
    }

    public void fetchBankAccNo(MainFrame mainFrame, JComboBox cb, String companyCode, Connection conn) {
        this.mainFrame = mainFrame;
        Object selectedNo = cb.getSelectedItem();
        cb.removeAllItems();
        String sql = "select accountNumber,groupName from ACCOUNT_DETAIL where companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                String accountNumber = rs.getString("accountNumber");
                String groupName = rs.getString("groupName");
                if (checkPredefinedGroupOrNot(groupName)) {
                    if (checkBankInGroupNature(groupName)) {
                        cb.addItem(accountNumber);
                    }
                } else {
                    int count = 0;
                    String underGroup = getUnderGroupName(groupName, companyCode);
                    for (;;) {
                        count++;
                        if (checkPredefinedGroupOrNot(underGroup)) {
                            if (checkBankInGroupNature(underGroup)) {
                                cb.addItem(accountNumber);
                                break;
                            }
                        } else {
                            underGroup = getUnderGroupName(underGroup, companyCode);
                        }
                        if (count > 20) {
                            break;
                        }
                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        cb.setSelectedItem(selectedNo);
    }

    private boolean checkBankInGroupNature(String groupName) {
        boolean status = false;
        if (groupName != null) {
            if (groupName.equalsIgnoreCase("Bank Accounts")) {
                status = true;
            }
        }
        return status;
    }

    public String getAccountGroupName(String companyCode, String accountNumber, Connection conn) {
        String sql = "select groupName from ACCOUNT_DETAIL where accountNumber = ? and companyCode = ?";
        String accountG = null;
        try {
            conn.setAutoCommit(false);
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, accountNumber);
            p.setString(2, companyCode);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                accountG = r.getString("groupName");
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accountG;
    }

    public boolean checkBankAccountGroup(String aGD, Connection conn, String companyCode) {
        boolean status = false;
        String sql = "select groupName from ACCOUNT_GROUP_DETAIL where companyCode = ? and groupName = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, aGD);
            rs = ps.executeQuery();
            if (rs.next()) {
                String groupName = rs.getString("groupName");
                if (checkPredefinedGroupOrNot(groupName)) {
                    if (checkBankAccountGroupNature(groupName)) {
                        status = true;
                    }
                } else {
                    int count = 0;
                    String underGroup = getUnderGroupName(groupName, companyCode);
                    for (;;) {
                        count++;
                        if (checkPredefinedGroupOrNot(underGroup)) {
                            if (checkBankAccountGroupNature(underGroup)) {
                                status = true;
                                break;
                            }
                        } else {
                            underGroup = getUnderGroupName(underGroup, companyCode);
                        }
                        if (count > 20) {
                            break;
                        }
                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    private boolean checkBankAccountGroupNature(String groupName) {
        boolean status = false;
        if (groupName != null) {
            if (groupName.equalsIgnoreCase("Bank Accounts")) {
                status = true;
            }
        }
        return status;
    }

    public boolean checkCashAccountGroup(String aGD, Connection conn, String companyCode) {
        boolean status = false;
        String sql = "select groupName from ACCOUNT_GROUP_DETAIL where companyCode = ? and groupName = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            ps.setString(2, aGD);
            rs = ps.executeQuery();
            if (rs.next()) {
                String groupName = rs.getString("groupName");
                if (checkPredefinedGroupOrNot(groupName)) {
                    if (checkCashInGroupNature(groupName)) {
                        status = true;
                    }
                } else {
                    int count = 0;
                    String underGroup = getUnderGroupName(groupName, companyCode);
                    for (;;) {
                        count++;
                        if (checkPredefinedGroupOrNot(underGroup)) {
                            if (checkCashInGroupNature(underGroup)) {
                                status = true;
                                break;
                            }
                        } else {
                            underGroup = getUnderGroupName(underGroup, companyCode);
                        }
                        if (count > 20) {
                            break;
                        }
                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    public void fetchAccountNoSale(MainFrame mainFrame, JComboBox cb, String companyCode, Connection conn) {
        this.mainFrame = mainFrame;
        Object selectedNo = cb.getSelectedItem();
        cb.removeAllItems();
        String sql = "select accountNumber,groupName from ACCOUNT_DETAIL where companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                String accountNumber = rs.getString("accountNumber");
                String groupName = rs.getString("groupName");
                if (checkPredefinedGroupOrNot(groupName)) {
                    if (checkSaleGroupNature(groupName)) {
                        cb.addItem(accountNumber);
                    }
                } else {
                    int count = 0;
                    String underGroup = getUnderGroupName(groupName, companyCode);
                    for (;;) {
                        count++;
                        if (checkPredefinedGroupOrNot(underGroup)) {
                            if (checkSaleGroupNature(underGroup)) {
                                cb.addItem(accountNumber);
                                break;
                            }
                        } else {
                            underGroup = getUnderGroupName(underGroup, companyCode);
                        }
                        if (count > 20) {
                            break;
                        }
                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        cb.setSelectedItem(selectedNo);
    }

    public void fetchAccountNameSale(MainFrame mainFrame, JComboBox cb, String companyCode, Connection conn) {
        this.mainFrame = mainFrame;
        Object selectedNo = cb.getSelectedItem();
        cb.removeAllItems();
        String sql = "select accountName,groupName from ACCOUNT_DETAIL where companyCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                String accountNumber = rs.getString("accountName");
                String groupName = rs.getString("groupName");
                if (checkPredefinedGroupOrNot(groupName)) {
                    if (checkSaleGroupNature(groupName)) {
                        cb.addItem(accountNumber);
                    }
                } else {
                    int count = 0;
                    String underGroup = getUnderGroupName(groupName, companyCode);
                    for (;;) {
                        count++;
                        if (checkPredefinedGroupOrNot(underGroup)) {
                            if (checkSaleGroupNature(underGroup)) {
                                cb.addItem(accountNumber);
                                break;
                            }
                        } else {
                            underGroup = getUnderGroupName(underGroup, companyCode);
                        }
                        if (count > 20) {
                            break;
                        }
                    }
                }
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        cb.setSelectedItem(selectedNo);
    }

    public String getUnitType(String unitName, Connection conn) {
        String unitType = null;
        String s = "select unitType from UNIT_DETAIL where unitName = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(s);
            ps.setString(1, unitName);
            rs = ps.executeQuery();
            if (rs.next()) {
                unitType = rs.getString("unitType");

            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return unitType;
    }

    public String getPrimaryUnit(String unitName, Connection conn) {
        String primaryU = null;
        String query = "select primaryUnit from UNIT_DETAIL where unitName = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            ps.setString(1, unitName);
            rs = ps.executeQuery();
            if (rs.next()) {
                primaryU = rs.getString("primaryUnit");
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return primaryU;
    }

    public String getPerUnit(String unitName, Connection conn) {
        String perUnit = null;
        String query = "select perUnit from UNIT_DETAIL where unitName = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            ps.setString(1, unitName);
            rs = ps.executeQuery();
            if (rs.next()) {
                perUnit = rs.getString("perUnit");
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return perUnit;
    }

    public void fetchExpiryDate(MainFrame mainFrame, JComboBox expiryDateCB, String toString, String companyCode, Connection conn) {

    }

    public String getNextDepositOrWithdrawNo(String companyCode, Connection conn) {
        String sql = "select voucherNumber from DEPOSIT_OR_WITHDRAW_DETAIL where companyCode = ?";
        int count = 0;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(sql);
            ps.setString(1, companyCode);
            rs = ps.executeQuery();
            while (rs.next()) {
                count++;
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(FetchVoucherData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(++count);
    }

    public String getPurchaseRate(String itemCode, Connection conn, String companyCode) {
        String purchasePrice = null;
        String query = "select purchasePrice from ITEM_DETAIL where itemCode = ?";
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(query);
            ps.setString(1, itemCode);
            rs = ps.executeQuery();
            if (rs.next()) {
                purchasePrice = rs.getString("purchasePrice");
            }
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(ListOfData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return purchasePrice;
    }
}
