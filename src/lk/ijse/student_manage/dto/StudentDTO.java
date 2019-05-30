/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.dto;

/**
 *
 * @author chamara
 */
public class StudentDTO extends SuperDTO{
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

    public StudentDTO() {
        
    } 

    public StudentDTO(String SID, String Name, String Address, String Telephone, String School, String gender, String email, String dob, String Nic, String universityorther, String Hignereduquq) {
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

    @Override
    public String toString() {
        return "StudentDTO{" + "SID=" + SID + ", Name=" + Name + ", Address=" + Address + ", Telephone=" + Telephone + ", School=" + School + ", gender=" + gender + ", email=" + email + ", dob=" + dob + ", Nic=" + Nic + ", universityorther=" + universityorther + ", Hignereduquq=" + Hignereduquq + '}';
    }
    
    }
    
   