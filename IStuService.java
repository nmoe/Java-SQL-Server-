package hbut.services.interfaces;
//import hbut.dao.impl.StuDaoImpl;
import hbut.po.Stu;

import java.util.List;

public interface IStuService {
    public List<Stu> findStu() throws Exception;
    public int addStu(Stu stud) throws Exception;
    public Stu findStuBySno(int Sno) throws Exception;
    public int deleteStu(int Sno) throws Exception;
    public int modifyStu(Stu stud) throws Exception;
}
