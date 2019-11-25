package servlet;

import com.StudentBean;
import server.StudentServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/QueryStudentBySnoServlet")
public class QueryStudentBySnoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int no= Integer.parseInt(request.getParameter("sno"));
        StudentServer studentServer=new StudentServer();
        StudentBean student=studentServer.queryStudentBySno(no);
        //System.out.println(student);
        request.setAttribute("student",student);
        request.getRequestDispatcher("studentInfo.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
