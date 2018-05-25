/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */

package ui.reports.print.model;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class RegRetModel {
    private Object sn;
    private Object itemCode;
    private Object itemName;
    private Object unitName;
    private Object quantity;
    private Object rate;
    private Object itemAmount;
    private Object billSundry;
    private Object atTheRate;
    private Object miscAmount;
    private Object rowAmount;

    public RegRetModel(Object sn, Object itemCode, Object itemName, Object unitName, Object quantity, Object rate, Object itemAmount, Object billSundry, Object atTheRate, Object miscAmount, Object rowAmount) {
        this.sn = sn;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.unitName = unitName;
        this.quantity = quantity;
        this.rate = rate;
        this.itemAmount = itemAmount;
        this.billSundry = billSundry;
        this.atTheRate = atTheRate;
        this.miscAmount = miscAmount;
        this.rowAmount = rowAmount;
    }

    public Object getSn() {
        return sn;
    }

    public void setSn(Object sn) {
        this.sn = sn;
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

    public Object getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(Object itemAmount) {
        this.itemAmount = itemAmount;
    }

    public Object getBillSundry() {
        return billSundry;
    }

    public void setBillSundry(Object billSundry) {
        this.billSundry = billSundry;
    }

    public Object getAtTheRate() {
        return atTheRate;
    }

    public void setAtTheRate(Object atTheRate) {
        this.atTheRate = atTheRate;
    }

    public Object getMiscAmount() {
        return miscAmount;
    }

    public void setMiscAmount(Object miscAmount) {
        this.miscAmount = miscAmount;
    }

    public Object getRowAmount() {
        return rowAmount;
    }

    public void setRowAmount(Object rowAmount) {
        this.rowAmount = rowAmount;
    }
    
    
}
