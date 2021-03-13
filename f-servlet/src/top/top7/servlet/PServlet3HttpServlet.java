package top.top7.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/******
 *       Created by LEARNING on 2020/10/25 12:15.
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
 * 创建servlet的三种方式:
 * 3.继承HttpServlet抽象类(推荐)
 * 并重写其doGet与doPost方法,使Servlet的请求只对get与post请求有效
 */

/**
 * Servlet的两种配置方式之注解配置
 *
 * 常用属性:
 * name:名字
 * value:访问路径,可配置多个@WebServlet(value = {"/ps3","/ps33"})
 * loadOnStartup:0 容器加载时机,具体见web.xml
 */
@WebServlet("/Ps3")//大小写敏感
public class PServlet3HttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我是HttpServlt");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
