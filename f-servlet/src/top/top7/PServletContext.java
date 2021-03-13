package top.top7;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/******
 *       Created by LEARNING on 2020/10/25 18:29.
 *
 **********************************************************************
 *                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
 *            __.'              ~.   .~              `.__
 *          .'//                  \./                  \\`.
 *        .'//                     |                     \\`.
 *      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
 *    .'//.-"                 `-.  |  .-'                 "-.\\`.
 *  .'//______.============-..   \ | /   ..-============.______\\`.
 *.'______________________________\|/______________________________`.
 *
 *
 *                     Don't forget to be awesome!                      
 **********************************************************************
 */

/**
 * ServletContext对象:
 * 全局对象,作用域为一个tomcat中的应用
 * 当web服务器启动时,会为每一个web应用程序创建一块共享的存储区域(ServletContext)
 * ServletContext在web容器启动时创建,关闭时销毁
 */
public class PServletContext extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext对象的三种方式
        //1.GenricServlet提供
        ServletContext servletContext = getServletContext();
        //2.HttpServletRequest提供
        ServletContext servletContext1 = req.getServletContext();
        //3.HttpSession提供
        ServletContext servletContext2 = req.getSession().getServletContext();
        //4.
        ServletContext servletContext3 = getServletConfig().getServletContext();

        //常用方法
        //获取配置文件中的初始化参数
        String kk = servletContext.getInitParameter("kk");
        //获取项目在服务器发布的真实路径
        String realPath = servletContext.getRealPath("/");

        //获取项目上下文路径(项目名称)
        String contextPath = servletContext.getContextPath();
        String contextPath1 = req.getContextPath();

        //全局作用域的数据存储 读取 移除
        servletContext.setAttribute("stringName","ObjectValue");
        Object stringName = servletContext.getAttribute("stringName");
        servletContext.removeAttribute("stringName");



    }
}
