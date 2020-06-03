package hbut.dao.utils.interfaces;
import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public interface IBaseDao {
    public Connection getConn() throws Exception ;

    public void closeConn(ResultSet rs, PreparedStatement ps, Connection conn) throws Exception ;
}

