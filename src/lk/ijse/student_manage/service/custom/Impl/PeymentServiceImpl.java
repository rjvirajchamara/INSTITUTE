/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.service.custom.Impl;

import java.util.ArrayList;
import lk.ijse.student_manage.dao.DAOFactory;
import lk.ijse.student_manage.dao.custom.peymentDAO;
import lk.ijse.student_manage.dto.paymentDTO;
import lk.ijse.student_manage.service.ServiceFactory;
import lk.ijse.student_manage.service.custom.PeymentService;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class PeymentServiceImpl implements PeymentService{

   private peymentDAO paymentDAO1;

    public PeymentServiceImpl() {
        
        paymentDAO1 = (peymentDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.payment);
    }
    
    
    
    @Override
    public boolean add(paymentDTO dto) throws Exception {
        return paymentDAO1.add(dto);
    }

    @Override
    public boolean update(paymentDTO dto) throws Exception {
        return  paymentDAO1.update(dto);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return paymentDAO1.delete(key);
    }

    @Override
    public paymentDTO get(String key) throws Exception {
        return  paymentDAO1.get(key);
    }

    @Override
    public ArrayList<paymentDTO> getAll() throws Exception {
        return  paymentDAO1.getAll();
    }

}
