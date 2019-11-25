//package servlet;
//
//import com.StudentBean;
//import server.checkUser;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
////servlet 3.0特性
//@WebServlet("/login")
//public class loginUser extends HttpServlet {
//    public loginUser(){
//        super();
//    }
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        request.setCharacterEncoding("utf-8");
//
//        String username=request.getParameter("username");
//        String password=request.getParameter("password");
//        StudentBean user=new StudentBean();
//        user.setUsername(username);
//        user.setPassword(password);
//        checkUser ck=new checkUser();
//
//    out.println(user.getUsername());
//    out.println(user.getPassword());
//        if(ck.checkUser(user)){
//            out.println("login succeed");
//        }else out.println("login fail");
//
//
////        out.println(username+"<br>");
////        out.println(password+"<br>");
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
