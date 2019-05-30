/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.dto;

import java.math.BigDecimal;

/**
 *
 * @author chamara
 */
public class CoureDTO extends SuperDTO {

    private String CID;
    private String Coursename;
    private String Duration;
    private BigDecimal Course_fee;
    private String Regfee;
    private String CStatas;
    private BigDecimal discount;

    public CoureDTO() {

    }

    public CoureDTO(String CID, String Coursename, String Duration, BigDecimal Course_fee, String Regfee, String CStatas, BigDecimal discount) {
        this.CID = CID;
        this.Coursename = Coursename;
        this.Duration = Duration;
        this.Course_fee = Course_fee;
        this.Regfee = Regfee;
        this.CStatas = CStatas;
        this.discount = discount;
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
     * @return the Duration
     */
    public String getDuration() {
        return Duration;
    }

    /**
     * @param Duration the Duration to set
     */
    public void setDuration(String Duration) {
        this.Duration = Duration;
    }

    /**
     * @return the Course_fee
     */
    public BigDecimal getCourse_fee() {
        return Course_fee;
    }

    /**
     * @param Course_fee the Course_fee to set
     */
    public void setCourse_fee(BigDecimal Course_fee) {
        this.Course_fee = Course_fee;
    }

    /**
     * @return the Regfee
     */
    public String getRegfee() {
        return Regfee;
    }

    /**
     * @param Regfee the Regfee to set
     */
    public void setRegfee(String Regfee) {
        this.Regfee = Regfee;
    }

    /**
     * @return the CStatas
     */
    public String getCStatas() {
        return CStatas;
    }

    /**
     * @param CStatas the CStatas to set
     */
    public void setCStatas(String CStatas) {
        this.CStatas = CStatas;
    }

    /**
     * @return the discount
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "CoureDTO{" + "CID=" + CID + ", Coursename=" + Coursename + ", Duration=" + Duration + ", Course_fee=" + Course_fee + ", Regfee=" + Regfee + ", CStatas=" + CStatas + ", discount=" + discount + '}';
    }

}
