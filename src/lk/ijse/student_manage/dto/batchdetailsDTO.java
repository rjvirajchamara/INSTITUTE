/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.dto;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class batchdetailsDTO  extends SuperDTO{
    
   private String BAID;   
 private String BID ;      
 private String CID;       
 private String Bstatas ;  
 private String startdate;

    public batchdetailsDTO() {
        
    }

    public batchdetailsDTO(String BAID, String BID, String CID, String Bstatas, String startdate) {
        this.BAID = BAID;
        this.BID = BID;
        this.CID = CID;
        this.Bstatas = Bstatas;
        this.startdate = startdate;
    }

    /**
     * @return the BAID
     */
    public String getBAID() {
        return BAID;
    }

    /**
     * @param BAID the BAID to set
     */
    public void setBAID(String BAID) {
        this.BAID = BAID;
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
     * @return the Bstatas
     */
    public String getBstatas() {
        return Bstatas;
    }

    /**
     * @param Bstatas the Bstatas to set
     */
    public void setBstatas(String Bstatas) {
        this.Bstatas = Bstatas;
    }

    /**
     * @return the startdate
     */
    public String getStartdate() {
        return startdate;
    }

    /**
     * @param startdate the startdate to set
     */
    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    @Override
    public String toString() {
        return "batchdetailsDTO{" + "BAID=" + BAID + ", BID=" + BID + ", CID=" + CID + ", Bstatas=" + Bstatas + ", startdate=" + startdate + '}';
    }
 
 

}
