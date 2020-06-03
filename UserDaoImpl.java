package hbut.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import hbut.dao.utils.impl.sqlserverBaseDao;
import hbut.dao.utils.interfaces.IBaseDao;
import hbut.po.User;
import hbut.dao.interfaces.IUserDao;

public class UserDaoImpl implements IUserDao {
    IBaseDao baseDao = (IBaseDao) new sqlserverBaseDao();

    @Override
    public User login(User user) throws Exception {
        
        User users = null;
        try {
            Connection conn = baseDao.getConn();
            String sql = "SELECT * FROM users WHERE username = ? AND userpwd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, user.getUserName());
            ps.setObject(2, user.getUserPwd());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                users = new User();
                users.setUserId(rs.getInt("userId"));
                users.setUserName(rs.getString("userName"));
                users.setUserPwd(rs.getString("userPwd"));
            }
            baseDao.closeConn(rs, ps, conn);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return users;
    }

}
