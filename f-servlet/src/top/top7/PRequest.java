package top.top7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/******
 *       Created by LEARNING on 2020/10/25 22:36.
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
 * 在Servlet中处理客户端请求需要用到request请求对象
 * 在服务端实现请求转发
 */
@WebServlet("/pr")
public class PRequest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //request的主要方法:

        //根据表单组件名称获取请求参数,根据key获取value,返回值都是String类型
        String name = req.getParameter("name");

        //获取用户ip
        String remoteAddr = req.getRemoteAddr();

        //获取请求url
        StringBuffer requestURL = req.getRequestURL();

        //获取请求资源路径
        String requestURI = req.getRequestURI();

        //获取项目名称
        String contextPath = req.getContextPath();

        //处理请求参数的中文乱码问题
        //post方式指定服务端接收请求参数的编码格式-对get方式请求的参数无效
        req.setCharacterEncoding("utf8");

        //get方式解决请求参数乱码,tomcat8之前解决方式如下: tomcat8之后get方式不会产生乱码,且不能存在如下代码
        //name = new String(name.getBytes("ISO8859-1"), "utf8");

        //存储数据,一次请求内有效
        req.setAttribute("attrKey", "object");

        //取出存入请求域的数据
        Object attrKey = req.getAttribute("attrKey");

        //请求转发:转发的作用在服务端,将请求发送给服务器上的其他资源,以共同完成一次请求的处理
        //请求转发发生在服务端,对客户端屏蔽,客户端无法得知是否发生了请求转发
        // /xx/xx表示从项目根目录开始  不带 / 表示当前项目servlet映射路径
        //只能将请求转发给同一个web应用中的组件
        req.getRequestDispatcher("转发资源uri").forward(req, resp);
        //响应请求转发的servlet执行结束后,会回到当前位置继续执行下面的代码,
        // 若不需要执行可使用return;


        System.out.println("name= " + name);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
