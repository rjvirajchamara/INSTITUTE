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
public class QueryDTO extends SuperDTO {

    private String BatchID;
    private String BatchName;
    private String BatchBAID;
    private String BatchDate;
    private String BatchCourseName;
    private String BatchStatus;
    private String RID;
    private String CID;
    private String Coursename;
    private String studentname;
    private String NIC;
    private String SID;
    private String Name;
    private String Address;
    private String Telephone;
    private String School;
    private String gender;
    private String email;
    private String dob;
    private String Nic;
    private String universityorther;
    private String Hignereduquq;
    private String Gid;
   // private String SID;
    private String Gname;
    private String Gtelephone;
    private String Gmobile;
    private String GDesignation;
    private String Gworkingplace;
    private String GAddress;
    private String GEmail;
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

    public QueryDTO() {
        
    }

    public QueryDTO(String BatchID, String BatchName, String BatchBAID, String BatchDate, String BatchCourseName, String BatchStatus, String RID, String CID, String Coursename, String studentname, String NIC, String SID, String Name, String Address, String Telephone, String School, String gender, String email, String dob, String Nic, String universityorther, String Hignereduquq, String Gid, String Gname, String Gtelephone, String Gmobile, String GDesignation, String Gworkingplace, String GAddress, String GEmail, String pid, String Ptype, String rid, BigDecimal fee, int discount, BigDecimal firstAmount, BigDecimal secondAmount, int tax_rate, BigDecimal tax, int delay, BigDecimal totalAmount, BigDecimal balance, Date pDate, String pStatus, Date duePaymentDate) {
        this.BatchID = BatchID;
        this.BatchName = BatchName;
        this.BatchBAID = BatchBAID;
        this.BatchDate = BatchDate;
        this.BatchCourseName = BatchCourseName;
        this.BatchStatus = BatchStatus;
        this.RID = RID;
        this.CID = CID;
        this.Coursename = Coursename;
        this.studentname = studentname;
        this.NIC = NIC;
        this.SID = SID;
        this.Name = Name;
        this.Address = Address;
        this.Telephone = Telephone;
        this.School = School;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.Nic = Nic;
        this.universityorther = universityorther;
        this.Hignereduquq = Hignereduquq;
        this.Gid = Gid;
        this.Gname = Gname;
        this.Gtelephone = Gtelephone;
        this.Gmobile = Gmobile;
        this.GDesignation = GDesignation;
        this.Gworkingplace = Gworkingplace;
        this.GAddress = GAddress;
        this.GEmail = GEmail;
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
     * @return the BatchID
     */
    public String getBatchID() {
        return BatchID;
    }

    /**
     * @param BatchID the BatchID to set
     */
    public void setBatchID(String BatchID) {
        this.BatchID = BatchID;
    }

    /**
     * @return the BatchName
     */
    public String getBatchName() {
        return BatchName;
    }

    /**
     * @param BatchName the BatchName to set
     */
    public void setBatchName(String BatchName) {
        this.BatchName = BatchName;
    }

    /**
     * @return the BatchBAID
     */
    public String getBatchBAID() {
        return BatchBAID;
    }

    /**
     * @param BatchBAID the BatchBAID to set
     */
    public void setBatchBAID(String BatchBAID) {
        this.BatchBAID = BatchBAID;
    }

    /**
     * @return the BatchDate
     */
    public String getBatchDate() {
        return BatchDate;
    }

    /**
     * @param BatchDate the BatchDate to set
     */
    public void setBatchDate(String BatchDate) {
        this.BatchDate = BatchDate;
    }

    /**
     * @return the BatchCourseName
     */
    public String getBatchCourseName() {
        return BatchCourseName;
    }

    /**
     * @param BatchCourseName the BatchCourseName to set
     */
    public void setBatchCourseName(String BatchCourseName) {
        this.BatchCourseName = BatchCourseName;
    }

    /**
     * @return the BatchStatus
     */
    public String getBatchStatus() {
        return BatchStatus;
    }

    /**
     * @param BatchStatus the BatchStatus to set
     */
    public void setBatchStatus(String BatchStatus) {
        this.BatchStatus = BatchStatus;
    }

    /**
     * @return the RID
     */
    public String getRID() {
        return RID;
    }

    /**
     * @param RID the RID to set
     */
    public void setRID(String RID) {
        this.RID = RID;
    }

    /**
     * @return the CID
     */
    public String getCID() {
        return CID;
    }

    /**
     * @param CID the CID to set
     */
    public void setCID(String CID) {
        this.CID = CID;
    }

    /**
     * @return the Coursename
     */
    public String getCoursename() {
        return Coursename;
    }

    /**
     * @param Coursename the Coursename to set
     */
    public void setCoursename(String Coursename) {
        this.Coursename = Coursename;
    }

    /**
     * @return the studentname
     */
    public String getStudentname() {
        return studentname;
    }

    /**
     * @param studentname the studentname to set
     */
    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    /**
     * @return the NIC
     */
    public String getNIC() {
        return NIC;
    }

    /**
     * @param NIC the NIC to set
     */
    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    /**
     * @return the SID
     */
    public String getSID() {
        return SID;
    }

    /**
     * @param SID the SID to set
     */
    public void setSID(String SID) {
        this.SID = SID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param Address the Address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * @return the Telephone
     */
    public String getTelephone() {
        return Telephone;
    }

    /**
     * @param Telephone the Telephone to set
     */
    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    /**
     * @return the School
     */
    public String getSchool() {
        return School;
    }

    /**
     * @param School the School to set
     */
    public void setSchool(String School) {
        this.School = School;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the Nic
     */
    public String getNic() {
        return Nic;
    }

    /**
     * @param Nic the Nic to set
     */
    public void setNic(String Nic) {
        this.Nic = Nic;
    }

    /**
     * @return the universityorther
     */
    public String getUniversityorther() {
        return universityorther;
    }

    /**
     * @param universityorther the universityorther to set
     */
    public void setUniversityorther(String universityorther) {
        this.universityorther = universityorther;
    }

    /**
     * @return the Hignereduquq
     */
    public String getHignereduquq() {
        return Hignereduquq;
    }

    /**
     * @param Hignereduquq the Hignereduquq to set
     */
    public void setHignereduquq(String Hignereduquq) {
        this.Hignereduquq = Hignereduquq;
    }

    /**
     * @return the Gid
     */
    public String getGid() {
        return Gid;
    }

    /**
     * @param Gid the Gid to set
     */
    public void setGid(String Gid) {
        this.Gid = Gid;
    }

    /**
     * @return the Gname
     */
    public String getGname() {
        return Gname;
    }

    /**
     * @param Gname the Gname to set
     */
    public void setGname(String Gname) {
        this.Gname = Gname;
    }

    /**
     * @return the Gtelephone
     */
    public String getGtelephone() {
        return Gtelephone;
    }

    /**
     * @param Gtelephone the Gtelephone to set
     */
    public void setGtelephone(String Gtelephone) {
        this.Gtelephone = Gtelephone;
    }

    /**
     * @return the Gmobile
     */
    public String getGmobile() {
        return Gmobile;
    }

    /**
     * @param Gmobile the Gmobile to set
     */
    public void setGmobile(String Gmobile) {
        this.Gmobile = Gmobile;
    }

    /**
     * @return the GDesignation
     */
    public String getGDesignation() {
        return GDesignation;
    }

    /**
     * @param GDesignation the GDesignation to set
     */
    public void setGDesignation(String GDesignation) {
        this.GDesignation = GDesignation;
    }

    /**
     * @return the Gworkingplace
     */
    public String getGworkingplace() {
        return Gworkingplace;
    }

    /**
     * @param Gworkingplace the Gworkingplace to set
     */
    public void setGworkingplace(String Gworkingplace) {
        this.Gworkingplace = Gworkingplace;
    }

    /**
     * @return the GAddress
     */
    public String getGAddress() {
        return GAddress;
    }

    /**
     * @param GAddress the GAddress to set
     */
    public void setGAddress(String GAddress) {
        this.GAddress = GAddress;
    }

    /**
     * @return the GEmail
     */
    public String getGEmail() {
        return GEmail;
    }

    /**
     * @param GEmail the GEmail to set
     */
    public void setGEmail(String GEmail) {
        this.GEmail = GEmail;
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
        return "QueryDTO{" + "BatchID=" + BatchID + ", BatchName=" + BatchName + ", BatchBAID=" + BatchBAID + ", BatchDate=" + BatchDate + ", BatchCourseName=" + BatchCourseName + ", BatchStatus=" + BatchStatus + ", RID=" + RID + ", CID=" + CID + ", Coursename=" + Coursename + ", studentname=" + studentname + ", NIC=" + NIC + ", SID=" + SID + ", Name=" + Name + ", Address=" + Address + ", Telephone=" + Telephone + ", School=" + School + ", gender=" + gender + ", email=" + email + ", dob=" + dob + ", Nic=" + Nic + ", universityorther=" + universityorther + ", Hignereduquq=" + Hignereduquq + ", Gid=" + Gid + ", Gname=" + Gname + ", Gtelephone=" + Gtelephone + ", Gmobile=" + Gmobile + ", GDesignation=" + GDesignation + ", Gworkingplace=" + Gworkingplace + ", GAddress=" + GAddress + ", GEmail=" + GEmail + ", pid=" + pid + ", Ptype=" + Ptype + ", rid=" + rid + ", fee=" + fee + ", discount=" + discount + ", firstAmount=" + firstAmount + ", secondAmount=" + secondAmount + ", tax_rate=" + tax_rate + ", tax=" + tax + ", delay=" + delay + ", totalAmount=" + totalAmount + ", balance=" + balance + ", pDate=" + pDate + ", pStatus=" + pStatus + ", duePaymentDate=" + duePaymentDate + '}';
    }
    
    }
   
