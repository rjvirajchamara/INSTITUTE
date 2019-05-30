/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.service.custom.Impl;

import java.util.ArrayList;
import lk.ijse.student_manage.dao.DAOFactory;
import lk.ijse.student_manage.dao.custom.paymenttypeDAO;
import lk.ijse.student_manage.dto.paymentTypeDTO;
import lk.ijse.student_manage.service.custom.paymenttypeService;

/**
 *
 * @author  chamara
 */
public class paymenttypeServiceImpl implements paymenttypeService{
      private paymenttypeDAO paymenttypeDAO1;

    public paymenttypeServiceImpl() {
        paymenttypeDAO1= (paymenttypeDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.paymenttype);
    }
      
      
    
    @Override
    public boolean add(paymentTypeDTO dto) throws Exception {
        return paymenttypeDAO1.add(dto);
    }

    @Override
    public boolean update(paymentTypeDTO dto) throws Exception {
      return paymenttypeDAO1.update(dto);
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public paymentTypeDTO get(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<paymentTypeDTO> getAll() throws Exception {
        return paymenttypeDAO1.getAll();
    }

}
