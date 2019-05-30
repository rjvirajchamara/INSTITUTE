/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.student_manage.controller.ControllerFactory;
import lk.ijse.student_manage.controller.custom.QueryController;
import lk.ijse.student_manage.dto.QueryDTO;
import lk.ijse.student_manage.service.ServiceFactory;
import lk.ijse.student_manage.service.custom.QueryService;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class QueryControllerImpl implements QueryController{
    private  QueryService queryService;

    public QueryControllerImpl() {
        queryService= (QueryService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceTypes.Query);
                }
    @Override
    public boolean add(QueryDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(QueryDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public QueryDTO search(String Dto) throws Exception {
        return queryService.get(Dto);
    }

    @Override
    public ArrayList<QueryDTO> getAll() throws Exception {
        return queryService.getAll();
    }

    @Override
    public ArrayList<QueryDTO> getCourseName(String Dto) throws Exception {
        return queryService.getCourseName(Dto);
    }

   // public ArrayList<QueryDTO> getALlstudent(String DTO) throws Exception {
      //  return queryService.getALlstudent(DTO);
   // }

    @Override
    public ArrayList<QueryDTO> getALlstudent() throws Exception {
       return queryService.getALlstudent();
    }

    @Override
    public ArrayList<QueryDTO> getALlpayment() throws Exception {
        return queryService.getALlpayment();
    }

}
