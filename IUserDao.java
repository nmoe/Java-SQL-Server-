package hbut.dao.interfaces;
import hbut.po.User;
public interface IUserDao {
    public User login(User user) throws Exception;
}
