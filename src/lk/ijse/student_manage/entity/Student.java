/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.entity;

/**
 *
 * @author chamara
 */
public class Student {
    private String SID;
    private String nic;
    private String Name;
    private String bday;
    private String address;
    private String telNo;

    public Student() {
    }

    public Student(String SID, String nic, String Name, String bday, String address, String telNo) {
        this.SID = SID;
        this.nic = nic;
        this.Name = Name;
        this.bday = bday;
        this.address = address;
        this.telNo = telNo;
    }

    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getBday() {
        return bday;
    }

    public void setBday(String bday) {
        this.bday = bday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

}

