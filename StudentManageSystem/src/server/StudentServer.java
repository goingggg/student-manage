package server;

import com.StudentBean;
import dao.OperDB;

import java.util.List;

//逻辑层
public class StudentServer {
    OperDB operDB =new OperDB();
    //查全部
    public List<StudentBean> queryAllStudent(){
       return operDB.queryAllStudent();
    }
    //查
    public StudentBean queryStudentBySno(int sno){
        return operDB.queryStudentBySno(sno);

    }
    public boolean updateStudentBySno(int sno,StudentBean student){
        if (operDB.isExit(student.getSno())) {
            return operDB.updateStudentBySno(sno,student);
        }else return false;
    }
    //逻辑增
    public boolean addStudent(StudentBean student){
        if (!operDB.isExit(student.getSno())){
            operDB.addStudent(student);
            return true;
        } else return false;
    }
    //逻辑删
    public boolean deleteStudentBySno(int sno){
        if(operDB.isExit(sno)){
            return operDB.deleteStudentBySno(sno);
        }else {
            return false;
        }
    }
}
