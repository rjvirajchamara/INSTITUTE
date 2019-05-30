/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.student_manage.controller.custom.batchdetailsController;
import lk.ijse.student_manage.dao.DAOFactory;
import lk.ijse.student_manage.dto.BatchDTO;
import lk.ijse.student_manage.dto.batchdetailsDTO;
import lk.ijse.student_manage.service.ServiceFactory;
import lk.ijse.student_manage.service.SuperService;
import lk.ijse.student_manage.service.custom.BatchService;
import lk.ijse.student_manage.service.custom.batchdetailsService;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class batchdetailsControllerImpl implements batchdetailsController{
    
   private batchdetailsService batchdetailsService1;

    public batchdetailsControllerImpl() {
       batchdetailsService1 = (batchdetailsService) ServiceFactory.getInstance().getService(ServiceFactory.ServiceTypes.batchdetails);
        
        
    }
   
   

    @Override
    public boolean add(batchdetailsDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(batchdetailsDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public batchdetailsDTO search(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<batchdetailsDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    

}
