/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.service.custom;

import lk.ijse.student_manage.dto.BatchDTO;
import lk.ijse.student_manage.dto.batchdetailsDTO;
import lk.ijse.student_manage.service.SuperService;

/**
 *
 * @author chamara
 */
public interface BatchService extends SuperService<BatchDTO>{
     public boolean adWithTrance(BatchDTO p, batchdetailsDTO a) throws Exception; 
     
     
}
