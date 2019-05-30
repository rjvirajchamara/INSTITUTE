/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.student_manage.controller.custom.TaxController;
import lk.ijse.student_manage.dto.TaxDTO;
import lk.ijse.student_manage.service.ServiceFactory;
import lk.ijse.student_manage.service.custom.TaxService;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class TaxControllerImpl implements TaxController{
 private TaxService taxService;

    public TaxControllerImpl() {
        taxService = (TaxService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceTypes.Tax);
    }
 
 
    @Override
    public boolean add(TaxDTO dto) throws Exception {
      return taxService.add(dto);
    }

    @Override
    public boolean update(TaxDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TaxDTO search(String Dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<TaxDTO> getAll() throws Exception {
        return taxService.getAll();
    }

}
