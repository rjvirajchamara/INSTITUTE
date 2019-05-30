/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.student_manage.dao.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chamara
 */
public class ConnectionFactory {
    private Connection connection;
    private static ConnectionFactory dBConnection;

    private ConnectionFactory()  {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            connection=DriverManager.getConnection("jdbc:mysql://localhost/ijsesystem", "root", "viraj11");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @return the dBConnection
     */
    public static ConnectionFactory getInstance(){
        if (dBConnection==null){
            dBConnection=new ConnectionFactory();
        }
        return dBConnection;
    }
    
    
}
