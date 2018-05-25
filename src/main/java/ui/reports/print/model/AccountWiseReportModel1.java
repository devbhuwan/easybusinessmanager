/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */

package ui.reports.print.model;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class AccountWiseReportModel1 {
    
    private Object sn;
    private Object date;
    private Object voucherNo;
    private Object accNo;
    private Object accName;
    private Object debitAmount;
    private Object creditAmount;
    private Object remark;

    public AccountWiseReportModel1(Object sn, Object date, Object voucherNo, Object accNo, Object accName, Object debitAmount, Object creditAmount,Object remark) {
        this.sn = sn;
        this.date = date;
        this.voucherNo = voucherNo;
        this.accNo = accNo;
        this.accName = accName;
        this.debitAmount = debitAmount;
        this.creditAmount = creditAmount;
        this.remark = remark;
    }

    public Object getSn() {
        return sn;
    }

    public void setSn(Object sn) {
        this.sn = sn;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    public Object getVoucherNo() {
        return voucherNo;
    }

    public void setVoucherNo(Object voucherNo) {
        this.voucherNo = voucherNo;
    }

    public Object getAccNo() {
        return accNo;
    }

    public void setAccNo(Object accNo) {
        this.accNo = accNo;
    }

    public Object getAccName() {
        return accName;
    }

    public void setAccName(Object accName) {
        this.accName = accName;
    }

    public Object getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(Object debitAmount) {
        this.debitAmount = debitAmount;
    }

    public Object getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Object creditAmount) {
        this.creditAmount = creditAmount;
    }

    public Object getRemark() {
        return remark;
    }

    public void setRemark(Object remark) {
        this.remark = remark;
    }
    
    
    
}
