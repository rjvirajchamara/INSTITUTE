/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.student_manage.controller.custom.PeymentController;
import lk.ijse.student_manage.dao.DAOFactory;
import lk.ijse.student_manage.dto.paymentDTO;
import lk.ijse.student_manage.service.ServiceFactory;
import lk.ijse.student_manage.service.custom.PeymentService;
import lk.ijse.student_manage.service.custom.paymenttypeService;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class PeymentControllerImpl implements PeymentController{
    
   private PeymentService paymenService;

    public PeymentControllerImpl() {
        paymenService = (PeymentService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceTypes.payment);
    }
   
   

    @Override
    public boolean add(paymentDTO dto) throws Exception {
        return  paymenService.add(dto);
        
    }

    @Override
    public boolean update(paymentDTO dto) throws Exception {
        return paymenService.update(dto);
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public paymentDTO search(String id) throws Exception {
        return paymenService.get(id);
    }

    @Override
    public ArrayList<paymentDTO> getAll() throws Exception {
        return  paymenService.getAll();
    }

}
