/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */

package ui.reports.print.model;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class ProductionReportModel {
    private Object sn;
    private Object date;
    private Object voucherNumber;
    private Object itemCode;
    private Object itemName;
    private Object unitName;
    private Object quantity;
    private Object rate;
    private Object amount;
    private Object expiryDate;

    public ProductionReportModel(Object sn, Object date, Object voucherNumber, Object itemCode, Object itemName, Object unitName, Object quantity, Object rate, Object amount, Object expiryDate) {
        this.sn = sn;
        this.date = date;
        this.voucherNumber = voucherNumber;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.unitName = unitName;
        this.quantity = quantity;
        this.rate = rate;
        this.amount = amount;
        this.expiryDate = expiryDate;
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

    public Object getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(Object voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public Object getItemCode() {
        return itemCode;
    }

    public void setItemCode(Object itemCode) {
        this.itemCode = itemCode;
    }

    public Object getItemName() {
        return itemName;
    }

    public void setItemName(Object itemName) {
        this.itemName = itemName;
    }

    public Object getUnitName() {
        return unitName;
    }

    public void setUnitName(Object unitName) {
        this.unitName = unitName;
    }

    public Object getQuantity() {
        return quantity;
    }

    public void setQuantity(Object quantity) {
        this.quantity = quantity;
    }

    public Object getRate() {
        return rate;
    }

    public void setRate(Object rate) {
        this.rate = rate;
    }

    public Object getAmount() {
        return amount;
    }

    public void setAmount(Object amount) {
        this.amount = amount;
    }

    public Object getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Object expiryDate) {
        this.expiryDate = expiryDate;
    }
   
    
}
