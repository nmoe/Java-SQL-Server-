package hbut.dao.utils.impl;

//import hbut.dao.utils.interfaces.IBaseDao;

import java.sql.*;

import hbut.dao.utils.interfaces.IBaseDao;

public class sqlserverBaseDao implements IBaseDao {
    static String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=bigtest";
    static String USER = "Kizuna";
    static String PWD = "123456";
    private Connection conn;

    public Connection getConn() throws Exception {
        
        Connection conn = null;
        try {
            Class.forName(DRIVER_CLASS);
            conn = DriverManager.getConnection(URL, USER, PWD);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return conn;
    }
    public Connection getConnection() {
		return this.conn;
	}

    public void closeConn(ResultSet rs, PreparedStatement ps, Connection conn)
            throws Exception {
        
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
