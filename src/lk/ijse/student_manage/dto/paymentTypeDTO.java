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
public class paymentTypeDTO extends SuperDTO{

  private String PaId ;
 private  String type;

    public paymentTypeDTO () {
        
    }

    public paymentTypeDTO(String PaId, String type) {
        this.PaId = PaId;
        this.type = type;
    }

    /**
     * @return the PaId
     */
    public String getPaId() {
        return PaId;
    }

    /**
     * @param PaId the PaId to set
     */
    public void setPaId(String PaId) {
        this.PaId = PaId;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "payment_typeDTO{" + "PaId=" + PaId + ", type=" + type + '}';
    }
 
 
    
    
}
