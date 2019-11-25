package servlet;

import server.StudentServer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int no= Integer.parseInt(request.getParameter("sno"));
        StudentServer studentServer=new StudentServer();
        boolean result=studentServer.deleteStudentBySno(no);
        if (result){
            //response.getWriter().println("deleteStudent succeed");
            response.sendRedirect("allInfo");
        }else {
            response.getWriter().println("deleteStudent failed");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
