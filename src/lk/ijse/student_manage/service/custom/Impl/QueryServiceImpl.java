/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.service.custom.Impl;

import java.util.ArrayList;
import lk.ijse.student_manage.dao.DAOFactory;
import lk.ijse.student_manage.dao.custom.QueryDAO;
import lk.ijse.student_manage.dto.QueryDTO;
import lk.ijse.student_manage.service.custom.QueryService;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class QueryServiceImpl implements QueryService{

   private QueryDAO queryDAO;

    public QueryServiceImpl() {
        queryDAO = (QueryDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Query);
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
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public QueryDTO get(String Dto) throws Exception {
        return queryDAO.get(Dto);
    }

    @Override
    public ArrayList<QueryDTO> getAll() throws Exception {
        return queryDAO.getAll();
    }

    @Override
    public ArrayList<QueryDTO> getCourseName(String Dto) throws Exception {
        return queryDAO.getCourseName(Dto);
    }

    @Override
    public ArrayList<QueryDTO> getALlstudent() throws Exception {
        return queryDAO.getALlstudent();
    }

    @Override
    public ArrayList<QueryDTO> getALlpayment() throws Exception {
       return queryDAO.getALlpayment();
    }

   

}
