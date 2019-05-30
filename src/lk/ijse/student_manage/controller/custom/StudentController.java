/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.controller.custom;

import lk.ijse.student_manage.controller.SuperController;
import lk.ijse.student_manage.dto.GurdlanDTO;
import lk.ijse.student_manage.dto.StudentDTO;

/**
 *
 * @author chamara
 */
public interface StudentController extends SuperController<StudentDTO>{
      public boolean adWithTrance(StudentDTO s, GurdlanDTO a) throws Exception; 
    
}
