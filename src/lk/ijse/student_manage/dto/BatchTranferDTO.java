/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.dto;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in
 * Templates/Classes/Class.java.
 */
public class BatchTranferDTO extends SuperDTO {

    private String TID;
    private String RID;
    private String SID;
    private String BID_Old;
    private String BID_New;
    private String TrasnferDate;
    private String Transferfee;

    public BatchTranferDTO() {

    }

    public BatchTranferDTO(String TID, String RID, String SID, String BID_Old, String BID_New, String TrasnferDate, String Transferfee) {
        this.TID = TID;
        this.RID = RID;
        this.SID = SID;
        this.BID_Old = BID_Old;
        this.BID_New = BID_New;
        this.TrasnferDate = TrasnferDate;
        this.Transferfee = Transferfee;
    }

    /**
     * @return the TID
     */
    public String getTID() {
        return TID;
    }

    /**
     * @param TID the TID to set
     */
    public void setTID(String TID) {
        this.TID = TID;
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
     * @return the BID_Old
     */
    public String getBID_Old() {
        return BID_Old;
    }

    /**
     * @param BID_Old the BID_Old to set
     */
    public void setBID_Old(String BID_Old) {
        this.BID_Old = BID_Old;
    }

    /**
     * @return the BID_New
     */
    public String getBID_New() {
        return BID_New;
    }

    /**
     * @param BID_New the BID_New to set
     */
    public void setBID_New(String BID_New) {
        this.BID_New = BID_New;
    }

    /**
     * @return the TrasnferDate
     */
    public String getTrasnferDate() {
        return TrasnferDate;
    }

    /**
     * @param TrasnferDate the TrasnferDate to set
     */
    public void setTrasnferDate(String TrasnferDate) {
        this.TrasnferDate = TrasnferDate;
    }

    /**
     * @return the Transferfee
     */
    public String getTransferfee() {
        return Transferfee;
    }

    /**
     * @param Transferfee the Transferfee to set
     */
    public void setTransferfee(String Transferfee) {
        this.Transferfee = Transferfee;
    }

    @Override
    public String toString() {
        return "BatchTranferDTO{" + "TID=" + TID + ", RID=" + RID + ", SID=" + SID + ", BID_Old=" + BID_Old + ", BID_New=" + BID_New + ", TrasnferDate=" + TrasnferDate + ", Transferfee=" + Transferfee + '}';
    }

}
