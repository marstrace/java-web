package top.top7.servlet;

/******
 *       Created by LEARNING on 2020/10/25 11:23.
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
import java.io.IOException;

/**
 * 创建servlet的三种方式:
 * 1.实现javax.servlet.Servlet接口
 * 重写5个未实现方法
 * 在web.xml中配置servlet的资源路径和其他配置
 */
public class PServlet1 implements Servlet {

    //初始化方法
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    //获取每个Servlet独有的ServletConfig对象
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //接收请求,并响应
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("frist servlet");
    }

    //获取Servlet的基本信息
    @Override
    public String getServletInfo() {
        return null;
    }

    //销毁方法
    @Override
    public void destroy() {

    }
}
