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
public class BatchDTO extends SuperDTO{

 private  String BID;
 private String Batchname;

    public BatchDTO() {
    }

    public BatchDTO(String BID, String Batchname) {
        this.BID = BID;
        this.Batchname = Batchname;
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
     * @return the Batchname
     */
    public String getBatchname() {
        return Batchname;
    }

    /**
     * @param Batchname the Batchname to set
     */
    public void setBatchname(String Batchname) {
        this.Batchname = Batchname;
    }

    @Override
    public String toString() {
        return "BatchDTO{" + "BID=" + BID + ", Batchname=" + Batchname + '}';
    }
 
 
    
    
    
}
