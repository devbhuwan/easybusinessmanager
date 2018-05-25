/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */

package ui.reports.print.model;

/**
 *
 * @author Bhuwan Upadhyay
 */
public class VoucherModel {
    private Object sn;
    private Object accNo1;
    private Object accName1;
    private Object amount1;
    private Object accNo2;
    private Object accName2;
    private Object amount2;

    public VoucherModel(Object sn, Object accNo1, Object accName1, Object amount1, Object accNo2, Object accName2, Object amount2) {
        this.sn = sn;
        this.accNo1 = accNo1;
        this.accName1 = accName1;
        this.amount1 = amount1;
        this.accNo2 = accNo2;
        this.accName2 = accName2;
        this.amount2 = amount2;
    }

    public Object getSn() {
        return sn;
    }

    public void setSn(Object sn) {
        this.sn = sn;
    }

    public Object getAccNo1() {
        return accNo1;
    }

    public void setAccNo1(Object accNo1) {
        this.accNo1 = accNo1;
    }

    public Object getAccName1() {
        return accName1;
    }

    public void setAccName1(Object accName1) {
        this.accName1 = accName1;
    }

    public Object getAmount1() {
        return amount1;
    }

    public void setAmount1(Object amount1) {
        this.amount1 = amount1;
    }

    public Object getAccNo2() {
        return accNo2;
    }

    public void setAccNo2(Object accNo2) {
        this.accNo2 = accNo2;
    }

    public Object getAccName2() {
        return accName2;
    }

    public void setAccName2(Object accName2) {
        this.accName2 = accName2;
    }

    public Object getAmount2() {
        return amount2;
    }

    public void setAmount2(Object amount2) {
        this.amount2 = amount2;
    }
    
    
}
