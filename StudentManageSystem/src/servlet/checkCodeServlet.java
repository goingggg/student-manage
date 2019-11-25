package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/checkCodeServlet")
public class checkCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String resultTip="img/error.png";
        String checkCodeClient=request.getParameter("checkCode");
        String checkCodeServer=(String) request.getSession().getAttribute("checkCode");
        if (checkCodeServer.equals(checkCodeClient)){
            resultTip="img/right.png";
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer=response.getWriter();
        writer.write(resultTip);
        writer.flush();
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
