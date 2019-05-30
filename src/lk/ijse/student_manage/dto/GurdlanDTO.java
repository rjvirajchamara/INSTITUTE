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
public class GurdlanDTO extends SuperDTO{

    private String Gid;
    private String SID;
    private String Gname;
    private String Gtelephone;
    private String Gmobile;
    private String GDesignation;
    private String Gworkingplace;
    private String GAddress;
    private String GEmail;

    public GurdlanDTO() {
        
    }

    public GurdlanDTO(String Gid, String SID, String Gname, String Gtelephone, String Gmobile, String GDesignation, String Gworkingplace, String GAddress, String GEmail) {
        this.Gid = Gid;
        this.SID = SID;
        this.Gname = Gname;
        this.Gtelephone = Gtelephone;
        this.Gmobile = Gmobile;
        this.GDesignation = GDesignation;
        this.Gworkingplace = Gworkingplace;
        this.GAddress = GAddress;
        this.GEmail = GEmail;
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

    @Override
    public String toString() {
        return "GurdlanDTO{" + "Gid=" + Gid + ", SID=" + SID + ", Gname=" + Gname + ", Gtelephone=" + Gtelephone + ", Gmobile=" + Gmobile + ", GDesignation=" + GDesignation + ", Gworkingplace=" + Gworkingplace + ", GAddress=" + GAddress + ", GEmail=" + GEmail + '}';
    }
    
    }

  