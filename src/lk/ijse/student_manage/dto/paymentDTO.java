/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in
 * Templates/Classes/Class.java.
 */
public class paymentDTO extends SuperDTO {

    private String pid;
    private String Ptype;
    private String rid;
    private BigDecimal fee;
    private int discount;
    private BigDecimal firstAmount;
    private BigDecimal secondAmount;
    private int tax_rate;
    private BigDecimal tax;
    private int delay;
    private BigDecimal totalAmount;
    private BigDecimal balance;
    private Date pDate;
    private String pStatus;
    private Date duePaymentDate;

    public paymentDTO() {
       
    }

    public paymentDTO(String pid, String Ptype, String rid, BigDecimal fee, int discount, BigDecimal firstAmount, BigDecimal secondAmount, int tax_rate, BigDecimal tax, int delay, BigDecimal totalAmount, BigDecimal balance, Date pDate, String pStatus, Date duePaymentDate) {
        this.pid = pid;
        this.Ptype = Ptype;
        this.rid = rid;
        this.fee = fee;
        this.discount = discount;
        this.firstAmount = firstAmount;
        this.secondAmount = secondAmount;
        this.tax_rate = tax_rate;
        this.tax = tax;
        this.delay = delay;
        this.totalAmount = totalAmount;
        this.balance = balance;
        this.pDate = pDate;
        this.pStatus = pStatus;
        this.duePaymentDate = duePaymentDate;
    }

    /**
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @return the Ptype
     */
    public String getPtype() {
        return Ptype;
    }

    /**
     * @param Ptype the Ptype to set
     */
    public void setPtype(String Ptype) {
        this.Ptype = Ptype;
    }

    /**
     * @return the rid
     */
    public String getRid() {
        return rid;
    }

    /**
     * @param rid the rid to set
     */
    public void setRid(String rid) {
        this.rid = rid;
    }

    /**
     * @return the fee
     */
    public BigDecimal getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    /**
     * @return the discount
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * @return the firstAmount
     */
    public BigDecimal getFirstAmount() {
        return firstAmount;
    }

    /**
     * @param firstAmount the firstAmount to set
     */
    public void setFirstAmount(BigDecimal firstAmount) {
        this.firstAmount = firstAmount;
    }

    /**
     * @return the secondAmount
     */
    public BigDecimal getSecondAmount() {
        return secondAmount;
    }

    /**
     * @param secondAmount the secondAmount to set
     */
    public void setSecondAmount(BigDecimal secondAmount) {
        this.secondAmount = secondAmount;
    }

    /**
     * @return the tax_rate
     */
    public int getTax_rate() {
        return tax_rate;
    }

    /**
     * @param tax_rate the tax_rate to set
     */
    public void setTax_rate(int tax_rate) {
        this.tax_rate = tax_rate;
    }

    /**
     * @return the tax
     */
    public BigDecimal getTax() {
        return tax;
    }

    /**
     * @param tax the tax to set
     */
    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    /**
     * @return the delay
     */
    public int getDelay() {
        return delay;
    }

    /**
     * @param delay the delay to set
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }

    /**
     * @return the totalAmount
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * @return the pDate
     */
    public Date getpDate() {
        return pDate;
    }

    /**
     * @param pDate the pDate to set
     */
    public void setpDate(Date pDate) {
        this.pDate = pDate;
    }

    /**
     * @return the pStatus
     */
    public String getpStatus() {
        return pStatus;
    }

    /**
     * @param pStatus the pStatus to set
     */
    public void setpStatus(String pStatus) {
        this.pStatus = pStatus;
    }

    /**
     * @return the duePaymentDate
     */
    public Date getDuePaymentDate() {
        return duePaymentDate;
    }

    /**
     * @param duePaymentDate the duePaymentDate to set
     */
    public void setDuePaymentDate(Date duePaymentDate) {
        this.duePaymentDate = duePaymentDate;
    }

    @Override
    public String toString() {
        return "paymentDTO{" + "pid=" + pid + ", Ptype=" + Ptype + ", rid=" + rid + ", fee=" + fee + ", discount=" + discount + ", firstAmount=" + firstAmount + ", secondAmount=" + secondAmount + ", tax_rate=" + tax_rate + ", tax=" + tax + ", delay=" + delay + ", totalAmount=" + totalAmount + ", balance=" + balance + ", pDate=" + pDate + ", pStatus=" + pStatus + ", duePaymentDate=" + duePaymentDate + '}';
    }

    
    
    
    }

    