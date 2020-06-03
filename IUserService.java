package hbut.services.interfaces;
import hbut.dao.impl.UserDaoImpl;
import hbut.po.User;
public interface IUserService {
    public User login(User user) throws Exception;
}
