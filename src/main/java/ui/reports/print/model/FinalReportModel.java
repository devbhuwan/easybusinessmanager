/*
 * Developer : Bhuwan and Vimal
 * License Under Developer  * 
 */

package ui.reports.print.model;


/**
 *
 * @author Bhuwan Upadhyay
 */
public class FinalReportModel {
 
    private Object sn1;
    private Object part1;
    private Object debitAmount;
    private Object sn2;
    private Object part2;
    private Object creditAmount;

    public FinalReportModel(Object sn1, Object part1, Object debitAmount, Object sn2, Object part2, Object creditAmount) {
        this.sn1 = sn1;
        this.part1 = part1;
        this.debitAmount = debitAmount;
        this.sn2 = sn2;
        this.part2 = part2;
        this.creditAmount = creditAmount;
    }

    public Object getSn1() {
        return sn1;
    }

    public void setSn1(Object sn1) {
        this.sn1 = sn1;
    }

    public Object getPart1() {
        return part1;
    }

    public void setPart1(Object part1) {
        this.part1 = part1;
    }

    public Object getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(Object debitAmount) {
        this.debitAmount = debitAmount;
    }

    public Object getSn2() {
        return sn2;
    }

    public void setSn2(Object sn2) {
        this.sn2 = sn2;
    }

    public Object getPart2() {
        return part2;
    }

    public void setPart2(Object part2) {
        this.part2 = part2;
    }

    public Object getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Object creditAmount) {
        this.creditAmount = creditAmount;
    }
    
    
}
