package top.top7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/******
 *       Created by LEARNING on 2020/10/25 16:40.
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
 * response用于响应客户端请求,并输出信息
 * 重定向
 */
@WebServlet("/pre")
public class PResponse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //response对象的常用方法:

        //设置响应头信息
        resp.setHeader("version", "servlet4.0");
        //设置响应文件类型及编码方式
        resp.setContentType("text/html;charset=utf-8");
        //设置服务端响应内容编码方式
        resp.setCharacterEncoding("utf-8");

        //获取字符输出流,并输出内容到客户端
        PrintWriter writer = resp.getWriter();
        writer.println("打印内容到客户端");
        writer.print(true);
        //下方代码还会继续执行


        //解决输出中文乱码问题
        //方式一:不推荐
        //第一步,设置服务端响应内容的编码格式
        resp.setCharacterEncoding("utf-8");
        //第二步,设置响应头信息,告诉客户端响应内容的类型及编码格式
        resp.setHeader("Content-Type", "text/html;charset=utf-8");

        //方式二,同步设置服务端编码格式及响应头信息
        resp.setContentType("text/html;charset=utf-8");

        //重定向
        //uri:统一资源标识符,用来表示服务器中定位一个资源,资源在web项目中的路径(/project/source)
        //使用redirect跳转时,是在客户端跳转,地址栏发生变化,属于两次请求
        //可以通过uri的拼接传递数据 /project/source?name=hah&age=15
        resp.sendRedirect("ps2");
        //重定向可以指向任何资源....其他站点资源
        //下方代码不会执行


        System.out.println("我是谁...");

    }
}
