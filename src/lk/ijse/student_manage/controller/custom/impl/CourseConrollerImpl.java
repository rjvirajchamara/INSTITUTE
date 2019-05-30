/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lk.ijse.student_manage.controller.custom.impl;

import java.util.ArrayList;
import lk.ijse.student_manage.controller.custom.CourseController;
import lk.ijse.student_manage.dto.CoureDTO;
import lk.ijse.student_manage.service.ServiceFactory;
import lk.ijse.student_manage.service.custom.CourseService;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class CourseConrollerImpl implements CourseController{
    
   private CourseService courseService;

    public CourseConrollerImpl() {
        courseService = (CourseService)ServiceFactory.getInstance().getService(ServiceFactory.ServiceTypes.Course);
    }
   
   

    @Override
    public boolean add(CoureDTO dto) throws Exception {
         return courseService.add(dto);
    }

    @Override
    public boolean update(CoureDTO dto) throws Exception {
      return courseService.update(dto);
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CoureDTO search(String id) throws Exception {
        return courseService.get(id);
    }

    @Override
    public ArrayList<CoureDTO> getAll() throws Exception {
       return courseService.getAll();
    }

}
