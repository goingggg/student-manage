package servlet;

import com.StudentBean;
import server.StudentServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        int no= Integer.parseInt(request.getParameter("sno"));
        String name=request.getParameter("sname");
        int age= Integer.parseInt(request.getParameter("sage"));
        String address=request.getParameter("saddress");
        //封装到实体类
        StudentBean student=new StudentBean(no,name,age,address);
        StudentServer studentServer=new StudentServer();
        boolean result=studentServer.updateStudentBySno(no,student);
        if (result){
            response.getWriter().println("UpdateStudent succeed");
            response.sendRedirect("allInfo");
        }else {
            response.getWriter().println("UpdateStudent failed");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
