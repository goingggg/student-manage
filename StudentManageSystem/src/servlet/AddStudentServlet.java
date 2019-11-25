package servlet;

import com.StudentBean;
import server.StudentServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int no= Integer.parseInt(request.getParameter("sno"));
        String name=request.getParameter("sname");
        int age= Integer.parseInt(request.getParameter("sage"));
        String address=request.getParameter("saddress");
        StudentBean student=new StudentBean(no,name,age,address);
        StudentServer studentServer=new StudentServer();
        boolean result=studentServer.addStudent(student);
        if (result){
            response.sendRedirect("allInfo");
        }else {
            response.getWriter().println("add faile");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
