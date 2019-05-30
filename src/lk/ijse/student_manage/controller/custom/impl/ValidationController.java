/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.controller.custom.impl;

/**
 *
 * @author Kavindu
 */
public class ValidationController {
    public boolean setTelNumber(String nicNumber) throws Exception {
        if (nicNumber.matches("\\d{3}-\\d{7}")) {
            return true;
        } else {
            return false;
        }
    }
    public boolean setNicNumber(String idNumber) throws Exception {
        if (idNumber.matches("\\d{9}[Vv]")) {
            return true;
        } else {
            return false;
        }
    }
    public boolean setName(String name) throws Exception {
        if(name.matches("\\W[A-Za-z]")){
            return true;
        }else{
            return false;
        }
    }
    public boolean setPrice(double price) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
