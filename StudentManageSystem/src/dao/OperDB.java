package dao;
import com.StudentBean;
import java.util.List;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OperDB {
    Connection connection=null;
    PreparedStatement pst=null;
    ResultSet resultSet=null;
    //查，根据学号查人
    public StudentBean queryStudentBySno(int sno) {
        StudentBean student = null;
        String sql = "select * from student where sno=?";
        try {
            connection = DBUtil.getConnetcion();
            pst = connection.prepareStatement(sql);
            pst.setInt(1, sno);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                int no = resultSet.getInt("sno");
                String name = resultSet.getString("sname");
                int age = resultSet.getInt("sage");
                String address = resultSet.getString("saddress");
                student = new StudentBean(no, name, age, address);
            }
            else student=null;
            //return student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }
    //查,是否存在
    public  boolean isExit(int sno){
        return queryStudentBySno(sno)==null? false:true;
    }
    //查，全部

    public List<StudentBean> queryAllStudent() {
        List<StudentBean> students=new ArrayList<>();
        StudentBean student = null;
        String sql = "select * from student ";
        try {
            connection = DBUtil.getConnetcion();
            pst = connection.prepareStatement(sql);
            resultSet = pst.executeQuery();
            while (resultSet.next()) {
                int no = resultSet.getInt("sno");
                String name = resultSet.getString("sname");
                int age = resultSet.getInt("sage");
                String address = resultSet.getString("saddress");
                student = new StudentBean(no, name, age, address);
                students.add(student);
            }

            //return student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
    //增
//    public boolean login(StudentBean user){
//
//        boolean islogin = false;
//        String sql="select * from register where username=? and password = ?" ;
//        try {
//
//            connection = DBUtil.getConnetcion();
//            pst=connection.prepareStatement(sql);
//            pst.setString(1,user.getUsername());
//            pst.setString(2,user.getPassword());
//            resultSet=pst.executeQuery();
//            if(resultSet.next()){
//                islogin=true;
//            }else  islogin=false;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if(resultSet!=null){
//            try {
//                connection.close();
//                resultSet.close();
//                pst.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//        }
//        return islogin;
//    }
    public boolean addStudent(StudentBean student){
        boolean isAdd=false;
        String sql="insert into student(sno,sname,sage,saddress) values(?,?,?,?)";
        try {
            connection = DBUtil.getConnetcion();
            pst=connection.prepareStatement(sql);
            pst.setInt(1,student.getSno());
            pst.setString(2,student.getSname());
            pst.setInt(3,student.getSage());
            pst.setString(4,student.getSaddress());
            int i=pst.executeUpdate();
            if(i!=0){
                isAdd=true;
            }else  isAdd=false;

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(isAdd){
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return isAdd;
    }
    //根据学号，修改学生信息
    public boolean updateStudentBySno(int sno ,StudentBean student){
        boolean isUpdate=false;
        String sql="update student set sname=?,sage=?,saddress=? where sno=?";
        try {
            connection = DBUtil.getConnetcion();
            pst=connection.prepareStatement(sql);
            pst.setString(1,student.getSname());
            pst.setInt(2,student.getSage());
            pst.setString(3,student.getSaddress());
            pst.setInt(4,student.getSno());
            int i=pst.executeUpdate();
            if(i!=0){
                isUpdate=true;
            }else  isUpdate=false;

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(isUpdate){
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return isUpdate;

    }
    //根据学号删除学生
    public boolean deleteStudentBySno(int sno){
        boolean isDelete=false;
        String sql="delete from student where sno=?";
        try {
            connection = DBUtil.getConnetcion();
            pst=connection.prepareStatement(sql);
            pst.setInt(1,sno);
            int i=pst.executeUpdate();
            if(i!=0){
                isDelete=true;
            }else  isDelete=false;

        } catch (Exception e) {
            e.printStackTrace();
        }
        if(isDelete){
            try {
                connection.close();
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
                isDelete=false;
            }

        }

        return isDelete;
    }
}
