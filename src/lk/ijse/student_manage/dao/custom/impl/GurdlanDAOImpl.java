/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.dao.custom.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import lk.ijse.student_manage.dao.custom.GurdlanDAO;
import lk.ijse.student_manage.dao.db.ConnectionFactory;
import lk.ijse.student_manage.dto.GurdlanDTO;
import lk.ijse.student_manage.dto.SuperDTO;

/**
 *
 * @author Expression chamara is undefined on line 12, column 14 in
 * Templates/Classes/Class.java.
 */
public class GurdlanDAOImpl implements GurdlanDAO {

    private Connection connection;

    public GurdlanDAOImpl() {
        connection = ConnectionFactory.getInstance().getConnection();
    }

    @Override
    public boolean add(GurdlanDTO dto) throws Exception {
        String SQL = "INSERT INTO gurdlan VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(SQL);
        stm.setObject(1, dto.getGid());
        stm.setObject(2, dto.getSID());
        stm.setObject(3, dto.getGname());
        stm.setObject(4, dto.getGtelephone());
        stm.setObject(5, dto.getGmobile());
        stm.setObject(6, dto.getGDesignation());
        stm.setObject(7, dto.getGworkingplace());
        stm.setObject(8, dto.getGAddress());
        stm.setObject(9, dto.getGEmail());
      //  stm.setObject(2, dto.getSID());
       
        
        int res = stm.executeUpdate();
        /*  System.out.println("gid"+dto.getGid());
       System.out.println("gid"+dto. getSID());
        System.out.println("gin"+dto.getGname());
        System.out.println("git"+dto.getGtelephone());
        System.out.println("gim"+dto.getGmobile());
        System.out.println("gide"+dto.getGDesignation());
        System.out.println("gigw"+dto.getGworkingplace());
         System.out.println("giad"+dto.getGAddress());
         System.out.println("gige"+dto.getGEmail());*/

        return (res > 0);
    }

    @Override
    public boolean update(GurdlanDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String key) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GurdlanDTO get(String Dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<GurdlanDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
