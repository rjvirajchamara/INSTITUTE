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
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class RegistrationDTO extends SuperDTO{
    
    
 private String RID  ;       
 private String SID ;        
 private String   BID ;       
 private String CID ;         
 private String RegDate;      
 private BigDecimal Course_fee;         
 private String regfeestatar ;
  private String status;

    public RegistrationDTO() {
        
    }

    public RegistrationDTO(String RID, String SID, String BID, String CID, String RegDate, BigDecimal Course_fee, String regfeestatar, String status) {
        this.RID = RID;
        this.SID = SID;
        this.BID = BID;
        this.CID = CID;
        this.RegDate = RegDate;
        this.Course_fee = Course_fee;
        this.regfeestatar = regfeestatar;
        this.status = status;
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
     * @return the BID
     */
    public String getBID() {
        return BID;
    }

    /**
     * @param BID the BID to set
     */
    public void setBID(String BID) {
        this.BID = BID;
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
     * @return the RegDate
     */
    public String getRegDate() {
        return RegDate;
    }

    /**
     * @param RegDate the RegDate to set
     */
    public void setRegDate(String RegDate) {
        this.RegDate = RegDate;
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
     * @return the regfeestatar
     */
    public String getRegfeestatar() {
        return regfeestatar;
    }

    /**
     * @param regfeestatar the regfeestatar to set
     */
    public void setRegfeestatar(String regfeestatar) {
        this.regfeestatar = regfeestatar;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
}
   