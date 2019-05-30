/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.service.custom;

import java.util.ArrayList;
import lk.ijse.student_manage.dto.QueryDTO;
import lk.ijse.student_manage.service.SuperService;

/**
 *
 * @author chamara
 */
public interface QueryService extends SuperService<QueryDTO>{
      public ArrayList<QueryDTO> getCourseName(String Dto) throws Exception;
      public ArrayList<QueryDTO>getALlstudent() throws Exception;
       public ArrayList<QueryDTO>getALlpayment() throws Exception;
      

}