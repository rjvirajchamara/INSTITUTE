/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.service.custom.Impl;

import java.util.ArrayList;
import lk.ijse.student_manage.dao.DAOFactory;
import lk.ijse.student_manage.dao.custom.CourseDAO;
import lk.ijse.student_manage.dto.CoureDTO;
import lk.ijse.student_manage.service.custom.CourseService;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class CourseServiceImpl implements CourseService{
    
    private CourseDAO  courseDAO;

    public CourseServiceImpl() {
        courseDAO= (CourseDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Course);
    }
    

    @Override
    public boolean add(CoureDTO dto) throws Exception {
        return courseDAO.add(dto);
                }

    @Override
    public boolean update(CoureDTO dto) throws Exception {
        return  courseDAO.update(dto);
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CoureDTO get(String key) throws Exception {
        return courseDAO.get(key);
    }

    @Override
    public ArrayList<CoureDTO> getAll() throws Exception {
        return  courseDAO.getAll();
    }

}
