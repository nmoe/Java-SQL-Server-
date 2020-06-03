package hbut.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import hbut.dao.interfaces.IStuDao;
import hbut.dao.utils.impl.sqlserverBaseDao;
import hbut.dao.utils.interfaces.IBaseDao;
import hbut.po.Stu;

public class StuDaoImpl implements IStuDao{
    IBaseDao baseDao = (IBaseDao) new sqlserverBaseDao();
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    int r = 0;
    public StuDaoImpl(Connection conn) {
		this.conn = conn;
	}
    @Override
    public List<Stu> findStu() throws Exception {
        
        List<Stu> stus = new ArrayList<Stu>();
        try {
            conn = baseDao.getConn();
            String sql = "SELECT * FROM  stu ORDER BY  Sno";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Stu stud = new Stu();
                stud.setSno(rs.getInt("Sno"));
                stud.setName(rs.getString("Name"));
                stud.setSex(rs.getString("Sex"));
                stud.setAddr(rs.getString("Addr"));
                stud.setColleage(rs.getString("Grade"));

                stus.add(stud);
            }
            baseDao.closeConn(rs, ps, conn);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return stus;
    }

    @Override
    public int addStu(Stu stud) throws Exception {
        
        try {
            conn = baseDao.getConn();
            String sql = "insert into stu values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, stud.getSno());
            ps.setObject(2, stud.getName());
            ps.setObject(3, stud.getSex());
            ps.setObject(4, stud.getAddr());
            ps.setObject(5, stud.getColleage());
            r = ps.executeUpdate();
            baseDao.closeConn(rs, ps, conn);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return r;
    }

    @Override
    public Stu findStuBySno(int Sno) throws Exception {
       
        Stu stud = null;
        try {
            conn = baseDao.getConn();
            String sql = "SELECT * FROM stu WHERE Sno = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, Sno);
            rs = ps.executeQuery();
            if (rs.next()) {
                stud = new Stu();
                stud.setSno(rs.getInt("Sno"));
                stud.setName(rs.getString("Name"));
                stud.setSex(rs.getString("Sex"));
                stud.setAddr(rs.getString("Addr"));
                stud.setColleage(rs.getString("Grade"));
            }
            baseDao.closeConn(rs, ps, conn);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return stud;
    }

    @Override
    public int deleteStu(int Sno) throws Exception {
        
        try {
            conn = baseDao.getConn();
            String sql = "delete from stu where Sno = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, Sno);
            r = ps.executeUpdate();
            baseDao.closeConn(rs, ps, conn);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return r;
    }

    @Override
    public int modifyStu(Stu stud) throws Exception {
        
        try {
            conn = baseDao.getConn();
            String sql = "UPDATE stu  SET Name = ?,Sex = ?,Grade = ? WHERE Sno = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, stud.getName());
            ps.setObject(2, stud.getSex());
            ps.setObject(3, stud.getColleage());
            ps.setObject(4, stud.getAddr());
            ps.setObject(4, stud.getSno());
            r = ps.executeUpdate();
            baseDao.closeConn(rs, ps, conn);
        } catch (Exception e) {
            throw new Exception(e);
        }
        return r;
    }
}



