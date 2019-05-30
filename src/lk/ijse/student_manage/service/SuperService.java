/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.service;

import java.util.ArrayList;
import lk.ijse.student_manage.dto.SuperDTO;
import lk.ijse.student_manage.service.custom.StudentService;

/**
 *
 * @author chamara
 */
public interface SuperService<T extends SuperDTO>{
    
     public boolean add(T dto)throws Exception;
     
    public boolean update(T dto)throws Exception;
    
    public boolean delete(String key)throws Exception;
    
    public T get(String Dto)throws Exception;
    
    public ArrayList<T> getAll() throws Exception;
    
}


