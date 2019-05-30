/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.controller.custom;

import lk.ijse.student_manage.controller.SuperController;
import lk.ijse.student_manage.dto.LoginDTO;
import lk.ijse.student_manage.dto.SuperDTO;

/**
 *
 * @author chamara
 */
public interface LoginController extends SuperController<LoginDTO>{

    public boolean Login(LoginDTO dto)throws Exception;
    
}
