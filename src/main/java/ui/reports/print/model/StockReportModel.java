/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */

package ui.reports.print.model;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class StockReportModel {
    
    private Object sn;
    private Object itemCode;
    private Object itemName;
    private Object unitName;
    private Object quantity;
    private Object extraQty;
    private Object rate;
    private Object amount;

    public StockReportModel(Object sn, Object itemCode, Object itemName, Object unitName, Object quantity, Object extraQty, Object rate, Object amount) {
        this.sn = sn;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.unitName = unitName;
        this.quantity = quantity;
        this.extraQty = extraQty;
        this.rate = rate;
        this.amount = amount;
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

    public Object getExtraQty() {
        return extraQty;
    }

    public void setExtraQty(Object extraQty) {
        this.extraQty = extraQty;
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
    
    
}
