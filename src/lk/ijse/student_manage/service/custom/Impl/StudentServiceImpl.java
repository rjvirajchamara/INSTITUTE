/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.service.custom.Impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.student_manage.dao.DAOFactory;
import lk.ijse.student_manage.dao.custom.GurdlanDAO;
import lk.ijse.student_manage.dao.custom.StudentDAO;
import lk.ijse.student_manage.dao.db.ConnectionFactory;
import lk.ijse.student_manage.dto.GurdlanDTO;
import lk.ijse.student_manage.dto.StudentDTO;
import lk.ijse.student_manage.dto.SuperDTO;
import lk.ijse.student_manage.service.custom.StudentService;

/**
 *
 * @author chamara
 */
public class StudentServiceImpl implements StudentService{
   
    private StudentDAO studentDAO;
    private GurdlanDAO gurdlanDAO;
    
    public StudentServiceImpl(){
        
         studentDAO = (StudentDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
         gurdlanDAO =(GurdlanDAO)DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Gurdlan);
         
    }

    @Override
    public boolean add(StudentDTO dto) throws Exception {
        return studentDAO.add(dto);
    }

    @Override
    public boolean update(StudentDTO dto) throws Exception {
        return studentDAO.update(dto);
    }

    @Override
    public boolean delete(String key) throws Exception {
        return studentDAO.delete(key);
    }

    @Override
    public StudentDTO get(String key) throws Exception {
        return  studentDAO.get(key);
    }

    @Override
    public ArrayList<StudentDTO> getAll() throws Exception {
        return  studentDAO.getAll();
    }

    @Override
    public boolean adWithTrance(StudentDTO s, GurdlanDTO a) throws Exception {
         Connection con = ConnectionFactory.getInstance().getConnection();
      
        con.setAutoCommit(false);
        try {
            boolean add = studentDAO.add(s);
            System.out.println(s);
            if (add) {
                boolean add1 = gurdlanDAO.add(a);
                System.out.println(a);
                if (add1) {
                    con.commit();
                    System.out.println("done");
                    return true;
                } else {
                    con.rollback();
                    return false;
                }
            } else {
                con.rollback();
                return false;
            }
        } finally {
            con.setAutoCommit(true);
        }

    }

}