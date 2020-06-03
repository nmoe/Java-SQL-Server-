package hbut.services.impl;
import hbut.dao.interfaces.IStuDao;
import hbut.dao.utils.impl.sqlserverBaseDao;
import hbut.dao.utils.interfaces.IBaseDao;
import hbut.po.Stu;
import java.sql.Connection;

import factory.DAOfactory;
import hbut.po.*;
import hbut.dao.impl.StuDaoImpl;
import hbut.dao.utils.impl.sqlserverBaseDao;
public class StuServiceImpl {
     
       public Connection conn= new sqlserverBaseDao().getConnection();
       //����DAO����ʵ�����Ӳ���
       public int insert(Stu stu) throws Exception{
           try{
               return DAOfactory.getstu(this.conn).addStu(stu);
           }catch(Exception e){
               throw e;
           }finally{
               this.conn.close();
           }
       }
       //����DAO����ʵ�ֲ��Ҳ���
       public Stu findstu(int Sno) throws Exception{
           try {
               return DAOfactory.getstu(this.conn).findStuBySno(Sno);
           } catch (Exception e) {
               throw e;
           }finally{
               this.conn.close();
           }
       }
       
       

       // ����ʵ��ɾ������
       public int remove(int Sno) throws Exception{
           try {
               return DAOfactory.getstu(this.conn).deleteStu( Sno);
           } catch (Exception e) {
               throw e;
           }finally{
               this.conn.close();
           }
       }
       
      


       // ����ʵ�ָ��Ĳ���
       public int update(Stu stud)throws Exception{
           try {
               return DAOfactory.getstu(this.conn).modifyStu(stud);
           } catch (Exception e) {
               throw e;
           }finally{
           this.conn.close();
       }
   }

   
}
