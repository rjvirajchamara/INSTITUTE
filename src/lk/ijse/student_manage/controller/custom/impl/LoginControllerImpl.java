/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.student_manage.controller.custom.LoginController;
import lk.ijse.student_manage.dao.DAOFactory;
import lk.ijse.student_manage.dao.custom.LoginDAO;
import lk.ijse.student_manage.dto.LoginDTO;
import lk.ijse.student_manage.dto.SuperDTO;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class LoginControllerImpl implements LoginController{
    
     private LoginDAO loginDAO;

    public LoginControllerImpl() {
        loginDAO = (LoginDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Login);
    }
     


    @Override
    public boolean add(LoginDTO dto) throws Exception {
        return loginDAO.add(dto);
    }

    @Override
    public boolean update(LoginDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LoginDTO search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<LoginDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Login(LoginDTO dto) throws Exception {
      return loginDAO.login(dto);
    }

   
    
}
