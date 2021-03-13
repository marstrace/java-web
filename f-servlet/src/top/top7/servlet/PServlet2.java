package top.top7.servlet;

/******
 *       Created by LEARNING on 2020/10/25 12:08.
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

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * 创建servlet的三种方式:
 * 2.继承GenericServlet抽象类并重写其service抽象方法
 * GenericServlet方法重写了Servlet接口的其他方法,现在只需要重写service方法就可以了
 *
 * 这种方式一般不使用
 */
@WebServlet("/ps2")//注解配置见ps3
public class PServlet2 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("我是GenericServlet");
    }
}
