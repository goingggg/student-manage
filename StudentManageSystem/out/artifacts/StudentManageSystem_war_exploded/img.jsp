<%@ page import="java.awt.*" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/11/11
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="image/jpeg;charset=UTF-8" language="java" %>

<%!
    //获取随机颜色
    public Color getColor(){
        Random random=new Random();
         int r=random.nextInt(256);
         int g=random.nextInt(256);
         int b=random.nextInt(256);
        return  new Color(r,g,b);
    }
    //获取4位随机数
    public String getNum(){
        int num=(int)(Math.random()*9000+1000);
        return String.valueOf(num);
    }

%>
<%
    //设置缓存过期
    response.setHeader("Cache-Control" , "no-store");
    response.setHeader( "Expires" , "0");
    response.setHeader( "Pragma" , "no-cache");

    //绘制验证码
    BufferedImage img= new BufferedImage(80,30,BufferedImage.TYPE_INT_RGB);

    //画笔
    Graphics graphics=img.getGraphics();
    graphics.fillRect(0,0,80,30);

    //绘制线条
    for (int i=1;i<60;i++){
        Random random=new Random();
        int xBegain=random.nextInt(80);
        int yBegain=random.nextInt(30);
        int xEnd=random.nextInt(xBegain+10);
        int yEnd=random.nextInt(yBegain+10);

        graphics.setColor(getColor());
        graphics.drawLine(xBegain,yBegain,xEnd,yEnd);
    }
    //绘制验证码
    graphics.setFont(new Font("seif",Font.BOLD,20));
    graphics.setColor(getColor());
    String checkCode=getNum();
    StringBuffer sb=new StringBuffer();
    for (int i=0;i<checkCode.length();i++){
        sb.append(checkCode.charAt(i)+" ");
    }
    graphics.drawString(sb.toString(),15,20);

    //真实值保存
    session.setAttribute("checkCode",checkCode);
    //真实图片
    ImageIO.write(img,"jpeg",response.getOutputStream());
    out.clear();
    out=pageContext.pushBody();
%>