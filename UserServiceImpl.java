package hbut.services.impl;
//import hbut.dao.impl.UserDaoImpl;
import hbut.po.User;
import hbut.services.impl.UserServiceImpl;


import java.sql.Connection;
import hbut.services.interfaces.IUserService;
public class UserServiceImpl implements IUserService {
    
    private Object conn;

    public User userlogin(User user) throws Exception {
        try {
            return login(user);
        } catch (Exception e) {
            throw e;
        }finally{
            ((Connection) this.conn).close();
        }
    }

    public User login(User user) throws Exception {

        return null;
    }
}
