package servlet;

import com.StudentBean;
import server.StudentServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allInfo")
public class QueryAllStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        StudentServer studentServer=new StudentServer();
        List<StudentBean> students=studentServer.queryAllStudent();
       // System.out.println(students);
        request.setAttribute("students",students);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
